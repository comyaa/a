import java.util.Scanner;

class Graph2
{
    int n;
    int [][] adj;
    int[] visited;
    
    Graph2(int n)
    {
        this.n=n;
        visited=new int[n];
        adj=new int[n][n];
    }
    
    public void edges()
    {
    	Scanner s=new Scanner(System.in);
        int t,e,f;
        System.out.println("Enter number of edges");
        e=s.nextInt();
        
        for(int i=0;i<e;i++)
        {
            System.out.println("Enter from and to egde");
            f=s.nextInt();
            t=s.nextInt();
            adj[f-1][t-1]=1;
            adj[t-1][f-1]=1;
        }
        
        System.out.println("Matrix is:");
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
                System.out.print(adj[i][j]+"  ");
            System.out.println();
        }
    }
    
    public void DFS(int v) 
    {
	    visited[v-1]=1;
	    System.out.println(v);
	    for(int i=0;i<n;i++) 
	    {
		    if(adj[v-1][i]==1) 
		    {
		  	   if(visited[i]==0)
		 		   DFS(i+1);
		    }
	    }
    }
}

public class DFSearch
{
    public static void main(String[] args)
    {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the number of vertices");
        int n=s.nextInt();
    
        Graph2 g=new Graph2(n);
        g.edges();
        System.out.println("Enter the starting vertex for the DFS");
        g.DFS(s.nextInt());
        s.close();
    }
}