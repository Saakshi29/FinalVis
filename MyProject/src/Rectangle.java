
public class Rectangle {
private int width;
private int height;
Rectangle(int width, int height)
{this.height=height;
this.width=width;}
Rectangle(){}
void draw(int width,int height)
{this.height=height;
this.width=width;}

	String getShapeName(){return "Rectangle";}
	int computeArea() {return this.height*this.width;}
	
}
