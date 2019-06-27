#include <iostream>
#include <string.h>
using namespace std;

int dx[3] = { 0,0,1 };
int dy[3] = { -1,1,0 };
int map[100][100];
int check[100][100];
int count_number=0;
void dfs(int x, int y)
{
	check[x][y] = 1;
	count_number = count_number + 1;

	if (x == 99)
	{
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
	int n;
	int countarr[100] = {0};
	int mx=0;
	int mxdx=0;


	for (int i = 1; 1 < 11; i++)
	{
		cin >> n;

		for (int j = 0; j <100; j++)
		{
			for (int k = 0; k < 100; k++)
			{
				cin >> map[j][k];
			}
		}

		for (int l = 0; l < 100; l++)
			memset(check[l], 0, sizeof(int) * 100);


		for (int j = 0; j < 100; j++)
		{
			if (map[0][j] == 1 && check[0][j] == 0)
			{
				dfs(0, j);
				countarr[j] = count_number;
			}
			
			for (int k = 0; k < 100; k++)
				memset(check[k], 0, sizeof(int) * 100);

			count_number = 0;
		}
		

		for (int a = 0; a < 100; a++)
		{
			if (a == 0)
			{
				mxdx = a;
				mx = countarr[a];
			}
			else
			{
				if (mx <= countarr[a])
				{
					mxdx = a;
					mx = countarr[a];
				}
			}
		}
		cout << "#" << i << " " << mxdx << endl;
		for (int x = 0; x < 100; x++)
			countarr[x] = 0;

		mx = 0;
		mxdx = 0;
	}
}
