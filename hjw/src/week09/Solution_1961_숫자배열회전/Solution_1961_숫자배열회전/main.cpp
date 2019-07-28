#include <cstdio>
#include <fstream>
#include <iostream>
using namespace std;
int map[8][8];
void turna(int a, int n)
{
	for (int i = n-1; i >=0;i--)
	{
		printf("%d", map[i][a]);
	}
}
void turnb(int a, int n)
{
	for (int i = n - 1; i >= 0; i--)
	{
		printf("%d", map[n-a-1][i]);
	}
}
void turnc(int a, int n)
{
	for (int i=0;i<n;i++)
	{
		printf("%d", map[i][n-a-1]);
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
		int n;
		//inf >> n;
		scanf("%d", &n);
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				//inf >> map[i][j];
				scanf("%d", &map[i][j]);
			}
		}

		printf("#%d\n", z);
		for (int a = 0; a < n; a++)
		{
			turna(a,n);
			printf(" ");
			turnb(a,n);
			printf(" ");
			turnc(a,n);
			printf("\n");
		}
	}
}