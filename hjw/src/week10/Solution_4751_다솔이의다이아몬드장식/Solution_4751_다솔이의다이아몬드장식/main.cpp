/*�ټ��̴� � ���ڿ��� �ϳ� ������ �ִµ�, �� ���ڿ��� ���� �Ƹ����� ���ϴٰ� �����ϰ� �ִ�.

�׷��� ����� ���ֱ�� �ߴ�.

���� ��� ���ڿ��� ��D����� ������ ��#���� �̷���� ���̾Ƹ��� ���μ� ������ ���� 5x5ũ��� ����Ѵ�.

�� ���� ��.���� ǥ���Ѵ�.



���� ���ڿ��� ���̰� 1���� �� ũ��, ������ ���ڴ� ��#���� ��.���� �����Ͽ� ����Ѵ�.

���� ��� ���ڿ��� ��APPLE���̸� ������ ���� ����Ѵ�.


 
�־��� ���ڿ��� ������ִ� ���α׷��� �ۼ��϶�.


[�Է�]

ù ��° �ٿ� �׽�Ʈ ���̽��� �� T�� �־�����.

�� �׽�Ʈ ���̽��� ù ��° �ٿ��� ���̰� 1�̻� 50������ ���ڿ��� �־�����.

[���]

�� �׽�Ʈ ���̽����� �ټ� �ٿ� ���� ��ĵ� ���ڿ��� ����Ѵ�.
*/
#include <iostream>
#include <stdio.h>
#include <string>
#include <string.h>
using namespace std;

char map[5][1000];

int main()
{
	int test;
	scanf("%d", &test);
	
	for (int t = 1; t <= test; t++)
	{
		string str;
		cin >> str;
		int str_size = str.length();
		int line3 = 5 + (str_size - 1) * 4;
		int idx = 0;
		int flag = 0;

		for (int i = 0; i < line3; i++)
		{
			if (i == 0 || i % 4 == 0)
			{
				map[2][i] = '#';
				flag = 1;
			}
			else if (flag == 1)
			{
				map[2][i] = '.';
				flag = 2;
			}
			else if (flag == 2)
			{
				map[2][i] = str.at(idx);
				idx++;
				flag = 1;
			}
		}
		
		map[1][0] = '.';
		map[3][0] = '.';
		map[0][0] = '.';
		map[0][1] = '.';
		map[4][0] = '.';
		map[4][1] = '.';
		map[0][line3-1] = '.';
		map[0][line3-2] = '.';
		map[4][line3-1] = '.';
		map[4][line3-2] = '.';
		for (int i = 1; i < line3; i++)
		{
			if (map[1][i - 1] == '.')
			{
				map[1][i] = '#';
				map[3][i] = '#';
			}
			else
			{
				map[1][i] = '.';
				map[3][i] = '.';
			}
		}
		int cnt = 0;
		for (int i = 2; i < line3 - 2; i++)
		{
			if (i == 2)
			{
				map[0][i] = '#';
				map[4][i] = '#';
			}
			else if (cnt == 3)
			{
				map[0][i] = '#';
				map[4][i] = '#';
				cnt = 0;
			}
			else
			{
				map[0][i] = '.';
				map[4][i] = '.';
				cnt++;
			}
		}

		for (int i = 0; i < 5; i++)
		{
			for (int j = 0; j < line3; j++)
			{
				printf("%c", map[i][j]);
			}
			printf("\n");
		}

	}
}