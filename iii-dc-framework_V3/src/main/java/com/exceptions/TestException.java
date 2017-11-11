package com.exceptions;

public class TestException extends RuntimeException 
{

		private static final long serialVersionUID = 1L;
		
		public TestException(String message)
		{
			super(message);
		}
		
		public TestException(Throwable exception) 
		{
			super(exception);
		}
		
		public TestException(String message, Throwable exception) 
		{
			super (message, exception);
		}
}