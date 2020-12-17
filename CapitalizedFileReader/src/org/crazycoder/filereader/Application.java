package org.crazycoder.filereader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Application {

	public static void main(String[] args) {
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
	}

}
