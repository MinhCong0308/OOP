package OtherProject.hust.soict.globalict.garbage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {

	public static void main(String[] args) {
		String filename = "test.txt";
		System.out.println("dm");
		byte[] inputBytes = {0};
		long startTime, endTime;
		try {
			inputBytes = Files.readAllBytes(Paths.get(filename));
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("dm");

		startTime = System.currentTimeMillis();
		String outputString = "";
		for(byte b : inputBytes) {
			outputString += (char)b;
		}
		
		endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
	}

}