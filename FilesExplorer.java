package assig2_2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FilesExplorer {

	/*******************************
	 * arguments: folder path ***************************** returns: ArrayList
	 * of Strings, that contains the names of the files inside the chosen folder
	 * or null if path is wrong ***************************** usage example:
	 * FilesExplorer.searchWordInFile(filePath, word)
	 * *****************************/
	public static ArrayList<String> getFilesList(String folderPath) {
		ArrayList<String> results = new ArrayList<String>();

		File[] files = new File(folderPath).listFiles();
		/*
		 * If this pathname does not denote a directory, then listFiles()
		 * returns null
		 */
		if (files == null)
			return null;

		for (File file : files) {
			if (file.isFile()) {
				results.add(file.getName());
			}
		}
		return results;
	}

	/*******************************
	 * arguments: file path and word to search in file
	 * ***************************** return: number of occurrences of the word
	 * inside the file, or -1 if file not found or -2 if error arise while
	 * reading file ***************************** usage example:
	 * FilesExplorer.searchWordInFile(filePath, word)
	 * *****************************/
	public static int searchWordInFile(String filePath, String searchedWord) {
		int word_occurences = 0;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(filePath));
		} catch (FileNotFoundException e) {
			System.out.println("File Was Not Found! Check Path");
			return -1;
		}

		String fileContent = null;
		try {
			// StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			while (line != null) {

				String[] lineArr = line.split(" ");
				for (String currWord : lineArr)
					if (currWord.equals(searchedWord))
						word_occurences++;
				// sb.append(line);
				// sb.append(System.lineSeparator());
				line = br.readLine();
			}
			// fileContent = sb.toString();
			br.close();

		} catch (IOException e) {
			System.out.println("Error While Reading File");
			return -2;
		}
		return word_occurences;
	}

}
