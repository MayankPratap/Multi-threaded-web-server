import java.net.*;
import java.io.*;
import java.util.Scanner;


public class serverthreads extends Thread{
	
   private Socket socket = null;
   
   public String pathname;

   public serverthreads(Socket socket){

      super("IloveThreads");
      this.socket = socket;

      pathname=new server().pathname;

   }

   public void run(){

      try(
          
          PrintWriter outToClient = new PrintWriter(socket.getOutputStream(),true);
          BufferedReader inFromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));

      ){

         String inputLine,outputLine;

         File file = new File(pathname);
         StringBuilder fileContents = new StringBuilder((int)file.length());
         Scanner scanner = new Scanner(file);
         String lineSeperator = System.getProperty("line.seperator");

       
          
            while(scanner.hasNextLine()){

              fileContents.append(scanner.nextLine()+lineSeperator);

            }

            outputLine=fileContents.toString();
           // System.out.println("Hello");
            outToClient.println(outputLine);

            socket.close();
        
         
      }catch(IOException e){

         e.printStackTrace();

      }

   }

}
