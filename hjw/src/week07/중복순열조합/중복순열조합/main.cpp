#include <cstdio>
#include <iostream>
#include <vector>
using namespace std;
/*조합은 순서를 고려하지 않음
중복은 중복을 허용
n개중에서 r개 뽑기 -- > n C r
*/
vector<int> vc;
void print_set(int *set, int set_size)
{
	for (int i = 0; i < set_size; i++)
	{
		cout << set[i] << " ";
	}
	cout << endl;
}
void comb(int* set, int set_size, int m, int n, int index)//조합-->순서는 중요하지 않다.
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
void rcomb(int *set, int set_size, int m, int n, int index)
{
	if (set_size == n)//종료조건
	{
		print_set(set, set_size);
		return;
	}
	else if (index == m)return;//범위 초과하면 return

	set[set_size] = index;
	rcomb(set, set_size + 1, m, n, index);
	rcomb(set, set_size, m, n, index + 1);
}
//순열
void dfs(int cnt,int a, int b)
{
	if (vc.size() == b)
	{
		for (auto i : vc)
		{
			printf("%d ", i);
		}
		cout << endl;
		return;
	}

	for (int i = cnt; i < a; i++)
	{
		if (vc.size() < b)
		{
			vc.push_back(i);
			dfs(i + 1, a, b);
			vc.pop_back();
		}
	}
}
void rdfs(int m, int n)
{
	if (vc.size() == m)
	{
		for (auto i : vc)
		{
			printf("%d ", i);
		}
		cout << endl;
	}

	for (int i = 0; i <= n; i++)
	{
		if (vc.size() < m)
		{
			vc.push_back(i);
			rdfs(m, n);
			vc.pop_back();
		}
	}
}
int main()
{
	int m, n;
	cin >> m >> n;//m개중 n개

	int *set = new int[n];
	int *arr = new int[n];

	for (int i = 0; i < m; i++)
		arr[i] = i;

	cout << m << "c" << n << "조합 출력" << endl;
	comb(set, 0, m, n, 0);
	cout << m << "H" << n << "중복 조합 출력" << endl;
	rcomb(set, 0, m, n, 0);

	int a, b;//a개중 b개
	cin >> a >> b;
	cout << "vector + dfs 를 통한 조합 구현" << endl;
	dfs(0, a,b);
	cout << "vector + dfs를 통한 중복 조합 구현" << endl;
	rdfs(a,b);

}