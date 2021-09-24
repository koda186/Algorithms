
public class Student {
    private String first_name;
    private String last_name;
    private Double gpa;
    
    public Student()
	{
		first_name = null;
		last_name = null;
		gpa = Double.parseDouble(null);
	}
    
    public Student(String fName, String lName, String gpa2)
	{
		first_name = fName;
		last_name = lName;
		gpa = Double.parseDouble(gpa2);
	}
	
	public double getGpa()
	{
		return gpa;
	}
	
	public String getfName()
	{
		return first_name;
	}
	
	public String getlName()
	{
		return last_name;
	}
	
	public String toString() 
	{
        return (getfName() +
                    "    " + getlName() +
                    "    " + getGpa() + "\n");
   }
	
	//GPA Bubblesort
	public static void bubbleSortGpa(Student[] student)
    {
        int n = student.length;
        for (int i = 0; i < n - 1; i++) 
        {
            for (int j = 0; j < n - i - 1; j++) 
            {
            		Student student1 = student[j];
            		Student student2 = student[j+1];
            		double grade = student1.getGpa();
            		double grade2 = student2.getGpa();
                //compare grades
            		if ((grade) < (grade2))
                {
                    // swap temp and my_data[i]
                    Student temp = student[j];
                    student[j] = student[j+1];
                    student[j+1] = temp;
                }
            }
        }
        //print bubbleSort to screen
        for (int j = 0; j < student.length; j++) 
        {
	        System.out.print("gpa Sorted: " + student[j] );
	    }
        System.out.println();
    }
	
	//first_name bubblesort
	public static void bubbleSortfName(Student[] student)
    {
        int n = student.length;
        for (int i = 0; i < n - 1; i++) 
        {
            for (int j = 0; j < n - i - 1; j++) 
            {
            		Student student1 = student[j];
            		Student student2 = student[j+1];
            		String fName = student1.getfName();
            		String fName2 = student2.getfName();
                //compare fName
            		if (fName.compareTo(fName2) >  0)
                {
                    // swap temp and my_data[i]
                    Student temp = student[j];
                    student[j] = student[j+1];
                    student[j+1] = temp;
                }
            }
        }
        //print bubbleSort to screen
        for (int j = 0; j < student.length; j++) 
        {
	        System.out.print("fName Sorted: " + student[j] );
	    }
        System.out.println();
    }
    
	//last_name bubblesort
		public static void bubbleSortlName(Student[] student)
	    {
	        int n = student.length;
	        for (int i = 0; i < n - 1; i++) 
	        {
	            for (int j = 0; j < n - i - 1; j++) 
	            {
	            		Student student1 = student[j];
	            		Student student2 = student[j+1];
	            		String lName = student1.getlName();
	            		String lName2 = student2.getlName();
	                //compare lName
	            		if (lName.compareTo(lName2) >  0)
	                {
	                    // swap temp and my_data[i]
	                    Student temp = student[j];
	                    student[j] = student[j+1];
	                    student[j+1] = temp;
	                }
	            }
	        }
	        //print bubbleSort to screen
	        for (int j = 0; j < student.length; j++) 
	        {
		        System.out.print("lName Sorted: " + student[j] );
		    }
	        System.out.println();
	    }
}
