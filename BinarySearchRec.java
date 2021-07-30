import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class BinarySearchRec {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s=new Scanner(System.in);
		System.out.println("Enter the size of the array");
		int size=s.nextInt()+1;

		ArrayList<Integer> arr=new ArrayList<Integer>(size);
		
		Random r=new Random();
		arr.add(0,0);
		
		for(int i=1;i<size;i++)
		{
			int n=r.nextInt(100);
			arr.add(i,n);
		}
		
		Collections.sort(arr);
		System.out.println("List elements: "+arr);
		int key=r.nextInt(20);
		System.out.println("Key is "+key);
		
		long startTime=System.nanoTime();
		BinarySearchRec b=new BinarySearchRec();

		int index=b.binarySearch(arr,1,size-1,key);

		if (index==-1)
			System.out.println("Key "+key+" not found");
		else
			System.out.println("Key "+key+" found in the position "+index);

		long endTime=System.nanoTime();
		double td=(endTime-startTime)/1000000.0;
		System.out.println("Time taken: "+td);
	}

	int binarySearch(ArrayList<Integer> a,int i,int l,int x)
	{
		int mid;

		if (l==i)
		{
			if (a.get(l)==x)
				return l;
			return -1;
		}
		else if(l>i)
		{
			mid=(i+l)/2;
			if (x==a.get(mid))
				return mid;
			else if (x<a.get(mid))
				return binarySearch(a,i,mid-1,x);
			else
				return binarySearch(a,mid+1,l,x);
		}
		return -1;
	}

}
