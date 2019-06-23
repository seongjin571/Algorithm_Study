#include <iostream>
#include <string.h>
#include <queue>
#include <algorithm>
using namespace std;

int dx[4] = { 0,-1,0,1 };
int dy[4] = { -1,0,1,0 };
void bfs(int **arr, int **check, int i,int j,int n,int* count)
{
	queue<int> que;
	que.push(i);
	que.push(j);
	check[i][j] = 1;
	*count = *count + 1;

	while (!que.empty())
	{
		int xx = que.front();
		que.pop();
		int yy = que.front();
		que.pop();
		for (int k = 0; k < 4; k++)
		{
			int newx = xx + dx[k];
			int newy = yy + dy[k];
			if ((-1 < newx && newx < n) && (-1 < newy && newy < n) && (arr[newx][newy] == 1) && (check[newx][newy] == 0))
			{
				*count = *count + 1;
				que.push(newx);
				que.push(newy);
				check[newx][newy] = 1;
			}
		}
	}
}
int main()
{
	int h=0;
	int count = 0;
	int danji = 0;
	int n;
	cin >> n;
	int countarr[1000];
	int **arr = new int*[n];
	int **check = new int*[n];
	char *start = new char[n];

	for (int i = 0; i < n; i++)
		arr[i] = new int[n];
	for (int i = 0; i < n; i++)
		check[i] = new int[n];

	for (int i = 0; i < n; i++)//arr°ª ¹Þ±â
	{
		for (int j = 0; j < n; j++)
		{
			cin >> start[j];
		}
		for (int j = 0; j < n; j++)
		{
			arr[i][j] = start[j] - '0';
		}
	}

	for (int i= 0; i < n; i++)
	{
		memset(check[i], 0, sizeof(int)*n);
	}

	fill(countarr, countarr + 1000, 0);

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			if (arr[i][j] == 1 && check[i][j] == 0)
			{
				bfs(arr,check,i,j,n,&count);
				danji++;
				countarr[h] = count;
				h++;
			}
			count = 0;
		}
	}
	h = 0;
	int a = 0;
	while (countarr[h] != 0)
	{
		a++;
		h++;
	}
	sort(countarr, countarr + a);
	cout << danji << endl;
	h = 0;
	while (a != 0)
	{
		cout << countarr[h] << endl;
		h++;
		a--;
	}

}