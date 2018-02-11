import java.util.*;
import java.io.*;
import java.net.*;

public class SocketClient {
	public static void main(String[] args) throws Exception {
		int number,temp;
    String characterGuess;
		Scanner ScannerSystem = new Scanner(System.in);
		Socket SocketServer = new Socket("localhost",2333);

    System.out.println("--------Start!--------");

		Scanner InputScanner = new Scanner(SocketServer.getInputStream());
		String TextInput = input.nextLine();
    PrintStream OutputStream = new PrintStream(SocketServer.getOutputStream());
    while ( !(Text.indexOf('*') < 0)){
        	System.out.println(TextInput);
        	characterGuess = ScannerSystem.nextLine();
          OutputStream.println(characterGuess);
          TextInput = InputScanner.nextLine();
    }

    System.out.println(TextInput);
    System.out.println("---------Congrats----------");
	}
}
