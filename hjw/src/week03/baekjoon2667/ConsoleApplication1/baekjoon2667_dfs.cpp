#include <iostream>
#include <string.h>
#include <algorithm>

using namespace std;

int dx[4] = { 0,-1,0,1 };
int dy[4] = { -1,0,1,0 };
void dfs(int **arr, int **check, int x, int y,int n, int* count)
{
	check[x][y] = 1;//방문처리
	*count = *count + 1;
	for (int i = 0; i < 4; i++)
	{
		int newx = x + dx[i];
		int newy = y + dy[i];
		if ((-1<newx && newx < n) && (-1<newy && newy < n) && (check[newx][newy] == 0)&&(arr[newx][newy] == 1))
		{
			dfs(arr, check, newx, newy, n, count);
		}
	}

}

int main()
{
	int countarr[1000];
	int a = 0;
	int k = 0;
	int n;//array size
	int count = 0;
	int danji = 0;
	cin >> n;
	
	int **arr = new int*[n];//행 동적할당
	int **check = new int*[n];
	char *start = new char[n];

	for (int i = 0; i < n; i++)
		arr[i] = new int[n];//열 동적할당
	for (int i = 0; i < n; i++)
		check[i] = new int[n];

	for (int i = 0; i < n; i++)//arr값 받기
	{
		for (int j = 0; j < n; j++)
		{
			cin >> start[j];
		}
		for (int j = 0; j < n;j++)
		{
			arr[i][j] = start[j]-'0';
		}
	}

	for (int i = 0; i < n; i++)//check함수 초기화
		memset(check[i], 0, sizeof(int)*n);//모든값 0으로 초기화,,,0->방문x 1->방문o

	fill(countarr, countarr + 1000, 0);

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j<n; j++)
		{
			if ((arr[i][j] == 1) && (check[i][j] == 0))//방문안한것중 처음것 찾기
			{
				danji++;
				dfs(arr, check, i, j, n, &count);//보내줄요소 1.2차원배열 2.check배열 3.현재x좌표 4.현재y좌표, 5.배열의 크기 6.개수
				countarr[k] = count;
				k++;
			}
			count = 0;
		}
	}
	k = 0;
	while (countarr[k] != 0)
	{
		a++;
		k++;
	}
	k = 0;
	sort(countarr, countarr + a);
	cout << danji << endl;
	while (countarr[k] != 0)
	{
		cout << countarr[k] << endl;
		k++;
	}




	

	for (int i = 0; i < n; i++)
		delete[] arr[i];//메모리 해제

	delete[] arr;//메모리 해제
}
