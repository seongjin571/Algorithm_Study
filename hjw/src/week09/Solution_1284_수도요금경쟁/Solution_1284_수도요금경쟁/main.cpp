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
//p : ���ʹ� ���
//q : r���� ������ ���
//r : r����
//s : ���ʹ� �߰����
//w : ��� ���� ��