package org.crazycoder.singletondesignpattern;

public class Application {

	public static void main(String[] args) {
		LoggerManager loggerManager = LoggerManager.getLoggerManager();
		loggerManager.writeLog("Hi this is second log : 2020-12-21"+"\n");
		System.out.println(" Log is created Successfully ");
	}

}
