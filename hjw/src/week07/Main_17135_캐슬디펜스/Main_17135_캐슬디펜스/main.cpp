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
int visit[16][16];
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
vector<int>res;
vector <position> vc;//������ ���� ����
vector<content>die;//�����ֵ� ���(��ǥ)
void cal(int gx, int gy)
{
	int flag = 0;
	content c;
	c.xpos = gx;
	c.ypos = gy;
	c.len = 0;//�ü��� ���� ��ǥ
	queue<content> que;
	que.push(c);

	while (1)
	{
		int xx = que.front().xpos;
		int yy = que.front().ypos;
		int ll = que.front().len;
		que.pop();
		for (int i = 0; i < 3; i++)
		{
			int newx = xx + dx[i];
			int newy = yy + dy[i];
			int newlen = ll + 1;
			if (newlen > al)//�����Ÿ� ���� ������ ���� ã�� ���Ѱ��̹Ƿ� �ݺ��� Ż��
			{
				flag = 1;
				break;
			}

			if ((-1 < newx) && (-1 < newy) && (newx != gx))//���ǿ� �´� map���� ���� �ִ°� newx != gx�� ���� �������� ��� �Ⱥ���
			{
				content temp;
				temp.xpos = newx;
				temp.ypos = newy;
				temp.len = newlen;
				que.push(temp);
				if (sample[newx][newy] == 1)//������ ã�Ұ�
				{
					flag = 1;//����ִ� ������ �׿��� ���� ������ �� �׿��� Ż��
					if (visit[newx][newy] == 0)//���� ���� ���� �����϶�
					{
						content enemy;
						enemy.xpos = newx;
						enemy.ypos = newy;
						die.push_back(enemy);
						visit[newx][newy] = 1;
						result++;
						break;
					}
				}
			}
		}
		if (flag == 1)
			break;
	}

}
void init()
{
	for (int i = 0; i < h; i++)
	{
		for (int j = 0; j < y; j++)
		{
			sample[i][j] = map[i][j];
			visit[i][j] = 0;
		}
	}
}
void change_sample()
{
	for (auto i : die)
	{
		sample[i.xpos][i.ypos] = 0;//���� ������ ��ġ�� 0���� �ٲ���
	}
	die.clear();
}
void dfs(int cnt, int n, int r, int h)
{
	position p;

	if (vc.size() == r)
	{
		init();
		result = 0;
		for (int a = 0; a < h; a++)
		{
			cal(vc[0].xpos - a, vc[0].ypos);//�ü� 1 �� ��ġ ����
			cal(vc[1].xpos - a, vc[1].ypos);//�ü� 2 �� ��ġ
			cal(vc[2].xpos - a, vc[2].ypos);
			change_sample();//�� ���� �������Ƿ� ���� ������ 0���� �ٲٰ� �� ����
		}
		res.push_back(result);//������� ���Ϳ� �ִ´�
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
	
	sort(res.begin(), res.end());//�ִ밪�� ã������ ��Ʈ
	printf("%d", res.back());
}