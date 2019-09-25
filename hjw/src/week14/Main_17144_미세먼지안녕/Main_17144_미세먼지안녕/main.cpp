//Ȯ��Ǵ� �� = ������/5
//���� �̼����� �� = ó�� - (ó��/5)xȮ��� ������ ����

#include <iostream>

using namespace std;

int map[51][51];
int sample[51][51];//Ȯ�길 ǥ�� ��
int r, c;
int t;
int result;
int up, down;
int dx[4] = { 0,1,0,-1 };
int dy[4] = { 1,0,-1,0 };
void sample_init()
{
	for (int i = 0; i < r; i++)
		for (int j = 0; j < c; j++)
			sample[i][j] = 0;
}
void spread()
{
	for (int i = 0; i <= up; i++)
	{
		for (int j = 0; j < c; j++)
		{
			if (map[i][j] != -1 && map[i][j] != 0)//û���Ⱑ �ƴϰ� ��������
			{
				int cnt = 0;//Ȯ���� ��
				int origin = map[i][j];
				int spread_data = origin / 5;//Ȯ�� ����
				for (int k = 0; k < 4; k++)//���⼺ �ľ�
				{
					int newx = i + dx[k];
					int newy = j + dy[k];
					if ((-1 < newx && newx < r) && (-1 < newy && newy < c) && (map[newx][newy] != -1))
					{//���� �� ���̸� û���� ���� �ƴ�
						cnt++;//Ȯ�� ��
						sample[newx][newy] += spread_data;
					}
				}
				origin = origin - spread_data*cnt;
				map[i][j] = origin;
			}
		}
	}
	for (int i = down; i < r; i++)
	{
		for (int j = 0; j < c; j++)
		{
			if (map[i][j] != -1 && map[i][j] != 0)
			{
				int cnt = 0;
				int origin = map[i][j];
				int spread_data = origin / 5;
				for (int k = 0; k < 4; k++)
				{
					int newx = i + dx[k];
					int newy = j + dy[k];
					if ((-1 < newx && newx < r) && (-1 < newy && newy < c) && (map[newx][newy] != -1))
					{
						cnt++;
						sample[newx][newy] += spread_data;
					}
				}
				origin = origin - spread_data*cnt;
				map[i][j] = origin;
			}
		}
	}

	for (int i = 0; i < r; i++)
	{
		for (int j = 0; j < c; j++)
		{
			map[i][j] += sample[i][j];
		}
	}
}
void down_run()
{
	for (int i = down + 1; i < r; i++)
	{
		map[i][0] = map[i + 1][0];
	}
	for (int i = 0; i < c - 1; i++)
	{
		map[r - 1][i] = map[r - 1][i + 1];
	}
	for (int i = r - 1; i > down; i--)
	{
		map[i][c - 1] = map[i - 1][c - 1];
	}
	for (int i = c - 1; i > 1; i--)
	{
		map[down][i] = map[down][i - 1];
	}
	map[down][1] = 0;
}
void up_run()
{
	for (int i = up - 1; i > 0; i--)
	{
		map[i][0] = map[i - 1][0];
	}
	for (int i = 0; i < c - 1; i++)
	{
		map[0][i] = map[0][i + 1];
	}
	for (int i = 0; i < up; i++)
	{
		map[i][c - 1] = map[i + 1][c - 1];
	}
	for (int i = c - 1; i > 1; i--)
	{
		map[up][i] = map[up][i - 1];
	}
	map[up][1] = 0;
}
int main()
{
	int flag = 0;
	cin >> r >> c >> t;
	for (int i = 0; i < r; i++)
	{
		for (int j = 0; j < c; j++)
		{
			cin >> map[i][j];
			if (flag == 0 && map[i][j] == -1)
			{
				flag = 1;
				up = i;
			}
		}
	}
	down = up + 1;
	//cout << up << ", " << down << endl;
	result = 0;
	for (int i = 0; i < t; i++)
	{
		spread();
		sample_init();
		up_run();
		down_run();
		
	}
	
	for (int i = 0; i < r; i++)
	{
		for (int j = 0; j < c; j++)
		{
			if (map[i][j] != -1 && map[i][j] != 0)
				result += map[i][j];
		}
	}

	cout << result;
}