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
	que.push(x);//시작좌표를 넣어줌
	que.push(y);
	check[x][y] = true;//시작좌표 방문처리
	int count = 0;
	arr[x][y] = count;//첫번쨰 입장

	while (!que.empty())//큐 안에 데이터 없어질때 까지
	{
		int xx = que.front();//시작좌표값 뽑기
		que.pop();//빼기
		int yy = que.front();
		que.pop();
		for (int i = 0; i < 4; i++)//dx dy로 움직임
		{
			int newx = xx + dx[i];//다음 x좌표
			int newy = yy + dy[i];//다음 y좌표
			if ((-1 < newx && newx < 10) && (-1 < newy && newy < 10) && (check[newx][newy] == false))//다음 좌표의 범위가 틀리거나 방문 됬으면 if문 안에 들어오지 않음
			{
				que.push(newx);//새로운좌표 큐에 삽입
				que.push(newy);
				count++;
				check[newx][newy] = true;//방문처리
				arr[newx][newy] = count;
			}
		}
	}
	for (int i = 0; i < 10; i++)//출력
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
	check[x][y] = true;//x,y 좌표 방문처리
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
	int count = 0;//dfs 확인을 위한 것
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
	for (int i = 0; i < 10; i++)//출력
	{
		for (int j = 0; j < 10; j++)
		{
			printf("%3d", arr[i][j]);
		}
		cout << endl;
	}
}