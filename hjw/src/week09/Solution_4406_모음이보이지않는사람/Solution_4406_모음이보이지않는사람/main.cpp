/*
������ ������ ���� ����� �� �� �ڽ��� �ν� �ӿ��� �����̶�� ���� ����� ���� �˰� �Ǿ���.

���ĺ� �ҹ��� ������ �̷���� �ܾ ����� � ������ ���� �ɱ�?

���ĺ����� ������ ��a��, ��e��, ��i��, ��o��, ��u���� �ټ������� ���� ��� ��congratulation���̶�� �ܾ ����� ���� �Ǹ� ��cngrtltn������ �ν��ϰ� �� ���̴�.


[�Է�]

ù ��° �ٿ� �׽�Ʈ ���̽��� �� T�� �־�����.

�� �׽�Ʈ ���̽��� ù ��° �ٿ��� ���̰� 50�����̰� ���ĺ� �ҹ��ڸ����� �̷���� �ܾ �־�����. �� �ܾ ������ �ƴ� ����(����)�� ��� �ϳ��� ����ִٴ� ���� ����ȴ�.

[���]

�׽�Ʈ ���̽� T�� ���� ����� ��#T ���� ���,  �� �׽�Ʈ ���̽����� �־��� �ܾ ����� ��� �ν��ϴ����� ����Ѵ�.*/
#include <cstdio>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

vector<char>vc;

int main()
{
	int test;
	cin >> test;

	for (int t = 1; t <= test; t++)
	{
		string str;
		cin >> str;
		for (int i = 0; i < str.size(); i++)
		{
			if (str.at(i) != 'a' && str.at(i) != 'e' && str.at(i) != 'i' && str.at(i) != 'o' && str.at(i) != 'u')
			{
				vc.push_back(str.at(i));
			}
		}

		printf("#%d ", t);
		for (auto i : vc)
			printf("%c", i);
		cout << endl;
		vc.clear();
	}
}