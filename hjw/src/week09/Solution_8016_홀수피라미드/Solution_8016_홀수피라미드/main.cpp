/*경표는 아래와 같이 삼각형 모양으로 숫자를 쌓기로 했다.

1층에는 1개, 2층에는 3개, 3층에는 5개, … 와 같이 쌓는다.




위와 같이 경표는 끝도 없이 피라미드를 쌓을 때, N층의 제일 왼쪽, 오른쪽에 쓰게 될 숫자가 무엇일지 예측해보자.


[입력]

첫 번째 줄에 테스트 케이스의 수 T가 주어진다.

각 테스트 케이스의 첫 번째 줄에는 층의 번호 N(1≤N≤109)이 주어진다.


[출력]

각 테스트 케이스마다 ‘#x’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고,

각 테스트 케이스마다 N층의 제일 왼쪽, 오른쪽에 쓰게 될 숫자를 공백으로 구별하여 출력한다.*/
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
