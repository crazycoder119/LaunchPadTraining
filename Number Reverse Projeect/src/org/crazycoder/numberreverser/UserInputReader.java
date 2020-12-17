package org.crazycoder.numberreverser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInputReader {
	public  String readUserInputsFromBufferedReader() throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number : ");
		String number = bufferedReader.readLine();
		return number;
	}
}
