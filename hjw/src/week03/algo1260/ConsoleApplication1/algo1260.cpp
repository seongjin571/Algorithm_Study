#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
#include <stdio.h>
using namespace std;

void bfs(vector<int>v[], bool check[], int start_v)
{
	queue<int> que;
	que.push(start_v);//큐에 시작점을 넣는다
	check[start_v] = true;//시작점 index 방문

	while (!que.empty())
	{
		int print;//출력할 문자 즉, 큐의 맨 아래것
		print = que.front();
		que.pop();
		cout << print << " ";

		for (int i = 0; i < v[print].size(); i++)//노드의 연결된 노드수만큼 반복
		{
			if (check[v[print][i]] == false)//출력한 노드의 연결된 노드가 방문을 하지 않았을경우
			{
				check[v[print][i]] = true;//방문 처리
				que.push(v[print][i]);//큐에 삽입
			}
		}
	}
}
void dfs(vector<int>v[], bool check[], int start_v)//인자 v[]와 check[], start인자
{
	check[start_v] = true;//첫 방문 -> true 
	cout << start_v << " ";//출력

	for (int i = 0; i < v[start_v].size(); i++)//v[i] 연결된 노드의 수만큼 반복
	{
		int next = v[start_v][i];//v[i]의 연결된 첫 노드를 next로 변경

		if (check[next] == false)
		{
			dfs(v, check, next);// 재귀 및 탈출조건
		}
	}
}
int main()
{
	int n, m, start_v;
	int a, b;
	cin >> n >> m >> start_v;

	vector<int> v[1001];
	bool check[1001];//방문 노방문 생각

	fill(check, check + n + 1, false);//check배열을 모두 false값으로 초기설정

	for (int i = 0; i < m; i++)//간선의 개수만큼 입력
	{
		cin >> a >> b;
		v[a].push_back(b);//노드 a 와 노드 b 연결
		v[b].push_back(a);//노드 b 와 노드 a 연결
	}

	for (int i = 1; i < n + 1; i++)
	{
		sort(v[i].begin(), v[i].end());
	}

	dfs(v, check, start_v);
	cout << endl;
	fill(check, check + n + 1, false);//체크 배열 초기화
	bfs(v, check, start_v);


	
	return 0;
}
