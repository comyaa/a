import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class QuickSort {
	
	ArrayList<Integer> arr;
	int j, size;
	
	QuickSort()
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the size of the array");
		size=s.nextInt()+1;
		initArr();
	}
	
	QuickSort(int s)
	{
		size=s+1;
		initArr();
	}
	
	void initArr()
	{
		arr = new ArrayList<Integer>(size);
		
		arr.add(0,0);
		
		Random r=new Random();
		for(int i=1;i<size;i++)
		{
			int n=r.nextInt(100);
			arr.add(i,n);
		}
	}
	
	void sort()
	{
		quickSort(arr,1,size-1);
	}
	
	void quickSort(ArrayList<Integer> arr,int p, int q)
	{
		if (p<q)
		{
			j=partition(arr,p,q);
			quickSort(arr,p,j-1);
			quickSort(arr,j+1,q);
		}
	}
	
	int partition(ArrayList<Integer> a,int m,int p)
	{
		int Pi=a.get(m);
		int l=m;
		int r=p;
		
		while (l<r)
		{
			while (a.get(l)<=Pi && l<p)
				l=l+1;
			while (a.get(r)>Pi && r>m)
				r=r-1;
			
			if (l<r)
			{
				int tmp=a.get(l);
				a.set(l, a.get(r));
				a.set(r, tmp);
			}
		}
		a.set(m, a.get(r));
		a.set(r, Pi);
		return r;
	}
	
	void disp()
	{
		System.out.println("List Elements "+arr);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		QuickSort q=new QuickSort();
        
        System.out.println("Array before sorting: ");
        q.disp();
        
        long startTime=System.nanoTime();
		q.sort();
    
		System.out.println("Array after sorting: ");
        q.disp();
        
        long endTime=System.nanoTime();
		double td=(endTime-startTime)/1000000.0;	
		System.out.println("Time taken: "+td);
	}
}
