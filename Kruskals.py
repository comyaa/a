#Program to find Minimum Spanning Tree using Kruskal's Algorithm
import heapq

#Class for Sets to store Forests
class SetTrees:
    def __init__(self, n):
        self.n=n
        self.p=[-1]*(n+1)

    def find(self, i):
        while self.p[i]>=0:
            i=self.p[i]
        return i

    #Weighted Union Implementation
    def union(self, i, j):
        tmp=self.p[i]+self.p[j]
        if self.p[i]>self.p[j]:
            self.p[i]=j
            self.p[j]=tmp
        else:
            self.p[j]=i
            self.p[i]=tmp


#Class for Edges with Cost
class GEdge:

    def __init__(self, cost, v1, v2):
        self.cost=cost
        self.v1=v1
        self.v2=v2

    #Compares the second value
    def __lt__(self, other):
        return self.cost<other.cost

    def __str__(self):
        return str("{} -> ({} , {})".format(self.cost, self.v1, self.v2))

#MAIN CODE STARTS HERE
#Cost matrix
n=int(input("Enter the number of nodes: "))

CostMat=[[0 for i in range(n+1)]for j in range(n+1)]

#Input the Cost Matrix and constructing MinHeap of edges with Cost as Key
EdgeHeap=[]
print("Enter the Cost Matrix row wise:")
for i in range(1, n+1):
    for j in range(1, n+1):
        CostMat[i][j]=int(input())
        if (CostMat[i][j]!=0 and i<j):
            edge=GEdge(CostMat[i][j],i,j)
            heapq.heappush(EdgeHeap,edge)

#List to store MCST
Tree=[[0 for i in range(3)] for j in range(n)]

st=SetTrees(n)

i=0
minCost=0.0
while i<n-1 and len(EdgeHeap)!=0:
    #Delete the min cost edge and add in MCST if it does not form a cycle
    E=heapq.heappop(EdgeHeap)
    j=st.find(E.v1)
    k=st.find(E.v2)
    if j==-1 or k==-1 or j!=k:
        i=i+1
        minCost=minCost+CostMat[E.v1][E.v2]
        Tree[i][1]=E.v1
        Tree[i][2]=E.v2
        st.union(E.v1, E.v2)

    #print("Added Edge: ",E.v1," , ",E.v2)
    #print("Set Trees: ",st.p)
    #print("Mincost is: ",minCost)

if i!=n-1:
    print("No Spanning Tree for the given Graph")
else:
    print("Minimum Cost is ",minCost)
    print("MCST is ")

    for i in range(1, n):
        print(Tree[i][1], Tree[i][2])

