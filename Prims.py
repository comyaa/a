import heapq

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

#Function to create a list the indexes of positive entries in a given list
def posInt(ls):
    inList=[]
    for i in range(len(ls)):
        if ls[i]>0:
            inList.append(i)
    return inList

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

#List to store near value for vetices, initialise to -1 to denote not yet in tree
near=[-1 for i in range(n+1)]

#Pop the least cost edge from MinHeap of edges and add to MCST
E=heapq.heappop(EdgeHeap)

minCost=CostMat[E.v1][E.v2]
Tree[1][1]=E.v1
Tree[1][2]=E.v2

#print("Tree: ",E.v1, E.v2)

#Initialize near values
for i in range(1, n+1):
    if CostMat[i][E.v1]==0:
        if CostMat[i][E.v2]!=0:
            near[i]=E.v2
    elif CostMat[i][E.v2]==0:
        if CostMat[i][E.v1]!=0:
            near[i]=E.v1
    elif (CostMat[i][E.v1]<CostMat[i][E.v2]):
        near[i]=E.v1
    else:
        near[i]=E.v2    

#nodes added to Tree so update near to 9
near[E.v1]=0
near[E.v2]=0

#List for storing nodes with near!=0
ind=[]

#print("Near: ",near)

#Find the next n-2 edges in MCST
for i in range(2, n):
    #Finding an index j such that near[j]!=0 and cost[j,near[j]] is minimum
    ind=posInt(near)
    #print("Indexes: ",ind)

    #print("Near: ",near)

    minEC=CostMat[ind[0]][near[ind[0]]]

    j=ind[0]
    for l in ind:
        if CostMat[l][near[l]]<minEC:
            minEC=CostMat[l][near[l]]
            j=l

    #add edge j,near[j] into tree and update mincost, make near[j]=0 since added to tree
    Tree[i][1]=j
    Tree[i][2]=near[j]
    minCost=minCost+CostMat[j][near[j]]
    near[j]=0

    #print("Tree: ",Tree[i][1], Tree[i][2])
    #print("Mincost ",minCost)

    #Update the near values considering inclusion of vertex j
    for k in range(1, n+1):
        if near[k]!=0:
            if CostMat[k][j]!=0:
                if near[k]!=-1 and CostMat[k][near[k]]>CostMat[k][j]:
                    near[k]=j
                elif near[k]==-1:
                    near[k]=j

print("Minimum Cost is: ", minCost)
print("MCST is: ")

for i in range(1,n):
    print(Tree[i][1], Tree[i][2])