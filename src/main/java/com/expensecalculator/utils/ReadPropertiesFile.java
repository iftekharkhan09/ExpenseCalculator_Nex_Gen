package com.expensecalculator.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;

public class ReadPropertiesFile {
	final static Logger logger = Logger.getLogger(ReadPropertiesFile.class);
	public String key;

	public String getValue(String key, String filename) {
		this.key = key;
		try {
			File file = new File(filename);
			FileInputStream fileInput = new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(fileInput);
			String value = properties.getProperty(key);
			fileInput.close();
			return value;
		} catch (FileNotFoundException e) {
			logger.error("Unable to locate the properties file - " + e);
		} catch (IOException e) {
			logger.error("Error while reading the properties file - " + e);
		}
		return null;
	}
}