#include <cstdio>
#include <iostream>
int result;
char map[100][100];
using namespace std;
bool func(int i)
{
	int flag = 0;

	for (int x = 0; x < 100; x++)
	{
		for (int y = 0; y <= 100 - i; y++)
		{
			for (int z = 0; z < i / 2; z++)
			{
				if (map[x][y + z] != map[x][y + i - z - 1])
				{
					flag = 1;
					break;
				}
			}
			if (flag == 0)
				return true;

			flag = 0;
		}
	}

	for (int x = 0; x <= 100 - i; x++)
	{
		for (int y = 0; y < 100; y++)
		{
			for (int z = 0; z < i / 2; z++)
			{
				if (map[x + z][y] != map[x + i - z - 1][y])
				{
					flag = 1;
					break;
				}
			}
			if (flag == 0)
				return true;

			flag = 0;
		}
	}

	return false;
}
int main()
{
	for (int t = 1; t < 11; t++)
	{
		result = 0;
		int test;
		cin >> test;
		char temp;
		for (int i = 0; i < 100; i++)
		{
			for (int j = 0; j < 100; j++)
			{
				cin >> temp;
				map[i][j] = temp;
			}
		}

		for (int i = 3; i <= 50; i++)
		{
			if (func(i))
			{
				result = i;
			}
		}

		printf("#%d %d\n", test, result);
	}
}