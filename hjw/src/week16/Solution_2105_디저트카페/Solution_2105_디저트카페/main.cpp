#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
using namespace std;
int dx[4] = { 1,1,-1,-1 };
int dy[4] = { -1,1,1,-1 };
vector<vector<int> >map(25, vector<int>(25, 0));
int check[101];
//vector<vector<int> >check(25, vector<int>(25, 0));
//int map[25][25];
//int check[25][25];
int n;
int result;
void init()
{
	for (int i = 0; i < 101; i++)
		check[i] = 0;
}
void dfs(int x, int y, int len, int dir, int start_x, int start_y)
{
	int newx = x + dx[dir];
	int newy = y + dy[dir];

	if (dir == 3 && newx == start_x && newy == start_y)
	{
		result = max(result, len);
		return;
	}

	if ((-1 < newy && newy < n) && (-1 < newx && newx < n) && check[map[newx][newy]] == 0)
	{
		check[map[newx][newy]] = 1;
		dfs(newx, newy, len + 1, dir, start_x, start_y);

		if (dir < 3)
		{
			dfs(newx, newy, len + 1, dir + 1, start_x, start_y);
		}
		check[map[newx][newy]] = 0;
	}
}
int main()
{
	int test;
	cin >> test;
	for (int t = 1; t <= test; t++)
	{
		cin >> n;
		result = -1;
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				cin >> map[i][j];
			}
		}
		init();
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				check[map[i][j]] = 1;
				dfs(i, j, 1, 0, i, j);
				check[map[i][j]] = 0;
			}
		}
		
		printf("#%d %d\n", t, result);
		
	}
}