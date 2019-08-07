/*다솔이는 어떤 문자열을 하나 가지고 있는데, 이 문자열이 별로 아름답지 못하다고 생각하고 있다.

그래서 장식을 해주기로 했다.

예를 들어 문자열이 “D”라면 주위를 ‘#’로 이루어진 다이아몬드로 감싸서 다음과 같이 5x5크기로 장식한다.

빈 곳은 ‘.’로 표시한다.



만약 문자열의 길이가 1보다 더 크면, 인접한 문자는 ‘#’과 ‘.’을 공유하여 장식한다.

예를 들어 문자열이 “APPLE”이면 다음과 같이 장식한다.


 
주어진 문자열을 장식해주는 프로그램을 작성하라.


[입력]

첫 번째 줄에 테스트 케이스의 수 T가 주어진다.

각 테스트 케이스의 첫 번째 줄에는 길이가 1이상 50이하인 문자열이 주어진다.

[출력]

각 테스트 케이스마다 다섯 줄에 걸쳐 장식된 문자열을 출력한다.
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