
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class PredicateTry {

	public static void main(String[] args) {
		List<String> words = Arrays.asList("hi", "hello", "okay");
		System.out.println(words);
		Predicate<String> p1 = s -> s.length() < 4;
		Predicate<String> p2 = s -> s.contains("b");
		Predicate<String> p3 = s -> s.length() % 2 == 0;
		List<String> res = allMatches(words, p1);
		System.out.println(res);
		List<String> res1 = allMatches(words, p2);
		System.out.println(res1);
		List<String> res2 = allMatches(words, p3);
		System.out.println(res2);
		Predicate<Integer> p = j -> j < 10;
		List<Integer> num = Arrays.asList(1, 22, 40, 5, 8, 10);
		List result = allMatchesG(num, p);
		System.out.println(result);

		Function<String, String> f = s -> s + "!";
		Function<String, Integer> f2 = s -> s.length();
		System.out.println(TransformedListG(words,f2));

		TransformedList(words, f);
	}

	public static void TransformedList(List<String> l, Function<String, String> f) {

		List<String> lr = new ArrayList<String>();
		for (String k : l) {
			k = f.apply(k);
			lr.add(k);
		}

		System.out.println(lr);

	}

	public static <T, K> List<T> TransformedListG(List<K> l, Function<K, T> f) {

		List<T> lr = new ArrayList<T>();
		for (K k : l) {
			T t = f.apply(k);
			lr.add(t);
		}
		return lr;

	}

	public static List<String> allMatches(List<String> words, Predicate<String> p) {
		List<String> arr = new ArrayList<String>();

		for (String k : words) {
			if (p.test(k))
				arr.add(k);
		}

		// System.out.println(arr1);
		return arr;

	}

	public static <T> List<T> allMatchesG(List<T> words, Predicate<T> p) {
		List<T> arr = new ArrayList<T>();

		for (T k : words) {
			if (p.test(k))
				arr.add(k);
		}

		// System.out.println(arr1);
		return arr;

	}

}