package utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import beanpackage.Doctors;

public class Utility {
 
	static Scanner scanner = new Scanner(System.in);	
	
	
	
	public static  int readInteger()
	{
		return scanner.nextInt();
	}
	public static String readString()
	{
		return scanner.next();
	}
	public static double readDouble()
	{
		return scanner.nextDouble();
		
	}
	public static long readLong()
	{
		return scanner.nextLong();
		
	}
	public static boolean readBoolean()
	{
		return scanner.nextBoolean();
		
	}
	public static char readChar()
	{
		return scanner.next().charAt(0);
		
	}
	
	public static <T> List<T>  readFile(String filename,Class<T[]> clazz)
	{   List<T> list = null;
		BufferedReader  reader = null;
		 String jsonArray = "";
			try {
				reader = new BufferedReader(new FileReader(filename));
			} catch (FileNotFoundException e) {
				System.out.println(" not exist");	
			}
			
			 try {
				 String line = "";
				 while ((line = reader.readLine()) != null) {
			           jsonArray += line;
				 }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 //System.out.println(jsonArray);
	    if(jsonArray != null)
	    {
			 ObjectMapper objectMapper = new ObjectMapper();
	           
			 try {
				 list= new LinkedList<T> (Arrays.asList(objectMapper.readValue(jsonArray,clazz)));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
		return list;
	}
    

	
	public static <T> void saveDetails(String filename,List<T> list) {
		ObjectMapper mapper = new ObjectMapper();   
		 try {
			mapper.writeValue(new File(filename),list);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
}
