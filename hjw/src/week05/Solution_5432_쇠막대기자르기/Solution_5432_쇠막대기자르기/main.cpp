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
		for (int j = 0; j < str.length(); j++)//������ ���۰� ���� ã�� ���� & �� �ȿ� ��� �������� �ִ��� ã��
		{
			if (str.at(j) == '(' && str.at(j+1) == ')')//�������� ���,,,��ü���� <- �������� ����
			{	
				result += pipe_num;
			}
			else if (str.at(j) == '(' && str.at(j + 1) != ')')//�������� ����,,,������ ���� +1
			{
				pipe_num++;
			}
			else if(str.at(j) == ')' && str.at(j - 1) != '(')//�������� ��,,��ü���� +1, �������� ���� -1
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