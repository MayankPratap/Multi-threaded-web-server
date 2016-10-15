import java.net.*;
import java.io.*;
import java.util.Scanner;

public class server{

    public static String pathname;

   public static void main(String[] args) throws IOException{

      if(args.length!=1){

         System.err.println("Use as: java <port>");
         System.exit(1);

      }


      int port=Integer.parseInt(args[0]);
      

      boolean listening = true;

      try (ServerSocket serverSocket = new ServerSocket(port)){

         while(listening){

            new serverthreads(serverSocket.accept()).start();

         }
          
      }catch(IOException e){

          System.err.println("Could not listen on port "+port);
          System.exit(-1);
          

      }
   }
}
