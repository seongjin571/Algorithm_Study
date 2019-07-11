#include <iostream>
#include <stdio.h>
#include <string>
#include <string.h>
using namespace std;

int main()
{
	int total;
	scanf("%d", &total);
	int result;
	for (int i = 0; i < total; i++)
	{
		string str;
		cin >> str;
		
		result = 0;
		int pipe_num = 0;
		for (int j = 0; j < str.length(); j++)//막대의 시작과 끝을 찾는 로직 & 그 안에 몇개의 레이저가 있는지 찾기
		{
			if (str.at(j) == '(' && str.at(j+1) == ')')//레이저인 경우,,,전체개수 <- 파이프의 개수
			{	
				result += pipe_num;
			}
			else if (str.at(j) == '(' && str.at(j + 1) != ')')//파이프의 시작,,,파이프 개수 +1
			{
				pipe_num++;
			}
			else if(str.at(j) == ')' && str.at(j - 1) != '(')//파이프의 끝,,전체개수 +1, 파이프의 개수 -1
			{
				result++;
				pipe_num--;
			}
		}
		cout << "#" << i + 1 << " ";
		printf("%d\n", result);
	}
	return 0;
}