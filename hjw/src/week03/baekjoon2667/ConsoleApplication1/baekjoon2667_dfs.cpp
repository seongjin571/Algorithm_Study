#include <iostream>
#include <string.h>
#include <algorithm>

using namespace std;

int dx[4] = { 0,-1,0,1 };
int dy[4] = { -1,0,1,0 };
void dfs(int **arr, int **check, int x, int y,int n, int* count)
{
	check[x][y] = 1;//�湮ó��
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
	
	int **arr = new int*[n];//�� �����Ҵ�
	int **check = new int*[n];
	char *start = new char[n];

	for (int i = 0; i < n; i++)
		arr[i] = new int[n];//�� �����Ҵ�
	for (int i = 0; i < n; i++)
		check[i] = new int[n];

	for (int i = 0; i < n; i++)//arr�� �ޱ�
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

	for (int i = 0; i < n; i++)//check�Լ� �ʱ�ȭ
		memset(check[i], 0, sizeof(int)*n);//��簪 0���� �ʱ�ȭ,,,0->�湮x 1->�湮o

	fill(countarr, countarr + 1000, 0);

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j<n; j++)
		{
			if ((arr[i][j] == 1) && (check[i][j] == 0))//�湮���Ѱ��� ó���� ã��
			{
				danji++;
				dfs(arr, check, i, j, n, &count);//�����ٿ�� 1.2�����迭 2.check�迭 3.����x��ǥ 4.����y��ǥ, 5.�迭�� ũ�� 6.����
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
		delete[] arr[i];//�޸� ����

	delete[] arr;//�޸� ����
}
