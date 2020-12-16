package org.crazycoder.filereader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CapitalizeFileReader {
	public List<String> readFileInCapital(String path) throws IOException {
		BufferedReader bufferedReader = null;
		List<String> characterArray = new ArrayList<String>();
		try {
			bufferedReader = new BufferedReader(new FileReader(path));

			String line;
			while ((line = bufferedReader.readLine()) != null) {
				characterArray.add(line.toUpperCase());
			}
		}

		finally {
			if (bufferedReader != null) {
				bufferedReader.close();
			}
		}
		return characterArray;
	}
}
