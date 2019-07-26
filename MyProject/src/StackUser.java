
public class StackUser{

	
	public void fill(Stack s) {
		
		for(int i=0;i<10;i++)
			{s.push(i);
			System.out.println(i);
			}
	}
	
	public void empty(Stack s) {
		for(int i=0;i<10;i++)
		System.out.println(s.pop());
	}
}
