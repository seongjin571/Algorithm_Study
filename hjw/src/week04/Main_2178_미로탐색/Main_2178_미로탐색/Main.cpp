#include <iostream>
#include <string.h>
#include <queue>
using namespace std;
int dx[4] = { 0,1,0,-1 };
int dy[4] = { 1,0,-1,0 };//우 -> 아래 -> 좌 -> 위
int result;
void bfs(int **map, int **check,int n,int m)
{
	queue<int>que;
	que.push(0);
	que.push(0);
	check[0][0] = 1;

	while (!que.empty())
	{
		int xx = que.front();
		que.pop();
		int yy = que.front();
		que.pop();
		for (int i = 0; i < 4; i++)
		{
			int newx = xx + dx[i];
			int newy = yy + dy[i];
			if ((-1 < newx && newx < n) && (-1 < newy && newy < m) && (check[newx][newy] == 0) && (map[newx][newy] == 1))
			{
				que.push(newx);
				que.push(newy);
				check[newx][newy] = check[xx][yy] + 1;
			}
		}
	}
}
int main()
{
	int n, m;//가로 세로
	cin >> n >> m;
	int **map = new int*[n];
	char **arr = new char*[n];
	int **check = new int*[n];
	for (int i = 0; i < n; i++)
	{
		map[i] = new int[m];
		arr[i] = new char[m];
		check[i] = new int[m];
	}

	for (int i = 0; i < n; i++)
	{
		memset(check[i], 0, sizeof(int)*m);
	}

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			cin >> arr[i][j];
		}
		for (int j = 0; j < m; j++)
		{
			map[i][j] = arr[i][j] - '0';
		}
	}

	bfs(map, check, n, m);
	cout << check[n-1][m-1] << endl;
}