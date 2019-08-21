#include <cstdio>
#include <queue>
#include <vector>
#include <algorithm>
using namespace std;
struct info {
	int start_x;
	int start_y;
	int end_x;
	int end_y;
};
int n, m, k;
int original_map[51][51];
int map[51][51];
int visit[7];

vector<info> save;
vector<info>vc;
vector<int> vec;
void make_map()
{
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			map[i][j] = original_map[i][j];
		}
	}
}
void rotate(int inner_rec, int fx, int fy, int lx, int ly, int width, int height)
{
	int temp = map[fx + inner_rec][ly - inner_rec];
	for (int i = ly - inner_rec; i > fy + inner_rec; i--)
	{
		map[fx + inner_rec][i] = map[fx + inner_rec][i - 1];
	}

	for (int i = fx + inner_rec; i < lx - inner_rec; i++)
	{
		map[i][fy + inner_rec] = map[i + 1][fy + inner_rec];
	}

	for (int i = fy + inner_rec; i < ly - inner_rec; i++)
	{
		map[lx - inner_rec][i] = map[lx - inner_rec][i + 1];
	}

	for (int i = lx - inner_rec; i > fx + inner_rec; i--)
	{
		map[i][ly - inner_rec] = map[i - 1][ly - inner_rec];
	}
	map[fx + inner_rec + 1][ly - inner_rec] = temp;
}
void dfs()
{
	if (vc.size() == k)
	{
		make_map();
		for (auto i : vc)
		{
			int fx = i.start_x;
			int fy = i.start_y;
			int lx = i.end_x;
			int ly = i.end_y;
			int width = ly - fy + 1;
			int height = lx - fx + 1;

			int min;
			if (width > height)
				min = height;
			else
				min = width;
			min = min / 2;
			for (int j = 0; j < min; j++)
			{
				rotate(j, fx, fy, lx, ly, width, height);
			}
		}
		int sum = 0;
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < m; j++)
			{
				sum += map[i][j];
			}
			vec.push_back(sum);
			sum = 0;
		}
		return;
	}
	else
	{
		for (int i = 0; i < k; i++)
		{
			if (visit[i] != 1)
			{
				info a;
				visit[i] = 1;
				a.start_x = save.at(i).start_x;
				a.start_y = save.at(i).start_y;
				a.end_x = save.at(i).end_x;
				a.end_y = save.at(i).end_y;
				vc.push_back(a);
				dfs();
				vc.pop_back();
				visit[i] = 0;
			}
		}
	}
}
int main()
{
	scanf("%d %d %d", &n, &m, &k);

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			scanf("%d", &original_map[i][j]);
		}
	}

	int r, c, s;
	for (int i = 0; i < k; i++)
	{
		scanf("%d %d %d", &r, &c, &s);
		int sx = r - s - 1;
		int sy = c - s - 1;
		int ex = r + s - 1;
		int ey = c + s - 1;
		info t;
		t.start_x = sx;
		t.start_y = sy;
		t.end_x = ex;
		t.end_y = ey;
		save.push_back(t);
	}

	dfs();
	sort(vec.begin(), vec.end());
	printf("%d", vec.front());
}