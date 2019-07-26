import java.io.File;
import java.util.*;

public class SearchWorker extends Thread {
	String fileName;
	Queue<File> fileQueue;
	List<File> results;

	public SearchWorker(String fileName, Queue<File> fileQueue, List<File> results) {
		super();
		this.fileName = fileName;
		this.fileQueue = fileQueue;
		this.results = results;
	}

	@Override
	public void run() {
		while (true) {
			File aFileFolder = fileQueue.poll();
			if (aFileFolder == null) {
				break;
			}
			if (aFileFolder.isFile() && aFileFolder.getName().equalsIgnoreCase(fileName))
				results.add(aFileFolder);
			else if (aFileFolder.isDirectory() && aFileFolder.canRead()) {
				File[] contents = aFileFolder.listFiles();
				fileQueue.addAll(Arrays.asList(contents));
			}

		}
	}
}
