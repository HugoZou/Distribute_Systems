import java.util.*;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class SocketServer{
  public static  List<String> WordList = new ArrayList<String>();

  //Get word from the file
  public static String GetWord(){
    //Get word from wordlist.txt
    File file = new File("words.txt");
        try( Scanner scan = new Scanner(new FileInputStream(file))){
           while (scan.hasNext()){
               String s = scan.next();
               WordList.add(s);
           }
        }catch (Exception e) {

        }

    // select a word randomly
    Random rand = new Random();
    int RandomNumber = rand.nextInt(WordList.size());
    String word = WordList.get(RandomNumber);
    return word;

  }
	public static void main(String[] args) throws Exception {
        String FirstMessage = "";

        StringBuilder starResponseFromServer = new StringBuilder(WordList.size());
        String word = GetWord();
        //Initial the connect
        int WordLength = word.length();
        for ( int i = 0; i < WordLength; i++){
             FirstMessage += "*";
             starResponseFromServer.append("*");
        }

        // Make a scoket, bound to <port>
        ServerSocket serverSocket = new ServerSocket(1234);

        //Read/write data
        Socket SocketServer = serverSocket.accept();

        PrintStream Output = new PrintStream(SocketServer.getOutputStream());
        Output.println(FirstMessage);

        Scanner ScanClient = new Scanner ( SocketServer.getInputStream() );
        String clientAnswer = ScanClient.nextLine();
        // client input character
        char c = clientAnswer.charAt(0);

        while (!FirstMessage.equals(word)){
        	  for ( int i = 0; i < word.length(); i++){

              //If you guess right, conver * to right character
        	  	 if ( word.charAt(i) == c ) starResponseFromServer.setCharAt(i,c);
        	  }
        	  FirstMessage = starResponseFromServer.toString();
        	  Output.println(FirstMessage);
            clientAnswer = ScanClient.nextLine();
        	  c = clientAnswer.charAt(0);

        }

        Output.println(word);

	}
}
