/*
#include <iostream>
#include <cstdio>
#include <vector>
using namespace std;

int dx[4] = { 0,1,0,-1 };
int dy[4] = { 1,0,-1,0 };
int map[101][101];
int check[101][101];
int n, m;
int mini;
int flag;
vector<int> vc;
void dfs(int x, int y, int cnt)
{

}
int main()
{
	cin >> m >> n;//4 2

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			scanf("%1d", &map[i][j]);
		}
	}
	
	flag = 0;
	mini = 100000;
	int cnt = 0;
	dfs(0, 0, cnt);

	printf("%d", mini);
}
*/
#include <stdio.h>
#include <algorithm>
#include <functional>
#include <memory.h>
#include <vector>
#include <queue>

using namespace std;

int N, M;
char arr[100][101];
int dx[4] = { 1, 0, -1, 0 };
int dy[4] = { 0, 1, 0, -1 };
int result;
int visited[100][100];

typedef pair<int, pair<int, int>> T;
priority_queue<T, vector<T>, greater<T>> q;

void bfs(int X, int Y)
{
	q.push({ 0,{ X, Y } });
	visited[X][Y] = 1;

	while (!q.empty())
	{
		int x = q.top().second.first;
		int y = q.top().second.second;
		int w = q.top().first;

		q.pop();

		if (x == M - 1 && y == N - 1)
		{
			result = w;
			return;
		}
		for (int i = 0; i < 4; i++)
		{
			int nextX = x + dx[i];
			int nextY = y + dy[i];

			if (nextX >= 0 && nextX < M && nextY >= 0 && nextY < N)
			{
				if (arr[nextX][nextY] == '0' && visited[nextX][nextY] == 0)
				{
					visited[nextX][nextY] = 1;
					q.push({ w,{ nextX, nextY } });
				}
				if (arr[nextX][nextY] == '1' && visited[nextX][nextY] == 0)
				{
					visited[nextX][nextY] = 1;
					q.push({ w + 1,{ nextX, nextY } });
				}
			}
		}


	}
}
int main(void)
{
	scanf("%d %d", &N, &M);
	for (int i = 0; i < M; i++)
		scanf("%s", arr[i]);

	bfs(0, 0);
	printf("%d\n", result);
}