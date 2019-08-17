#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int n,m;
int result;
int map[8][8];
int test[8][8];
int cctv_size = 0;
struct info {
	int x;
	int y;
	int dir;
	int type;
};
vector<info> cctv;
void go0(int x, int y)//오른쪽
{
	for (int i = y; i < m; i++)
	{
		if (test[x][i] == 6)
			break;
		if (test[x][i] == 0)
			test[x][i] = -1;
	}
}
void go1(int x, int y)//아래로
{
	for (int i = x; i < n; i++)
	{
		if (test[i][y] == 6)
			break;
		if (test[i][y] == 0)
			test[i][y] = -1;
	}
}
void go2(int x, int y)//왼쪽
{
	for (int i = y; i >= 0; i--)
	{
		if (test[x][i] == 6)
			break;
		if (test[x][i] == 0)
			test[x][i] = -1;
	}
}
void go3(int x, int y)//위로
{
	for (int i = x; i >= 0; i--)
	{
		if (test[i][y] == 6)
			break;
		if (test[i][y] == 0)
			test[i][y] = -1;
	}
}
void start()
{
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			test[i][j] = map[i][j];
		}
	}//sample map 생성

	for (int i = 0; i < cctv.size(); i++)
	{
		if (cctv[i].type == 1)
		{
			if (cctv[i].dir == 0)
				go0(cctv[i].x, cctv[i].y);
			if (cctv[i].dir == 1)
				go1(cctv[i].x, cctv[i].y);
			if (cctv[i].dir == 2)
				go2(cctv[i].x, cctv[i].y);
			if (cctv[i].dir == 3)
				go3(cctv[i].x, cctv[i].y);
		}

		if (cctv[i].type == 2)
		{
			if (cctv[i].dir == 0 || cctv[i].dir == 2)
			{
				go0(cctv[i].x, cctv[i].y);
				go2(cctv[i].x, cctv[i].y);
			}

			if (cctv[i].dir == 1 || cctv[i].dir == 3)
			{
				go1(cctv[i].x, cctv[i].y);
				go3(cctv[i].x, cctv[i].y);
			}
		}

		if (cctv[i].type == 3) {

			if (cctv[i].dir == 0) {
				go2(cctv[i].x, cctv[i].y);
				go3(cctv[i].x, cctv[i].y);
			}

			if (cctv[i].dir == 1) {
				go0(cctv[i].x, cctv[i].y);
				go3(cctv[i].x, cctv[i].y);
			}

			if (cctv[i].dir == 2) {
				go0(cctv[i].x, cctv[i].y);
				go1(cctv[i].x, cctv[i].y);
			}

			if (cctv[i].dir == 3) {
				go1(cctv[i].x, cctv[i].y);
				go2(cctv[i].x, cctv[i].y);
			}
		}

		if (cctv[i].type == 4) {

			if (cctv[i].dir == 0) {
				go0(cctv[i].x, cctv[i].y);
				go1(cctv[i].x, cctv[i].y);
				go2(cctv[i].x, cctv[i].y);
			}

			if (cctv[i].dir == 1) {
				go1(cctv[i].x, cctv[i].y);
				go2(cctv[i].x, cctv[i].y);
				go3(cctv[i].x, cctv[i].y);
			}

			if (cctv[i].dir == 2) {
				go0(cctv[i].x, cctv[i].y);
				go2(cctv[i].x, cctv[i].y);
				go3(cctv[i].x, cctv[i].y);
			}

			if (cctv[i].dir == 3) {
				go0(cctv[i].x, cctv[i].y);
				go1(cctv[i].x, cctv[i].y);
				go3(cctv[i].x, cctv[i].y);
			}
		}

		if (cctv[i].type == 5) {
			go0(cctv[i].x, cctv[i].y);
			go1(cctv[i].x, cctv[i].y);
			go2(cctv[i].x, cctv[i].y);
			go3(cctv[i].x, cctv[i].y);
		}
	}

	int cnt = 0;
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			if (test[i][j] == 0)
				cnt++;
		}
	}

	result = min(result, cnt);
}
void go(int index)
{
	if (index == cctv_size)
	{
		start();
		return;
	}

	cctv[index].dir = 0;
	go(index + 1);

	cctv[index].dir = 1;
	go(index + 1);

	cctv[index].dir = 2;
	go(index + 1);

	cctv[index].dir = 3;
	go(index + 1);
}
int main()
{
	result = 1000000;
	cin >> n >> m;

	
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			cin >> map[i][j];
			if (map[i][j] != 0 && map[i][j] != 6)
			{
				cctv.push_back({ i,j,0,map[i][j] });
				//x좌표 y좌표 방향성 cctv종류
			}
		}
	}
	cctv_size = cctv.size();
	go(0);

	cout << result << endl;
}
/*
void go(int index)
{
	if(index == 3)
	{
		for(int i=0;i<vc.size();i++)
		{
			cout << vc[i] << " ";
		}
		cout << endl;

		return;
	}

	for(int i=0;i<4;i++)
	{
		vc.push_back(i);
		go(index+1);
		vc.pop_back();
	}
}
int main ()
{
	vector<int>vc;
	go(0);
}
*/