import java.util.Arrays;

public class LambdaUSe {

	
	public void main(String[] args)
	{String[] s= {"hi","this","ise","mee"};
	Arrays.sort(s,(s1,s2)->s1.length()-s2.length());
	for(String t:s)
		System.out.println(t);
	//for(String t:s)
	//System.out.println(s[0]);
//	Arrays.sort(s,(s1,s2)->s2.length()-s1.length());
	//System.out.println(s);
	
	}
	
}
