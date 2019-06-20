#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
#include <stdio.h>
using namespace std;

void bfs(vector<int>v[], bool check[], int start_v)
{
	queue<int> que;
	que.push(start_v);//ť�� �������� �ִ´�
	check[start_v] = true;//������ index �湮

	while (!que.empty())
	{
		int print;//����� ���� ��, ť�� �� �Ʒ���
		print = que.front();
		que.pop();
		cout << print << " ";

		for (int i = 0; i < v[print].size(); i++)//����� ����� ������ŭ �ݺ�
		{
			if (check[v[print][i]] == false)//����� ����� ����� ��尡 �湮�� ���� �ʾ������
			{
				check[v[print][i]] = true;//�湮 ó��
				que.push(v[print][i]);//ť�� ����
			}
		}
	}
}
void dfs(vector<int>v[], bool check[], int start_v)//���� v[]�� check[], start����
{
	check[start_v] = true;//ù �湮 -> true 
	cout << start_v << " ";//���

	for (int i = 0; i < v[start_v].size(); i++)//v[i] ����� ����� ����ŭ �ݺ�
	{
		int next = v[start_v][i];//v[i]�� ����� ù ��带 next�� ����

		if (check[next] == false)
		{
			dfs(v, check, next);// ��� �� Ż������
		}
	}
}
int main()
{
	int n, m, start_v;
	int a, b;
	cin >> n >> m >> start_v;

	vector<int> v[1001];
	bool check[1001];//�湮 ��湮 ����

	fill(check, check + n + 1, false);//check�迭�� ��� false������ �ʱ⼳��

	for (int i = 0; i < m; i++)//������ ������ŭ �Է�
	{
		cin >> a >> b;
		v[a].push_back(b);//��� a �� ��� b ����
		v[b].push_back(a);//��� b �� ��� a ����
	}

	for (int i = 1; i < n + 1; i++)
	{
		sort(v[i].begin(), v[i].end());
	}

	dfs(v, check, start_v);
	cout << endl;
	fill(check, check + n + 1, false);//üũ �迭 �ʱ�ȭ
	bfs(v, check, start_v);


	
	return 0;
}
