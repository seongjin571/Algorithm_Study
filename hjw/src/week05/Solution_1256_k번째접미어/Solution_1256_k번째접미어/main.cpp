/*���� �ҹ��ڷ� �� ���ڿ��� �ִ�. ���ڿ��� ���̰� n�� �� ���̾���� ���ڿ��� ���̸�ŭ �����Ѵ�.

��monster����� ���ڿ����� �Ʒ� �׷��� ���ʰ� ���� ���̾���� �ְ� ���������� �������� ��쿡 �Ʒ� �׸��� ���� ���ĵȴ�.
 



��monster�� ���ڿ��� ���̾�� �߿��� ������ ������ 4��°�� ���� ���̾�� ��onster �̴�.

K���� ���ڿ��� �־����� ���̾�� �� ������ ������ K��°�� �ش��ϴ� ���̾ ã�Ƽ� ����Ͻÿ�.

[�Է�]

���� ù ���� ��ü �׽�Ʈ ���̽��� ���̴�.

10���� �׽�Ʈ ���̽��� ǥ�� �Է��� ���Ͽ� �־�����.

�� �׽�Ʈ ���̽��� ���� K �ϳ��� ������ �� ������ ���� �ҹ��ڷ� �� ���ڿ��� ���� �ٷ� �̷������.

���ڿ��� ���̴� �ִ� 400 �̴�.

[���]

�� �׽�Ʈ ���̽�����, ù �ٿ��� ��#C���� ����ؾ� �ϴµ� C�� ���̽� ��ȣ�̴�.

���� �ٿ� �� ĭ�� �ϳ� ���̿� �ΰ� �̾ ���� ������ K��° ������ �κ� ���ڿ��� ����Ѵ�.

���� K��° ���ڿ��� �������� �ʴ´ٸ�, ��none���� ����Ѵ�.*/
#include <iostream>
#include <vector>
#include <string.h>
#include <algorithm>
#include<string>
using namespace std;
/*
int main()
{
	int testcase;
	cin >> testcase;
	for (int i = 0; i < testcase; i++)
	{
		int k;//k��° ����
		cin >> k;
		char arr[400];//���ڿ�
		cin >> arr;
		vector<char> vec[400];//�迭�� �ɰ��� ���� ����
		
		for (int j = 0; j < strlen(arr); j++)
		{
			for (int t = j; t < strlen(arr); t++)
			{
				vec[j].push_back(arr[t]);
			}
		}
		
		char *comparearr;
		comparearr = new char[strlen(arr)];

		for (int j = 0; j < strlen(arr); j++)
		{
			comparearr[j] = vec[j].at(0);
		}
		sort(comparearr, comparearr + strlen(arr));
		cout << "#" << i + 1 << " ";
		if (k > strlen(arr))
		{
			cout << "none";
		}
		else
		{
			for (int a = 0; a < strlen(arr); a++)
			{
				if (comparearr[k - 1] == vec[a].at(0))
				{
					for (int b = 0; b < vec[a].size(); b++)
						cout << vec[a].at(b);
					break;
				}
			}
		}
		cout << endl;
	}
}
*/
int main()
{
	int testcase;
	cin >> testcase;

	for (int i = 0; i < testcase; i++)
	{
		int k;
		cin >> k;
		string str;
		cin >> str;
		int n = str.length();

		string *arr;
		arr = new string[n];

		for (int j = 0; j < n; j++)
		{
			arr[j] = str.substr(j, n - j);
		}
		sort(arr, arr + n);
		
		cout << "#" << i + 1 << " ";
		cout << arr[k - 1] << endl;
	}
}