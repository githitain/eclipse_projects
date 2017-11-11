package LOgging;

import org.apache.log4j.Logger;

public class Hello
{

	final static Logger logger = Logger.getLogger(Hello.class);

	public static void main(String[] args) 
	{

		Hello obj = new Hello();
		obj.runMe("automation");

	}

	private void runMe(String parameter)
	{

		if(logger.isDebugEnabled()){
			logger.debug("This is debug : " + parameter);
		}

		if(logger.isInfoEnabled()){
			logger.info("This is info : " + parameter);
		}

		logger.warn("This is warn : " + parameter);
		logger.error("This is error : " + parameter);
		logger.fatal("This is fatal : " + parameter);

	}

}