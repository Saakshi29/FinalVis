import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Predicate;

public class MapR {

	public static void main(String[] args) {
		Map<String, String> m = new HashMap<String, String>();
		List<String> words = Arrays.asList("hi", "hello", "hwo");
		words.forEach(w -> System.out.println(w + " "));

		words.stream().forEach(System.out::println);

		String[] x = words.stream().map(s -> s + "!").toArray(String[]::new);
		for (String r : x)
			System.out.println(r);

		String l = words.stream().reduce("", (s1, s2) -> s1.toUpperCase() + s2.toUpperCase()).toString();
		System.out.println(l);

		String fin = words.stream().map(s -> s.toUpperCase()).reduce("", String::concat).toString();
		System.out.println(fin);
	
		String l2 = words.stream().reduce( (s1, s2) -> s1+","+s2).orElse("null");
		System.out.println(l2);
		
		
		double[] arr2=new Random().doubles(10).toArray();
	for(double a:arr2)
		System.out.println(a);
		
	}

}
