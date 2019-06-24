#include <iostream>
#include <string.h>
using namespace std;

int dx[3] = { 0,0,1 };
int dy[3] = { -1,1,0 };
int map[100][100];
int check[100][100];
int flag = 0;
void dfs(int x, int y)
{
	check[x][y] = 1;//规巩贸府
	if (x == 99)
	{
		if (map[x][y] == 2)//档馒版快
		{
			flag = 1;
		}
		for (int a = 0; a < 100; a++)
		{
			memset(check[a], 1, sizeof(int) * 100);
		}
	}

	for (int i = 0; i < 3; i++)
	{
		int newx = x + dx[i];
		int newy = y + dy[i];
		if ((-1 < newx && newx < 100) && (-1 < newy &&  newy < 100) && (check[newx][newy] == 0) && (map[newx][newy] != 0))
		{
			dfs(newx, newy);
		}
	}
}
int main()
{
	int n;//testcase number;
	int start_number;

	for (int i = 1; i < 11; i++)
	{
		cin >> n;

		for (int j = 0; j < 100; j++)
		{
			for (int k = 0; k < 100; k++)
			{
				cin >> map[j][k];
			}
		}
		for (int l = 0; l < 100; l++)
		{
			memset(check[l], 0, sizeof(int) * 100);
		}

		for (int j = 0; j < 100; j++)
		{
			if (map[0][j] == 1 && check[0][j] == 0)
			{
				dfs(0,j);
				if (flag == 1)
				{
					start_number = j;
					flag = 2;
				}
				for (int l = 0; l < 100; l++)
				{
					memset(check[l], 0, sizeof(int) * 100);
				}
			}
		}
		cout << "#" << i << " " << start_number << endl;
		flag = 0;
		start_number = 0;
	}

}