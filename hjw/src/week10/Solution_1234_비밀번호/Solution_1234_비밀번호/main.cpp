/*��ҿ� �ܸӸ��� �ߴ��ϰ� ������ ö���� ��й�ȣ�� ����ϴ� ���� �ʹ� �����ҽ��ϴ�.

��� ������ �ٴϰ� ������ ���� ����� �����Դϴ�. �Ѱ��� ������ �س��ϴ�.
 
0~9�� �̷���� ��ȣ ���ڿ����� ���� ��ȣ�� �پ��ִ� �ֵ��� �Ұ��ϰ� ���� ��ȣ�� ��й�ȣ�� ����� ���Դϴ�.

��ȣ ���� �Ұŵǰ� �Ұŵ� ��ȣ ���� �¿� ��ȣ�� ���� ��ȣ�̸� �� �Ұ� �� �� �ֽ��ϴ�.

���� ��� �Ʒ��� ��ȣ ���� ö���� ������� �Ұ��ϰ� �˾Ƴ� ��� ��ȣ�Դϴ�.
 


 
[�Է�]

10���� �׽�Ʈ ���̽��� 10�ٿ� ����, �� �ٿ� �׽�Ʈ ���̽� �ϳ��� �����ȴ�.

�� �׽�Ʈ ���̽��� �켱 ���ڿ��� �����ϴ� ������ �� ���� �־�����, ������ �� ���� ��ȣ ���ڿ��� ���� ���� �����ȴ�.

���ڿ��� 0~9�� �����Ǹ� ���ڿ��� ���� N�� 10��N��100�̴�. ��й�ȣ�� ���̴� ���ڿ��� ���̺��� �۴�.
 
[���]

#��ȣ�� �Բ� �׽�Ʈ ���̽��� ��ȣ�� ����ϰ�, ���� ���� �� �׽�Ʈ ���̽��� ���� ��(��й�ȣ)�� ����Ѵ�.*/

#include <vector>
#include <cstdio>
#include <stack>
#include <string>
#include <string.h>
#include <iostream>
using namespace std;

vector<int>vc;
void func(int n, string str)
{
	for (int i = 0; i < str.size(); i++)
	{
		int temp;
		temp = str.at(i) - '0';
		vc.push_back(temp);
	}
}
int main()
{
	for (int test = 1; test <= 10; test++)
	{
		int n;
		scanf("%d", &n);
		string str;
		cin >> str;

		func(n, str);

		
		while (1)
		{
			int flag = 0;
			for (int i = 1; i < vc.size(); i++)
			{
				if (vc.at(i - 1) == vc.at(i))
				{
					vector<int>::iterator it;
					it = vc.begin();
					vc.erase(it + i - 1, it + i+1);
					flag = 1;
					break;
				}
			}
			
			if (flag == 0)
				break;
		}

		printf("#%d ", test);
		for (int i = 0; i < vc.size(); i++)
			printf("%d", vc.at(i));
		printf("\n");
		vc.clear();
	}
}