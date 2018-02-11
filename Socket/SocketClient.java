import java.util.*;
import java.io.*;
import java.net.*;

public class SocketClient {
	public static void main(String[] args) throws Exception {
    String characterGuess;
		Scanner ScannerSystem = new Scanner(System.in);

    //Make a scoket and connect it to <host,port>
		Socket SocketServer = new Socket("localhost",1234);

    //Start
    System.out.println("--------Start!--------");

    //Get read stream
		Scanner InputScanner = new Scanner(SocketServer.getInputStream());
		String TextInput = InputScanner.nextLine();

    //Get write stream
    PrintStream OutputStream = new PrintStream(SocketServer.getOutputStream());

    while ( !(TextInput.indexOf('*') < 0)){
        	System.out.println(TextInput);
        	characterGuess = ScannerSystem.nextLine();
          OutputStream.println(characterGuess);
          TextInput = InputScanner.nextLine();
    }

    System.out.println(TextInput);
    System.out.println("---------Congrats----------");
	}
}
