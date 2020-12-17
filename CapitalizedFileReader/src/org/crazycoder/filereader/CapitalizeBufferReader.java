package org.crazycoder.filereader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CapitalizeBufferReader extends BufferedReader{

	public CapitalizeBufferReader(FileReader fileReader) {
		super(fileReader);
	}
	@Override
	public String readLine() throws IOException {
        String line = super.readLine();
		if(line == null)
			return null;
		else
			return line.toUpperCase();
    }
	
}
