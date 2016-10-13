import java.io.*;
import java.net.*;

public class KnockKnockClient{

   public static void main(String[] args) throws IOException{

      if(args.length!=2){

          System.err.println("Use as : java KnockKnockClient <host name> <port number>");

          System.exit(1);

      }

      String hostName=args[0];
      int portNumber=Integer.parseInt(args[1]);

      try(Socket clientSocket=new Socket(hostName,portNumber);
      	  PrintWriter outToServer=new PrintWriter(clientSocket.getOutputStream(),true);
      	  BufferedReader inFromServer=new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));){

          BufferedReader inFromUser=new BufferedReader(new InputStreamReader(System.in));

          String fromServer,fromUser;

          while((fromServer=inFromServer.readLine())!=null){

              System.out.println("Server: "+fromServer);

              if(fromServer.equals("Bye."))
              	 break;

              fromUser=inFromUser.readLine();

              if(fromUser!=null){

                 System.out.println("Client: "+fromUser);
                 outToServer.println(fromUser);

              }

          }


      }catch(UnknownHostException e){

          System.err.println("Dont know about host"+hostName);
          System.exit(1);

      }



   }



}
