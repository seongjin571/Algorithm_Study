#include <iostream>
#include <string.h>
#include <algorithm>
#include <queue>
using namespace std;
int arr[10][10];
bool check[10][10];
int dx[4] = { 0,-1,0,1 };
int dy[4] = { 1,0,-1,0 };
void bfs(int x, int y)
{
	queue<int>que;
	que.push(x);//������ǥ�� �־���
	que.push(y);
	check[x][y] = true;//������ǥ �湮ó��
	int count = 0;
	arr[x][y] = count;//ù���� ����

	while (!que.empty())//ť �ȿ� ������ �������� ����
	{
		int xx = que.front();//������ǥ�� �̱�
		que.pop();//����
		int yy = que.front();
		que.pop();
		for (int i = 0; i < 4; i++)//dx dy�� ������
		{
			int newx = xx + dx[i];//���� x��ǥ
			int newy = yy + dy[i];//���� y��ǥ
			if ((-1 < newx && newx < 10) && (-1 < newy && newy < 10) && (check[newx][newy] == false))//���� ��ǥ�� ������ Ʋ���ų� �湮 ������ if�� �ȿ� ������ ����
			{
				que.push(newx);//���ο���ǥ ť�� ����
				que.push(newy);
				count++;
				check[newx][newy] = true;//�湮ó��
				arr[newx][newy] = count;
			}
		}
	}
	for (int i = 0; i < 10; i++)//���
	{
		for (int j = 0; j < 10; j++)
		{
			printf("%3d", arr[i][j]);
		}
		cout << endl;
	}
}
void dfs(int x, int y, int count)
{
	check[x][y] = true;//x,y ��ǥ �湮ó��
	arr[x][y] = count;
	
	for (int i = 0; i < 4; i++)
	{
		int newx = x + dx[i];
		int newy = y + dy[i];
		if ((-1 < newx && newx < 10) && (-1 < newy && newy < 10) && (check[newx][newy] == false))
		{
			dfs(newx, newy,count+1);
		}
	}

	
}

int main()
{	
	for (int i = 0; i < 10; i++)
	{
		for (int j = 0; j < 10;j++)
		{
			arr[i][j] = 0;
			check[i][j] = false;
		}
	}
	cout << "++++++++++++++++++++bfs++++++++++++++++++++" << endl;
	bfs(0, 0);
	int count = 0;//dfs Ȯ���� ���� ��
	for (int i = 0; i < 10; i++)
	{
		for (int j = 0; j < 10; j++)
		{
			arr[i][j] = 0;
			check[i][j] = false;
		}
	}
	cout << "++++++++++++++++++++dfs++++++++++++++++++++" << endl;
	dfs(0, 0,count);
	for (int i = 0; i < 10; i++)//���
	{
		for (int j = 0; j < 10; j++)
		{
			printf("%3d", arr[i][j]);
		}
		cout << endl;
	}
}