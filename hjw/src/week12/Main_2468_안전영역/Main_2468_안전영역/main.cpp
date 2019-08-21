#include <cstdio>
#include <queue>
#include <vector>
using namespace std;

int map[101][101];
int check[101][101];
int n;
int result;
int dx[4] = { 0,1,0,-1 };
int dy[4] = { 1,0,-1,0 };

queue<int>que;
void init()
{
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
			check[i][j] = 0;
	}
}
void water(int height)
{
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			if (height >= map[i][j])
				check[i][j] = 1;
		}
	}
}
void bfs(int x, int y)
{
	que.push(x);
	que.push(y);
	check[x][y] = 1;

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
			if ((-1 < newx && newx < n) && (-1 < newy && newy < n) && (check[newx][newy] != 1))
			{
				que.push(newx);
				que.push(newy);
				check[newx][newy] = 1;
			}
		}
	}
}
int main()
{
	scanf("%d", &n);
	result = 0;
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			scanf("%d", &map[i][j]);
		}
	}
	int cnt = 0;
	for (int h = 0; h < 101; h++)
	{
		water(h);
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				if (check[i][j] != 1)
				{
					cnt++;
					bfs(i, j);;
				}
			}
		}
		init();
		if (result < cnt)
			result = cnt;
		cnt = 0;
	}
	printf("%d", result);
}