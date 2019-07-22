/*캐슬 디펜스는 성을 향해 몰려오는 적을 잡는 턴 방식의 게임이다. 게임이 진행되는 곳은 크기가 N×M인 격자판으로 나타낼 수 있다. 격자판은 1×1 크기의 칸으로 나누어져 있고, 각 칸에 포함된 적의 수는 최대 하나이다. 격자판의 N번행의 바로 아래(N+1번 행)의 모든 칸에는 성이 있다.

성을 적에게서 지키기 위해 궁수 3명을 배치하려고 한다. 궁수는 성이 있는 칸에 배치할 수 있고, 하나의 칸에는 최대 1명의 궁수만 있을 수 있다. 각각의 턴마다 궁수는 적 하나를 공격할 수 있고, 모든 궁수는 동시에 공격한다. 궁수가 공격하는 적은 거리가 D이하인 적 중에서 가장 가까운 적이고, 그러한 적이 여럿일 경우에는 가장 왼쪽에 있는 적을 공격한다. 같은 적이 여러 궁수에게 공격당할 수 있다. 공격받은 적은 게임에서 제외된다. 궁수의 공격이 끝나면, 적이 이동한다. 적은 아래로 한 칸 이동하며, 성이 있는 칸으로 이동한 경우에는 게임에서 제외된다. 모든 적이 격자판에서 제외되면 게임이 끝난다. 

게임 설명에서 보다시피 궁수를 배치한 이후의 게임 진행은 정해져있다. 따라서, 이 게임은 궁수의 위치가 중요하다. 격자판의 상태가 주어졌을 때, 궁수의 공격으로 제거할 수 있는 적의 최대 수를 계산해보자.

격자판의 두 위치 (r1, c1), (r2, c2)의 거리는 |r1-r2| + |c1-c2|이다.

입력
첫째 줄에 격자판 행의 수 N, 열의 수 M, 궁수의 공격 거리 제한 D가 주어진다. 둘째 줄부터 N개의 줄에는 격자판의 상태가 주어진다. 0은 빈 칸, 1은 적이 있는 칸이다.

출력
첫째 줄에 궁수의 공격으로 제거할 수 있는 적의 최대 수를 출력한다.

제한
3 ≤ N, M ≤ 15
1 ≤ D ≤ 10*/
#include <iostream>
#include <cstdio>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;
int dx[3] = { 0,-1,0 };
int dy[3] = { -1,0,1 };//공격 우선 순위가 왼쪽부터 && 적은 위에서 부터 내려온다
int map[16][16];
int sample[16][16];
int result;
int h, y, al;
int flag;
struct position {
	int xpos;
	int ypos;
};
struct content {
	int xpos;
	int ypos;
	int len;
};
vector <position> vc;//조합을 위한 벡터
vector <int> res;//결과를 출력하기 위한 벡터
queue<position> die;//궁수들이 죽인 적을 담아놓는 큐
void init()
{
	for (int i = 0; i < h; i++)
	{
		for (int j = 0; j < y; j++)
			sample[i][j] = map[i][j];
	}
}
void cal(int xpos, int ypos)//적군을 찾고 해당 적군이 사정거리 내에 있는지 확인 후 사살
{
	flag = 0;
	int count = 0;
	content c;//궁수위치
	c.xpos = xpos;
	c.ypos = ypos;
	c.len = 0;
	vector<content>news;
	queue<content> s;
	s.push(c);
	while (flag != 1)
	{
		int xx = s.front().xpos;
		int yy = s.front().ypos;
		int llen = s.front().len;
		s.pop();
		for (int i = 0; i < 3; i++)
		{
			int newx = xx + dy[i];
			int newy = yy + dx[i];
			int newlen = llen + 1;
			if ((-1 < newx && newx < h) && (-1 < newy && newy < y) && (llen <= al))
			{
				content ss;
				ss.len = newlen;
				ss.xpos = newx;
				ss.ypos = newy;
				//printf("input : %d %d\n", newx, newy);
				s.push(ss);
			}
			else if (llen > al)
			{
				flag = 1;
				break;
			}
		}
	}
	while (!s.empty())
	{
		content sss;
		sss.xpos = s.front().xpos;
		sss.ypos = s.front().ypos;
		sss.len = s.front().len;
		news.push_back(sss);
		s.pop();
	}
	for (int z = 0; z < h; z++)
	{
		for (auto i : news)
		{
			int newx = i.xpos;
			int newy = i.ypos;
			//printf("%d, %d\t", newx, newy);
			if (sample[newx][newy] == 1)
			{
				position e;
				e.xpos = newx - count;
				e.ypos = newy;
				printf("count : %d, 죽인 적의 좌표 : (%d, %d)\n", count, e.xpos, e.ypos);
				die.push(e);
				break;
			}
		}
		
		count++;
		for (int i = h - 1; i >= 0; i--)
		{
			for (int j = 0; j < y; j++)
			{
				if (i == 0)
				{
					sample[i][j] = 0;
				}
				else
				{
					sample[i][j] = sample[i - 1][j];
				}
			}
		}

	}
	
}
void dfs(int cnt, int n, int r, int h)
{
	position p;
	vector<position>result;
	int flag2;
	if (vc.size() == r)
	{
		for (auto i : vc)
		{
			init();
			printf("궁수위치 : (%d, %d)\n", i.xpos, i.ypos);
			cal(i.xpos, i.ypos);
		}
		cout << endl;
		//궁수 배치 case끝
		while (!die.empty())
		{
			flag2 = 0;
			position pp = die.front();
			die.pop();
			if (result.empty())
			{
				result.push_back(pp);
			}
			else
			{
				for (auto j : result)
				{
					if (j.xpos == pp.xpos && j.ypos == pp.ypos)
					{
						flag2 = 1;
						break;
					}
				}
				if (flag2 == 0)
				{
					result.push_back(pp);
				}
			}
		}
		
		res.push_back(result.size());
		result.clear();
		return;
	}
	for (int i = cnt; i <= n; i++)
	{
		if (vc.size() < r)
		{
			p.ypos = i;
			p.xpos = h;
			vc.push_back(p);
			dfs(i + 1, n, r, h);
			vc.pop_back();
		}
	}
}
int main()
{
	scanf("%d %d %d", &h, &y, &al);//행, 열, 궁수의 사거리

	for (int i = 0; i < h; i++)
	{
		for (int j = 0; j < y; j++)
		{
			scanf("%d", &map[i][j]);
		}
	}
	//h행에 궁수를 배치
	dfs(0, y-1, 3, h);
	sort(res.begin(), res.end());
	printf("%d", res.back());
}