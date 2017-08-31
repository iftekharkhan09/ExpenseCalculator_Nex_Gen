package com.expensecalculator.logging;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.expensecalculator.utils.ReadPropertiesFile;

@Component
public class MonitoringLogProcessor {
	FileAppender fileAppender;

	public void setLog4jProperties() {
		final String propertiesFilePath = "C:\\Users\\212669319\\git\\ExpenseCalculator_Nex_Gen\\Log4j.properties";
		ReadPropertiesFile readPropertiesFile = new ReadPropertiesFile();
		String monitoringfile = readPropertiesFile.getValue("monitoringFile", propertiesFilePath);
		final String LoggingLevel = readPropertiesFile.getValue("LEVEL", propertiesFilePath);
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
