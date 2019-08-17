#include <cstdio>
#include <queue>
#include <vector>
#include <algorithm>
using namespace std;
struct a {
	int x;
	int y;
	int ggul;
};
int q,w;
int resulta;
int resultb;
int maxa, maxb;
int res;
int map[10][10];
int check[10][10];
int n, m, c;
vector<a> pa;
vector<a>res_va;
vector<a> va;
vector<a>vva;
void dfs(int idx, int q)//idx∫Œ≈Õ cnt∏∏≈≠ªÃ±‚
{
	if (va.size() == q)
	{
		for (auto i : va)
		{
			a t;
			t.ggul = i.ggul;
			t.x = i.x;
			t.y = i.y;
			resulta += i.ggul;
			vva.push_back(t);
		}
		//printf("%d\n",resulta);
		if (resulta <= c)
		{
			int tempa = 0;
			for (auto j : vva)
			{
				tempa += j.ggul * j.ggul;
			}
			if (tempa > maxa)
			{
				maxa = tempa;
				if (res_va.empty())
				{
					for (auto j : vva)
					{
						a t;
						t.ggul = j.ggul;
						t.x = j.x;
						t.y = j.y;
						res_va.push_back(t);
					}
				}
				else
				{
					res_va.clear();
					for (auto j : vva)
					{
						a t;
						t.ggul = j.ggul;
						t.x = j.x;
						t.y = j.y;
						res_va.push_back(t);
					}
				}
			}
		}
		vva.clear();
		resulta = 0;
	}
	
	for (int i = idx; i < m; i++)
	{
		if (va.size() < q)
		{
			a t;
			t.x = pa.at(i).x;
			t.y = pa.at(i).y;
			t.ggul = pa.at(i).ggul;
			va.push_back(t);
			dfs(i + 1,q);
			va.pop_back();
		}
	}
}
void personA(int x, int y)
{
	for (int i = 0; i < m; i++)
	{
		check[x][y + i] = 1;
		a b;
		b.x = x;
		b.y = y + i;
		b.ggul = map[x][y + i];
		pa.push_back(b);
		//printf("%d\n", map[x][y + i]);
	}
	
	for (q = 1; q <= m; q++)
	{
		resulta = 0;
		dfs(0,q);
	}
		
	for (auto i : pa)
	{
		check[i.x][i.y] = 0;
	}

	pa.clear();
	
}

int main()
{
	int test;
	scanf("%d", &test);

	for (int t = 1; t <= test; t++)
	{
		scanf("%d %d %d", &n, &m, &c);

		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				scanf("%d", &map[i][j]);
			}
		}//π˙≤‹ ¿‘∑¬ 
		res = 0;
		maxa = 0;
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				if ((j + m - 1 < n))
				{
					//printf("%d %d", i, j);
					personA(i, j);
				}
			}
		}

		for (auto k : res_va)
		{
			map[k.x][k.y] = 0;
		}
		res_va.clear();
		res += maxa;
		maxa = 0;

		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				printf("%d ", map[i][j]);
			}
			printf("\n");
		}

		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				if ((j + m - 1 < n))
				{
					//printf("%d %d", i, j);
					personA(i, j);
				}
			}
		}
		res += maxa;
		printf("#%d %d\n", t, res);
	}
}