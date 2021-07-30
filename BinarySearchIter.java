import java.util.*;

public class BinarySearchIter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s=new Scanner(System.in);
		
		System.out.println("Enter the size of the array");
		int size=s.nextInt();

		ArrayList<Integer> arr=new ArrayList<Integer>(size);

		Random r=new Random();
		for(int i=0;i<size;i++)
		{
			int n=r.nextInt(100);
			arr.add(i,n);
		}
		Collections.sort(arr);
		System.out.println("List elements: "+arr);
		int key=r.nextInt(100);
		
		long startTime=System.nanoTime();
		BinarySearchIter b=new BinarySearchIter();
		
		int index=b.binarySearch(arr,size,key);
		
		if (index==-1)
			System.out.println("Key "+key+" not found");
		else
			System.out.println("Key "+key+" found in the position "+(index+1));
		
		long endTime=System.nanoTime();
		double td=(endTime-startTime)/1000000.0;
		System.out.println("Time taken: "+td);
		
	}
	int binarySearch(ArrayList<Integer> a,int n,int x)
	{
		int low=0;
		int high=n-1;
		int mid;
		
		while (low<=high)
		{
			mid=(low+high)/2;
			
			if (a.get(mid)==x)
				return mid;
			else if (x<a.get(mid))
				high=mid-1;
			else
				low=mid+1;
		}
		return -1;
	}

}
