package Z4.java.programms;

public class basicProgrammes 
{

	/*1-Armstrong---
	An Armstrong number of three digits is an integer such that the sum of the cubes of its digits is equal to the number itself. 
	For example, 371 is an Armstrong number since 371=3*3(27) + 7**3(343) + 1**3(3) = 371. Write a program to find all Armstrong number in the range of 0 and 999.
*/
		static void Armstrong (int n)
	    {
		        int c=0, a, temp;
		        temp=n;
		        while(n>0)
		        {
		            a=n%10;
		            n=n/10;
		            c=c+(a*a*a);
		        }
		        if(temp==c)
		        {
		            System.out.println("the numbner is armstrong" + c);
		        }
		        else
		            System.out.println("the numbner is not armstrong" + c);
	    }
	
//2---Fibonacci -a series of numbers in which each number ( Fibonacci number ) is the sum of the two preceding numbers. The simplest is the series 1, 1, 2, 3, 5, 8, etc.
		static void fabonacci(int num) 
		{
			       int fobo = 0, fob1 = 1, fob2 = 1;
			       for (int i = 0; i < num; i++)
			       {
			           fobo = fob1 + fob2;
			           System.out.println(fobo);
			           fob2 = fob1;
			           fob1 = fobo;
			       }
		   }

//3---Palindrome-a word, phrase, or sequence that reads the same backwards as forwards, e.g. madam or nurses run.
		 public static boolean isPalindrome(String word)
	     {
		  	  String reverse ="";
				 int len = word.length();
				 for(int i=len-1;i>=0;i--)
				 {
					 reverse=reverse+word.charAt(i);
				 }
				 if(word.equals(reverse))
				 {
					  System.out.println("Entered string is a palindrome.");
				       return true;
				 }
				 else
				 {
					  System.out.println("Entered string is not a palindrome.");
			             return false;
				  }
			     }
//4-Reverse--------
		 static int reverseNumber(int num)
		    {
		        int rev=0;
		        while(num !=0)
		        {
		            rev=(rev*10)+(num%10);
		            num=num/10;
		        }
		        System.out.println(rev);
		        return rev;
		    }

		    static String reverseString(String a)
		    {
		        char ch[]= a.toCharArray();
		        String rev="";
		        for(int i =ch.length-1; i>0;i--)
		        {
		            rev+=ch[i];

		       }
		        System.out.println(rev);
		        return rev;
		    }

//5-SecondNumber_array--------
		    
		    static void SecondNumber_array(int arr [])
		    {
		    	int largest = arr[0];
				int secondLargest = arr[0];
				System.out.println("The given array is:" );
				for (int i = 0; i < arr.length; i++)
				{
						System.out.print(arr[i]+"\t");
				}
				for (int i = 0; i < arr.length; i++) 
				{
						if (arr[i] > largest) 
						{
							secondLargest = largest;
						}
						else if (arr[i] > secondLargest)
						{
							secondLargest = arr[i];
						}
									
				}
				System.out.println("\nSecond largest number is:" + secondLargest);
		
		    }
		    
///6-Duplicate_Elements_Array
		    static void Duplicate_Elements_Array(String strArray[])
		    {
		    	for (int i = 0; i < strArray.length - 1; i++) 
		    	{
		    		for (int j = i + 1; j < strArray.length; j++) 
		    		{
		    			if ((strArray[i].equals(strArray[j])) && (i != j)) 
		    			{
		    				System.out.println("Duplicate Element is : " + strArray[j]);
		    			}
		    			else
		    			System.out.println("NO Duplicate Element is:" + strArray[j]);
		    		}
		    	}
		    } 	

///7-Prime number  - in Java: Prime number is a number that is greater than 1 and divided by 1 or itself
		    
		    static void PrimeNumber(int n)
		    {
		    	int m=0,flag=0;
		    	
		    	m=n/2;
		    	
		    	for (int i=2;i<m;i++)
		    	{
		    		if(n%i==0)
		    		{
		    			System.out.println("Number is not prime"); 
		    			flag=1;
		    			break;
		    		}
		    	}
		    	if(flag==0)
		    		 System.out.println("Number is prime");    
		    }
		    
		    
		    
		    
		    public static void main(String[] args)
		    {
		    	//isPalindrome("this");
		    	
		    	//String s1[]={"r1","r1","s1"}; 		    	Duplicate_Elements_Array( s1);
		    	
		    	PrimeNumber(13);
		    }
}


