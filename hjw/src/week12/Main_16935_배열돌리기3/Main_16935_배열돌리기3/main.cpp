#include <cstdio>
#include <stack>
#include <queue>
using namespace std;

int n, m, r;
int map[101][101];
int width, height;
queue<int> rque;
void change()
{
	if (width == n)
	{
		width = m;
		height = n;
	}
	else
	{
		width = n;
		height = m;
	}
}
void one_func()
{
	stack <int> st;
	for (int j = 0; j < width; j++)
	{
		for (int i = 0; i < height; i++)
		{
			st.push(map[i][j]);
		}
		for (int i = 0; i < height; i++)
		{
			map[i][j] = st.top();
			st.pop();
		}
	}
	
}
void two_func()
{
	stack <int> st;
	for (int i = 0; i < height; i++)
	{
		for (int j = 0; j < width; j++)
		{
			st.push(map[i][j]);
		}
		for (int j = 0; j < width; j++)
		{
			map[i][j] = st.top();
			st.pop();
		}
	}
	
}
void three_func()
{
	queue<int> st;
	for (int j = 0; j < width; j++)
	{
		for (int i = 0; i < height; i++)
		{
			st.push(map[i][j]);
		}
	}
	int temp;
	for (int i = 0; i < width; i++)
	{
		for (int j = height-1;j>=0;j--)
		{
			temp = st.front();
			st.pop();
			map[i][j] = temp;
		}
	}
	
	change();
}
void four_func()
{
	queue<int> que;
	for (int j = 0; j < width; j++)
	{
		for (int i = 0; i < height; i++)
		{
			que.push(map[i][j]);
		}
	}

	int temp;
	for (int i = width - 1; i >= 0; i--)
	{
		for (int j = 0; j < height; j++)
		{
			temp = que.front();
			que.pop();
			map[i][j] = temp;
		}
	}
	
	change();
}
void five_func()
{
	queue<int>que1;
	queue<int>que2;
	queue<int>que3;
	queue<int>que4;
	for (int i = 0; i < height / 2; i++)
	{
		for (int j = 0; j < width / 2; j++)
		{
			que1.push(map[i][j]);
		}
	}//1번 담기
	for (int i = 0; i < height/2; i++)
	{
		for (int j = width/2; j < width; j++)
		{
			que2.push(map[i][j]);
		}
	}//2번 담기
	for (int i = height/2; i < height; i++)
	{
		for (int j = width/2; j < width; j++)
		{
			que3.push(map[i][j]);
		}
	}//3번 담기
	for (int i = height/2; i < height; i++)
	{
		for (int j = 0; j < width/2; j++)
		{
			que4.push(map[i][j]);
		}
	}//4번 담기


	int temp;
	for (int i = 0; i < height / 2; i++)
	{
		for (int j = width / 2; j < width; j++)
		{
			temp = que1.front();
			que1.pop();
			map[i][j] = temp;
		}
	}//1 -> 2

	for (int i = height / 2; i < height; i++)
	{
		for (int j = width / 2; j < width; j++)
		{
			temp = que2.front();
			que2.pop();
			map[i][j] = temp;
		}
	}//2->3

	for (int i = height / 2; i < height; i++)
	{
		for (int j = 0; j < width / 2; j++)
		{
			temp = que3.front();
			que3.pop();
			map[i][j] = temp;
		}
	}//3->4

	for (int i = 0; i < height / 2; i++)
	{
		for (int j = 0; j < width / 2; j++)
		{
			temp = que4.front();
			que4.pop();
			map[i][j] = temp;
		}
	}//4->1
}
void six_func()
{
	queue<int>que1;
	queue<int>que2;
	queue<int>que3;
	queue<int>que4;
	for (int i = 0; i < height / 2; i++)
	{
		for (int j = 0; j < width / 2; j++)
		{
			que1.push(map[i][j]);
		}
	}//1번 담기
	for (int i = 0; i < height / 2; i++)
	{
		for (int j = width / 2; j < width; j++)
		{
			que2.push(map[i][j]);
		}
	}//2번 담기
	for (int i = height / 2; i < height; i++)
	{
		for (int j = width / 2; j < width; j++)
		{
			que3.push(map[i][j]);
		}
	}//3번 담기
	for (int i = height / 2; i < height; i++)
	{
		for (int j = 0; j < width / 2; j++)
		{
			que4.push(map[i][j]);
		}
	}//4번 담기

	int temp;
	for (int i = height / 2; i < height; i++)
	{
		for (int j = 0; j < width / 2; j++)
		{
			temp = que1.front();
			que1.pop();
			map[i][j] = temp;
		}
	}//1->4

	for (int i = height / 2; i < height; i++)
	{
		for (int j = width / 2; j < width; j++)
		{
			temp = que4.front();
			que4.pop();
			map[i][j] = temp;
		}
	}//4->3

	for (int i = 0; i < height / 2; i++)
	{
		for (int j = width / 2; j < width; j++)
		{
			temp = que3.front();
			que3.pop();
			map[i][j] = temp;
		}
	}//3->2

	for (int i = 0; i < height / 2; i++)
	{
		for (int j = 0; j < width / 2; j++)
		{
			temp = que2.front();
			que2.pop();
			map[i][j] = temp;
		}
	}//2->1
}
int main()
{
	scanf("%d %d %d", &n, &m, &r);

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			scanf("%d", &map[i][j]);
		}
	}
	int temp;
	for (int i = 0; i < r; i++)
	{
		scanf("%d", &temp);
		rque.push(temp);
	}
	width = m;
	height = n;
	while (!rque.empty())
	{
		int rotate_num = rque.front();
		rque.pop();
		switch (rotate_num)
		{
		case 1: one_func(); break;
		case 2: two_func(); break;
		case 3: three_func(); break;
		case 4: four_func(); break;
		case 5: five_func(); break;
		case 6: six_func(); break;
		default:
			break;
		}
		
	}
	for (int i = 0; i < height; i++)
	{
		for (int j = 0; j < width; j++)
		{
			printf("%d ", map[i][j]);
		}
		printf("\n");
	}
}