import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class MergeSort1
{
	ArrayList<Integer> arr;
	ArrayList<Integer> tmp;
	int size;
	
	MergeSort1()
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the size of the array");
		size=s.nextInt()+1;
		initArr();
	}
	
	MergeSort1(int s)
	{
		size=s+1;
		initArr();
	}
	
	void initArr()
	{
		arr = new ArrayList<Integer>(size);
		tmp=new ArrayList<Integer>(size);
		
		arr.add(0,0);
		
		Random r=new Random();
		for(int i=1;i<size;i++)
		{
			int n=r.nextInt(100);
			arr.add(i,n);
		}
		
		for(int i=0;i<size;i++)
			tmp.add(0);
	}
	
	void sort()
	{
		//Sorting using MergeSort
		mergeSort(arr,1,size-1);
	}
	
	void mergeSort(ArrayList<Integer> arr, int low, int high)
    {
        if (low < high)
        {
            int mid = (low+high)/2;
  
            mergeSort(arr, low, mid);
            mergeSort(arr , mid+1, high);
  
            merge(arr, low, mid, high);
        }
    }
	
	void merge(ArrayList<Integer> arr, int low, int mid, int high)
    {
    	int h=low;
    	int i=low;
    	int j=mid+1;
  
        while (h <= mid && j <= high)
        {
            if (arr.get(h) < arr.get(j))
                tmp.set(i++,arr.get(h++));
            else
            	tmp.set(i++,arr.get(j++));
        }
  
        if (j<=high)
        {
        	for(int k=j;k <= high;k++)
        		tmp.set(i++,arr.get(k));
        }
        
        if (h<=mid)
        {
        	for(int k=h;k <= mid;k++)
        		tmp.set(i++,arr.get(k));
        }
        
        for (int k = low; k <= high; k++)
        	arr.set(k, tmp.get(k));
    }
  
	void disp()
	{
		System.out.println("List Elements "+arr);
	}
}
public class MergeSortCL {

	public static void main(String[] args)
	{
		MergeSort1 m = new MergeSort1();
		
		System.out.println("Array before sorting: ");
		m.disp();
		
		long startTime=System.nanoTime();
		
		m.sort();
		
		System.out.println("Array after sorting: ");
		m.disp();
		
		long endTime=System.nanoTime();
		
		double td=(endTime-startTime)/1000000.0;
		
		System.out.println("Time taken: "+td);
	}
}
