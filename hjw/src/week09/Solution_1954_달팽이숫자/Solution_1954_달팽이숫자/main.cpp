#include <cstdio>

using namespace std;
int map[11][11];
int check[11][11];
int dx[4] = { 0,1,0,-1 };
int dy[4] = { 1,0,-1,0 };
void init(int n)
{
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			check[i][j] = 0;
		}
	}
}
void dfs(int n, int x, int y, int cnt)
{
	map[x][y] = cnt;
	check[x][y] = 1;

	for (int i = 0; i < 4; i++)
	{
		int newx = x + dx[i];
		int newy = y + dy[i];
		if ((-1 < newx && newx < n) && (-1 < newy && newy < n) && (check[newx][newy] == 0))
		{
			dfs(n, newx, newy, cnt + 1);
		}
	}
}
int main()
{
	int test;
	scanf("%d", &test);

	for (int a = 1; a <= test; a++)
	{
		int n;
		scanf("%d", &n);
		int cnt = 1;
		init(n);
		dfs(n,0,0,cnt);

		printf("#%d\n", a);
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				printf("%d ", map[i][j]);
			}
			printf("\n");
		}

	}
}