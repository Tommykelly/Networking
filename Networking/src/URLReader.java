import java.io.*;
import java.net.URL;

public class URLReader {
	
public static void main(String args[]){
	URL myURL;
	InputStreamReader  myURLContent;
	int intValue;
	
	try{
		
		myURL= new URL("http://www.ballybunionnews.com");
		myURLContent= new InputStreamReader(myURL.openStream());
		intValue= myURLContent.read();
		while (intValue!=-1){
			System.out.print((char)intValue);
			intValue = myURLContent.read();
			
		}
		myURLContent.close();
		
	}
	catch(Exception e){
		 System.out.println("Error while opening URL");
			
	}
	
	
	
}
	
}


