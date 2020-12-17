package org.crazycoder.filereader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Application {

	public static void main(String[] args) {
		/**
		 * First implementation
		 */
		
		try {
			CapitalizeFileReader capitalizeFileReader = new CapitalizeFileReader();
			List<String> capitalLines = capitalizeFileReader.readFileInCapital("CheckFile.txt");
			for (String line : capitalLines) {
				System.out.println(line);
			}
		} catch (FileNotFoundException fileNotFoundException) {
			System.out.println("File not found exception " + fileNotFoundException);
		} catch (IOException ioException) {
			System.out.println("IO exception " + ioException);
		}
		
		/**
		 * Second implementation which is correct 
		 */
		
//		try {
//			CapitalizeBufferReader capitalizeBufferReader = null;
//			//List<String> characterArray = new ArrayList<String>();
//			try {
//				capitalizeBufferReader = new CapitalizeBufferReader(new FileReader("CheckFile.txt"));
//
//				String line;
//				while ((line = capitalizeBufferReader.readLine()) != null) {
//					System.out.println(line);
//				}
//			}
//
//			finally {
//				if (capitalizeBufferReader != null) {
//					capitalizeBufferReader.close();
//				}
//			}
//		} catch (FileNotFoundException fileNotFoundException) {
//			System.out.println("File not found exception " + fileNotFoundException);
//		} catch (IOException ioException) {
//			System.out.println("IO exception " + ioException);
//		}
		
		
	}

}
