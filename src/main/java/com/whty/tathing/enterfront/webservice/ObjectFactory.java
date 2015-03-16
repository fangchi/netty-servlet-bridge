
package com.whty.tathing.enterfront.webservice;

import java.util.Date;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.whty.tathing.enterfront.webservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AppStatusNotifyResponse_QNAME = new QName("http://www.tathing.com", "AppStatusNotifyResponse");
    private final static QName _Version_QNAME = new QName("http://www.tathing.com", "version");
    private final static QName _AppDeleteResponse_QNAME = new QName("http://www.tathing.com", "AppDeleteResponse");
    private final static QName _AppActiveRequest_QNAME = new QName("http://www.tathing.com", "AppActiveRequest");
    private final static QName _TradeNO_QNAME = new QName("http://www.tathing.com", "tradeNO");
    private final static QName _SSDInfoRequest_QNAME = new QName("http://www.tathing.com", "SSDInfoRequest");
    private final static QName _AppPersonialResponse_QNAME = new QName("http://www.tathing.com", "AppPersonialResponse");
    private final static QName _Receiver_QNAME = new QName("http://www.tathing.com", "receiver");
    private final static QName _PublicKeyRequest_QNAME = new QName("http://www.tathing.com", "PublicKeyRequest");
    private final static QName _AppActiveResponse_QNAME = new QName("http://www.tathing.com", "AppActiveResponse");
    private final static QName _OrderSaveRequest_QNAME = new QName("http://www.tathing.com", "OrderSaveRequest");
    private final static QName _AppDownloadResponse_QNAME = new QName("http://www.tathing.com", "AppDownloadResponse");
    private final static QName _AppDownloadRequest_QNAME = new QName("http://www.tathing.com", "AppDownloadRequest");
    private final static QName _SSDInfoResponse_QNAME = new QName("http://www.tathing.com", "SSDInfoResponse");
    private final static QName _AppQueryResponse_QNAME = new QName("http://www.tathing.com", "AppQueryResponse");
    private final static QName _AppDownloadResultNotifyResponse_QNAME = new QName("http://www.tathing.com", "AppDownloadResultNotifyResponse");
    private final static QName _PublicKeyResponse_QNAME = new QName("http://www.tathing.com", "PublicKeyResponse");
    private final static QName _TokenSignRequest_QNAME = new QName("http://www.tathing.com", "TokenSignRequest");
    private final static QName _SessionID_QNAME = new QName("http://www.tathing.com", "sessionID");
    private final static QName _AppDeleteResultNotifyResponse_QNAME = new QName("http://www.tathing.com", "AppDeleteResultNotifyResponse");
    private final static QName _Sender_QNAME = new QName("http://www.tathing.com", "sender");
    private final static QName _AppPushRequest_QNAME = new QName("http://www.tathing.com", "AppPushRequest");
    private final static QName _AppDeleteRequest_QNAME = new QName("http://www.tathing.com", "AppDeleteRequest");
    private final static QName _DeviceType_QNAME = new QName("http://www.tathing.com", "deviceType");
    private final static QName _AppPersonialRequest_QNAME = new QName("http://www.tathing.com", "AppPersonialRequest");
    private final static QName _AppQueryRequest_QNAME = new QName("http://www.tathing.com", "AppQueryRequest");
    private final static QName _TokenSignResponse_QNAME = new QName("http://www.tathing.com", "TokenSignResponse");
    private final static QName _SendTime_QNAME = new QName("http://www.tathing.com", "sendTime");
    private final static QName _TradeRefNO_QNAME = new QName("http://www.tathing.com", "tradeRefNO");
    private final static QName _AppDownloadResultNotifyRequest_QNAME = new QName("http://www.tathing.com", "AppDownloadResultNotifyRequest");
    private final static QName _AppDeleteResultNotifyRequest_QNAME = new QName("http://www.tathing.com", "AppDeleteResultNotifyRequest");
    private final static QName _AppSeCheckRequest_QNAME = new QName("http://www.tathing.com", "AppSeCheckRequest");
    private final static QName _OrderSaveResponse_QNAME = new QName("http://www.tathing.com", "OrderSaveResponse");
    private final static QName _MsgType_QNAME = new QName("http://www.tathing.com", "msgType");
    private final static QName _AppSeCheckResponse_QNAME = new QName("http://www.tathing.com", "AppSeCheckResponse");
    private final static QName _CreatSSDRequest_QNAME = new QName("http://www.tathing.com", "CreatSSDRequest");
    private final static QName _CreatSSDResponse_QNAME = new QName("http://www.tathing.com", "CreatSSDResponse");
    private final static QName _AppPushResponse_QNAME = new QName("http://www.tathing.com", "AppPushResponse");
    private final static QName _AppStatusNotifyRequest_QNAME = new QName("http://www.tathing.com", "AppStatusNotifyRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.whty.tathing.enterfront.webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SSDInfoRequest }
     * 
     */
    public SSDInfoRequest createSSDInfoRequest() {
        return new SSDInfoRequest();
    }

    /**
     * Create an instance of {@link AppActiveRequest }
     * 
     */
    public AppActiveRequest createAppActiveRequest() {
        return new AppActiveRequest();
    }

    /**
     * Create an instance of {@link AppPersonialResponse }
     * 
     */
    public AppPersonialResponse createAppPersonialResponse() {
        return new AppPersonialResponse();
    }

    /**
     * Create an instance of {@link PublicKeyRequest }
     * 
     */
    public PublicKeyRequest createPublicKeyRequest() {
        return new PublicKeyRequest();
    }

    /**
     * Create an instance of {@link AppStatusNotifyResponse }
     * 
     */
    public AppStatusNotifyResponse createAppStatusNotifyResponse() {
        return new AppStatusNotifyResponse();
    }

    /**
     * Create an instance of {@link AppDeleteResponse }
     * 
     */
    public AppDeleteResponse createAppDeleteResponse() {
        return new AppDeleteResponse();
    }

    /**
     * Create an instance of {@link AppDeleteResultNotifyResponse }
     * 
     */
    public AppDeleteResultNotifyResponse createAppDeleteResultNotifyResponse() {
        return new AppDeleteResultNotifyResponse();
    }

    /**
     * Create an instance of {@link AppDeleteRequest }
     * 
     */
    public AppDeleteRequest createAppDeleteRequest() {
        return new AppDeleteRequest();
    }

    /**
     * Create an instance of {@link AppPushRequest }
     * 
     */
    public AppPushRequest createAppPushRequest() {
        return new AppPushRequest();
    }

    /**
     * Create an instance of {@link TokenSignRequest }
     * 
     */
    public TokenSignRequest createTokenSignRequest() {
        return new TokenSignRequest();
    }

    /**
     * Create an instance of {@link AppQueryRequest }
     * 
     */
    public AppQueryRequest createAppQueryRequest() {
        return new AppQueryRequest();
    }

    /**
     * Create an instance of {@link AppPersonialRequest }
     * 
     */
    public AppPersonialRequest createAppPersonialRequest() {
        return new AppPersonialRequest();
    }

    /**
     * Create an instance of {@link SSDInfoResponse }
     * 
     */
    public SSDInfoResponse createSSDInfoResponse() {
        return new SSDInfoResponse();
    }

    /**
     * Create an instance of {@link AppActiveResponse }
     * 
     */
    public AppActiveResponse createAppActiveResponse() {
        return new AppActiveResponse();
    }

    /**
     * Create an instance of {@link OrderSaveRequest }
     * 
     */
    public OrderSaveRequest createOrderSaveRequest() {
        return new OrderSaveRequest();
    }

    /**
     * Create an instance of {@link AppDownloadResponse }
     * 
     */
    public AppDownloadResponse createAppDownloadResponse() {
        return new AppDownloadResponse();
    }

    /**
     * Create an instance of {@link AppDownloadRequest }
     * 
     */
    public AppDownloadRequest createAppDownloadRequest() {
        return new AppDownloadRequest();
    }

    /**
     * Create an instance of {@link AppQueryResponse }
     * 
     */
    public AppQueryResponse createAppQueryResponse() {
        return new AppQueryResponse();
    }

    /**
     * Create an instance of {@link AppDownloadResultNotifyResponse }
     * 
     */
    public AppDownloadResultNotifyResponse createAppDownloadResultNotifyResponse() {
        return new AppDownloadResultNotifyResponse();
    }

    /**
     * Create an instance of {@link PublicKeyResponse }
     * 
     */
    public PublicKeyResponse createPublicKeyResponse() {
        return new PublicKeyResponse();
    }

    /**
     * Create an instance of {@link AppDownloadResultNotifyRequest }
     * 
     */
    public AppDownloadResultNotifyRequest createAppDownloadResultNotifyRequest() {
        return new AppDownloadResultNotifyRequest();
    }

    /**
     * Create an instance of {@link AppDeleteResultNotifyRequest }
     * 
     */
    public AppDeleteResultNotifyRequest createAppDeleteResultNotifyRequest() {
        return new AppDeleteResultNotifyRequest();
    }

    /**
     * Create an instance of {@link TokenSignResponse }
     * 
     */
    public TokenSignResponse createTokenSignResponse() {
        return new TokenSignResponse();
    }

    /**
     * Create an instance of {@link CreatSSDResponse }
     * 
     */
    public CreatSSDResponse createCreatSSDResponse() {
        return new CreatSSDResponse();
    }

    /**
     * Create an instance of {@link CreatSSDRequest }
     * 
     */
    public CreatSSDRequest createCreatSSDRequest() {
        return new CreatSSDRequest();
    }

    /**
     * Create an instance of {@link AppStatusNotifyRequest }
     * 
     */
    public AppStatusNotifyRequest createAppStatusNotifyRequest() {
        return new AppStatusNotifyRequest();
    }

    /**
     * Create an instance of {@link AppPushResponse }
     * 
     */
    public AppPushResponse createAppPushResponse() {
        return new AppPushResponse();
    }

    /**
     * Create an instance of {@link OrderSaveResponse }
     * 
     */
    public OrderSaveResponse createOrderSaveResponse() {
        return new OrderSaveResponse();
    }

    /**
     * Create an instance of {@link AppSeCheckRequest }
     * 
     */
    public AppSeCheckRequest createAppSeCheckRequest() {
        return new AppSeCheckRequest();
    }

    /**
     * Create an instance of {@link AppSeCheckResponse }
     * 
     */
    public AppSeCheckResponse createAppSeCheckResponse() {
        return new AppSeCheckResponse();
    }

    /**
     * Create an instance of {@link Rapdu }
     * 
     */
    public Rapdu createRapdu() {
        return new Rapdu();
    }

    /**
     * Create an instance of {@link Capdu }
     * 
     */
    public Capdu createCapdu() {
        return new Capdu();
    }

    /**
     * Create an instance of {@link RspnMsg }
     * 
     */
    public RspnMsg createRspnMsg() {
        return new RspnMsg();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AppStatusNotifyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tathing.com", name = "AppStatusNotifyResponse")
    public JAXBElement<AppStatusNotifyResponse> createAppStatusNotifyResponse(AppStatusNotifyResponse value) {
        return new JAXBElement<AppStatusNotifyResponse>(_AppStatusNotifyResponse_QNAME, AppStatusNotifyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tathing.com", name = "version")
    public JAXBElement<Integer> createVersion(Integer value) {
        return new JAXBElement<Integer>(_Version_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AppDeleteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tathing.com", name = "AppDeleteResponse")
    public JAXBElement<AppDeleteResponse> createAppDeleteResponse(AppDeleteResponse value) {
        return new JAXBElement<AppDeleteResponse>(_AppDeleteResponse_QNAME, AppDeleteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AppActiveRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tathing.com", name = "AppActiveRequest")
    public JAXBElement<AppActiveRequest> createAppActiveRequest(AppActiveRequest value) {
        return new JAXBElement<AppActiveRequest>(_AppActiveRequest_QNAME, AppActiveRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tathing.com", name = "tradeNO")
    public JAXBElement<Integer> createTradeNO(Integer value) {
        return new JAXBElement<Integer>(_TradeNO_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SSDInfoRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tathing.com", name = "SSDInfoRequest")
    public JAXBElement<SSDInfoRequest> createSSDInfoRequest(SSDInfoRequest value) {
        return new JAXBElement<SSDInfoRequest>(_SSDInfoRequest_QNAME, SSDInfoRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AppPersonialResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tathing.com", name = "AppPersonialResponse")
    public JAXBElement<AppPersonialResponse> createAppPersonialResponse(AppPersonialResponse value) {
        return new JAXBElement<AppPersonialResponse>(_AppPersonialResponse_QNAME, AppPersonialResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tathing.com", name = "receiver")
    public JAXBElement<String> createReceiver(String value) {
        return new JAXBElement<String>(_Receiver_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PublicKeyRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tathing.com", name = "PublicKeyRequest")
    public JAXBElement<PublicKeyRequest> createPublicKeyRequest(PublicKeyRequest value) {
        return new JAXBElement<PublicKeyRequest>(_PublicKeyRequest_QNAME, PublicKeyRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AppActiveResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tathing.com", name = "AppActiveResponse")
    public JAXBElement<AppActiveResponse> createAppActiveResponse(AppActiveResponse value) {
        return new JAXBElement<AppActiveResponse>(_AppActiveResponse_QNAME, AppActiveResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderSaveRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tathing.com", name = "OrderSaveRequest")
    public JAXBElement<OrderSaveRequest> createOrderSaveRequest(OrderSaveRequest value) {
        return new JAXBElement<OrderSaveRequest>(_OrderSaveRequest_QNAME, OrderSaveRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AppDownloadResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tathing.com", name = "AppDownloadResponse")
    public JAXBElement<AppDownloadResponse> createAppDownloadResponse(AppDownloadResponse value) {
        return new JAXBElement<AppDownloadResponse>(_AppDownloadResponse_QNAME, AppDownloadResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AppDownloadRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tathing.com", name = "AppDownloadRequest")
    public JAXBElement<AppDownloadRequest> createAppDownloadRequest(AppDownloadRequest value) {
        return new JAXBElement<AppDownloadRequest>(_AppDownloadRequest_QNAME, AppDownloadRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SSDInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tathing.com", name = "SSDInfoResponse")
    public JAXBElement<SSDInfoResponse> createSSDInfoResponse(SSDInfoResponse value) {
        return new JAXBElement<SSDInfoResponse>(_SSDInfoResponse_QNAME, SSDInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AppQueryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tathing.com", name = "AppQueryResponse")
    public JAXBElement<AppQueryResponse> createAppQueryResponse(AppQueryResponse value) {
        return new JAXBElement<AppQueryResponse>(_AppQueryResponse_QNAME, AppQueryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AppDownloadResultNotifyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tathing.com", name = "AppDownloadResultNotifyResponse")
    public JAXBElement<AppDownloadResultNotifyResponse> createAppDownloadResultNotifyResponse(AppDownloadResultNotifyResponse value) {
        return new JAXBElement<AppDownloadResultNotifyResponse>(_AppDownloadResultNotifyResponse_QNAME, AppDownloadResultNotifyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PublicKeyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tathing.com", name = "PublicKeyResponse")
    public JAXBElement<PublicKeyResponse> createPublicKeyResponse(PublicKeyResponse value) {
        return new JAXBElement<PublicKeyResponse>(_PublicKeyResponse_QNAME, PublicKeyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TokenSignRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tathing.com", name = "TokenSignRequest")
    public JAXBElement<TokenSignRequest> createTokenSignRequest(TokenSignRequest value) {
        return new JAXBElement<TokenSignRequest>(_TokenSignRequest_QNAME, TokenSignRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tathing.com", name = "sessionID")
    public JAXBElement<Integer> createSessionID(Integer value) {
        return new JAXBElement<Integer>(_SessionID_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AppDeleteResultNotifyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tathing.com", name = "AppDeleteResultNotifyResponse")
    public JAXBElement<AppDeleteResultNotifyResponse> createAppDeleteResultNotifyResponse(AppDeleteResultNotifyResponse value) {
        return new JAXBElement<AppDeleteResultNotifyResponse>(_AppDeleteResultNotifyResponse_QNAME, AppDeleteResultNotifyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tathing.com", name = "sender")
    public JAXBElement<String> createSender(String value) {
        return new JAXBElement<String>(_Sender_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AppPushRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tathing.com", name = "AppPushRequest")
    public JAXBElement<AppPushRequest> createAppPushRequest(AppPushRequest value) {
        return new JAXBElement<AppPushRequest>(_AppPushRequest_QNAME, AppPushRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AppDeleteRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tathing.com", name = "AppDeleteRequest")
    public JAXBElement<AppDeleteRequest> createAppDeleteRequest(AppDeleteRequest value) {
        return new JAXBElement<AppDeleteRequest>(_AppDeleteRequest_QNAME, AppDeleteRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tathing.com", name = "deviceType")
    public JAXBElement<String> createDeviceType(String value) {
        return new JAXBElement<String>(_DeviceType_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AppPersonialRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tathing.com", name = "AppPersonialRequest")
    public JAXBElement<AppPersonialRequest> createAppPersonialRequest(AppPersonialRequest value) {
        return new JAXBElement<AppPersonialRequest>(_AppPersonialRequest_QNAME, AppPersonialRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AppQueryRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tathing.com", name = "AppQueryRequest")
    public JAXBElement<AppQueryRequest> createAppQueryRequest(AppQueryRequest value) {
        return new JAXBElement<AppQueryRequest>(_AppQueryRequest_QNAME, AppQueryRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TokenSignResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tathing.com", name = "TokenSignResponse")
    public JAXBElement<TokenSignResponse> createTokenSignResponse(TokenSignResponse value) {
        return new JAXBElement<TokenSignResponse>(_TokenSignResponse_QNAME, TokenSignResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Date }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tathing.com", name = "sendTime")
    @XmlJavaTypeAdapter(Adapter1 .class)
    public JAXBElement<Date> createSendTime(Date value) {
        return new JAXBElement<Date>(_SendTime_QNAME, Date.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tathing.com", name = "tradeRefNO")
    public JAXBElement<Integer> createTradeRefNO(Integer value) {
        return new JAXBElement<Integer>(_TradeRefNO_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AppDownloadResultNotifyRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tathing.com", name = "AppDownloadResultNotifyRequest")
    public JAXBElement<AppDownloadResultNotifyRequest> createAppDownloadResultNotifyRequest(AppDownloadResultNotifyRequest value) {
        return new JAXBElement<AppDownloadResultNotifyRequest>(_AppDownloadResultNotifyRequest_QNAME, AppDownloadResultNotifyRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AppDeleteResultNotifyRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tathing.com", name = "AppDeleteResultNotifyRequest")
    public JAXBElement<AppDeleteResultNotifyRequest> createAppDeleteResultNotifyRequest(AppDeleteResultNotifyRequest value) {
        return new JAXBElement<AppDeleteResultNotifyRequest>(_AppDeleteResultNotifyRequest_QNAME, AppDeleteResultNotifyRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AppSeCheckRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tathing.com", name = "AppSeCheckRequest")
    public JAXBElement<AppSeCheckRequest> createAppSeCheckRequest(AppSeCheckRequest value) {
        return new JAXBElement<AppSeCheckRequest>(_AppSeCheckRequest_QNAME, AppSeCheckRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderSaveResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tathing.com", name = "OrderSaveResponse")
    public JAXBElement<OrderSaveResponse> createOrderSaveResponse(OrderSaveResponse value) {
        return new JAXBElement<OrderSaveResponse>(_OrderSaveResponse_QNAME, OrderSaveResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tathing.com", name = "msgType")
    public JAXBElement<String> createMsgType(String value) {
        return new JAXBElement<String>(_MsgType_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AppSeCheckResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tathing.com", name = "AppSeCheckResponse")
    public JAXBElement<AppSeCheckResponse> createAppSeCheckResponse(AppSeCheckResponse value) {
        return new JAXBElement<AppSeCheckResponse>(_AppSeCheckResponse_QNAME, AppSeCheckResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreatSSDRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tathing.com", name = "CreatSSDRequest")
    public JAXBElement<CreatSSDRequest> createCreatSSDRequest(CreatSSDRequest value) {
        return new JAXBElement<CreatSSDRequest>(_CreatSSDRequest_QNAME, CreatSSDRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreatSSDResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tathing.com", name = "CreatSSDResponse")
    public JAXBElement<CreatSSDResponse> createCreatSSDResponse(CreatSSDResponse value) {
        return new JAXBElement<CreatSSDResponse>(_CreatSSDResponse_QNAME, CreatSSDResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AppPushResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tathing.com", name = "AppPushResponse")
    public JAXBElement<AppPushResponse> createAppPushResponse(AppPushResponse value) {
        return new JAXBElement<AppPushResponse>(_AppPushResponse_QNAME, AppPushResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AppStatusNotifyRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tathing.com", name = "AppStatusNotifyRequest")
    public JAXBElement<AppStatusNotifyRequest> createAppStatusNotifyRequest(AppStatusNotifyRequest value) {
        return new JAXBElement<AppStatusNotifyRequest>(_AppStatusNotifyRequest_QNAME, AppStatusNotifyRequest.class, null, value);
    }

}
