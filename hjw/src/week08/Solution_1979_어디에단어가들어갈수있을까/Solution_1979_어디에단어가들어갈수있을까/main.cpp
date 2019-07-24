#include <cstdio>
#include <iostream>
#include <fstream>
using namespace std;

int map[16][16];
int cnt;
int result;
void cla(int x, int y, int k)
{
	cnt = 1;
	int idx = 1;
	while (1)
	{
		if (map[x][y-1] == 1)
			break;
		if (map[x][y + idx] == 1)
		{
			cnt++;
			idx++;
		}
		else
			break;
	}
	if (cnt == k)
		result++;

	idx = 1;
	cnt = 1;
	while (1)
	{
		if (map[x - 1][y] == 1)
			break;
		if (map[x + idx][y] == 1)
		{
			cnt++;
			idx++;
		}
		else
			break;
	}
	if (cnt == k)
		result++;
}
int main()
{
	int test;
	scanf("%d", &test);

	//ifstream inf("C:\\Users\\admin\\Downloads\\input.txt");
	//inf >> test;
	for (int a = 1; a <= test; a++)
	{
		int n, k;
		int real = 0;
		//inf >> n >> k;
		scanf("%d %d", &n, &k);
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				scanf("%d", &map[i][j]);
				//inf >> map[i][j];
			}
		}
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				if (map[i][j] == 1)
				{
					result = 0;
					cla(i, j,k);
					real += result;
				}

			}
		}
		
		printf("#%d %d\n", a, real);
	}
}