
class BubbleSort
{
    static void bubbleSort(double my_data[])
    {
        int n = my_data.length;
        int countBSort = 2; //We start at two to count for initializations in loops below
        for (int i = 0; i < n - 1; i++) 
        {
        		countBSort++;	
        		//System.out.println("Operation loop count with initialization: " + countBSort);
            for (int j = 0; j < n - i - 1; j++) 
            {
            		countBSort++;
                if (my_data[j] > my_data[j+1])
                {
                    // swap temp and my_data[i]
                    double temp = my_data[j];
                    countBSort++;
                    my_data[j] = my_data[j+1];
                    countBSort++;
                    my_data[j+1] = temp;
                    countBSort++;
                    //print actions if j>j+1
                    //System.out.print("operation compare count: " + countBSort + ": [" + temp + "]");
                    //System.out.print(", [" + my_data[j] + "]");
                    //System.out.println();
                }
            }
        }
        //print bubbleSort
        //for (int j = 0; j < my_data.length; j++) {
	        //System.out.print("[" + my_data[j] + "]");
	    //}
        //System.out.println();
        System.out.println("Operations for BubbleSort are: " + countBSort);
    }
}

class InsertionSort
{
    /*Function to sort array using insertion sort*/
    static void sort(double my_data[])
    {
        int n = my_data.length;
        int countInsertion = 2; //We start at two to count for initializations in loops below
        
        for (int i=1; i<n; ++i)
        {
        		//System.out.println("Operation loop count with initializations: " + countInsertion);
            double key = my_data[i];
            countInsertion++;
            int j = i-1;
            countInsertion++;
            
            /* Move elements of my_data[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j>=0 && my_data[j] > key)
            {
                my_data[j+1] = my_data[j];
                countInsertion++;
                
                //print actions if j>j+1
                //System.out.print("operation compare count: " + countInsertion + ": [" + my_data[j] + "]");
                //System.out.print(", [" + key + "]");
                //System.out.println();
                
                j = j-1;
            	    countInsertion++;
            }
            my_data[j+1] = key;
            countInsertion++;
            
        }
        
        //print insertionSort
        //System.out.println("Final Insertion Sort: ");
        //for (int j = 0; j < my_data.length; j++) {
	    		//System.out.print("[" + my_data[j] + "]");
	    //} 
        //System.out.println();
        System.out.println("Operations for InsertionSort are: " + countInsertion);
    }
}

class ShellSort
{
    static void sort(double my_data[])
    {
      int n = my_data.length;
      int countShSort =0; 
      
      // Start with a big gap, then reduce the gap
      for (int gap = n/2; gap > 0; gap /= 2)
      {
    	  	countShSort++;
          for (int i = gap; i < n; i += 1)
          {	
        	  	  //System.out.println("gap: " + gap);
        	  	  //System.out.println("Operation loop count: " + countShSort);
              double temp = my_data[i];
              countShSort++;
              //System.out.println("i: " + i);
              //System.out.println("temp: " + temp);
              // shift earlier gap-sorted elements up until the correct location
              // for a[i] is found
              int j;
              for (j = i; j >= gap && my_data[j - gap] > temp; j -= gap)
              {
            	      //System.out.println("j: " + j);
                  my_data[j] = my_data[j - gap];
                  countShSort++;
                  
                  //print actions if j>gap && my_data[j-gap] > temp;
                  /*System.out.print("operation compare count: " + countShSort + ": "
                  		+ "[" + my_data[j] + "]");*/
                  //System.out.print(", [" + temp + "]");
                  //System.out.println();
              }
              my_data[j] = temp;
              countShSort++;
          }
      }
      
      //print ShellSort
      //System.out.println("Final Shell Sort: ");
      //for (int j = 0; j < my_data.length; j++) 
      //	{
    	  		//System.out.print("[" + my_data[j] + "]");
	  //} 
      //System.out.println();
      System.out.println("Operations for ShellSort are: " + countShSort);
      }
}

