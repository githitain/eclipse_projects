package main.utils;

import main.exceptions.TestException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomGenerator 
{
    private static final Random random = new Random();
    private static final int BARCODE_LENGTH = 10;

    public static String getBarcode() 
    {
        return getRandomNumberByLength(BARCODE_LENGTH).toString();
    }

    public static String getTestSpecificBarcode() 
    {
        return getRandomNumberByLength(BARCODE_LENGTH - TestRunSuffix.getCurrentTestSuffix().toString().length()).toString();
    }

    public static Long getRandomNumberByLength(int length) 
    {
        return getRandomNumber(
                Math.round(Math.pow(10, length - 1)),
                Math.round(Math.pow(10, length) - 1));
    }

    public static Long getRandomNumber(long min, long max) 
    {
        if (min == max) 
        {
            return min;
        }

        long border = max - min;

        long bits, val;
        do 
        {
            bits = (random.nextLong() << 1) >>> 1;
            val = bits % border;
        } while (bits - val + (border) < 0L);

        return val + min;
    }

    public static int getRandomInt(int min, int max) 
    {
        if (min == max) 
        {
            return min;
        }
        return random.nextInt((max - min) + 1) + min;

    }

    public static List<String> getStringsWithRandomNumber(String word, int countWords, int lengthOfNum) 
    {
	        List<String> resultArray = new ArrayList<>();
	        if (word == null || countWords <= 0 || lengthOfNum <= 0) 
	        {
	            throw new TestException(String
	                    .format("incorrect parameters:\nWord='%1s'\nCounts of words ='%2s'\nLength of random numbers='%3s'",
	                            word, countWords, lengthOfNum));
	        }
	        for (int i = 0; i < countWords; i++) 
	        {
	            resultArray.add(word.concat(RandomGenerator.getRandomNumberByLength(lengthOfNum).toString()));
	        }
	        return resultArray;
    }

    public static String getStringWithRandomNumber(String word, int lengthOfNum)
    {
        return word.concat(String.valueOf(getRandomNumberByLength(lengthOfNum)));
    }

}
