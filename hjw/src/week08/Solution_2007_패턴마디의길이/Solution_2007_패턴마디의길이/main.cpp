/*
���Ͽ��� �ݺ��Ǵ� �κ��� ������ �θ���. ���ڿ��� �Է� �޾� ������ ���̸� ����ϴ� ���α׷��� �ۼ��϶�.


[���� ����]

�� ���ڿ��� ���̴� 30�̴�. ������ �ִ� ���̴� 10�̴�.


[�Է�]

���� ù �ٿ��� �׽�Ʈ ���̽��� ���� T�� �־�����, �� �Ʒ��� �� �׽�Ʈ ���̽��� �־�����.

�� �׽�Ʈ ���̽��� ù ��° �ٿ��� ���̰� 30�� ���ڿ��� �־�����.


[���]

����� �� ���� '#t'�� �����ϰ�, ������ �� ĭ �� ���� ������ ����Ѵ�.

(t�� �׽�Ʈ ���̽��� ��ȣ�� �ǹ��ϸ� 1���� �����Ѵ�.)
*/
#include <cstdio>
#include <cstring>
#include <string>
using namespace std;

int main()
{
	int test_case;
	scanf("%d", &test_case);
	
	for (int i = 1; i <= test_case; i++)
	{
		char str[31];
		int max = 0;
		int temp = 0;
		scanf("%s", str);
		for (int j = 0; j < 10; j++)
		{
			for (int k = j + 1; k < 30; k++)
			{
				if (str[j] == str[k])
				{
					temp = k - j;
					break;
				}
			}
			if (max < temp)
				max = temp;
		}
		printf("#%d %d\n", i, max);
	}
}