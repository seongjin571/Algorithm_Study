#include <cstdio>
#include <vector>
#include <string>
#include <stdlib.h>
using namespace std;
struct virus
{
	int x;
	int y;
	int num;
	int dir;
};
vector <virus> vc;//바이러스 담아두는 벡터
int n, m, k;//배열크기, 격리시간, 미생물 군집 개수
int map[101][101];

void same_locate()
{
	for (int i = 0; i < vc.size(); i++)
	{
		int total = vc.at(i).num;
		int mx = vc.at(i).num;
		int dir = vc.at(i).dir;
		for (int j = i+1; j < vc.size();)
		{
			if (vc.at(i).x == vc.at(j).x && vc.at(i).y == vc.at(j).y)
			{
				total += vc.at(j).num;
				if (mx < vc.at(j).num)
				{
					mx = vc.at(j).num;
					dir = vc.at(j).dir;
				}
				vc.erase(vc.begin() + j);
			}
			else
				j++;
		}
		vc.at(i).num = total;
		vc.at(i).dir = dir;
	}
}
void move(int a)
{
	if (vc.at(a).dir == 1)//상
	{
		int temp;
		temp = vc.at(a).x - 1;
		vc.at(a).x = temp;
		if (vc.at(a).x == 0)
		{
			vc.at(a).num = vc.at(a).num / 2;
			vc.at(a).dir = 2;
		}
	}
	else if (vc.at(a).dir == 2)//하
	{
		int temp;
		temp = vc.at(a).x + 1;
		vc.at(a).x = temp;
		if (vc.at(a).x == n-1)
		{
			vc.at(a).num = vc.at(a).num / 2;
			vc.at(a).dir = 1;
		}
	}
	else if (vc.at(a).dir == 3)//좌
	{
		int temp;
		temp = vc.at(a).y - 1;
		vc.at(a).y = temp;
		if (vc.at(a).y == 0)
		{
			vc.at(a).num = vc.at(a).num / 2;
			vc.at(a).dir = 4;
		}
	}
	else if (vc.at(a).dir == 4)//우
	{
		int temp;
		temp = vc.at(a).y + 1;
		vc.at(a).y = temp;
		if (vc.at(a).y == n-1)
		{
			vc.at(a).num = vc.at(a).num / 2;
			vc.at(a).dir = 3;
		}
	}
}
int main()
{
	int t;
	scanf("%d", &t);

	for (int test = 1; test <= t; test++)
	{
		scanf("%d %d %d", &n, &m, &k);
		for (int k_num = 0; k_num < k; k_num++)
		{
			int x, y, num, dir;
			scanf("%d %d %d %d", &x, &y, &num, &dir);
			virus vi;
			vi.x = x;
			vi.y = y;
			vi.num = num;
			vi.dir = dir;
			vc.push_back(vi);
		}
		
		for (int i = 0; i < m; i++)
		{
			for (int j = 0; j < vc.size(); j++)
			{
				move(j);
			}
			same_locate();
		}
		int sum = 0;
		for (int i = 0; i < vc.size(); i++)
		{
			sum += vc.at(i).num;
		}
		printf("#%d %d\n", test,sum);
		vc.clear();
	}
}
