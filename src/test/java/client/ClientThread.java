package client;

public class ClientThread extends Thread{

	private String url = "http://127.0.0.1:8070/servlet2";
	
	private String id;
	
	public ClientThread(String id){
		this.id = id;
	}
	
	@Override
	public void run() {
		int i = 0 ; 
		long l1 = System.currentTimeMillis();
		for(i = 0 ;i <1;i++){
			String echoString = HttpClientHelper.doPost(url,this.id+"-"+i);
			System.out.println(echoString);
		}
		System.out.println("线程"+this.id+"共耗时"+(System.currentTimeMillis()-l1)/1000+"秒");
	}
	
	public static void main(String[] args) {
		int i = 0;
		for(i = 0 ;i < 4;i++){
			new ClientThread(String.valueOf(i)).start();
		}
		System.out.println("send finished");
	}
}
