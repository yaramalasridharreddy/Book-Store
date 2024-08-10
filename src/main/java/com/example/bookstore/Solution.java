package com.example.bookstore;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result 
{

    /*
     * Complete the 'sockMerchant' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY ar
     */

    public static int sockMerchant(int n, List<Integer> ar) 
    {
    	int ele=0;
    	int temp=0;
        if(!(n==ar.size()))
        {
        	return 0;
        }
        else
        {
        	for(int i=0;i<ar.size()-1;i++)
        	{
        		int count=0;
        		int prev=0;
        		ArrayList<Integer> container = null;
        		container.add(ar.get(i));
        		if(!(container.contains(i)))
        		{
        			prev=ar.get(i);
        			temp=prev;
        		}
       			for(int j=0;j<ar.size()-1;j++)
       			{
       				if(ar.get(j)==prev)
       				{
       					count++;
       				}
       			}
       			ele=ele+count/2;
        	}
        	return ele;
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
