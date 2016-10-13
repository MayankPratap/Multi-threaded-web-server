import java.net.*;
import java.io.*;

public class KKMultiServer{

   public static void main(String[] args) throws IOException{

      if(args.length!=1){

         System.err.println("Use as: java KKMultiServer <root directory>");
         System.exit(1);

      }


      int port=8000;

      String rootDir=args[0];

      boolean listening = true;

      try (ServerSocket serverSocket = new ServerSocket(port)){

         while(listening){

            new KKMultiServerThread(serverSocket.accept()).start();

         }
          
      }catch(IOException e){

          System.err.println("Could not listen on port "+port);
          System.exit(-1);   
      }
   }
}
