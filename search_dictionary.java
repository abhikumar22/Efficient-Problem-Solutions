import java.io.IOException;
import java.util.Scanner;
import java.io.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.io.BufferedReader;

public class search_dictionary
{	
	public static void main(String[] args) throws FileNotFoundException 
	{
		Scanner scan = new Scanner(System.in); 
		FileInputStream fstream = new FileInputStream("englishdictioanry.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		HashMap<String, String> map = new HashMap<String, String>();
		
		String strLine;
		String[] splitted_string;
		
		//splitted_string = strLine.split(";");
		//System.out.println("Word is = "+splitted_string[0]);
		//System.out.println("meaning is = "+splitted_string[1]);
		
		long time_1 = System.nanoTime();
		try{
			while ((strLine = br.readLine()) != null){
				splitted_string = strLine.split(",");
				map.put(splitted_string[0],splitted_string[1]);
				//System.out.println("Word is = "+splitted_string[0]);
				//System.out.println("meaning is = "+splitted_string[1]);	
			}
		}
		catch (IOException e) {
		e.printStackTrace();
		}
	   long time_2 = System.nanoTime();
	   
	   
       System.out.println("Enter the Word for the meaning :");  
       String value = scan.nextLine();  
	   
	   long time_3 = System.nanoTime();
	   String result = map.get(value);
	   long time_4 = System.nanoTime();
	   
		if(result==null)
			System.out.println("No Succh file"); 
		else
			System.out.println("Value is:"+result); 
	
		
		System.out.println("time for Insertion = "+(time_2-time_1));
		System.out.println("time for Sorting = "+(time_4-time_3));
		
		
    }
		
}

		
		
		
		
		
		