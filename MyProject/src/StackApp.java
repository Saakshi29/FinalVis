
public class StackApp {

	public static void main(String[] args) {
		
		FixedArrayStack s=new FixedArrayStack(10);
		StackUser u=new StackUser();
		u.fill(s);
		u.empty(s);
	}

}
