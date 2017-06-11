package scatter;

public class Point {
	int x;
	int y;
	Point(){	x=0;	y=0;}
	Point(int a,int b){
		x=a;
		y=b;
	}
	public String toString(){
		String res = "(";
		res+=x;
		res+=",";
		res+=y;
		res+=")";
		return res;
	}
}
