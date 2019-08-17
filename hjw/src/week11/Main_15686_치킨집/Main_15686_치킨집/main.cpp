#include <cstdio>
#include <queue>
#include <cmath>
#include <vector>
using namespace std;
struct info {
	int x;
	int y;
};
vector<info> v1;
vector<info> v2;
int map[1000][1000];
int n, m, cnt2;
int result;
int mini;
vector<info> vc;
int func1()
{
	int min = 100000;
	int temp;
	int nx = 0, ny = 0;
	int result = 0;
	for (auto i : v1)
	{
		for (auto j : v2)
		{
			nx = i.x - j.x;
			ny = i.y - j.y;
			temp = abs(nx) + abs(ny);
			if (min > temp)
				min = temp;
		}
		result += min;
		min = 100000;
	}

	return result;
}

int func2()//특정 조합을 뽑아 냈을 경우 그것의 치킨거리 값 계산
{
	int nx = 0, ny = 0;
	int temp = 0;
	int min = 100000;
	int result = 0;
	for (auto t : v1)
	{
		for (auto j : vc)
		{
			nx = t.x - j.x;
			ny = t.y - j.y;
			temp = abs(nx) + abs(ny);
			if (min > temp)
				min = temp;
		}
		result += min;
		min = 100000;
	}
	return result;
}
void dfs(int cnt)//조합을 위한 함수
{
	int result;
	info a;
	if (vc.size() == m)
	{
		result = func2();
		if (mini > result)
			mini = result;
		
		return;
	}
	else
	{
		for (int i = cnt; i < v2.size(); i++)
		{
			if (vc.size() < m)
			{
				a.x = v2.at(i).x;
				a.y = v2.at(i).y;
				vc.push_back(a);
				dfs(i + 1);
				vc.pop_back();
			}
		}
	}
}
int main()
{
	result = 0;
	cnt2 = 0;
	scanf("%d %d", &n, &m);
	info a;
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			scanf("%d", &map[i][j]);
			if (map[i][j] == 2)
			{
				cnt2++;
				a.x = i;
				a.y = j;
				v2.push_back(a);
			}
			else if (map[i][j] == 1) {
				a.x = i;
				a.y = j;
				v1.push_back(a);
			}
		}
	}

	mini = 100000;
	if (m >= cnt2)//치킨집을 버리지 않아도 되는 경우 즉, 그냥 최단거리만
	{
		result = func1();
	}
	else
	{
		dfs(0);
		result = mini;
	}
	printf("%d", result);
}