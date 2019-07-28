#include <cstdio>

using namespace std;
struct A{
	int price;
};
struct B {
	int price;
};
int main()
{
	int t;
	scanf("%d", &t);

	for (int z = 1; z <= t; z++)
	{
		int p, q, r, s, w;
		scanf("%d %d %d %d %d", &p, &q, &r, &s, &w);

		A a;
		B b;
		a.price = p*w;
		if (w > r)
		{
			b.price = q + (w - r)*s;
		}
		else
		{
			b.price = q;
		}
		int res = a.price > b.price ? b.price : a.price;
		printf("#%d %d\n", z, res);
	}
}
//p : 리터당 요금
//q : r리터 이하의 요금
//r : r리터
//s : 리터당 추가요금
//w : 사용 물의 양