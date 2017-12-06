package assig2_2;

public class FileReaderThread extends Thread {
	private FileSearchResult fileSearchResult;

	FileReaderThread(String filePath, String word) {
		fileSearchResult=new FileSearchResult();
		fileSearchResult.filePath = filePath;
		fileSearchResult.word = word;
	}
	
	public void printResult(){
		SyncronizedPrinter.println("-----------------------");
		SyncronizedPrinter.println("File: "+fileSearchResult.filePath);
		SyncronizedPrinter.println("Word: "+fileSearchResult.word);
		SyncronizedPrinter.println("Occurences: "+fileSearchResult.occurences);
		SyncronizedPrinter.println("-----------------------");
	}
	
	public void run(){
		fileSearchResult.occurences=FilesExplorer.searchWordInFile(fileSearchResult.filePath, fileSearchResult.word);
		printResult();
	}
	
	public void setWord(String word){
		fileSearchResult.word=word;
	}
}
