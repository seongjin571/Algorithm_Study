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