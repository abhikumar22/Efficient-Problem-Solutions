import java.io.IOException;
import java.util.Scanner;
import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;

public class effsearch
{	
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
	static int NUM_CHARS = 26;
	
	public class DataNode
	{
		//String word;
		String m_Meaning;
		
		DataNode[] allNextNodes= new DataNode[NUM_CHARS];
		
		public DataNode()
		{
			m_Meaning = "";
		}
		
		public DataNode(String meaning)
		{
			m_Meaning = meaning;
		}
	}
	
	static DataNode[] m_rootNodes=new DataNode[NUM_CHARS];void AddWord(String word, String meaning)
	{
		if ((word == null) || (word == ""))
		{
			return;
		}
		
		word = word.toUpperCase().trim();
		int acsciiA = 65;
		
		int iLength = word.length();
		DataNode presentCharNode = null;
		
		for (int i = 0; i < iLength; i++)
		{
			int iTempIndex = ((int) word.charAt(i)) - acsciiA;
			
			if ((iTempIndex < 0) || (iTempIndex >= 26))
			{
				//word has some special character which is wrong so break
				//System.out.println(word);
				break;
			}
			
			
			if (i == 0)
			{
				presentCharNode = m_rootNodes[iTempIndex];
				continue;
			}
			
			if (presentCharNode.allNextNodes[iTempIndex] == null)
			{
				presentCharNode.allNextNodes[iTempIndex] = this.new DataNode("");
			}
			
			DataNode newCharNode = presentCharNode.allNextNodes[iTempIndex];
			
			if (i == iLength - 1)
			{
				newCharNode.m_Meaning = meaning;
			}
			
			presentCharNode = newCharNode;
		}
	}
	public static String searchword(String wordInput)  
	{
		DataNode tempNode = null;
	    int length = wordInput.length();
	    int acsciiA = 65;
	    
	    if ((wordInput == null) || (wordInput.trim() == ""))
	    {
	    	return "";
	    }
	    
	    wordInput = wordInput.trim().toUpperCase();
	    
		try
		{
			tempNode = m_rootNodes[0];
			int indexForChar;
				
			for(int j = 1;j < length;j++)
			{
				indexForChar = wordInput.charAt(j) - acsciiA;
				tempNode = tempNode.allNextNodes[indexForChar];				
			}
		}
		catch (Exception ex)
		{
			return "";
		}

	    if (tempNode == null)
	    {
	    	return "";
	    }
	    else
	    {
	    	return tempNode.m_Meaning;
	    }
	}
	public static void main(String[] args) throws FileNotFoundException // main function of the program
	{
		FileReader fr = new FileReader("englishdictioanry.txt"); 
		BufferedReader br = new BufferedReader(fr);
		Scanner scan = new Scanner(System.in);
		effsearch objWordSearch = new effsearch();
		for(int i=0;i < NUM_CHARS;i++) 
		{
			objWordSearch.m_rootNodes[i] = objWordSearch.new DataNode("");
		}
		
		//read word from file here and call the below method repeatedly
		//FileReader fr = new FileReader("englishdictioanry.txt"); 
		//BufferedReader br = new BufferedReader(fr);
		int i; 
		//int count=0;
		long t1 = System.nanoTime();
		try 
		{
			String strTemp = "";
				
			while ((strTemp = br.readLine()) != null)
			{
				String[] arrWordMeaning = strTemp.split(",");
				
				if (arrWordMeaning.length != 2)
				{
					continue;
				}
				
				//System.out.println("pp."+count++);
				objWordSearch.AddWord(arrWordMeaning[0], arrWordMeaning[1]);
			}	
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long t2 = System.nanoTime();	
		long st=t2-t1;
		System.out.println("Insertion time="+st);
		//System.out.println("searchTime="+t1);
		//System.out.println("searchTime="+t2);
		
		
		
		
		System.out.println("Enter a word:");
		Scanner scan1 = new Scanner (System.in);
		String word_input = scan1.nextLine();
		
		
		//long start = System.nanoTime();
		// do stuff
		//long end = System.nanoTime();
		//long microseconds = (end - start) / 1000;
		
		
		
		
		
		long start = System.nanoTime();
		//long time_4 = System.currentTimeMillis();
		String strMeaning = searchword(word_input);
		//long time_5 = System.currentTimeMillis();
		long end = System.nanoTime();
		
		System.out.println(strMeaning);
		//long search_time1=time_5-time_4;
		System.out.println("SearchTime="+(end-start));
		//System.out.println("searchTime="+time_5);
		//long microseconds = (end - start);
    }
		
}

		
		
		
		
		
		