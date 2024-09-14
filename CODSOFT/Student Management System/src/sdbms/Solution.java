package sdbms;

import java.util.Scanner;

import customexception.InvalidChoiceException;

public class Solution 
{
	public static void main(String[] args)
	{
		Scanner sc= new Scanner(System.in);
		StudentManagementSystem s1=new StudentManagementSystemimpl();
		System.out.println("WELCOME TO SCHOOL");
		System.out.println("-------------------------------");
		while(true)
		{
			System.out.println("1:addStudent\n2:displayStudent\n3:displayAllStudent\n4:removeStudent\n5:removeAllStudent\n6:updateStudent\n7:countStudent\n8:sortStudent\n9:getStudentwithHighestMarks\n10:getStudentwithLowestMarks\n11:Exit");
			System.out.println("Enter choice");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				s1.addStudent();
				break;
			case 2:
				s1.displayStudent();
				break;
			case 3:
				s1.displayAllStudent();
				break;
			case 4:
				s1.removeStudent();
				break;
			case 5:
				s1.removeAllStudent();
				break;
			case 6:
				s1.updateStudent();
				break;
			case 7:
				s1.countStudent();
				break;
			case 8:
				s1.sortStudent();
				break;
			case 9:
				s1.getStudentwithHighestMarks();
				break;
			case 10:
				s1.getStudentwithLowestMarks();
				break;
			case 11:
				System.out.println("THANK YOU..!");
				System.exit(0);
			default:
				try
				{
					throw  new InvalidChoiceException("Kindly Enter the valid choice");
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
			}
			System.out.println("----------------------------");
		}
	}
}

/**
 * Naming convention or coding Standards by Oracle
 * ----------------------------------------------------
 * 1. class-> Car, AudiCar, SortStudentByAge
 * 2. variable-> age studentAge, noOfStudent
 * 3. method-> display() showDetails()  
 * 4. package-> lowercase-> com, org,jspiders
 * 5. constants-> final variable ->PI EMPID
 * 
 * 
 */




