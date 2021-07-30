import java.util.Scanner;
import java.util.LinkedList;

class Graph3
{
    int n;
    int [][] adj;

    Graph3(int n)
    {
        this.n=n;
        adj=new int[this.n][this.n];
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
        
        System.out.println("Matrix is: ");
        for(int i=0;i<this.n;i++)
        {
            for(int j=0;j<this.n;j++)
                System.out.print(adj[i][j]+"  ");
            System.out.println();
        }
    }
    
    public void BFS(int v)
    {
        int[] visited=new int[n];
        LinkedList<Integer> queue=new LinkedList<Integer>();
        int u=v;
        visited[v-1]=1;
        System.out.println("BFS is:");
        System.out.println(v);
        
        while(true)
        {
            for(int i=0;i<n;i++)
            {
                if(this.adj[u-1][i]==1)
                { //there is an edge
                    if(visited[i]==0)
                    {
                        visited[i]=1;
                        System.out.println(i+1);
                        queue.add(i+1);
                    }                    
                }
            }
            if(queue.size()==0)
                return;
            u=queue.remove(0);
        }
    }
}

public class BFSearch
{
    public static void main(String[] args)
    {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the number of vertices");
        int n=s.nextInt();
    
        Graph3 g=new Graph3(n);
        g.edges();
        System.out.println("Enter the starting vertex for the BFS");
        g.BFS(s.nextInt());
        s.close();
    }
}