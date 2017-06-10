package com.expensecalculator.logging;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

import com.expensecalculator.utils.ReadPropertiesFile;

public class MonitoringLogProcesser {
	FileAppender fileAppender;
	public void setLog4jProperties() {
		ReadPropertiesFile readPropertiesFile = new ReadPropertiesFile();
		String monitoringfile = readPropertiesFile.getValue("monitoringFile", "D:\\Log4j.properties");
		final String LoggingLevel = readPropertiesFile.getValue("LEVEL", "D:\\Log4j.properties");
		PatternLayout layout = new PatternLayout();
		String conversionPattern = "%d{yyyy-MM-dd HH:mm:ss} [%-4p] [%t] %c:%L - %m%n";
		layout.setConversionPattern(conversionPattern);
		fileAppender = new FileAppender();
		fileAppender.setFile(monitoringfile);
		fileAppender.setLayout(layout);
		fileAppender.activateOptions();
		Logger rootLogger = Logger.getRootLogger();
		if (LoggingLevel.equalsIgnoreCase("ALL"))
			rootLogger.setLevel(Level.ALL);
		else if (LoggingLevel.equalsIgnoreCase("DEBUG"))
			rootLogger.setLevel(Level.DEBUG);
		else if (LoggingLevel.equalsIgnoreCase("WARN"))
			rootLogger.setLevel(Level.WARN);
		else if (LoggingLevel.equalsIgnoreCase("INFO"))
			rootLogger.setLevel(Level.INFO);
		else if (LoggingLevel.equalsIgnoreCase("ERROR"))
			rootLogger.setLevel(Level.ERROR);
		else
			rootLogger.setLevel(Level.FATAL);
		rootLogger.addAppender(fileAppender);
	}
}
