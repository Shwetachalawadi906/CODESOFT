package sdbms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import customexception.InvalidChoiceException;
import customsorting.SortStudentByAge;
import customsorting.SortStudentById;
import customsorting.SortStudentByMarks;
import customsorting.SortStudentByName;

public class StudentManagementSystemimpl  implements StudentManagementSystem 
{
	Scanner sc=new Scanner(System.in);
	Map <String ,Student> db=new LinkedHashMap<String,Student>();
	private Student key;

	@Override
	public void addStudent()
	{
		System.out.println("Enter the student Age:");
		int age=sc.nextInt();
		System.out.println("Enter the student Name:");
		String name=sc.next();
		System.out.println("Enter the student Marks:");
		int marks=sc.nextInt();
		Student s1=new Student(age,name,marks);
		db.put(s1.getId(), s1);
		System.out.println("student record inserted successfully");
		System.out.println("Student id is:"+s1.getId());
	}
	@Override
	public void displayStudent()
	{
		System.out.println("Enter the student id");
		String id=sc.next();   // String id= sc.next().toUpperCase();
		id=id.toUpperCase();
		if(db.containsKey(id))
		{
			Student s=db.get(id);
			System.out.println("id: "+s.getId());
			System.out.println("Age: "+s.getAge());
			System.out.println("Name: "+s.getName());
			System.out.println("Marks: "+s.getMarks());
		}
		else
		{
			try
			{
				throw new StudentNotFountException("studentt with "+ id + " is not found..!");
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public  void displayAllStudent()
	{
		System.out.println("Student details are as follows");
		System.out.println("----------------------");
		Set<String> keys=db.keySet();
		for(String key: keys)
		{
			Student obj=db.get(key);
			System.out.println(obj);
		}
	}
	@Override
	public  void removeStudent()
	{
		System.out.println("Enter student id");
		String id=sc.next().toUpperCase();
		//     id=id.toUpperCase();
		if(db.containsKey(id))
		{
			System.out.println("Student record Found.!");
			System.out.println(db.get(id));
			db.remove(id);
			System.out.println("Student Record deleted successfully");
		}
		else
		{
			try
			{
				throw new StudentNotFountException("student with"+ id+ "is not found..!");
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void removeAllStudent()
	{
		if(db.size()!=0)
		{
			System.out.println("Available student Records : "+db.size());
			db.clear();
			System.out.println("All the student recoed deleted successfully");
		}
		else
		{
			try
			{
				throw new StudentNotFountException("No student records to delete..!");
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public  void updateStudent()
	{
		System.out.println("Enter student id");
		String id=sc.next().toUpperCase();
		if(db.containsKey(id))
		{
			Student s1= db.get(id);
			System.out.println("1:Update Age\n2:Update Name\n3:Update Marks");
			System.out.println("Enter the choice");
			int choice=sc.nextInt();
			switch (choice)
			{
			case 1: 
				System.out.println("Enter Age");
				int age=sc.nextInt();
				s1.setage(age);
				System.out.println("Age updated successfully");
				break;
			case 2: 
				System.out.println("Enter Name");
				String Name=sc.next();
				s1.setname(Name);
				System.out.println("Name updated successfully");
				break;
			case 3: 
				System.out.println("Enter marks");
				int marks=sc.nextInt();
				s1.setmarks(marks);
				System.out.println(" updated successfully");
				break;
			default:
				try
				{
					throw new InvalidChoiceException("Kindly enter the valid choice");
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
			}
		}
		else
		{
			try
			{
				throw new StudentNotFountException("student with id:"+id+ "is not found");
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public  void countStudent()
	{
		System.out.println("No of student Records:"+ db.size());
	}
	@Override
	public  void sortStudent()
	{
		Set<String> keys=db.keySet();
		List <Student> l1= new ArrayList<Student>();
		for(String key: keys)
		{
			Student s= db.get(key);
			l1.add(s);
		}
		System.out.println("1:sort by age\n2:sort by id\n3:sort by marks\n4:sort by Name ");
		System.out.println("Enter the choice");
		int choice=sc.nextInt();
		switch(choice)
		{
		case 1: 
			Collections.sort(l1,new SortStudentByAge());
			display(l1);
			break;	
		case 2: 
			Collections.sort(l1, new SortStudentById());
			display(l1);
			break;	
		case 3: 
			Collections.sort(l1, new SortStudentByMarks());
			display(l1);
			break;	
		case 4: 
			Collections.sort(l1, new SortStudentByName());
			display(l1);
			break;
		default:
			try
			{
				throw new InvalidChoiceException("kindly enter the valid choice");
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}

		}
	}
	private static void display(List<Student> l1)
	{
		for(Student s: l1)
		{
			System.out.println(s);
		}
	}
	@Override
	public void getStudentwithHighestMarks() 
	{
		 Set<String> keys=db.keySet();
	        List<Student> l1= new ArrayList<Student>();
	        for(String key : keys)
	        {
	        	l1.add(db.get(key));
	        }
	        Collections.sort(l1, new SortStudentByMarks());
	        System.out.println("student details with highest marks");
	        System.out.println(l1.get(l1.size()-1));
	}
	@Override
	public void getStudentwithLowestMarks() 
	{
		 Set<String> keys=db.keySet();
	        List<Student> l1= new ArrayList<Student>();
	        for(String key : keys)
	        {
	        	l1.add(db.get(key));
	        }
	        Collections.sort(l1, new SortStudentByMarks());
	        System.out.println("student details with lowest marks");
	        System.out.println(l1.get(0));
	}
}


























