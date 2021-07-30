import java.util.*;

public class GreedyKnapsack {

	ArrayList<Double> w,p,x;
	
	int m,n;
	
	GreedyKnapsack()
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the capacity of the KnapSack:");
		m=s.nextInt();
		System.out.println("Enter number of objects:");
		n=s.nextInt();
		initArr();
	}
	
	GreedyKnapsack(int m, int n)
	{
		this.m=m;
		this.n=n;
		initArr();
	}
	
	void initArr()
	{
		w=new ArrayList<Double>(n);
		p=new ArrayList<Double>(n);
		x=new ArrayList<Double>(n);
		Random r=new Random();
		
		for(int i=0;i<n;i++)
		{
			int k=r.nextInt(20);
			w.add(i,(double) k);
		}
		
		for(int i=0;i<n;i++)
		{
			int k=r.nextInt(20);
			p.add(i,(double) k);
		}
		
		for(int i=0;i<n;i++)
			x.add(i,0.0);
	}
	
	void greedyW()
	{
		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if(w.get(j) < w.get(i))
				{
					Double tmp=p.get(j);
					p.set(j, p.get(i));
					p.set(i, tmp);
					
					tmp=w.get(j);
					w.set(j, w.get(i));
					w.set(i, tmp);
				}
			}
		}
	}
	
	void greedyP()
	{
		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if(p.get(j) > p.get(i))
				{
					Double tmp=p.get(j);
					p.set(j, p.get(i));
					p.set(i, tmp);
					tmp=w.get(j);
					w.set(j, w.get(i));
					w.set(i, tmp);
				}
			}
		}
	}
	
	void greedyPW()
	{
		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if(p.get(j)/w.get(j) > p.get(i)/w.get(i))
				{
					Double tmp=p.get(j);
					p.set(j, p.get(i));
					p.set(i, tmp);
					
					tmp=w.get(j);
					w.set(j, w.get(i));
					w.set(i, tmp);
				}
			}
		}
	}
	
	void call()
	{
		System.out.println("Greedy on weight: ");
		greedyW();
		ArrayList<Double> xw=greedyKnapsack(m,n);
		disp(xw);
		
		System.out.println("Greedy on profit: ");
		greedyP();
		ArrayList<Double> xp=greedyKnapsack(m,n);
		disp(xp);
		
		System.out.println("Greedy on profit/weight: ");
		greedyPW();
		ArrayList<Double> xpw=greedyKnapsack(m,n);
		disp(xpw);
	}
	
	ArrayList<Double> greedyKnapsack(int m, int n)
	{
		for(int i=0;i<n;i++)
			x.set(i,0.0);
	
		int a=0;
		double u=m;
		
		for(int i=0;i<n;i++)
		{
			if (w.get(i)>u)
				break;
			x.set(i, 1.0);
			u=u-w.get(i);
			a=i+1;
		}
		
		if (a<n)
			x.set(a, (double) (u/w.get(a)));
		return x;
	}
	
	void disp(ArrayList<Double> x)
	{
		System.out.println("x: "+x);
		System.out.println("w: "+w);
		System.out.println("p: "+p);
		double sum=0.0;
		for (int i=0;i<n;i++)
			sum+=x.get(i)*p.get(i);
		System.out.println("Total Profit: "+sum);
	}
	
	public static void main(String[] args)
	{
		GreedyKnapsack g = new GreedyKnapsack();
		
		long startTime=System.nanoTime();
		g.call();
		long endTime=System.nanoTime();
        
		double td=(endTime-startTime)/1000000.0;	
		System.out.println("Time taken: "+td);
	}
}