class MergeSort
{
    // Merges two subarrays of my_data[].
    // First subarray is my_data[left..mid]
    // Second subarray is my_data[mid+1..right]
	//private static int countMerge = 0;
    static void merge(double my_data[], int left, int mid, int right)
    {
    		//count the operations
    		int countMerge = 0;
        // Find sizes of two subarrays to be merged
        int n1 = mid - left + 1;
        int n2 = right- mid;
        int n3 = n1+n2;
        
        /* Create temp arrays */
        double L[] = new double [n1];
        double R[] = new double [n2];

        /*Copy data to temp arrays*/
        for (int i=0; i<n1; i++)
        {
            L[i] = my_data[left + i];  //casted double to int
            countMerge++;
        }
        for (int i=0; i<n2; i++)
        {
            R[i] = my_data[mid + 1 + i];  //casted double to int
            countMerge++;
        }

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0;
        int j = 0;

        // Initial index of merged subarry array
        int k = left;
        while (i < n1 && j < n2)
        {
        		countMerge++;
            if (L[i] <= R[j])
            {
                my_data[k] = L[i];
                countMerge++;
                i++;
                countMerge++;
                //System.out.print("[" + my_data[k] + "]");
            }
            else
            {
                my_data[k] = R[j];
                countMerge++;
                j++;
                countMerge++;
                //System.out.print("[" + my_data[k] + "]");
            }
            k++;
            countMerge++;
          
            //print Final Merge Sort////////////////////
            //System.out.print("Final Merge Sort: ");
            
          	  	//System.out.print("[" + my_data[k] + "]");
     
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            my_data[k] = L[i];
            countMerge++;
            i++;
            countMerge++;
            k++;
            countMerge++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            my_data[k] = R[j];
            countMerge++;
            j++;
            countMerge++;
            k++;
            countMerge++;
        }
        
        
        helperMergeCount(countMerge);
        //Print final mergeSort operation count
        if (n3 == my_data.length)
        {
            //Print Count for mergeSort
            System.out.println("Count for merge is: " + helperMergeCount(countMerge));
        }
        	
    }
    
    //Counter for MergeSort
    static int helperMergeCount(int count)
    {
    		int countMHelper = 0;
    		return countMHelper += count;
    }
    
    // Main function that sorts my_data[l..r] using
    // merge()
    static void sort(double my_data[], int left, int right)
    {
    		int countMerge = 0;
    		countMerge++;
        if (left < right)
        {
        		helperMergeCount(countMerge);
            // Find the middle point
            int mid = (left + right)/2;
    			countMerge++;

            // Sort first and second halves
            sort(my_data, left, mid);
            countMerge++;
            sort(my_data, mid+1, right);
            countMerge++;

            // Merge the sorted halves
            merge(my_data, left, mid, right);
        }
        helperMergeCount(countMerge);
    }
    
}


class QuickSort
{
    /* This function takes last element as pivot,
       places the pivot element at its correct
       position in sorted array, and places all
       smaller (smaller than pivot) to left of
       pivot and all greater elements to right
       of pivot */
	//private static int countQSort = 0;
    static int partition(double my_data[], int low, int high)
    {
    		int countQSort = 0;
		countQSort++;
        double pivot = my_data[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
        		countQSort++;
        		// If current element is smaller than or
            // equal to pivot
            if (my_data[j] <= pivot)
            {
                i++;
                countQSort++;

                // swap my_data[i] and my_data[j]
                double temp = my_data[i];
                countQSort++;
                my_data[i] = my_data[j];
                countQSort++;
                my_data[j] = temp;
                countQSort++;
            }
        }

        // swap my_data[i+1] and my_data[high] (or pivot)
        double temp = my_data[i+1];
       // System.out.println(temp);
        countQSort++;
        my_data[i+1] = my_data[high];
        countQSort++;
        my_data[high] = temp;
        countQSort++;

        helperQuickSortCount(countQSort);
        if ((i == my_data.length-2))
		{
        //Print Count for mergeSort
        System.out.println("Count for QuickSort is: " + helperQuickSortCount(countQSort));
		}
        return i+1;
    }


    static int helperQuickSortCount(int count)
    {
    		int countQHelper = 0;
    		//countQHelper += count;
    		return countQHelper += count;


    }
    /* The main function that implements QuickSort()
      my_data[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    static void sort(double my_data[], int low, int high)
    {
    		int countQSort = 0;
    		countQSort++;
    		
        if (low < high)
        {
            /* pivot is partitioning index, my_data[pivot] is
              now at right place */
            int pivot = partition(my_data, low, high);
            countQSort++;

            // Recursively sort elements before
            // partition and after partition
            sort(my_data, low, pivot-1);
            countQSort++;
            sort(my_data, pivot+1, high);
            countQSort++;
        }
        helperQuickSortCount(countQSort);
        
        //Print Count for mergeSort
        //System.out.println("Count for QuickSort is: " + helperQuickSortCount(countQSort));
    }
}

