#include <cstdio>
#include <queue>
using namespace std;

int n, b, c;
long long result;
queue<int>que;
queue<int>que2;

int main()
{
	result = 0;
	scanf("%d", &n);
	int a;
	for (int i = 0; i < n; i++)
	{
		scanf("%d", &a);
		que.push(a);
		result++;
	}
	scanf("%d %d", &b, &c);

	while (!que.empty())
	{
		int man = que.front();
		que.pop();
		man = man - b;
		if(man > 0)
			que2.push(man);
	}
	while (!que2.empty())
	{
		int man = que2.front();
		que2.pop();
		int num = man / c;
		result += num;
		if (man%c != 0)
			result++;
	}
	printf("%lld", result);
}