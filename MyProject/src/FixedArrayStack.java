
public class FixedArrayStack implements Stack {

	int[] s;
	int top=-1;
	
	
	
	
	public FixedArrayStack(int cap) {
		s=new int[cap];
	}

	@Override
	public void push(Object element) {
		top++;
		s[top]=(int)element;
		
		
	}

	@Override
	public Object pop() {
		Object ele=s[top];	
		top--;
		return ele;
	}
	
}
