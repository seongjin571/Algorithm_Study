#include <cstdio>
#include <iostream>
#include <vector>
using namespace std;
/*������ ������ ������� ����
�ߺ��� �ߺ��� ���
n���߿��� r�� �̱� -- > n C r
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
void comb(int* set, int set_size, int m, int n, int index)//����-->������ �߿����� �ʴ�.
{
	if (set_size == n)//��������
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
	if (set_size == n)//��������
	{
		print_set(set, set_size);
		return;
	}
	else if (index == m)return;//���� �ʰ��ϸ� return

	set[set_size] = index;
	rcomb(set, set_size + 1, m, n, index);
	rcomb(set, set_size, m, n, index + 1);
}
//����
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
	cin >> m >> n;//m���� n��

	int *set = new int[n];
	int *arr = new int[n];

	for (int i = 0; i < m; i++)
		arr[i] = i;

	cout << m << "c" << n << "���� ���" << endl;
	comb(set, 0, m, n, 0);
	cout << m << "H" << n << "�ߺ� ���� ���" << endl;
	rcomb(set, 0, m, n, 0);

	int a, b;//a���� b��
	cin >> a >> b;
	cout << "vector + dfs �� ���� ���� ����" << endl;
	dfs(0, a,b);
	cout << "vector + dfs�� ���� �ߺ� ���� ����" << endl;
	rdfs(a,b);

}