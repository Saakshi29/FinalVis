import java.util.*;

class StringLengthComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		return o1.length() - o2.length();

	}

}

public class CollectionsDemo {

	
	//to return highest no. instead of void, put T
	//public static<T> void mySort(List<T> l,Comparator<T> c)
	{//some sort logic
		
	}
	
	//generic method
	public static<T> void mySort(List<T> l,Comparator<?super T> c)
	{//some sort logic
		
	}
	//public static void mySort(List l,Comparator c)
	
	public static void main(String[] args) {
		// listsDemo();
		// mapDemo();
		// setdemo();
		//sortDemo();

	}

	private static void sortDemo() {

		String[] words = { "this", "is", "a", "test", "of", "sorteeeeed", "lists", "made", "from", "arrays" };

		List<String> wordList = Arrays.asList(words);
		System.out.println("before sorting\n" + wordList);
//Collections.sort(wordList);
		Collections.sort(wordList,new Comparator<String>() {

		@Override
		public int compare(String o1, String o2) {
			// TODO Auto-generated method stub
			return 0;
		}
		});
		Collections.sort(wordList, new StringLengthComparator());
		System.out.println("afteer" + wordList);

	}

	private static void mapDemo() {
		Map<String, String> emp = new HashMap<String, String>();
		emp.put("E1234", "Steve Jobs");
		emp.put("E2345", "Bill Gates");
		emp.put("E3456", "Larry Ellison");
		emp.put("E4567", "Jeff Bezos");
		emp.put("E8765", "Mark Zuckerberg");
		emp.put("E6789", "Larry Page");
		while (true) {
			String input = fromKB("enter id");
			if (input.equalsIgnoreCase("quit"))
				break;
			if (emp.containsKey(input))
				System.out.println(emp.get(input));
			else
				System.out.println("cant find");

		}
	}

	private static void setdemo() {
		Set<String> words = new TreeSet<String>();
		while (true) {
			String aWord = fromKB("enter a unique wrd");
			if (!words.add(aWord)) {
				System.out.println("duplicate");
			}
			if (words.size() == 10)
				break;
		}
		System.out.println("unique");
		for (String aWord : words) {
			System.out.println(aWord);

		}
	}

	private static String fromKB(String prompt) {
		System.out.println("enter");
		Scanner s = new Scanner(System.in);
		return s.nextLine();
	}

	private static void listsDemo() {
		List<MyCircle> circles = new ArrayList<MyCircle>();
		while (true) {
			double aRadius = Math.random();
			if (aRadius < 0.01) {
				break;
			}
			MyCircle aCircle = new MyCircle(aRadius);
			circles.add(aCircle);
		}
		System.out.println(circles.size());
		/*
		 * System.out.println(circles.size()); for(MyCircle c:circles)
		 * {System.out.println(c.area());
		 * 
		 * }
		 */

		/*
		 * for(MyCircle c:circles) {if(c.getRadius()<0.5) {circles.remove(c);}
		 * 
		 * 
		 * } System.out.println(circles.size());
		 */

		Iterator<MyCircle> it = circles.iterator();
		while (it.hasNext()) {
			MyCircle c = it.next();
			if (c.getRadius() < 0.5) {
				it.remove();
			}

		}
		System.out.println(circles.size());
	}

}
