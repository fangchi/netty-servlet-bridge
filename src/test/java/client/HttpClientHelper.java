package client;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.http.Consts;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.client.params.CookiePolicy;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class HttpClientHelper {

	private static final Logger logger = LoggerFactory
			.getLogger(HttpClientHelper.class);

	private static Charset defaultCharset = Consts.UTF_8;

	private static HashMap<String, String> defaultGetRequestHeader = new HashMap<String, String>();
	static {
		defaultGetRequestHeader.put("Content-Type", "text/plain;charset="
				+ defaultCharset.name());
		defaultGetRequestHeader.put("Accept-Charset", defaultCharset.name());
		defaultGetRequestHeader.put("Accept",
				"application/json,text/xml,application/xml,text/plain");
		defaultGetRequestHeader.put("Accept-Encoding", "gzip, deflate");
		defaultGetRequestHeader.put("Connection", "close");
	}

	private static HashMap<String, String> defaultPostRequestHeader = new HashMap<String, String>();
	static {
		defaultPostRequestHeader.put(
				"Content-Type",
				"application/x-www-form-urlencoded;charset="
						+ defaultCharset.name());
		defaultPostRequestHeader.put("Accept-Charset", defaultCharset.name());
		defaultPostRequestHeader.put("Accept",
				"application/json,text/xml,application/xml,text/plain");
		defaultPostRequestHeader.put("Accept-Encoding", "gzip, deflate");
		defaultPostRequestHeader.put("Connection", "close");
	}

	/**
	 * 
	 * @param host
	 * @param port
	 * @param requestUri
	 * @return
	 */
	public static String doGet(String host, int port, String requestUri) {
		return doGet(host, port, requestUri, null, null);
	}

	/**
	 * 
	 * @param host
	 * @param port
	 * @param requestUri
	 * @param params
	 * @return
	 */
	public static String doGet(String host, int port, String requestUri,
			HashMap<String, String> params) {
		return doGet(host, port, requestUri, params, null);
	}

	/**
	 * 
	 * @param host
	 * @param port
	 * @param requestUri
	 * @param params
	 * @param requestHeader
	 * @return
	 */
	public static String doGet(String host, int port, String requestUri,
			HashMap<String, String> params,
			HashMap<String, String> requestHeader) {

		long start = System.currentTimeMillis();

		String responseMsg = null;
		HttpEntity entity = null;
		String uri = requestUri;

		try {
			HttpClient httpclient = new DefaultHttpClient();
			HttpParams httpParams = httpclient.getParams();

			// 设置cookie的兼容性
			httpParams.setParameter(ClientPNames.COOKIE_POLICY,
					CookiePolicy.BROWSER_COMPATIBILITY);

			URIBuilder uriBuilder = new URIBuilder(uri);
			if (params != null) {

				logger.debug("parameter encoded by {}", defaultCharset.name());

				Iterator<String> paramNames = params.keySet().iterator();
				while (paramNames.hasNext()) {
					String paramName = paramNames.next();
					String paramValue = params.get(paramName);
					logger.debug("Request parameter:{}={}", paramName,
							paramValue);
					// paramValue = URLEncoder.encode(paramValue,
					// defaultCharset.name());
					if (!"".equals(paramValue) && null != paramValue) {
						uriBuilder.addParameter(paramName, paramValue);
					} else {
						logger.debug("Null value, ignore parameter name {}",
								paramName);
					}

				}
			}

			uri = uriBuilder.toString();

			uri = "http://" + host + ":" + port + "/" + uri;

			logger.debug("Request URL after encode:{}", uri);

			HttpUriRequest request = new HttpGet(uri);

			resetGetRequestHeaders(requestHeader, request);

			logger.debug("send request...");

			// HttpHost target = new HttpHost(host, port);
			// HttpResponse response = httpclient.execute(target, request);
			HttpResponse response = httpclient.execute(request);

			Header[] headers = response.getAllHeaders();
			for (int i = 0; i < headers.length; i++) {
				logger.debug("response header:{}", headers[i]);
			}

			StatusLine statusLine = response.getStatusLine();
			logger.debug("response status:{}", statusLine);

			// 判断页面返回状态判断是否进行转向抓取新链接
			int statusCode = statusLine.getStatusCode();
			if ((statusCode == HttpStatus.SC_MOVED_PERMANENTLY)
					|| (statusCode == HttpStatus.SC_MOVED_TEMPORARILY)
					|| (statusCode == HttpStatus.SC_SEE_OTHER)
					|| (statusCode == HttpStatus.SC_TEMPORARY_REDIRECT)) {
				// 此处重定向处理 此处还未验证
				String newUri = response.getLastHeader("Location").getValue();
				response = httpclient.execute(new HttpGet(newUri));
			}

			entity = response.getEntity();

			if (statusCode == HttpStatus.SC_OK) {
				if (entity != null) {
					responseMsg = EntityUtils.toString(entity, defaultCharset);
					logger.debug("responseMsg:{}", responseMsg);
				} else {
					logger.debug("Http response entity is null.");
				}
			}

		} catch (Exception e) {
			logger.error("Error while sending and receiving message.", e);
		} finally {
			// close stream
			try {
				EntityUtils.consume(entity);
			} catch (IOException e) {
				logger.warn(
						"Ignore! Error while sending and receiving message.", e);
			}

			long end = System.currentTimeMillis();
			logger.debug("send message by http GET total used {} ms",
					(end - start));
		}

		return responseMsg;

	}

	public static void resetGetRequestHeaders(
			HashMap<String, String> requestHeader, HttpUriRequest request) {
		if (defaultGetRequestHeader != null) {
			Iterator<String> requestHeaderNames = defaultGetRequestHeader
					.keySet().iterator();
			while (requestHeaderNames.hasNext()) {
				String headerName = requestHeaderNames.next();
				String headerValue = defaultGetRequestHeader.get(headerName);
				logger.debug("default request header:{}={}", headerName,
						headerValue);
				request.setHeader(headerName, headerValue);
			}
		}

		if (requestHeader != null) {
			Iterator<String> requestHeaderNames = requestHeader.keySet()
					.iterator();
			while (requestHeaderNames.hasNext()) {
				String headerName = requestHeaderNames.next();
				String headerValue = requestHeader.get(headerName);
				logger.debug("add or override request header:{}={}",
						headerName, headerValue);
				request.setHeader(headerName, headerValue);
			}
		}
	}

	/**
	 * 
	 * @author dengzm
	 * @param url
	 * @param json
	 * @return
	 */
	public static String doPost(String url, String json) {
		logger.info("url" + url);
		String result = null;
		// 创建一个默认的HttpClient
		HttpClient httpclient = new DefaultHttpClient();
		try {
			// 以post方式请求
			HttpPost http = new HttpPost(url);
			http.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
			// 创建响应处理器处理服务器响应内容
			ResponseHandler<String> responseHandler = new BasicResponseHandler();
			// 执行请求并获取结果
			result = httpclient.execute(http, responseHandler);
		} catch (Exception e) {
			logger.error("执行http post请求异常：", e);
		} finally {
			// 当不再需要HttpClient实例时,关闭连接管理器以确保释放所有占用的系统资源
			httpclient.getConnectionManager().shutdown();
		}
		return result;

	}

	/**
	 * @author dengzm
	 * @param url
	 * @param params
	 * @param timeout
	 * @return
	 */
	public static String doPost(String url, Map<String, String> params,
			Integer timeout) {
		logger.info("url" + url);
		String result = null;
		// 创建一个默认的HttpClient
		HttpClient httpclient = new DefaultHttpClient();
		if (timeout != null) {
			httpclient.getParams().setParameter(
					CoreConnectionPNames.CONNECTION_TIMEOUT, timeout);
			httpclient.getParams().setParameter(
					CoreConnectionPNames.SO_TIMEOUT, timeout);
		}
		try {
			// 以post方式请求
			HttpPost http = new HttpPost(url);
			if (params != null) {
				HttpParams pr = new BasicHttpParams();
				for (Map.Entry<String, String> entry : params.entrySet()) {
					pr.setParameter(entry.getKey(), entry.getValue());
				}
				http.setParams(pr);
			}
			// 创建响应处理器处理服务器响应内容
			ResponseHandler<String> responseHandler = new BasicResponseHandler();
			// 执行请求并获取结果
			result = httpclient.execute(http, responseHandler);
		} catch (Exception e) {
			logger.error("执行http post请求异常：", e);
		} finally {
			// 当不再需要HttpClient实例时,关闭连接管理器以确保释放所有占用的系统资源
			httpclient.getConnectionManager().shutdown();
		}
		return result;

	}

	/**
	 * @author dengzm
	 * @param url
	 * @param params
	 * @return
	 */
	public static String doPost(String url, Map<String, String> params) {
		return doPost(url, params, null);
	}

	/**
	 * 
	 * @param host
	 * @param port
	 * @param requestUri
	 * @return
	 */
	public static String doPost(String host, int port, String requestUri) {
		return doPost(host, port, requestUri, null, null);
	}

	/**
	 * 
	 * @param host
	 * @param port
	 * @param requestUri
	 * @param params
	 * @return
	 */
	public static String doPost(String host, int port, String requestUri,
			HashMap<String, String> params) {
		return doPost(host, port, requestUri, params, null);
	}
	
	public static String doPost(String host, int port, String requestUri,
			String paramString) {
		return doPostStr(host, port, requestUri, paramString, null);
	}

	/**
	 * @param host
	 * @param port
	 * @param requestUri
	 * @param params
	 * @return
	 */
	public static String doPostStr(String host, int port, String requestUri,
			String paramString, HashMap<String, String> requestHeader) {
		long start = System.currentTimeMillis();
		String responseMsg = null;
		HttpEntity entity = null;
		try {
			HttpClient httpclient = new DefaultHttpClient();
			HttpResponse response = null;
			String uri = "http://" + host + ":" + port + "/" + requestUri;
			HttpPost httpPost = new HttpPost(uri);
			resetPostRequestHeaders(requestHeader, httpPost);
			;
			httpPost.setEntity(new StringEntity(paramString, defaultCharset));
			logger.debug("executing request:" + httpPost.getRequestLine());
			response = httpclient.execute(httpPost);
			Header[] headers = response.getAllHeaders();
			for (int i = 0; i < headers.length; i++) {
				logger.debug("response header:{}", headers[i]);
			}
			StatusLine statusLine = response.getStatusLine();
			// 判断页面返回状态判断是否进行转向抓取新链接
			int statusCode = statusLine.getStatusCode();
			if ((statusCode == HttpStatus.SC_MOVED_PERMANENTLY)
					|| (statusCode == HttpStatus.SC_MOVED_TEMPORARILY)
					|| (statusCode == HttpStatus.SC_SEE_OTHER)
					|| (statusCode == HttpStatus.SC_TEMPORARY_REDIRECT)) {
				// 此处重定向处理 此处还未验证
				String newUri = response.getLastHeader("Location").getValue();
				logger.debug("Redirect to {}", newUri);
				response = httpclient.execute(new HttpPost(newUri));
			}
			entity = response.getEntity();
			if (statusCode == HttpStatus.SC_OK) {
				if (entity != null) {
					logger.debug("Response content length: "
							+ entity.getContentLength());
					responseMsg = EntityUtils.toString(entity, defaultCharset);
				} else {
					logger.debug("Http response entity is null.");
				}
			}
			logger.debug("responseMsg:{}", responseMsg);
		} catch (Exception e) {
			logger.error("Error while sending and receiving message.", e);
		} finally {
			try {
				EntityUtils.consume(entity);
			} catch (IOException e) {
				logger.warn(
						"Ignore! Error while sending and receiving message.", e);
			}
			long end = System.currentTimeMillis();
			logger.debug("send message by http POST total used {} ms",
					(end - start));
		}
		return responseMsg;

	}

	/**
	 * @param host
	 * @param port
	 * @param requestUri
	 * @param params
	 * @return
	 */
	public static String doPost(String host, int port, String requestUri,
			HashMap<String, String> params,
			HashMap<String, String> requestHeader) {

		long start = System.currentTimeMillis();

		String responseMsg = null;

		HttpEntity entity = null;
		try {
			HttpClient httpclient = new DefaultHttpClient();
			HttpResponse response = null;

			String uri = "http://" + host + ":" + port + "/" + requestUri;

			HttpPost httpPost = new HttpPost(uri);

			resetPostRequestHeaders(requestHeader, httpPost);

			List<NameValuePair> nvps = new ArrayList<NameValuePair>();

			if (params != null) {
				Iterator<String> paramNames = params.keySet().iterator();
				while (paramNames.hasNext()) {

					String paramName = paramNames.next();
					String paramValue = params.get(paramName);

					logger.debug("Request parameter:{}={}", paramName,
							paramValue);

					if (!"".equals(paramValue) && null != paramValue) {
						nvps.add(new BasicNameValuePair(paramName, paramValue));
					} else {
						logger.debug("Null value, ignore parameter name {}",
								paramName);
					}
				}
			}

			httpPost.setEntity(new UrlEncodedFormEntity(nvps, defaultCharset));
			logger.debug("executing request:" + httpPost.getRequestLine());
			response = httpclient.execute(httpPost);
			Header[] headers = response.getAllHeaders();
			for (int i = 0; i < headers.length; i++) {
				logger.debug("response header:{}", headers[i]);
			}

			StatusLine statusLine = response.getStatusLine();
			logger.debug("response status:{}", statusLine);

			// 判断页面返回状态判断是否进行转向抓取新链接
			int statusCode = statusLine.getStatusCode();
			if ((statusCode == HttpStatus.SC_MOVED_PERMANENTLY)
					|| (statusCode == HttpStatus.SC_MOVED_TEMPORARILY)
					|| (statusCode == HttpStatus.SC_SEE_OTHER)
					|| (statusCode == HttpStatus.SC_TEMPORARY_REDIRECT)) {
				// 此处重定向处理 此处还未验证
				String newUri = response.getLastHeader("Location").getValue();

				logger.debug("Redirect to {}", newUri);

				response = httpclient.execute(new HttpPost(newUri));
			}

			entity = response.getEntity();

			if (statusCode == HttpStatus.SC_OK) {
				if (entity != null) {
					logger.debug("Response content length: "
							+ entity.getContentLength());
					responseMsg = EntityUtils.toString(entity, defaultCharset);
				} else {
					logger.debug("Http response entity is null.");
				}
			}

			logger.debug("responseMsg:{}", responseMsg);

		} catch (Exception e) {
			logger.error("Error while sending and receiving message.", e);
		} finally {
			// close stream
			try {
				EntityUtils.consume(entity);
			} catch (IOException e) {
				logger.warn(
						"Ignore! Error while sending and receiving message.", e);
			}
			long end = System.currentTimeMillis();
			logger.debug("send message by http POST total used {} ms",
					(end - start));
		}

		return responseMsg;

	}

	public static void resetPostRequestHeaders(
			HashMap<String, String> requestHeader, HttpUriRequest request) {
		if (defaultPostRequestHeader != null) {
			Iterator<String> requestHeaderNames = defaultPostRequestHeader
					.keySet().iterator();
			while (requestHeaderNames.hasNext()) {
				String headerName = requestHeaderNames.next();
				String headerValue = defaultPostRequestHeader.get(headerName);
				logger.debug("default request header:{}={}", headerName,
						headerValue);
				request.setHeader(headerName, headerValue);
			}
		}

		if (requestHeader != null) {
			Iterator<String> requestHeaderNames = requestHeader.keySet()
					.iterator();
			while (requestHeaderNames.hasNext()) {
				String headerName = requestHeaderNames.next();
				String headerValue = requestHeader.get(headerName);
				logger.debug("add or override request header:{}={}",
						headerName, headerValue);
				request.setHeader(headerName, headerValue);
			}
		}
	}
}
