package oops;
class Emp{
	static int count=100;
	int id;
	String name;
	String dept;
	public Emp(String name,String dept) {
		this.id=count++;
		this.name=name;
		this.dept=dept;
	}
	void show() {
		System.out.println("id : "+id);
		System.out.println( "name "+name);
		System.out.println("dept "+dept);
	}
}
public class StsticKeyword {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Emp ob=new Emp("Ram","IT");
		ob.show();
		//System.out.println(ob.id);
		Emp ob1=new Emp("SHYAM","CS");
		ob1.show();
		//System.out.println(ob.id);
		//System.out.println(ob1.id);
	}

}
