// java Chat_v2
// java Chat_v2 client localhost firstname
// java Chat_v2 client localhost secondname
// java Chat_v2 client localhost thirdname
// Exit
import java.io.*;
import java.util.*;
import java.net.*;

public class Chat_v2{
	static final int port = 12345;

	static BufferedReader getReader(InputStream is){
		return new BufferedReader(new InputStreamReader(is));
	}

	static BufferedWriter getWriter(OutputStream os){
		return new BufferedWriter(new OutputStreamWriter(os));
	}

	static void writeString(String str, BufferedWriter out) throws Exception{
		out.write(str, 0, str.length());
		out.newLine();
		out.flush();
	}

	static class AllSockets{
		static private Vector<Socket> allSockets = new Vector<Socket>();

    //Access to AllSockets is synchronized to avoid simultaneous element addition and for-loop
		synchronized static public void Add(Socket client) {
      allSockets.add(client); }

		synchronized static public void Remove(Socket client) {
      allSockets.remove(client); }

		synchronized static public void Broadcast(Socket from, String str) throws Exception{
			for(Socket s : allSockets)	// send str to everybody except from
				if(s != from)
					writeString(str, getWriter(s.getOutputStream()));
		}
	}

	static class EchoIncoming implements Runnable{
		BufferedReader reader;

        public EchoIncoming(BufferedReader r) { reader = r; }

        public void run(){
          try{
				        for(;;)
					           System.out.println(reader.readLine());
			    }catch(Exception e) {}
		    }
    }

	static void Client(String host,String nameClient) throws Exception{
		System.out.println("connecting to " + host);
		Socket s = new Socket(host, port);

		new Thread(new EchoIncoming(getReader(s.getInputStream()))).start();

		BufferedReader in = getReader(System.in);
		BufferedWriter out = getWriter(s.getOutputStream());
        String inputMessage = in.readLine();

		while(1){
		   if ( inputMessage.equals("Exit") ) {
		   	  writeString("",out);
		   	  break;
		   }
		   writeString(nameClient +"> "+ inputMessage, out);
		   inputMessage = in.readLine();
		}

		System.exit(0);

	}

	static class Broadcast implements Runnable{
		Socket client;

		public Broadcast(Socket c) { client = c; }

		public void run(){
			try{
				BufferedReader in = getReader(client.getInputStream());
				String msg = in.readLine();
        while (!msg.isEmpty()){
					AllSockets.Broadcast(client, msg);
					msg = in.readLine();
 				}
 				AllSockets.Remove(client);
			}catch(Exception e) {}
	  }
	}

	static void Server() throws Exception{
		ServerSocket s = new ServerSocket(port);
		while(1){
			System.out.println("Listening ...");
			Socket client = s.accept();
			AllSockets.Add(client);
			new Thread(new Broadcast(client)).start();
		}
	}

	public static void main(String args[]){
		try{
			if(args[0].equals("client"))
				Client(args[1],args[2]);
			else
				Server();
		}
		catch(Exception e){System.out.println("Connection error!");}
	}
}
