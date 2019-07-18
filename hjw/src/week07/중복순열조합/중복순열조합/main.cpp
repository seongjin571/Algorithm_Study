#include <cstdio>
#include <iostream>

using namespace std;
void print_set(int *set, int set_size)
{
	for (int i = 0; i < set_size; i++)
	{
		cout << set[i] << " ";
	}
	cout << endl;
}
void comb(int* set, int set_size, int m, int n, int index)//조합
{
	if (set_size == n)//종료조건
	{
		print_set(set, set_size);
		return;
	}
	if (m == index) {
		return;
	}
	set[set_size] = index;
	comb(set, set_size + 1, m, n, index + 1);
	comb(set, set_size, m, n, index + 1);
}
int main()
{
	int m, n;
	cin >> m >> n;

	int *set = new int[n];
	int *arr = new int[n];

	for (int i = 0; i < m; i++)
		arr[i] = i;

	cout << m << "c" << n << "조합 출력" << endl;
	comb(set, 0, m, n, 0);

}