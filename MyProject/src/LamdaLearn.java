import java.util.Arrays;

public class LamdaLearn {

	public static void main(String[] args) {

		// meth1();
		// meth2();
		// meth3();
		meth4();

	}

	private static void meth4() {
		String longer = betterElement("aaaknskfb", "sjdfkjbfb", (arg1, arg2) -> arg1.length() > arg2.length());
		System.out.println(longer);
		Integer greater = betterElement(10, 20, (i1, i2) -> i1 > i2);
		System.out.println(greater);
	}

	public static <T> T betterElement(T first, T second, TwoElementPredicate<T> condition) {
		if (condition.isFirstBetter(first, second))
			return first;
		else
			return second;

	}

	private static void meth3() {
		String longer = betterstring("aaaknskfb", "sjdfkjbfb", (arg1, arg2) -> arg1.length() > arg2.length());
		System.out.println(longer);
	}

	public static String betterstring(String first, String second, TwostringPredicate condition) {
		if (condition.isFirstBetter(first, second))
			return first;
		else
			return second;
	}

	public static int eChecker(String s1, String s2) {
		if (s1.contains("e") && !s2.contains("e")) {
			return -1;
		} else if (s2.contains("e") && !s1.contains("e")) {
			return -1;
		} else
			return 0;

	}

	// for the one that is not static
	/*
	 * private void meth3() {LamdaLearn l=new LamdaLearn(); String[] s = { "hi",
	 * "this", "ise", "mee" }; Arrays.sort(s,l::eChecker);
	 * System.out.println(Arrays.asList(s)); }
	 * 
	 */

	private static void meth2() {
		String[] s = { "hi", "this", "ise", "mee" };
		Arrays.sort(s, LamdaLearn::eChecker);
		System.out.println(Arrays.asList(s));
	}

	public static void meth1() {

		String[] s = { "hi", "this", "ise", "mee" };

		Arrays.sort(s, (s1, s2) -> s1.length() - s2.length());
		System.out.println(Arrays.asList(s));

		Arrays.sort(s, (s1, s2) -> s2.length() - s1.length());
		System.out.println(Arrays.asList(s));

		Arrays.sort(s, (s1, s2) -> s1.charAt(0) - s2.charAt(0));
		System.out.println(Arrays.asList(s));

		/*
		 * Arrays.sort(s, (s1, s2) -> s1.indexOf('e') - s2.indexOf('e'));
		 * System.out.println(Arrays.asList(s));
		 */

		Arrays.sort(s, (s1, s2) -> {
			if (s1.contains("e") && !s2.contains("e")) {
				return -1;
			} else if (s2.contains("e") && !s1.contains("e")) {
				return -1;
			} else
				return 0;
		});
		System.out.println(Arrays.asList(s));

	}

}
