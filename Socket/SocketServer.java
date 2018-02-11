import java.util.*;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class SocketServer{
	public static void main(String[] args) throws Exception {

		String FirstMessage = "";
        int WordCount = 0;
		List<String> WordList = new ArrayList<String>();
		File file = new File("WordList.txt");
        try( Scanner sc = new Scanner(new FileInputStream(file))){
           while (sc.hasNext()){
           	   String s = sc.next();
           	   WordList.add(s);
           }
        }

        Random rd = new Random();
        int RandomNumber = rd.nextInt(WordList.size());
        StringBuilder starResponseFromServer = new StringBuilder(WordList.size());
        String word = WordList.get(RandomNumber);

        int WordLength = word.length();
        for ( int i = 0; i < WordLength; i++){
             FirstMessage += "*";
             starResponseFromServer.append("*");
        }

        ServerSocket serverSocket = new ServerSocket(2509);
        Socket ss = serverSocket.accept();

        PrintStream p = new PrintStream(ss.getOutputStream());
        p.println(FirstMessage);

        Scanner sc = new Scanner ( ss.getInputStream() );
        String clientAnswer = sc.nextLine();

        char c = clientAnswer.charAt(0);

        while (!FirstMessage.equals(word)){
        	  for ( int i = 0; i < word.length(); i++)
        	  {
        	  	 if ( word.charAt(i) == c ) starResponseFromServer.setCharAt(i,c);
        	  }
        	  FirstMessage = starResponseFromServer.toString();
        	  p.println(FirstMessage);
            clientAnswer = sc.nextLine();
        	  c = clientAnswer.charAt(0);

        }

        p.println(word);

	}
}
