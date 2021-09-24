import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/*
This program sorts the data in Long_Student_Set.txt. Contained within
 this file are 1,009 student entries in the following format: First_Name Last_Name GPA.
 Each item in a single entry is separated by a tab (\t) while each entry is separated
 by a newline (\n) character. Final sorted output sorts the students first by
 GPA, then Last_Name, and finally First_Name (i.e. 4.0 students at the top, sorted by last
 name with ties in last name broken by first name). The list will then be in reverse order,
 so that students with the highest GPA are listed first.
 */

public class Student_Data_Main_Allen {

	public static void main(String[] args)
	{
		String fName = new String();
		String lName = new String();
		String gpa = new String();
		ArrayList<Student> studentList = new ArrayList<Student>();
		File file = new File ("Small_Name_List.txt");
		Scanner scan;
		try
		{
			scan = new Scanner(file);

			while(scan.hasNext()){
			fName = scan.next();
			lName = scan.next();
			gpa = scan.next();

			Student student1 = new Student(fName, lName, gpa);
			studentList.add(student1);
			}


			scan.close();
		}//end try
		catch (FileNotFoundException e1)
		{
			e1.printStackTrace();
		}//end catch error

		//iterate
		int count = 0;
		Student [] unsortedArray = new Student[studentList.size()];
		for (Iterator<Student> i = studentList.iterator(); i.hasNext();count++ )
		{
		    Student obj = i.next();
		        unsortedArray[count] = obj;
		}

		//bubblesort-sort the students first by
		//GPA, then Last_Name, and finally First_Name (i.e. 4.0 students at the
		//top, sorted by last name with ties in last name broken by first name).
		Student.bubbleSortGpa(unsortedArray);
		Student.bubbleSortlName(unsortedArray);
		Student.bubbleSortfName(unsortedArray);

	////////////////////////////////////////////////////////////////
		//Write to file
		File outputFile = new File ("S_Name_List.txt");
		try
		{

			FileWriter fw = new FileWriter(outputFile);
			Writer output = new BufferedWriter(fw);

			//list written to file 
			//in reverse order, so that students with the highest GPA are listed first.
			System.out.println("BubbleSort final: ");
			Student.bubbleSortGpa(unsortedArray);

			for (Student E : unsortedArray)
			{

				fw.write(E.toString());
			}

			//close file
			output.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}//End catch error

	}//end main

}//end class
