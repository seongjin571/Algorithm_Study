/*ĳ�� ���潺�� ���� ���� �������� ���� ��� �� ����� �����̴�. ������ ����Ǵ� ���� ũ�Ⱑ N��M�� ���������� ��Ÿ�� �� �ִ�. �������� 1��1 ũ���� ĭ���� �������� �ְ�, �� ĭ�� ���Ե� ���� ���� �ִ� �ϳ��̴�. �������� N������ �ٷ� �Ʒ�(N+1�� ��)�� ��� ĭ���� ���� �ִ�.

���� �����Լ� ��Ű�� ���� �ü� 3���� ��ġ�Ϸ��� �Ѵ�. �ü��� ���� �ִ� ĭ�� ��ġ�� �� �ְ�, �ϳ��� ĭ���� �ִ� 1���� �ü��� ���� �� �ִ�. ������ �ϸ��� �ü��� �� �ϳ��� ������ �� �ְ�, ��� �ü��� ���ÿ� �����Ѵ�. �ü��� �����ϴ� ���� �Ÿ��� D������ �� �߿��� ���� ����� ���̰�, �׷��� ���� ������ ��쿡�� ���� ���ʿ� �ִ� ���� �����Ѵ�. ���� ���� ���� �ü����� ���ݴ��� �� �ִ�. ���ݹ��� ���� ���ӿ��� ���ܵȴ�. �ü��� ������ ������, ���� �̵��Ѵ�. ���� �Ʒ��� �� ĭ �̵��ϸ�, ���� �ִ� ĭ���� �̵��� ��쿡�� ���ӿ��� ���ܵȴ�. ��� ���� �����ǿ��� ���ܵǸ� ������ ������. 

���� ������ ���ٽ��� �ü��� ��ġ�� ������ ���� ������ �������ִ�. ����, �� ������ �ü��� ��ġ�� �߿��ϴ�. �������� ���°� �־����� ��, �ü��� �������� ������ �� �ִ� ���� �ִ� ���� ����غ���.

�������� �� ��ġ (r1, c1), (r2, c2)�� �Ÿ��� |r1-r2| + |c1-c2|�̴�.

�Է�
ù° �ٿ� ������ ���� �� N, ���� �� M, �ü��� ���� �Ÿ� ���� D�� �־�����. ��° �ٺ��� N���� �ٿ��� �������� ���°� �־�����. 0�� �� ĭ, 1�� ���� �ִ� ĭ�̴�.

���
ù° �ٿ� �ü��� �������� ������ �� �ִ� ���� �ִ� ���� ����Ѵ�.

����
3 �� N, M �� 15
1 �� D �� 10*/
#include <iostream>
#include <cstdio>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;
int dx[3] = { 0,-1,0 };
int dy[3] = { -1,0,1 };//���� �켱 ������ ���ʺ��� && ���� ������ ���� �����´�
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
vector <position> vc;//������ ���� ����
vector <int> res;//����� ����ϱ� ���� ����
queue<position> die;//�ü����� ���� ���� ��Ƴ��� ť
void init()
{
	for (int i = 0; i < h; i++)
	{
		for (int j = 0; j < y; j++)
			sample[i][j] = map[i][j];
	}
}
void cal(int xpos, int ypos)//������ ã�� �ش� ������ �����Ÿ� ���� �ִ��� Ȯ�� �� ���
{
	flag = 0;
	int count = 0;
	content c;//�ü���ġ
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
				printf("count : %d, ���� ���� ��ǥ : (%d, %d)\n", count, e.xpos, e.ypos);
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
			printf("�ü���ġ : (%d, %d)\n", i.xpos, i.ypos);
			cal(i.xpos, i.ypos);
		}
		cout << endl;
		//�ü� ��ġ case��
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
	scanf("%d %d %d", &h, &y, &al);//��, ��, �ü��� ��Ÿ�

	for (int i = 0; i < h; i++)
	{
		for (int j = 0; j < y; j++)
		{
			scanf("%d", &map[i][j]);
		}
	}
	//h�࿡ �ü��� ��ġ
	dfs(0, y-1, 3, h);
	sort(res.begin(), res.end());
	printf("%d", res.back());
}