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