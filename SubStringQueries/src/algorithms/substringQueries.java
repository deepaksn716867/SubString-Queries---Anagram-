package algorithms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class substringQueries {
	public static void main(String args []) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader("E:\\hack.txt")); //Enter the input file for the substring anagram problem
        String line = br.readLine();
        int N = Integer.parseInt(line);
        class input
    	{
    		int numberofInput;
    		String string;
    		int noOfQueryString;
    		String [] QueryString ;
    	}
        ArrayList<input> samples = new ArrayList<input>();
        for (int i = 0; i < N; i++) 
        {
        	input a =new input();
        	a.string = br.readLine();
        	a.noOfQueryString = Integer.parseInt(br.readLine());
        	a.QueryString = new String[a.noOfQueryString];
        	for(int j=0;j<a.noOfQueryString;j++)
        	{
        		a.QueryString[j] = br.readLine();
        	}
        	samples.add(a);
        }
        int noofHits = 0;
        String substring = "";
        int endIndex = 0;
        for(input b : samples)
        {
        	for(int k = 0; k<b.noOfQueryString; k++)
        	{
        		for(int blockLength = 1; blockLength <= b.string.length();blockLength++)
        		{
        			endIndex = 0;
        			for(int startIndex = 0; startIndex <= b.string.length(); startIndex++)
        			{
        				endIndex = startIndex + blockLength;
        				
        				if(endIndex > b.string.length())
        				{
        					break;
        				}
        				substring =  b.string.substring(startIndex, endIndex);
        				
        				System.out.println("The substring is "+substring);
        				
        				if(b.QueryString[k].length() > substring.length())
        				{
        					break;
        				}
	        			if(substring.contains(b.QueryString[k]))
	        			{
	        				noofHits++;
	        			}
	        			else if(b.QueryString[k].length() > 1)
	        			{
	        				Boolean anagram = true;
	        				for(int innerloop = 0; innerloop < b.QueryString[k].length() ;innerloop++)
	        				{
	        					if(substring.contains(Character.toString(b.QueryString[k].charAt(innerloop))))
	        					{
	        						continue;
	        					}
	        					else
	        					{
	        						anagram = false;
	        						break;
	        					}
	        				}
	        				if(anagram)
	        				{
	        					noofHits++;
	        				}
	        			}
        			}
        		}
        		System.out.println("No of Hits are :"+noofHits);
        		noofHits = 0;
        	}
        	
        }
	}
}
