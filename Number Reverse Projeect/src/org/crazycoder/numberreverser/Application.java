package org.crazycoder.numberreverser;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Stack;

public class Application {
	public static void main(String[] args)  {

		try {
			Stack<BigInteger> bigIntegerStack = new Stack<BigInteger>();
			// reading the number from user using BufferReader
			UserInputReader userInputReader = new UserInputReader();
			String number = userInputReader.readUserInputsFromBufferedReader();

			System.out.println();
			// Adding numbers one by one to stack
			BigInteger bigIntegerNumber = new BigInteger(number);
			BigInteger devicer = new BigInteger("10");
			for (BigInteger a = new BigInteger("10"); a.signum() > 0; a = a.divide(devicer)) {
				BigInteger bigIntegerTemp = bigIntegerNumber.divide(a);
				if (bigIntegerTemp.compareTo(new BigInteger("10")) > 0) {
					a = a.multiply(new BigInteger("100"));
					continue;
				}
				if (bigIntegerTemp.signum() > 0) {
					System.out.print(bigIntegerTemp);
					bigIntegerStack.push(bigIntegerTemp);
					bigIntegerNumber = bigIntegerNumber.subtract(bigIntegerTemp.multiply(a));
				}
			}
			System.out.println();
			System.out.println("--------------------------------------");

			System.out.println("The new Stack is: " + bigIntegerStack);
			// Reverse the number using stack
			while (!bigIntegerStack.isEmpty()) {
				System.out.print(bigIntegerStack.pop());
			}
		} 
		catch (ArithmeticException arithmeticException) {
			System.out.println("Number devide by zero " +arithmeticException);
		}
		
		catch (IOException ioException) {
			System.out.println("User input not taken  " +ioException);
		}
	}
}
