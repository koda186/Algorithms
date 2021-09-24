
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;

public class Program2Main_Allen {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		ArrayList<Double> arr = new ArrayList< >();
		ArrayList<Double> doublesArrOutput = new ArrayList<Double>();
		File file = new File ("Large_Double_List.txt");
		Scanner scan;
		try 
		{
			scan = new Scanner(file);
	
		    while(scan.hasNext()){
		        arr.add(scan.nextDouble());
		    }
		    
		    double doubleArr[] = new double[arr.size()];
		    double tempArr[] = new double[arr.size()];
		    
		    for (int i = 0;i < arr.size(); i++) 
		    {
		        doubleArr[i] = arr.get(i);
		        tempArr[i] = doubleArr[i];
		    }
		    
		    for(double d : tempArr) 
		    	doublesArrOutput.add(d);;
		     
		   
		}//end try 
		catch (FileNotFoundException e1) 
		{
		// TODO Auto-generated catch block
		e1.printStackTrace();
		}//end catch
		
		////////////////////////////////////////////////////////////////
		//Write to file
		
		File outputFile = new File ("SDoubles.txt");
	    try
	    {
	    		double doubleArr[] = new double[arr.size()];
		    double tempArr[] = new double[arr.size()];
		    
		    for (int i = 0;i < doublesArrOutput.size(); i++) {
		        doubleArr[i] = doublesArrOutput.get(i);
		        tempArr[i] = doubleArr[i];
		    }
	    	
	    	
	    		FileWriter fw = new FileWriter(outputFile);
	    		Writer output = new BufferedWriter(fw);
	    		
	    		System.out.println("BubbleSort: ");
    			BubbleSort.bubbleSort(tempArr);
		    System.out.println();
	    		
		    output.write("BubbleSort: { ");
	    		for( int i = 0; i < tempArr.length; i++)
	    		{
	    			output.write("[" + tempArr[i] + "]" + " " );
	    		}
	    		output.write("}" + "\n\n");
	    			
			//reset array
			tempArr = doubleArr;
			////////////////////////////////////////////////////////////////// 
			    
			System.out.println("InsertionSort: ");
		    InsertionSort.sort(tempArr);
		    System.out.println();
		    
		    output.write("InsertionSort: { ");
    			for( int i = 0; i < tempArr.length; i++)
    			{
    				output.write("[" + tempArr[i] + "]" + " " );
    			}
    			output.write("}" + "\n\n");
		    
		    //reset array
		    tempArr = doubleArr;
			    
		    //////////////////////////////////////////////////////////////////
			System.out.println("ShellSort: ");
		    ShellSort.sort(tempArr);
		    System.out.println();
			 
		    output.write("ShellSort: { ");
    			for( int i = 0; i < tempArr.length; i++)
    			{
    			output.write("[" + tempArr[i] + "]" + " " );
    			}
    			output.write("}" + "\n\n");
    			
		    //reset array
	    	    tempArr = doubleArr;
			    
	    	    //////////////////////////////////////////////////////////////////    
	    	    System.out.println("MergeSort: ");
	    	    MergeSort.sort(tempArr, 0, tempArr.length-1);
	    	    System.out.println();
	    	    
	    	    output.write("MergeSort: { ");
	    		for( int i = 0; i < tempArr.length; i++)
	    		{
	    			output.write("[" + tempArr[i] + "]" + " " );
	    		}
	    		output.write("}" + "\n\n");
	    	    
	    		//reset array
	    	    tempArr = doubleArr;
	    		
	    	    //////////////////////////////////////////////////////////////////    
	    	    System.out.println("QuickSort: ");
	    	    QuickSort.sort(tempArr, 0, tempArr.length-1);
	    	    System.out.println();
	    	    
	    	    output.write("QuickSort: { ");
	    		for( int i = 0; i < tempArr.length; i++)
	    		{
	    			output.write("[" + tempArr[i] + "]" + " " );
	    		}
	    		output.write("}" + "\n\n");
	    	    
	    	    //close file
	    		output.close();
	    }
	    catch (Exception e)
	    {
			e.printStackTrace();
	    }//End Of Error Catching
	    
	}//end main

}//end class
