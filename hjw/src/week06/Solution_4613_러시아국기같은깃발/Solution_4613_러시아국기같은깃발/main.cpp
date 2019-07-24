/*
#include <iostream>

using namespace std;

int main()
{
	int test_case;
	cin >> test_case;

	for (int i = 1; i <= test_case; i++)
	{
		int n, m;
		cin >> n >> m;
		int result = 0;

		char **map;
		map = new char*[n];
		for (int j = 0; j < n; j++)
			map[j] = new char[m];

		for (int j = 0; j < n; j++)
		{
			for (int k = 0; k < m; k++)
				cin >> map[j][k];
		}
		
		for (int y = 0; y < m; y++)//ù���� ������ white
		{
			if (map[0][y] != 'W')
				result++;
		}
		for (int y = 0; y < m; y++)//���������� ������ red
		{
			if (map[n-1][y] != 'R')
				result++;
		}

		int index_of_b = 0;
		int how_many_b = 0;
		int compare_b = 0;
		for (int k = 1; k < n - 1; k++)//��°�ٺ��� ������ ���ٱ��� ���� ��簡 ���� �� ã��
		{
			for (int j = 0; j < m; j++)
			{
				if (map[k][j] == 'B')
				{
					how_many_b++;
				}
			}//�ϳ��� �� ��� ��
			if (compare_b < how_many_b)
			{
				index_of_b = k;//blue�� ���� ���� ��
				compare_b = how_many_b;
			}

			how_many_b = 0;//b���� �ʱ�ȭ
		}

		for (int y = 0; y < m; y++)//b�� ���� ���� �� ã������ �ű⼭ b�� �ٲٱ�
		{
			if (map[index_of_b][y] != 'B')
				result++;
		}

		int w_number = 0;
		int b_number = 0;
		for (int j = 1; j < index_of_b; j++)//��°�ٺ��� bĥ���� ���� ������ ���鼭 w�� ���� b ������ ���
		{
			for (int k = 0; k < m; k++)
			{
				if (map[j][k] == 'W')
					w_number++;
				else if (map[j][k] == 'B')
					b_number++;
			}
			if (w_number >= b_number)//w�� ������ b�� �������� ���ų� ������ �׳� w�� �� �ٲ۴�.
			{
				result += m - w_number;
			}
			else//b�� ������ ������ �׳� b �ιٲ۴�.
			{
				result += m - b_number;
			}
			w_number = 0;
			b_number = 0;
		}

		int r_number = 0;
		b_number = 0;
		for (int j = index_of_b +1; j < n-1; j++)//b���� ������ ���� ������ ���ٱ��� 
		{
			for (int k = 0; k < m; k++)
			{
				if (map[j][k] == 'R')
					r_number++;
				else if (map[j][k] == 'B')
					b_number++;
			}
			if (r_number >= b_number)//w�� ������ b�� �������� ���ų� ������ �׳� w�� �� �ٲ۴�.
			{
				result += m - r_number;
			}
			else//b�� ������ ������ �׳� b �ιٲ۴�.
			{
				result += m - b_number;
			}
			r_number = 0;
			b_number = 0;
		}


		cout << "#" << i << " " << result << endl;
	}
}
*/
//�ߺ���������  Ǯ��� �ϴ� ����
#include <cstdio>
#include <algorithm>
#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int hang, yeol;
char map[51][51];
int intmap[51][51];
int arr[51];
int index;
vector <int> vc;//������ ��� ����
vector<int> result;
queue<int> que;
int cal()
{
	int res = 0;
	int h_index = 1;
	int cnt = 0;
	while (!que.empty())
	{
		int x = que.front();
		que.pop();
		for (int i = 0; i < yeol; i++)
		{
			if (intmap[h_index][i] != x)
				cnt++;
		}
		res = res + cnt;
		cnt = 0;
		h_index++;
	}

	return res;
}
void dfs(int cnt, int n, int r)//0-n ������ ���ڸ� ���� r�� ��ġ
{
	if (vc.size() == r)
	{
		int flag = 0;
		for (auto i : vc)
		{
			if (i == 1)
			{
				flag = 1;
				break;
			}
		}
		if (flag == 1)
		{
			for (auto i : vc)
			{
				que.push(i);
			}
			
			result.push_back(cal());
		}
		return;
	}

	for (int i = cnt; i <= n; i++)
	{
		if (vc.size() < r)
		{
			vc.push_back(i);
			dfs(i, n, r);
			vc.pop_back();
		}
	}
	
}

int main()
{
	int test_case;
	scanf("%d", &test_case);

	for (int a = 1; a <= test_case; a++)
	{
		scanf("%d %d", &hang, &yeol);
		//0->w 1->b 2->r
		int count1 = 0;
		int count2 = 0;
		getchar();
		for (int i = 0; i < hang; i++)
		{
			for (int j = 0; j < yeol; j++)
			{
				scanf("%c", &map[i][j]);
			}
			getchar();
		}
		
		for (int i = 0; i < hang; i++)
		{
			for (int j = 0; j < yeol; j++)
			{
				if (map[i][j] == 'W')
					intmap[i][j] = 0;
				else if (map[i][j] == 'B')
					intmap[i][j] = 1;
				else
					intmap[i][j] = 2;
			}
		}
		
		for (int i = 0; i < yeol; i++)
		{
			if (map[0][i] != 'W')
				count1++;

			if (map[hang - 1][i] != 'R')
				count2++;
		}
		
		dfs(0, 2, hang - 2);//0����2���� (0,1,2)�� ���� hang-2�� ��ŭ �̱�
		sort(result.begin(), result.end());
		
		printf("#%d %d\n", a, result.front() + count1 + count2);
		vc.clear();
		result.clear();

	}
}
