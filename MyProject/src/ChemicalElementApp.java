
public class ChemicalElementApp {

	
	public static void main(String[] args) {
		ChemicalElement c1=new ChemicalElement(1,"H","Hydrogen");
		ChemicalElement c3=c1;
		
		ChemicalElement c2=new ChemicalElement(19,"K","Potassium");
	System.out.println(c1.isAlkaliMetal());
	System.out.println(c1.equals(c3));
	System.out.println(c1.isMetal());
	}

}
