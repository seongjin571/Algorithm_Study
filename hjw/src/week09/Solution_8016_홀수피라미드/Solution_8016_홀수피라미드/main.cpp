/*��ǥ�� �Ʒ��� ���� �ﰢ�� ������� ���ڸ� �ױ�� �ߴ�.

1������ 1��, 2������ 3��, 3������ 5��, �� �� ���� �״´�.




���� ���� ��ǥ�� ���� ���� �Ƕ�̵带 ���� ��, N���� ���� ����, �����ʿ� ���� �� ���ڰ� �������� �����غ���.


[�Է�]

ù ��° �ٿ� �׽�Ʈ ���̽��� �� T�� �־�����.

�� �׽�Ʈ ���̽��� ù ��° �ٿ��� ���� ��ȣ N(1��N��109)�� �־�����.


[���]

�� �׽�Ʈ ���̽����� ��#x��(x�� �׽�Ʈ���̽� ��ȣ�� �ǹ��ϸ� 1���� �����Ѵ�)�� ����ϰ�,

�� �׽�Ʈ ���̽����� N���� ���� ����, �����ʿ� ���� �� ���ڸ� �������� �����Ͽ� ����Ѵ�.*/
#include<cstdio>
#include <vector>
#include <iostream>
#include <fstream>
using namespace std;
int cnt;
/*
int main()
{
	int test;
	//ifstream inf("C:\\Users\\admin\\Downloads\\sample_input.txt");
	scanf("%d", &test);
	//inf >> test;
	for (int z = 1; z <= test; z++)
	{
		long long n;
		cnt = 1;
		//inf >> n;
		scanf("%lld", &n);
		vector<long long>vc;
		for (int i = 1; i <= n; i++)
		{
			for (int j = 0; j < 2 * i - 1; j++)
			{
				vc.push_back(cnt);
				cnt += 2;
			}
			if (i != n)
				vc.clear();
		}
		printf("#%d %lld %lld\n", z, vc.front(), vc.back());
		vc.clear();
	}
}
*/
/*
int main()
{
	int test;
	scanf("%d", &test);

	for (int z = 1; z <= test; z++)
	{
		long long n;
		scanf("%lld", &n);

		long long mid = 1;
		long long result1, result2;
		if (n == 1)
			printf("#%d %d %d\n", z, 1, 1);
		else
		{
			for (int i = 2; i <= n; i++)
			{
				mid += 4 * (i - 1);
			}
			result1 = mid;
			result2 = mid;
			for (int i = 0; i < n - 1; i++)
			{
				result1 -= 2;
				result2 += 2;
			}
			printf("#%d %lld %lld\n", z, result1, result2);
		}
	}
}
*/
