/*������ ���� �� ���� ���� N, M�� �־��� ��, N�� M �ŵ����� ���� ���ϴ� ���α׷��� ���ȣ���� �̿��Ͽ� ������ ���ƶ�.

2 5 = 2 X 2 X 2 X 2 X 2 = 32

3 6 = 3 X 3 X 3 X 3 X 3 X 3 = 729

[���� ����]

�� 10���� �׽�Ʈ ���̽��� �־�����.

��� ���� Integer ������ �Ѿ�� �ʴ´�.
 
[�Է�]

�� �׽�Ʈ ���̽��� ù �ٿ��� �׽�Ʈ ���̽��� ��ȣ�� �־����� �� ���� �ٿ��� �� ���� ���ڰ� �־�����.

[���]

#��ȣ�� �Բ� �׽�Ʈ ���̽��� ��ȣ�� ����ϰ�, ���� ���� �� �׽�Ʈ ���̽��� ���� ���� ����Ѵ�.*/
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