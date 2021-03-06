package storm.starter.bolt;

import java.io.*;
import java.net.*;
import java.util.Random;
import storm.starter.bolt.TcpServer;

class TestTcpServer
{
	public static final int SLEEP_MSEC = 2000;
	
    public static void main(String argv[]) throws Exception
    {
		TcpServer server = new TcpServer();
		server.init();
        Random generator = new Random();
		while(true)
        {
			server.beginPush();
            double lat = 40; // (generator.nextDouble() * 180.0) - 90;
            double lon = -105; //(generator.nextDouble() * 360);
            int    count = generator.nextInt(100);
            int    sentiment = generator.nextInt(10);
			server.push(lat, lon, count, sentiment);
            try {
                Thread.sleep(SLEEP_MSEC);
            } catch(InterruptedException ex) {
				Thread.currentThread().interrupt();
            }
        }
    }
}
