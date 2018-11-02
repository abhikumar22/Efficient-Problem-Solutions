import java.io.IOException;
import java.util.Scanner;
import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;

public class experiment_j
{	
	static String DICTIONARY_TEXT_FILE = "englishdictioanry.txt";
	
	
	static int n = 26;
	static node[] arr = new node[26];
	static node[] last_node_address = new node[26];
	
	static class node
	{
		String word;
		String meaning;
		node next_node;
		
		node (String word,String meaning)
		{
			this.word=word;
			this.meaning=meaning;
			this.next_node=null;
		}
	}
	public static int container(String a)
	{
		int str_char_zero=0;
		str_char_zero = (int)a.charAt(0);
		return str_char_zero % (n);
	}
	
	// putting each value in the hash table	
	public static void put_node(String word,String meaning)  
	{
		int curr = 0;

		curr = container(word);
	
		if(arr[curr] == null){
			last_node_address[curr] = arr[curr] = new node(word,meaning);
			//add_last_node[curr] = arr[curr];
		}
		else{
			node new_node = new node(word,meaning);
			last_node_address[curr].next_node = new_node;
			last_node_address[curr] = new_node;
			
			//last_node_address[curr].nextnode = new_node.nextnode;
			//arrLastNode[curr] = new_node;
		}

	}
	
	// getting the meaning of the desired word
	public static void get_node(String s)    
	{
		int curr;
		String result_string = null;
		
		curr = container(s); 
		node temp;
		temp = arr[curr];
		 
		while(temp.next_node!=null){
			String st;
			st=temp.word;
			if(s.compareTo(st)==0){
				result_string=temp.meaning;
				break;
			}
			temp=temp.next_node;
		}
		if(result_string!=null){
			System.out.println("Meaning="+result_string);
		}
		else{
			if(s.compareTo(temp.word)==0){
				System.out.println("Meaning="+temp.meaning);
			}
			else{
				result_string="Not found";
			    System.out.println("Error!!"+result_string);
			}
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException // main function of the program
	{
			
		Scanner scan = new Scanner(System.in); 
		FileInputStream fstream = new FileInputStream(DICTIONARY_TEXT_FILE);
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		
		String strLine;
		String[] splitted_string;
		
		
		long time_1 = System.nanoTime();
		try{

			while ((strLine = br.readLine()) != null){
				splitted_string = strLine.split(",");
				put_node(splitted_string[0],splitted_string[1]);

			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	    long time_2 = System.nanoTime();		
		
	    String value;
	    System.out.println("Enter the Word for the meaning :");  
	    while((value=scan.nextLine()).compareTo("0")!=0){
		    long time_3 = System.nanoTime();
		    get_node(value);
		    long time_4 = System.nanoTime();

		    System.out.println("Insertion Time = "+(time_2-time_1));
		    System.out.println("Searching Time = "+(time_4-time_3));
		    System.out.println("\nEnter the Word for the meaning :"); 
	    }
    }
		
}

		
		
		
		
		
		