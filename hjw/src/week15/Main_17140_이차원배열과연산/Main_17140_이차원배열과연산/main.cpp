#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int arr[101];
int map[101][101];
int r, c, k;
int r_num, c_num;
struct info {
	int num;
	int num_cnt;
};
vector<info> vc;
bool cmp(const info &p1, const info &p2)
{
	if (p1.num_cnt < p2.num_cnt)
		return true;
	else if (p1.num_cnt == p2.num_cnt)
	{
		return p1.num < p2.num;
	}
	else
		return false;
}
void init(int max)
{
	for (int i = 0; i <= max; i++)
		arr[i] = 0;
}
void change_r()//행의 개수 >= 열의 개수
{
	int max_vc = 0;
	for (int x = 0; x < r_num; x++)
	{
		vc.clear();
		int max = 0;
		for (int y = 0; y < c_num;y++)
		{
			if (max < map[x][y])
				max = map[x][y];
			if (map[x][y] != 0)
			{
				arr[map[x][y]]++;
			}
			map[x][y] = 0;
		}

		for (int i = 0; i <= max; i++)
		{
			if (arr[i] != 0)
			{
				vc.push_back({ i,arr[i] });
			}
		}
		if (max_vc < vc.size())
			max_vc = vc.size();
		sort(vc.begin(), vc.end(), cmp);
		int idx = 0;
		for (auto v : vc)
		{
			map[x][idx] = v.num;
			map[x][idx + 1] = v.num_cnt;
			idx = idx + 2;
		}
		init(max);
	}
	c_num = max_vc*2;
}
void change_c()//열의개수 > 행의 개수
{
	int max_vc = 0;
	for (int y = 0; y < c_num; y++)
	{
		vc.clear();
		int max = 0;
		for (int x = 0; x < r_num; x++)
		{
			if (max < map[x][y])
				max = map[x][y];
			if (map[x][y] != 0)
			{
				arr[map[x][y]]++;
			}
			map[x][y] = 0;
		}

		for (int i = 0; i <= max; i++)
		{
			if (arr[i] != 0)
			{
				vc.push_back({ i,arr[i] });
			}
		}
		if (max_vc < vc.size())
			max_vc = vc.size();
		sort(vc.begin(), vc.end(), cmp);
		int idx = 0;
		for (auto v : vc)
		{
			map[idx][y] = v.num;
			map[idx+1][y] = v.num_cnt;
			idx = idx + 2;
		}
		init(max);
	}
	r_num = max_vc*2;
}
int main()
{
	int cnt = 0;
	r_num = 3;
	c_num = 3;
	cin >> r >> c >> k;
	r = r - 1;
	c = c - 1;
	for (int i = 0; i < 3; i++)
	{
		for (int j = 0; j < 3; j++)
		{
			cin >> map[i][j];
		}
	}
	while (1)
	{
		if (cnt > 100)
		{
			cnt = -1;
			break;
		}

		if (map[r][c] == k)
		{
			break;
		}
		cnt++;
		if (r_num >= c_num)
		{
			change_r();
			
			if (c_num >= 100)
				c_num = 99;
		}
		else
		{
			change_c();
			
			if (r_num >= 100)
				r_num = 99;
		}
	}
	cout << cnt;
}