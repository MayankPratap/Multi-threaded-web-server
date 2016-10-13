import java.net.*;
import java.io.*;

public class KKMultiServerThread extends Thread{
	
   private Socket socket = null;

   public KKMultiServerThread(Socket socket){

      super("KKMultiServerThread");
      this.socket = socket;

   }

   public void run(){

      try(
          
          PrintWriter outToClient = new PrintWriter(socket.getOutputStream(),true);
          BufferedReader inFromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));

      ){

         String inputLine,outputLine;
         KnockKnockProtocol kkp = new KnockKnockProtocol();
         outputLine = kkp.processInput(null);

         outToClient.println(outputLine);

         while((inputLine = inFromClient.readLine())!=null){

             outputLine=kkp.processInput(inputLine);
             outToClient.println(outputLine);

             if(outputLine.equals("Bye"))
             	break;


         }

         socket.close();
      }catch(IOException e){

         e.printStackTrace();

      }

   }

}
