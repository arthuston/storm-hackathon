import java.io.*;
import java.net.*;
import java.util.Random;

class TcpServer
{
	public final int PORTNO = 4545;
	
    public static void main(String argv[]) throws Exception
    {
        String clientSentence;
        String capitalizedSentence;
        ServerSocket welcomeSocket = new ServerSocket(TcpServer::PORTNO);

        while(true)
        {
            Socket connectionSocket = welcomeSocket.accept();
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

            while(true)
            {

                Random generator = new Random();
                double lat = (generator.nextDouble() * 180.0) - 90;
                double lon = (generator.nextDouble() * 360);
                //double lon = (generator.nextDouble() * 180.0) - 90;
                int    sem = generator.nextInt(10);
                String str = String.valueOf(lat) + " " + String.valueOf(lon) + " " +  String.valueOf(sem) + "\n";
                outToClient.writeBytes(str);

                try {
                    Thread.sleep(2000);
                } catch(InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
