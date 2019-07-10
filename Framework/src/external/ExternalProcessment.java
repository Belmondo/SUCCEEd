package external;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

//new class 30%
public class ExternalProcessment {
	
	private static String urlLink;
	private static HttpURLConnection conn;
	private static String typeOfConn;
	
	
	public static void connectToServer(String urlLinkPage, String HttpMethod) {
		urlLink = urlLinkPage;
		
		if(HttpMethod.startsWith("G")) {
			urlLink += "?";
			typeOfConn = "GET";
		}
		else if(HttpMethod.startsWith("P")) {
			typeOfConn = "POST";
		}		
	}
	
	public static void connectToServer(String urlLinkPage, String HttpMethod, String command) {
		urlLink = urlLinkPage;
		
		if(HttpMethod.startsWith("G")) {
			urlLink += "?";
			typeOfConn = "GET";
		}
		else if(HttpMethod.startsWith("P")) {
			typeOfConn = "POST";
		}
		
		setCommand(command);
	}
	
	private static void realizeConnectionGET() {
		try {
			conn = (HttpURLConnection) new URL(urlLink).openConnection();
			conn.setRequestMethod("GET");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void realizeConnectionPost() {		
		try {
			conn = (HttpURLConnection) new URL(urlLink).openConnection();
			conn.setRequestMethod("POST");
			conn.setDoOutput( true );
			//conn.setInstanceFollowRedirects( false );
			//conn.setRequestMethod( "POST" );
			//conn.setRequestProperty( "Content-Type", "application/x-www-form-urlencoded"); 
			//conn.setRequestProperty( "charset", "utf-8");
			//conn.setUseCaches( false );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void setCommand(String command) {
		if(typeOfConn.startsWith("G")) {
			urlLink = urlLink.concat(command);
			realizeConnectionGET();
		}else if(typeOfConn.startsWith("P")) {
			realizeConnectionPost();
			
			byte [] postCommand = command.getBytes( StandardCharsets.UTF_8 );
			DataOutputStream wr;
			try {
				wr = new DataOutputStream(conn.getOutputStream());
				wr.write(postCommand);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	public static String getAnswer() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		StringBuffer sb = new StringBuffer();
		String line;
		while((line = in.readLine()) != null) {
			sb.append(line);
		}	
		in.close();
		return sb.toString();		
	}
	
}
