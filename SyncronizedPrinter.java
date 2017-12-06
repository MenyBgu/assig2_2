package assig2_2;

public class SyncronizedPrinter {
	public static synchronized void println(String txt) {
		System.out.println(txt);
	}

	public static synchronized void print(String txt) {
		System.out.print(txt);
	}
}
