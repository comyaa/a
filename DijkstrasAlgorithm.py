def minimum(S, dist):
    res = 0
    for i in range(1, len(S)):
        if S[i] is False and dist[i] > 0:
            if dist[i] < dist[res] or res == 0:
                res = i
    return res


def ShortestPath(v, Cost, n):
    S = [0]
    dist = [0]
    for i in range(1, n+1):
        S.append(False)
        dist.append(Cost[v][i])
    S[v] = True
    dist[v] = 0

    # print("S:", S[1: n+1])
    # print("dist:", dist[1: n+1])

    for num in range(2, n+1):
        u = minimum(S, dist)
        S[u] = True
        # print("S:", S[1: n+1])
        # print("dist:", dist[1: n+1])

        W = []
        for x in range(1, n+1):
            if Cost[u][x] > 0 and S[x] is False:
                W.append(x)

        for w in W:
            if (dist[w] > dist[u] + Cost[u][w]) or dist[w] <= 0:
                dist[w] = dist[u] + Cost[u][w]

    # print("S:", S[1: n+1])
    print("dist:", dist[1: n+1])


n = int(input("Enter the number of nodes: "))

print("Enter the cost matrix row-wise:")
#print("Note: Cost[i, i] = 0 and Cost[i, j] = -1 where there is no edge")

CostMat = [[0 for i in range(n+1)] for j in range(n+1)]
for i in range(1, n+1):
    for j in range(1, n+1):
        CostMat[i][j] = int(input())

v = int(input("Enter the starting vertex : "))

print("The Cost Matrix is: ")
for i in range(1, n+1):
    for j in range(1, n+1):
        print(CostMat[i][j], end=" ")
    print()

ShortestPath(v, CostMat, n)