package ctm;

public interface Connector {
	
	public void connect();
	public void desconnect();
	public void changeContext();
	public void sendActions();
	public void sendInterest();
	
	

}
