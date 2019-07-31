#include <cstdio>
#include <vector>
using namespace std;
int map[8][8];
int cnt;
void right(int x, int y, int len)
{
	int newx = x;
	vector<char>vc;
	int flag = 0;
	
	for (int i = 0; i < len; i++)
	{
		int newy = y + i;
		if ((newx < 8) && (newy < 8))
		{
			vc.push_back(map[newx][newy]);
		}
	}
	if (vc.size() == len)
	{
		if (len % 2 == 0)
		{
			for (int i = 0; i < len / 2; i++)
			{
				if (vc.at(i) != vc.at(len - 1 - i))
				{
					flag = 1;
					break;
				}
			}
			if (flag == 0)
				flag = 2;
		}
		else
		{
			for (int i = 0; i < (len - 1) / 2; i++)
			{
				if (vc.at(i) != vc.at(len - 1 - i))
				{
					flag = 1;
					break;
				}
			}
			if (flag == 0)
				flag = 2;
		}
	}
	else
		vc.clear();

	if (flag == 2)
		cnt++;
}
void down(int x, int y, int len)
{
	int newy = y;
	vector<char>vc;
	int flag = 0;
	for (int i = 0; i < len; i++)
	{
		int newx = x + i;
		if ((newx < 8) && (newy < 8))
		{
			vc.push_back(map[newx][newy]);
		}
	}
	if (vc.size() == len)
	{
		if (len % 2 == 0)
		{
			for (int i = 0; i < len / 2; i++)
			{
				if (vc.at(i) != vc.at(len - 1 - i))
				{
					flag = 1;
					break;
				}
			}
			if (flag == 0)
				flag = 2;
		}
		else
		{
			for (int i = 0; i < (len - 1) / 2; i++)
			{
				if (vc.at(i) != vc.at(len - 1 - i))
				{
					flag = 1;
					break;
				}
			}
			if (flag == 0)
				flag = 2;
		}
	}
	else
		vc.clear();

	if (flag == 2)
		cnt++;
}
int main()
{
	for (int t = 1; t <= 10; t++)
	{
		int len;
		scanf("%d", &len);
		cnt = 0;
		getchar();
		for (int i = 0; i < 8; i++)
		{
			for (int j = 0; j < 8; j++)
			{
				scanf("%c", &map[i][j]);
			}
			getchar();
		}

		for (int i = 0; i < 8; i++)
		{
			for (int j = 0; j < 8; j++)
			{
				right(i, j,len);
				down(i, j,len);
			}
		}

		printf("#%d %d\n", t, cnt);
	}
}