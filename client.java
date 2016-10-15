import java.io.*;
import java.net.*;
import java.util.Scanner;

public class client{

   public static void main(String[] args) throws IOException{

      if(args.length!=2){

          System.err.println("Use as : java <host name> <port number>");

          System.exit(1);

      }

      String hostName=args[0];
      int portNumber=Integer.parseInt(args[1]);

      try(Socket clientSocket=new Socket(hostName,portNumber);
      	 PrintWriter outToServer=new PrintWriter(clientSocket.getOutputStream(),true);
      	  BufferedReader inFromServer=new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));    BufferedReader inFromUser=new BufferedReader(new InputStreamReader(System.in));){
          
          String fromServer;
          String fromUser;

          fromUser=inFromUser.readLine();
          outToServer.println(fromUser);

          //System.out.println("Ye lo!!");
         // System.out.println();


          while((fromServer=inFromServer.readLine())!=null){

               if(fromServer.equals("Bye."))
                 break;


              System.out.println(fromServer);

             
              //   fromUser=inFromUser.readLine();

              /*  if(fromUser!=null){

                 System.out.println("Client: "+fromUser);
                 outToServer.println(fromUser);

              }  */

          }


      }catch(UnknownHostException e){

          System.err.println("Dont know about host"+hostName);
          System.exit(1);

      }



   }



}
