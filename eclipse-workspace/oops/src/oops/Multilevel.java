package oops;
class GrandFather{
	int x=10;
}
class Father extends GrandFather{
	int x=20;
}
class Son extends Father{
	int x=30;
	public Son(int x) {
		System.out.println();
	}
}

public class Multilevel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Son ob=new Son(5);
	}

}
