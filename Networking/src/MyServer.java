import java.io.*;
import java.net.*;
public class MyServer {
	ServerSocket providerSocket;
	Socket connection = null;
	ObjectOutputStream out;
	ObjectInputStream in;
	String message;
	MyServer(){}
	void run()
	{
            try{
            	  providerSocket= new ServerSocket(2004, 10);
            	  System.out.println("Waiting for connection");
            	  connection = providerSocket.accept();
            	  System.out.println("Connection recieved from" +
            	  connection.getInetAddress().getHostName());
            	  out= new ObjectOutputStream(connection.getOutputStream());
            	  out.flush();
            	  in= new ObjectInputStream(connection.getInputStream());
            	  sendMessage("Connection successful");
            	  
            	  do {
            		    try{
            		    	  message = (String)in.readObject();
            		    	  System.out.println("client>" + message);
            		    	  if(message.equals("bye"));
            		    	            sendMessage("bye");
            		    	            
            		    }  
            		    catch (ClassNotFoundException classnot){
            		    	System.err.println("Data recieved from unknown format");
            		    	
            		    }
            	  }while(!message.equals("bye"));
            }
            catch(IOException ioException){
            	 ioException.printStackTrace();
            	 
            }
            finally{
            	try{
            		  in.close();
            		  out.close();
            			  providerSocket.close();
            		  
            	}
            	catch(IOException ioException){
            		ioException.printStackTrace();
            		
            	}
            	  
            } 
            	  
         }
         void sendMessage(String msg)
         {
        	 try{
        		 
        		 out.writeObject(msg);
        		 out.flush();
        		 System.out.println("server>"+ msg);
        	 }
        	 catch(IOException ioException){
        		    ioException.printStackTrace();
        	 }
         }
         public static void main(String args[])
         {
        	 MyServer server = new MyServer();
        	 while(true){
        		 server.run();
         
         
        	 }
         }
}