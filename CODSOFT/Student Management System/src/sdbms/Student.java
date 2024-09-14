package sdbms;

public class Student 
{
	private String id;
	private int age;
	private String name;
	private int marks;
	 static int count=101;
	Student( int age, String name, int marks)
	{
		this.id="JSP"+count;
		this.age=age;
		this.name=name;
		this.marks=marks;
		count++;
	}
	public void setage(int age)
	{
     this.age=age;
	}
	public void setname(String name)
	{
     this.name=name;
	}
	public void setmarks(int marks)
	{
      this.marks=marks;
	}
	public String getId()
	{
		return id;
	}
	public int getAge()
	{
		return age;
	}
	public String getName()
	{
		return name;
	}
	public int getMarks()
	{
		return marks;
	}
	@Override
	public String toString()
	{
		return "id :" +id +" Age: "+age+ " Name: "+name+" Marks:"+ marks;  
	}
}
