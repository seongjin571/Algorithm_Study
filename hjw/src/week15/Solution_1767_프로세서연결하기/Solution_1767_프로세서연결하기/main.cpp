#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <cmath>
using namespace std;

struct info {
	int core_num;
	int line_num;
};
struct xy {
	int x;
	int y;
};
int n;
int temp[13][13];
int map[13][13];
vector<xy> core_location;
vector<info>vc;
bool cmp(const info &p1, const info &p2)
{
	if (p1.core_num > p2.core_num)
		return true;
	else if (p1.core_num == p2.core_num) {
		return p1.line_num < p2.line_num;
	}
	else
		return false;
}
int draw_line(int now_index, int dir)
{
	int cnt = 0;
	if (dir == 0)//상
	{
		for (int i = core_location[now_index].x-1; i >= 0; i--)
		{
			temp[i][core_location[now_index].y] = 2;
			cnt++;
		}
		
	}
	else if (dir == 1)//하
	{
		for (int i = core_location[now_index].x+1; i < n; i++)
		{
			temp[i][core_location[now_index].y] = 2;
			cnt++;
		}
		
	}
	else if (dir == 2)//좌
	{
		for (int i = core_location[now_index].y-1; i >= 0; i--)
		{
			temp[core_location[now_index].x][i] = 2;
			cnt++;
		}
		
	}
	else if (dir == 3)//우
	{
		for (int i = core_location[now_index].y+1; i < n; i++)
		{
			temp[core_location[now_index].x][i] = 2;
			cnt++;
		}
		
	}
	else if (dir == 4)//그대로
	{
		return cnt;
	}
	return cnt;
}
bool check(int now_index, int dir)
{
	bool flag = true;
	if (dir == 0)//상
	{
		for (int i = core_location[now_index].x-1; i >= 0; i--)
		{
			if (temp[i][core_location[now_index].y] != 0)
			{
				flag = false;
				break;
			}
		}
		if (flag)
			return true;
		else
			return false;
	}
	else if (dir == 1)//하
	{
		for (int i = core_location[now_index].x+1; i < n; i++)
		{
			if (temp[i][core_location[now_index].y] != 0)
			{
				flag = false;
				break;
			}
		}
		if (flag)
			return true;
		else
			return false;
	}
	else if (dir == 2)//좌
	{
		for (int i = core_location[now_index].y-1; i >=0; i--)
		{
			if (temp[core_location[now_index].x][i] != 0)
			{
				flag = false;
				break;
			}
		}
		if (flag)
			return true;
		else
			return false;
	}
	else if (dir == 3)//우
	{
		for (int i = core_location[now_index].y+1; i < n; i++)
		{
			if (temp[core_location[now_index].x][i] != 0)
			{
				flag = false;
				break;
			}
		}
		if (flag)
			return true;
		else
			return false;
	}
	else if (dir == 4)//그대로
	{
		return true;
	}

}
void remove(int now_index,int dir)
{
	if (dir == 0)//상
	{
		for (int i = core_location[now_index].x-1; i >= 0; i--)
		{
			temp[i][core_location[now_index].y] = 0;
		}

	}
	else if (dir == 1)//하
	{
		for (int i = core_location[now_index].x+1; i < n; i++)
		{
			temp[i][core_location[now_index].y] = 0;
		}

	}
	else if (dir == 2)//좌
	{
		for (int i = core_location[now_index].y-1; i >= 0; i--)
		{
			temp[core_location[now_index].x][i] = 0;
		}

	}
	else if (dir == 3)//우
	{
		for (int i = core_location[now_index].y+1; i < n; i++)
		{
			temp[core_location[now_index].x][i] =0;
		}

	}
	else if (dir == 4)//그대로
	{
		
	}
}
void go(int now_index, int count, int sum,int use_process)
{
	if (now_index == count)
	{
		vc.push_back({ use_process, sum });
		return;
	}
	else {
		for (int dir = 0; dir < 5; dir++) {
			bool b = check(now_index, dir);
			if (b) {
				int drawSum = draw_line(now_index, dir);
				if (dir != 4)
				{
					go(now_index + 1, count, sum + drawSum, use_process + 1);
				}
				else
					go(now_index + 1, count, sum + drawSum, use_process);
				remove(now_index,dir);
			}

		}
		
	}
}
void start()
{
	int count = core_location.size();
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			temp[i][j] = map[i][j];
		}
	}//sample map 생성
	go(0, count,0,0);
	sort(vc.begin(), vc.end(), cmp);
}
int main()
{
	int test;
	cin >> test;
	for (int t = 1; t <= test; t++)
	{
		cin >> n;
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				cin >> map[i][j];
				if (map[i][j] == 1)
				{
					core_location.push_back({ i,j });
				}
			}
		}

		for (int i = 0; i < core_location.size();)
		{
			if (core_location[i].x == 0 || core_location[i].x == n - 1 || core_location[i].y == 0 || core_location[i].y == n - 1)
			{
				core_location.erase(core_location.begin() + i);
			}
			else
				i++;
		}
		start();
		core_location.clear();
		printf("#%d %d\n", t, vc[0].line_num);
		vc.clear();
	}
}
//확인
//그리기
//재귀
//지워