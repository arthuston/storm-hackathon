import java.io.*;
import java.net.*;
import java.util.Random;

class TcpServer
{
	public static final int SOCKNUM = 4545;
    private ServerSocket connectionSocket = null;
	private DataOutputStream outToClient = null;

	public TcpServer() {
	}
	
	public void init() throws Exception {
		connectionSocket = new ServerSocket(SOCKNUM);
        outToClient = new DataOutputStream(connectionSocket.getOutputStream());
    }

	public void push(float lat, float lon, int count, int sentiment) {
		if (outToClient != null) {
			String str = String.valueOf(lat) + " " + String.valueOf(lon) + " " +  String.valueOf(count) + " " +  String.valueOf(sentiment) + "\n";
			outToClient.writeBytes(str);
		}
	}
	  
}