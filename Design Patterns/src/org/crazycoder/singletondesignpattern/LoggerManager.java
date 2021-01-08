package org.crazycoder.singletondesignpattern;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LoggerManager {
	private static volatile LoggerManager loggerManager;
	
	private LoggerManager() {
		if(loggerManager!=null) {
			throw new RuntimeException("Please use getLoggerManager method");
		}
	}

	public static LoggerManager getLoggerManager() {
		if(loggerManager == null) {
			synchronized (LoggerManager.class) {
				if(loggerManager==null) {
					loggerManager = new LoggerManager();
				}
			}
		}
		return loggerManager;
	}

	public synchronized void writeLog(String line) {
		File file = new File("EventLogger.txt");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException fileCreationIOException) {
				System.out.println("File not exit and Unable create new File" + fileCreationIOException);
			}
		}

		BufferedWriter bufferedWriter =null;
		/**
		 * We add log to the Eventlogger.txt
		 */
		try {
			bufferedWriter = new BufferedWriter(new FileWriter(file.getAbsoluteFile(), true));
				bufferedWriter.write(line);
		} catch (IOException ioException) {
			System.out.println("Buffered Writer is not able to write " + ioException);
		}
		finally{
			if(bufferedWriter!=null) {
				try {
					bufferedWriter.close();
				} catch (IOException bufferWriterCloseIOException) {
					System.out.println("Buffered writer is not able to close " +bufferWriterCloseIOException);
				}
			}
		}
	}
	
}
