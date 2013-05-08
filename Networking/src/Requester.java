import java.io.*;
import java.net.*;
public class Requester {
	   Socket requestSocket;
	   ObjectOutputStream out;
	   ObjectInputStream in;
	   String message;
	   Requester(){}
	   void run()
	   {
		   
		   try{
         	  requestSocket= new Socket("192.168.5.55",2004);
         	  System.out.println("Connected to localhost in port 2004");
         	  out= new ObjectOutputStream(requestSocket.getOutputStream());
        	  out.flush();
        	  in= new ObjectInputStream(requestSocket.getInputStream());
        	  
        	  do{
        		  
        		    try{
        		    	
        		    	 message = (String)in.readObject();
       		    	     System.out.println("server>" + message);
       		    	     sendMessage("Hi dude");
       		    	     message= "bye";
       		    	     sendMessage("the eagle has landed");
       		    	     
        		    }
        		    catch (ClassNotFoundException classnot){
        		    	System.err.println("Data recieved from unknown format");
        		    	
        		    }
        	        }while(!message.equals("bye"));
        	        
        	  }
        	  catch(UnknownHostException unknownHost){
        		  System.err.println("you are trying to connect to an unknown host");
        		  
        	  }
        	  catch(IOException ioException){
             	 ioException.printStackTrace();
             	 
             }
             finally{
             	try{
             		  in.close();
             		  out.close();
             		  requestSocket.close();
             		  
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
	        		 System.out.println("client>"+ msg);
	        	 }
	        	 catch(IOException ioException){
	        		    ioException.printStackTrace();
	        	 }
	         }
	         public static void main(String args[])
	         {
	        	 Requester client = new Requester();
	        	
	        		 client.run();
	         }
	         
	   }
	         
