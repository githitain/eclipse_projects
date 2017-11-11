package main.utils;

import org.testng.TestException;

import main.utils.LogStatuses;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class CsvLogger 
{
	    private final static String CELLS_SEPARATOR = ",";
	    private final static String ROWS_SEPARATOR = "\n";
	    private final String pathToFile;
	
	    public CsvLogger(String pathToFile, String... columns) 
	    {
	        this.pathToFile = pathToFile;
	
	        File file = new File(pathToFile);
	        if (!file.getParentFile().exists()) 
	        {
	            file.getParentFile().mkdirs();
	        }
	
	        appendLine(pathToFile, false, columns);
	    }
	
	    private static void appendLine(String pathToFile, boolean append, String... cellValues)
	    {
	        try (FileWriter writer = new FileWriter(pathToFile, append)) 
	        {
	            for (int columnNumber = 1; columnNumber < cellValues.length; columnNumber++) 
	            {
	                writer.append(cellValues[columnNumber - 1] + CELLS_SEPARATOR);
	            }
	            writer.append(cellValues[cellValues.length - 1] + ROWS_SEPARATOR);
	        } 
	        catch (IOException e) 
	        {
	            Logger.write(LogStatuses.ERR, e);
	            throw new TestException(e);
	        }
	    }
	
	    public void appendLine(String... cellValues) {
	        appendLine(pathToFile, true, cellValues);
	    }

}