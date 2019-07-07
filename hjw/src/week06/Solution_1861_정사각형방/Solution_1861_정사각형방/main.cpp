#include <stdio.h>
#include<iostream>
#include <string.h>
using namespace std;
int dx[4] = { 1,0,-1,0 };
int dy[4] = { 0,-1,0,1 };
int start_idx;
int start_idy;
void dfs(int **map,int n, int j, int k, int *number)
{
	number[map[start_idx][start_idy]]++;

	for (int i = 0; i < 4; i++)
	{
		int newx = j + dx[i];
		int newy = k + dy[i];
		if ((-1 < newx && newx < n) && (-1 < newy && newy < n) && (map[j][k] + 1 == map[newx][newy]))
		{
			dfs(map, n, newx, newy, number);
		}
	}
}
int main()
{
	int test_case;
	scanf("%d", &test_case);

	for (int i = 1; i <= test_case; i++)
	{
		int n;//배열의 크기
		cin >> n;
		int ** map;
		map = new int*[n];
		int *number = new int[(n*n + 1)];

		memset(number, 0, sizeof(int)*(n*n + 1));

		for (int j = 0; j < n; j++)
			map[j] = new int[n];

		for (int j = 0; j < n; j++)
		{
			for (int k = 0; k < n; k++)
				cin >> map[j][k];
		}
		start_idx = 0;
		start_idy = 0;
		for (int j = 0; j < n; j++)
		{
			for (int k = 0; k < n; k++)
			{
				start_idx = j;
				start_idy = k;
				dfs(map, n, j,k,number);
			}
		}
		int loc = 0;
		int max = 0;
		for (int j = 0; j <= n*n; j++)
		{
			if (max < number[j])
				max = number[j];
		}
		for (int j = 0; j <= n*n; j++)
		{
			if (max == number[j])
			{
				loc = j;
				break;
			}
		}
		printf("#%d %d %d\n", i, loc, max);
		
	}
}
