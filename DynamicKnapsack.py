def Knapsack(m, wt, p, n):
    K=[[0 for x in range(m+1)] for x in range(n+1)]

    #Build table K[][] in bottom up manner
    for i in range(n+1):
        for W in range(m+1):
            if i==0 or W==0:
                K[i][W]=0
            elif wt[i-1]<=W:
                K[i][W]=max(p[i-1]+K[i-1][W-wt[i-1]], K[i-1][W])
            else:
                K[i][W]=K[i-1][W]
    return K[n][m]


n=int(input("Enter the number of elements: "))

print("Enter the weights for",n,"elements: ")
w=[int(x) for x in input().split()]

print("Enter the profits for",n,"elements: ")
p=[int(x) for x in input().split()]

m=int(input("Enter the knapsack capacity: "))

print("Profit is: ", Knapsack(m,w,p,n))