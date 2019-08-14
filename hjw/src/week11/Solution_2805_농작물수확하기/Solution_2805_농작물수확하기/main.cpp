#include <iostream>
#include <cstdio>
using namespace std;
int map[50][50];
int check[50][50];
int result;
int n;
void  init()
{
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
			check[i][j] = 0;
	}
}
int main()
{
	int test;
	cin >> test;
	for (int t = 1; t <= test; t++)
	{
		result = 0;
		cin >> n;
		init();
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
				scanf("%1d", &map[i][j]);
		}

		if (n == 1)
		{
			result += map[0][0];
		}
		else
		{
			int row = (n - 1) / 2;
			for (int i = 0; i <= row; i++)
			{
				for (int j = 0; j < i+1; j++)
				{
					//result += map[i][row - j];
					check[i][row - j] = 1;
				}
			}
			for (int i = 0; i <= row; i++)
			{
				for (int j = 0; j <= i; j++)
				{
					//result += map[i][row + j];
					check[i][row + j] = 1;
				}
			}

			for (int i = row + 1; i < n; i++)
			{
				for (int j=n-i-1;j>=0;j--)
				{
					//result += map[i][row - j];
					check[i][row-j] = 1;
				}
			}
			for (int i = row + 1; i < n; i++)
			{
				for (int j = n - 1 - i; j >= 0; j--)
				{
					//result += map[i][row + j];
					check[i][row + j] = 1;
				}
			}

			for (int i = 0; i < n; i++)
			{
				for (int j = 0; j < n; j++)
				{
					if (check[i][j] == 1)
					{
						result += map[i][j];
					}
				}
			}

		}


		printf("#%d %d\n", t, result);
	}
}