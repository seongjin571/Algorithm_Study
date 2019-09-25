#include <iostream>
#include <vector>
#include <queue>
#include <fstream>
using namespace std;

struct t {
	int x;
	int y;
	int num;
};
int gogogo;
int w, h, n;
int map[20][20];
int sample[20][20];
int bomb_check[20][20];
vector<int> vc;
queue<t> que;
int result;
void reset_check()
{
	for (int i = 0; i < h; i++)
	{
		for (int j = 0; j < w; j++)
		{
			bomb_check[i][j] = 0;
		}
	}
}
void make_sample()
{
	for (int i = 0; i < h; i++)
	{
		for (int j = 0; j < w; j++)
		{
			sample[i][j] = map[i][j];
		}
	}
}
void move()
{
	queue<int> q;
	for (int y = 0; y < w; y++)
	{
		for (int x = h - 1; x >= 0; x--)
		{
			if (sample[x][y] != 0)
			{
				q.push(sample[x][y]);
				sample[x][y] = 0;
			}
		}
		int cnt = h - 1;
		while (!q.empty())
		{
			int data = q.front();
			sample[cnt][y] = data;
			q.pop();
			cnt--;
		}
	}
	
	
}
void bomb(int start)
{
	for (int i = 0; i < h; i++)
	{
		if (sample[i][start] != 0)
		{
			que.push({ i, start, sample[i][start] });
			break;
		}
	}
	while (!que.empty())
	{
		bomb_check[que.front().x][que.front().y] = 1;
		int num = que.front().num;
		int x = que.front().x;
		int y = que.front().y;
		sample[x][y] = 0;
		que.pop();
		for (int i = 1; i < num; i++)//아래
		{
			if ((-1 < x + i && x + i < h) && (bomb_check[x + i][y] == 0) && (sample[x + i][y] != 0))
			{
				que.push({ x + i,y,sample[x + i][y] });
				bomb_check[x + i][y] = 1;
			}
		}
		for (int i = 1; i < num; i++)//위
		{
			if ((-1 < x - i && x - i < h) && (bomb_check[x - i][y] == 0) && (sample[x - i][y] != 0))
			{
				que.push({ x - i,y,sample[x - i][y] });
				bomb_check[x - i][y] = 1;
			}
		}
		for (int i = 1; i < num; i++)//오른쪽
		{
			if ((-1 < y + i && y + i < w) && (bomb_check[x][y + i] == 0) && (sample[x][y + i] != 0))
			{
				que.push({ x,y + i,sample[x][y + i] });
				bomb_check[x][y + i] = 1;
			}
		}
		for (int i = 1; i < num; i++)//왼쪽
		{
			if ((-1 < y - i && y - i < w) && (bomb_check[x][y-i] == 0) && (sample[x][y-i] != 0))
			{
				que.push({ x,y - i,sample[x][y-i] });
				bomb_check[x][y-i] = 1;
			}
		}
	}
	/*
	cout << endl;
	for (int i = 0; i < h; i++)
	{
		for (int j = 0; j < w; j++)
			cout << sample[i][j] << " ";
		cout << endl;
	}
	*/
}
int count_sample()//남은 벽돌의 개수
{
	int cnt = 0;
	for (int i = 0; i < h; i++)
	{
		for (int j = 0; j < w; j++)
		{
			if (sample[i][j] != 0)
				cnt++;
		}
	}
	return cnt;
}
void dfs()
{
	int recent = 100000;
	if (vc.size() == n)
	{
		make_sample();
		for (auto idx : vc)
		{
			reset_check();
			bomb(idx);
			move();
			/*
			cout <<  idx << endl;
			for (int i = 0; i < h; i++)
			{
				for (int j = 0; j < w; j++)
					cout << sample[i][j] << " ";
				cout << endl;
			}
			*/
		}
		/*
		cout << "++++++++++++++++++++" << endl;
		*/
		recent = count_sample();
		if (recent < result)
			result = recent;
		if (recent == 0)
		{
			gogogo = 1;
			return;
		}
		
			
	}
	else
	{
		for (int i = 0; i < w; i++)
		{
				vc.push_back(i);
				if (gogogo == 0)
					dfs();
				vc.pop_back();

		}
	}
}
int main()
{
	//ifstream inf("C:\\Users\\admin\\Downloads\\sample_input.txt");
	int test;
	cin >> test;
	//inf >> test;
	for (int t = 1; t <= test; t++)
	{
		//inf >> n >> w >> h;
		cin >> n >> w >> h;
		for (int i = 0; i < h; i++)
		{
			for (int j = 0; j < w; j++)
			{
				//inf >> map[i][j];
				cin >> map[i][j];
			}
		}
		result = 100000;
		gogogo = 0;
		dfs();
		//ddf();
		cout << "#" << t << " " << result << endl;
	}

}
/*

3 10 10
0 0 0 0 0 0 0 0 0 0
1 0 1 0 1 0 0 0 0 0
1 0 3 0 1 1 0 0 0 1
1 1 1 0 1 2 0 0 0 9
1 1 4 0 1 1 0 0 1 1
1 1 4 1 1 1 2 1 1 1
1 1 5 1 1 1 1 2 1 1
1 1 6 1 1 1 1 1 2 1
1 1 1 1 1 1 1 1 1 5
1 1 7 1 1 1 1 1 1 1
2 9 10
0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0
0 1 0 0 0 0 0 0 0
0 1 0 0 0 0 0 0 0
1 1 0 0 1 0 0 0 0
1 1 0 1 1 1 0 1 0
1 1 0 1 1 1 0 1 0
1 1 1 1 1 1 1 1 0
1 1 3 1 6 1 1 1 1
1 1 1 1 1 1 1 1 1
3 6 7
1 1 0 0 0 0
1 1 0 0 1 0
1 1 0 0 4 0
4 1 0 0 1 0
1 5 1 0 1 6
1 2 8 1 1 6
1 1 1 9 2 1
4 4 15
0 0 0 0
0 0 0 0
0 0 0 0
1 0 0 0
1 0 0 0
1 0 0 0
1 0 0 0
1 0 5 0
1 1 1 0
1 1 1 9
1 1 1 1
1 6 1 2
1 1 1 5
1 1 1 1
2 1 1 2
*/