#include <iostream>
#include <vector>
using namespace std;
int map[50][9];
int newmap[50][9];
int ining, now;
int score, out_cnt;
int base[4];//��
int check[9];
vector<int>vc;
int max_result;
void init()
{
	for (int i = 0; i < 4; i++)
		base[i] = 0;
}
void func(int start,int now_ining)
{
	if (now_ining == ining )
		return;
	
	while (out_cnt < 3)
	{
		if (newmap[now_ining][start] == 0)
		{
			out_cnt++;//�ƿ�ī��Ʈ ����
		}
		else if (newmap[now_ining][start] == 1)//1��Ÿ
		{
			for (int i = 3; i >= 0; i--)
			{
				if (base[i] == 1 && i == 3)//3�翡 ����������
				{
					score++;
					base[i] = 0;
				}
				else
				{
					if (base[i] == 1)//3�縦 ������ ���� ����������
					{
						base[i] = 0;
						base[i + 1] = 1;
					}
				}

			}
			base[1] = 1;//ģ ���� 1���
		}
		else if (newmap[now_ining][start] == 2)//2��Ÿ
		{
			for (int i = 3; i >= 0; i--)
			{
				if (base[i] == 1 && i == 3)//3�翡 ���������
				{
					score++;
					base[i] = 0;
				}
				else if (base[i] == 1 && i == 2)//2�翡 ����������
				{
					score++;
					base[i] = 0;
				}
				else
				{
					if (base[i] == 1)//3,2�� ������ ���� ����
					{
						base[i] = 0;
						base[i + 2] = 1;
					}
				}

			}
			base[2] = 1;//ģ ���� 2���
		}
		else if (newmap[now_ining][start] == 3)//3��Ÿ
		{
			for (int i = 3; i >= 0; i--)
			{
				if (base[i] == 1 && i == 3)
				{
					score++;
					base[i] = 0;
				}
				else if (base[i] == 1 && i == 2)
				{
					score++;
					base[i] = 0;
				}
				else if (base[i] == 1 && i == 1)
				{
					score++;
					base[i] = 0;
				}
				
			}
			base[3] = 1;
		}
		else if (newmap[now_ining][start] == 4)
		{
			score++;//����
			for (int i = 3; i >= 0; i--)
			{
				if (base[i] == 1)
				{
					score++;
					base[i] = 0;
				}
			}
		}
		start = (start + 1) % 9;
	}

	if (out_cnt == 3)//�����̴�
	{
		init();
		out_cnt = 0;
		func(start, now_ining + 1);
	}
}
void make_newmap()
{
	for (int i = 0; i < ining; i++)
	{
		for (int j = 0; j < 9; j++)
		{
			if (j == 3)
			{
				newmap[i][j] = map[i][0];
			}
			else if (j < 3)
			{
				newmap[i][j] = map[i][vc.at(j)];
			}
			else if (j > 3)
			{
				newmap[i][j] = map[i][vc.at(j - 1)];
			}
		}
	}
}
void dfs()
{
	if (vc.size() == 8)
	{
		make_newmap();
		func(0,0);
		
		if (max_result < score)
		{
			max_result = score;
			///score = 0;
		}
		score = 0;
		
		/*
		for (int i = 0; i < ining; i++)
		{
			for (int j = 0; j < 9; j++)
			{
				cout << newmap[i][j] << " ";
			}
			cout << endl;
		}
		*/
		return;
	}
	else
	{
		for (int i = 1; i < 9; i++)
		{
			if (check[i] == 0)
			{
				vc.push_back(i);
				check[i] = 1;
				dfs();
				check[i] = 0;
				vc.pop_back();
			}
		}
	}
}
int main()
{
	cin >> ining;

	for (int t = 0; t < ining; t++)
	{
		for (int i = 0; i < 9; i++)
		{
			cin >> map[t][i];
		}
	}
	score = 0;
	out_cnt = 0;
	max_result = -1;
	dfs();
	printf("%d", max_result);
}