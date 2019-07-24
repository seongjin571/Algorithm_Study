#include <cstdio>
#include <fstream>
#include <iostream>
using namespace  std;
int map[9][9];
int flag;
int arr[10];
void init()
{
	for (int i = 0; i < 10; i++)
		arr[i] = 0;
}
void dx()
{
	init();
	for (int i = 0; i < 9; i++)
	{
		for (int j = 0; j < 9; j++)
		{
			if (arr[map[j][i]] == 0)
				arr[map[j][i]] = 1;
			else
			{
				flag = 0;
				break;
			}
			
		}
		if (flag == 0)
			break;
		init();
	}
}
void dy()
{
	init();
	for (int i = 0; i < 9; i++)
	{
		for (int j = 0; j < 9; j++)
		{
			if (arr[map[i][j]] == 0)
				arr[map[i][j]] = 1;
			else
			{
				flag = 0;
				break;
			}
		}
		if (flag == 0)
			break;
		init();
	}
}
void small()
{
	int result = 0;
	for (int i = 0; i < 9; i = i + 3)
	{
		for (int j = 0; j < 9; j = j + 3)
		{
			result = map[i][j] + map[i + 1][j] + map[i + 2][j] + map[i][j + 1] + map[i][j + 2] + map[i + 1][j + 1] + map[i + 1][j + 2] + map[i + 2][j + 1] + map[i + 2][j + 2];
			if (result != 45)
			{
				flag = 0;
				break;
			}
			result = 0;
		}
		if (flag == 0)
			break;
	}
}
int main()
{
	int test;
	scanf("%d", &test);
	//ifstream inf("C:\\Users\\admin\\Downloads\\input.txt");
	//inf >> test;
	for (int z = 1; z <= test; z++)
	{
		for (int i = 0; i < 9; i++)
		{
			for (int j = 0; j < 9; j++)
			{
				//inf >> map[i][j];
				scanf("%d", &map[i][j]);
			}
		}
		flag = 1;
		dy();
		dx();
		small();
		printf("#%d %d\n", z, flag);
	}
}