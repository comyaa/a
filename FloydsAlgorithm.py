def minimum(i, j, k):
    if A[i][j]==-1:
        if A[i][k]!=-1 and A[k][j]!=-1:
            return A[i][k] + A[k][j]
        else:
            return A[i][j]

    else:
        if A[i][k]!=-1 and A[k][j]!=-1:
            newC=A[i][k] +A[k][j]
            if A[i][j]<newC:
                return A[i][j]
            else:
                return newC
        else:
            return A[i][j]


n=int(input("Enter the number of nodes: "))

CostMat=[[0 for i in range(n+1)]for j in range(n+1)]
#Matrix for All Pairs Shortest Paths
A=[[0 for i in range(n+1)] for j in range(n+1)]
#Input the Cost Matrix and constructing MinHeap of Edges with Cost as Key

print("Enter the Cost Matrix row wise:")
#print("Note Cost[i,i]=0 and Cost[i,j] where there is no edge is taken as -1")
for i in range(1, n+1):
    for j in range(1, n+1):
        CostMat[i][j]=int(input())
        A[i][j]=CostMat[i][j]


for k in range(1, n+1):
    for i in range(1, n+1):
        for j in range(1,n+1):
            if i!=j:
                A[i][j]=minimum(i,j,k)
    #print("A ",k," is ",A)


print("Cost Matrix: ")
for i in range(1, n+1):
    for j in range(1, n+1):
        print(CostMat[i][j], end=" ")
    print()

print("All Pairs Shortest Paths Matrix: ")
for i in range(1, n+1):
    for j in range(1, n+1):
        print(A[i][j], end=" ")
    print()
