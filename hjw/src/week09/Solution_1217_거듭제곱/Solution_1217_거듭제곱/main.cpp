/*다음과 같이 두 개의 숫자 N, M이 주어질 때, N의 M 거듭제곱 값을 구하는 프로그램을 재귀호출을 이용하여 구현해 보아라.

2 5 = 2 X 2 X 2 X 2 X 2 = 32

3 6 = 3 X 3 X 3 X 3 X 3 X 3 = 729

[제약 사항]

총 10개의 테스트 케이스가 주어진다.

결과 값은 Integer 범위를 넘어가지 않는다.
 
[입력]

각 테스트 케이스의 첫 줄에는 테스트 케이스의 번호가 주어지고 그 다음 줄에는 두 개의 숫자가 주어진다.

[출력]

#부호와 함께 테스트 케이스의 번호를 출력하고, 공백 문자 후 테스트 케이스에 대한 답을 출력한다.*/
#include <cstdio>

using namespace std;
int result;
int func(int n, int m)
{
	if (m == 1)
	{
		return result *= n;
	}
	func(n, m - 1);
	return result *= n;
	
}
int main()
{
	for (int t = 1; t < 11; t++)
	{
		int test;
		scanf("%d", &test);
		int n, m;
		scanf("%d %d", &n, &m);
		result = 1;
		result = func(n, m);
		printf("#%d %d\n", t, result);
	}
}