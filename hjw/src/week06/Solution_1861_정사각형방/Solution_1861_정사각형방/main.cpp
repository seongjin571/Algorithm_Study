#include<iostream>
#include<queue>
#include <string.h>
#include <fstream>
using namespace std;
int dx[4] = { 1,0,-1,0 };
int dy[4] = { 0,-1,0,1 };
int start_idx;
int start_idy;
int check_count;
int max_n;
void bfs(int **map, int x, int y, int n, int *number)
{
	queue<int>que;
	que.push(x);
	que.push(y);
	start_idx = x;
	start_idy = y;
	number[map[start_idx][start_idy]] = 1;
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
			if ((-1 < newx && newx < n) && (-1 < newy && newy < n) && (map[xx][yy] == map[newx][newy] - 1))
			{
				que.push(newx);
				que.push(newy);
				number[map[start_idx][start_idy]]++;
			}
		}
	}
	if (max_n < number[map[start_idx][start_idy]])
		max_n = number[map[start_idx][start_idy]];
}
int main()
{
	int test_case;
	cin >> test_case;
	
	for (int i = 1; i <= test_case; i++)
	{
		int n;//배열의 크기
		cin >> n;
		int loc = 0;
		int **map = new int*[n];
		int *number = new int[(n*n + 1)];

		for (int j = 0; j < n; j++)
		{
			map[j] = new int[n];
		}

		for (int j = 0; j < n; j++)
		{
			for (int k = 0; k < n; k++)
				cin >> map[j][k];
		}

		max_n = 0;
		for (int j = 0; j < n; j++)
		{
			for (int k = 0; k < n; k++)
			{
				check_count = 0;
				bfs(map, j, k, n, number);
			}
		}


		for (int j = 0; j < n*n + 1; j++)
		{
			if (max_n == number[j])
			{
				loc = j;
				break;
			}
		}
		cout << "#" << i << " ";
		cout << loc << " " << max_n << endl;
	}
}
