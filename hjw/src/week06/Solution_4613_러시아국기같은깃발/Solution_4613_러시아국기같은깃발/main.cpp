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
		
		for (int y = 0; y < m; y++)//첫줄은 무조건 white
		{
			if (map[0][y] != 'W')
				result++;
		}
		for (int y = 0; y < m; y++)//마지막줄은 무조건 red
		{
			if (map[n-1][y] != 'R')
				result++;
		}

		int index_of_b = 0;
		int how_many_b = 0;
		int compare_b = 0;
		for (int k = 1; k < n - 1; k++)//둘째줄부터 마지막 전줄까지 가장 블루가 많은 행 찾기
		{
			for (int j = 0; j < m; j++)
			{
				if (map[k][j] == 'B')
				{
					how_many_b++;
				}
			}//하나의 행 계산 끝
			if (compare_b < how_many_b)
			{
				index_of_b = k;//blue가 가장 많은 행
				compare_b = how_many_b;
			}

			how_many_b = 0;//b개수 초기화
		}

		for (int y = 0; y < m; y++)//b가 가장 많은 줄 찾았으니 거기서 b로 바꾸기
		{
			if (map[index_of_b][y] != 'B')
				result++;
		}

		int w_number = 0;
		int b_number = 0;
		for (int j = 1; j < index_of_b; j++)//둘째줄부터 b칠해진 라인 전까지 돌면서 w로 할지 b 로할지 계산
		{
			for (int k = 0; k < m; k++)
			{
				if (map[j][k] == 'W')
					w_number++;
				else if (map[j][k] == 'B')
					b_number++;
			}
			if (w_number >= b_number)//w의 개수가 b의 개수보다 많거나 같으면 그냥 w로 다 바꾼다.
			{
				result += m - w_number;
			}
			else//b의 개수가 많으면 그냥 b 로바꾼다.
			{
				result += m - b_number;
			}
			w_number = 0;
			b_number = 0;
		}

		int r_number = 0;
		b_number = 0;
		for (int j = index_of_b +1; j < n-1; j++)//b라인 다음줄 부터 마지막 전줄까지 
		{
			for (int k = 0; k < m; k++)
			{
				if (map[j][k] == 'R')
					r_number++;
				else if (map[j][k] == 'B')
					b_number++;
			}
			if (r_number >= b_number)//w의 개수가 b의 개수보다 많거나 같으면 그냥 w로 다 바꾼다.
			{
				result += m - r_number;
			}
			else//b의 개수가 많으면 그냥 b 로바꾼다.
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
//중복조합으로  풀어야 하는 문제
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
vector <int> vc;//조합을 담는 벡터
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
void dfs(int cnt, int n, int r)//0-n 까지의 숫자를 갖고 r개 배치
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
		
		dfs(0, 2, hang - 2);//0부터2까지 (0,1,2)를 갖고 hang-2개 만큼 뽑기
		sort(result.begin(), result.end());
		
		printf("#%d %d\n", a, result.front() + count1 + count2);
		vc.clear();
		result.clear();

	}
}
