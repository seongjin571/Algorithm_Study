#include <cstdio>

using namespace std;

int main()
{
	int test;
	scanf("%d", &test);
	
	for (int z = 1; z <= test; z++)
	{
		int mon;
		scanf("%d", &mon);
		int arr[8];
		int idx = 0;
		arr[idx] = mon / 50000;
		mon = mon % 50000;
		idx++;
		arr[idx] = mon / 10000;
		mon = mon % 10000;
		idx++;
		arr[idx] = mon / 5000;
		mon = mon % 5000;
		idx++;
		arr[idx] = mon / 1000;
		mon = mon % 1000;
		idx++;
		arr[idx] = mon / 500;
		mon = mon % 500;
		idx++;
		arr[idx] = mon / 100;
		mon = mon % 100;
		idx++;
		arr[idx] = mon / 50;
		mon = mon % 50;
		idx++;
		arr[idx] = mon / 10;
		mon = mon % 10;
		
		printf("#%d\n", z);
		for (int i = 0; i <= idx; i++)
			printf("%d ", arr[i]);
		printf("\n");
	}
}