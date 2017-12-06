package assig2_2;

import java.util.ArrayList;

public class main {
	public static void main(String[] args) {
		final String folderPath = "C:\\Users\\Meni\\Desktop\\assig_2\\txt_files";
		final String word1 = "what", word2 = "dog";
		
		ArrayList<String> files;
		files = FilesExplorer.getFilesList(folderPath);
		if (files == null || files.isEmpty() || files.size() == 0)
			SyncronizedPrinter.println("No files in " + folderPath);
		else{
			FileReaderThread a=new FileReaderThread(folderPath+"\\"+files.get(0),word1);
			FileReaderThread b=new FileReaderThread(folderPath+"\\"+files.get(1),word1);
			FileReaderThread c=new FileReaderThread(folderPath+"\\"+files.get(2),word1);
			
			Thread aT=new Thread(a);
			Thread bT=new Thread(b);
			Thread cT=new Thread(c);
			
			aT.start();
			bT.start();
			cT.start();
			try{
				aT.join();
				bT.join();
				cT.join();
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
			a.setWord(word2);
			b.setWord(word2);
			c.setWord(word2);
			
			Thread a2T=new Thread(a);
			Thread b2T=new Thread(b);
			Thread c2T=new Thread(c);
			
			a2T.start();
			b2T.start();
			c2T.start();
			try{
				a2T.join();
				b2T.join();
				c2T.join();
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}
