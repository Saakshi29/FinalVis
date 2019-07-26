
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.*;

public class FileSearch {

	public static void main(String[] args) throws InterruptedException {
		String fileName = args[0];
		String folderName = args[1];
		File folder = new File(folderName);
		File[] contents = folder.listFiles();
		//Queue<File> filesQueue1 = new LinkedList<File>();
		Queue<File> filesQueue = new ConcurrentLinkedQueue<File>();
		List<File> results = Collections.synchronizedList(new ArrayList<File>());
		List<File> results1 = new ArrayList<File>();
		filesQueue.addAll(Arrays.asList(contents));
		SearchWorker w1 = new SearchWorker(fileName, filesQueue, results);

		SearchWorker w2 = new SearchWorker(fileName, filesQueue, results);
		SearchWorker w3 = new SearchWorker(fileName, filesQueue, results);
		SearchWorker w4 = new SearchWorker(fileName, filesQueue, results);
		w1.start();
		w2.start();
		w3.start();
		w4.start();

		w1.join();
		w2.join();
		w3.join();
		w4.join();
		System.out.println("there were" + results.size() + "matches found");
		results.forEach(f->System.out.println(f.getAbsolutePath()));
		
	}

}
