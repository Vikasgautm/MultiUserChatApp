package oops;
class parent_1{
	int x;
	public parent_1() {
		x=20;
		System.out.println("parent class const ");
	}
}
class child_1 extends parent_1{
	int x;
	public child_1() {
		super();
		x=50;
		System.out.println("child ");
	}
	public child_1(int x) {
		this();
		int total=x+this.x+super.x;
		System.out.println("child clss const are..."+total);
	}
}

public class Super {
	public static void main(String[]args) {
		child_1 ob=new child_1(30);
	}

}
