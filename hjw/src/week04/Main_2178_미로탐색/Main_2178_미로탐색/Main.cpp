#include <iostream>
#include <string.h>

using namespace std;
int dx[4] = { 0,1,0,-1 };
int dy[4] = { 1,0,-1,0 };
int result;
void dfs(int x, int y, int **map, int **check, int n, int m)
{
	if (x == 0 && y == 0)
		check[x][y] = 1;

	if ((x == n-1) && (y == m-1))
	{
		result = check[x][y];
		for (int i = 0; i < n; i++)
			memset(check[i],1, sizeof(int)*m);
	}

	for (int i = 0; i < 4; i++)
	{
		int newx = x + dx[i];
		int newy = y + dy[i];
		if ((-1 < newx && newx < n) && (-1 < newy && newy < m) && (check[newx][newy] == 0) && (map[newx][newy] == 1))
		{
			check[newx][newy] = check[x][y] + 1;
			dfs(newx, newy, map, check, n, m);
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

	dfs(0, 0, map, check,n,m);
	cout << result << endl;
}