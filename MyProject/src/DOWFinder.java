
public class DOWFinder {

	public static String findDOW(int day,int month, int year)
	{
		int numDays=(year-1900)*365;
		numDays=numDays+(year-1900)/4;
		if((year%4==0) &&(month<=2))
		{
	numDays--;			
		}
		switch(month)
		{case 12: numDays+=30;
		case 11: numDays+=31;
		case 10: numDays+=30;
		case 9: numDays+=31;
		case 8: numDays+=31;
		case 7: numDays+=30;
		case 6: numDays+=31;
		case 5: numDays+=30;
		case 4: numDays+=31;
		case 3: numDays+=28;
		case 2: numDays+=31;
		
		
		}
		
		numDays+=day;
		//int dowIndex=numDays/7;
		 int dowIndex = numDays % 7;
	        String dow[] = {"sunday","monday","tuesday","wednesday","thursday","friday","saturday"};
	        return dow[dowIndex]; 
		/*
		if(dowIndex==0)
		{return "Sunday";}
		else if(dowIndex==1)
		{return "Monday";}
		else if(dowIndex==2)
		{return "Tuesday";}
		else if(dowIndex==3)
		{return "Wednesday";}
		else if(dowIndex==4)
		{return "Thursday";}
		else if(dowIndex==5)
		{return "Friday";}
		else
		{return "Saturday";}
		*/
		
		
		
		}
		
	public static void main(String[] args) 
	{
	int day=8;
	int month=7;
	int year=2019;
		System.out.println(findDOW(8,7,2019));
		
	}
	

}
