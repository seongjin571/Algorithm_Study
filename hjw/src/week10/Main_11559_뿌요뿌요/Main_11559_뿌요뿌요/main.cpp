/*�ѿ�ѿ��� ���� ������ ����.

�ʵ忡 ���� ���� ������ �ѿ並 ���´�. �ѿ�� �߷��� ������ �޾� �Ʒ��� �ٴ��̳� �ٸ� �ѿ䰡 ���� ������ �Ʒ��� ��������.

�ѿ並 ���� �� ��, ���� �� �ѿ䰡 4�� �̻� �����¿�� ����Ǿ� ������ ����� ���� �� �ѿ���� �Ѳ����� ��������.

�ѿ���� �������� ���� ���� �ٸ� �ѿ���� �ִٸ�, ���� �߷��� ������ �޾� ���ʴ�� �Ʒ��� �������� �ȴ�.

�Ʒ��� �������� ���� �ٽ� ���� ���� �ѿ���� 4�� �̻� ���̰� �Ǹ� �� ������ �Ǵµ�, ���� �� �ѿ���� �������� �ٽ� ������ �ݺ��� ������ 1���⾿ �þ��.

���� �� �ִ� �ѿ䰡 ���� �׷��� �ִٸ� ���ÿ� ������ �ϰ� ���� �׷��� �������� �ѹ��� ���Ⱑ �߰��ȴ�.

���Դ� �ֱ� �ѿ�ѿ� ���ӿ� ǫ ������. �� ������ 1:1�� �ٴ� ���������̶� �� �״� �͵� �߿�������, ������ �Ͷ߸��ٸ� ���Ⱑ �� ���� ���� �ٷ� �ľ��� �� �ִ� �ɷµ� �ʿ��ϴ�. ������ ���� �Ƿ��� �����Ͽ� ���Դ� �ڱ� �ʵ忡�� �Ű� ���� �ٻڴ�. ������ �ʵ尡 �־����� ��, ���Ⱑ �� �� �������� �Ͼ�� ����Ͽ� ���Ը� ��������!

�Է�
12*6�� ���ڰ� �־�����.

�̶� .�� ������̰� .�� �ƴѰ��� ������ ������ �ѿ並 ��Ÿ����.

R�� ����, G�� �ʷ�, B�� �Ķ�, P�� ����, Y�� ����̴�.(��� �빮�ڷ� �־�����.)

�Է����� �־����� �ʵ�� �ѿ���� ���� �Ʒ��� ������ ���� ����(�� �ѿ� �Ʒ��� �� ĭ�� �ִ� ���� ����) �̴�.

���
���� �־��� ��Ȳ���� ��Ⱑ �Ǵ��� ����϶�. (�ϳ��� ������ �ʴ´ٸ� 0�� ����ϸ� �ȴ�.)*/


#include <cstdio>
#include <iostream>
#include <queue>
#include <vector>
int dx[4] = { 0,-1,0,1 };
int dy[4] = { 1,0,-1,0 };
struct T
{
	int x;
	int y;
	char mark;
};
using namespace std;
char map[12][6];
int check[12][6];
int result;
int cnt;
queue<T>que;
queue<T>dataq;
vector<int>vc;
void move()
{
	//cout << "move function start" << endl;
	int key = 0;
	for (auto j : vc)
	{
		for (int i = 11; i >= 0; i--)
		{
			if (map[i][j] == '.')
			{
				for (int x = i-1; x >= 0; x--)
				{
					if (map[x][j] != '.')
					{
						char temp = map[x][j];
						map[i-key][j] = temp;
						map[x][j] = '.';
						key++;
					}
				}
			}
		}
		key = 0;
	}
	
	vc.clear();
}
void bomb()
{
	while (!dataq.empty())
	{
		int x = dataq.front().x;
		int y = dataq.front().y;
		char ch = dataq.front().mark;
		map[x][y] = '.';
		check[x][y] = 0;
		dataq.pop();

		if (vc.size() == 0)
		{
			vc.push_back(y);
			//cout << "push : " << y << endl;
		}
		else
		{
			int flag = 1;
			for (auto i : vc)
			{
				if (i == y)
				{
					flag = 0;
					break;
				}
			}
			if (flag == 1)
			{
				vc.push_back(y);
				//cout << "push : " << y << endl;
			}
		}
	}
	
}
void bfs(int x, int y)
{
	T loc;
	loc.x = x;
	loc.y = y;
	loc.mark = map[x][y];
	que.push(loc);
	dataq.push(loc);
	check[x][y] = 1;

	cnt = 1;

	while (!que.empty())
	{
		int xx = que.front().x;
		int yy = que.front().y;
		char mm = que.front().mark;
		que.pop();

		for (int i = 0; i < 4; i++)
		{
			int newx = xx + dx[i];
			int newy = yy + dy[i];
			char newt = map[newx][newy];
			if ((-1 < newx && newx < 12) && (-1 < newy && newy < 6) && (newt == mm) && (check[newx][newy] == 0))
			{
				T newloc;
				newloc.x = newx;
				newloc.y = newy;
				newloc.mark = newt;
				check[newx][newy] = 1;
				que.push(newloc);
				dataq.push(newloc);
				cnt++;
			}
		}
	}
	if (cnt >= 4)
	{
		bomb();
	}
	else
	{
		while (!dataq.empty())
		{
			int x = dataq.front().x;
			int y = dataq.front().y;
			check[x][y] = 0;
			dataq.pop();
		}
	}
	
}
int main()
{
	for (int i = 0; i < 12; i++)
	{
		for (int j = 0; j < 6; j++)
		{
			cin >> map[i][j];
		}
	}
	result = 0;
	

	while (1)
	{
		for (int i = 11; i >= 0; i--)
		{
			for (int j = 0; j < 6; j++)
			{
				if (map[i][j] != '.')
				{
					bfs(i, j);
				}
			}
		}
		if (vc.size() != 0)
		{
			move();
			result++;
		}
		else
			break;
	}
	

	printf("%d", result);
}