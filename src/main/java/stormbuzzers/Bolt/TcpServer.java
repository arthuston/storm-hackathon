import java.io.*;
import java.net.*;
import java.util.Random;

class TcpServer
{
	public static final int SOCKNUM = 4545;
	public static final String BEGINPUSH = "xxx\n";
    private ServerSocket serverSocket = null;
	private Socket clientSocket = null;
	private DataOutputStream outToClient = null;
	private boolean beginPush = false;

	public TcpServer() {
	}
	
	public void init() throws Exception {
		serverSocket = new ServerSocket(SOCKNUM);
		clientSocket = serverSocket.accept();
        outToClient = new DataOutputStream(clientSocket.getOutputStream());
    }
	
	public void beginPush() throws Exception {
		if (outToClient != null) {
			writeBytes(BEGINPUSH);
			beginPush = true;
		}
	}

	public void push(double lat, double lon, int count, int sentiment) throws Exception {
		if (outToClient != null && beginPush) {
			String str = String.valueOf(lat) + " " + String.valueOf(lon) + " " +  String.valueOf(count) + " " +  String.valueOf(sentiment) + "\n";
			writeBytes(str);
		}
	}
	
	private void writeBytes(String str) throws Exception {
		try {
			outToClient.writeBytes(str);
		} catch (SocketException) {
			clientSocket = null;
			outToClient = null;
			beginPush = false;
			clientSocket = serverSocket.accept();
			outToClient = new DataOutputStream(clientSocket.getOutputStream());
		}
	}
	  
}