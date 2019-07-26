
public class ChemicalElement {

	int atomicNo;
	String symbolicName;
	String fullName;
	static boolean []arr;
	static {
		arr=new boolean[117];
		arr[13]=true;
		arr[49]=true;
		arr[50]=true;
		arr[81]=true;
		arr[82]=true;
		arr[83]=true;
		for(int i=113; i<=116;i++)
		{arr[i]=true;}
	}
	
	ChemicalElement(int atomicNo, String symbolicNAme, String fullName)
	{
		this.atomicNo=atomicNo;
		this.symbolicName=symbolicName;
		this.fullName=fullName;
	}
	
	boolean isAlkaliMetal() {
		int atomicNo=this.atomicNo;
		switch(atomicNo)
		{case 3:return true;
		case 11:return true;
		case 19:return true;
		case 37:return true;
		case 55:return true;
		case 87:return true;}
		return false;}
	
	boolean isTransitionMetal() {
		int atomicNo=this.atomicNo;
		if((atomicNo>=21 && atomicNo <=31)||(atomicNo>=39 && atomicNo <=48)||(atomicNo>=72 && atomicNo <=80)||(atomicNo>=104 && atomicNo <=112))
		return true;
		return false;}
	
	
	 boolean isMetal(){
		
	
		int atomicNo=this.atomicNo;
		if(arr[atomicNo]==true)
			return true;
		return false;}
	
	public boolean equals(ChemicalElement c2)
	{ChemicalElement c1=this;
		if(c1.atomicNo==c2.atomicNo && c1.symbolicName==c2.symbolicName && c1.fullName==c2.fullName)
	return true;
	return false;
	}


}
