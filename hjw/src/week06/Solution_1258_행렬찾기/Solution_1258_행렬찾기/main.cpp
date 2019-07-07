/*���� ������� ȭ�� ������ ��� ����κ��� 3���� ������ �߰��Ͽ���.

1. ȭ�� ������ ��� ������ �簢���� �̷�� �ִ�. ����, �簢�� ���ο��� �� ��Ⱑ ����.

���� ���, ���� �׸����� 3���� ȭ�� ������ ��� ����� �̷���� �簢�� A, B, C�� �ִ�.

2. ȭ�� ������ ��� ����� �̷���� �簢������ ���� ����(������ ��� �� x ������ ��� ��)�� �ٸ���.

���� ���, ���� �׸����� A�� 3x4, B�� 2x3, C�� 4x5�̴�.

3. 2���� ȭ�� ������ ��� ����� �̷���� �簢���� ���̿��� �� ������ �ִ�.

���� ���, ���� �׸����� A�� B ���̿� B�� C ���̸� ����, �� ��⸦ ��Ÿ���� ��0�� ���ҵ��� 2���� �簢�� ���̿� �ִ� ���� �� �� �ִ�.

��, A�� C�� ���� ���� �밢�� �����δ� �� ��Ⱑ ���� ���� �ִ�.

���� ������� â���� ���鿡 ���� 2���� �迭���� ���(ȭ�� ������ �� ����� �̷���� �簢��)���� ã�Ƴ��� ������ �����ϰ��� �Ѵ�.

ã�Ƴ� ��ĵ��� ������ ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

[���� ����]

n�� 100 �����̴�.

�κ� ����� ���� ������ ���� �ٸ��� ����� ���� ������ ���� �ٸ���.

���� ���, 3���� �κ���� ��� (A(3x4), B(2x3), C(4x5))�� ����Ǿ��ٸ�, �� �κ� ����� ���� ���� 3, 2, 4�� ���� �ٸ���.

���������� �� �κ� ����� ���� ���� 4, 3, 5�� ���� �ٸ���.

�׽�Ʈ ���̽��� ���� ���� �׷����� �����Ǹ� �Ʒ��� ����.
�׷� 1. n <= 10 �̰� sub matrix�� ���� 5�� ����
�׷� 2. n <= 40 �̰� 5 < sub matrix <= 10
�׷� 3. 40 < n <=80 �̰� 5 < sub matrix <= 10
�׷� 4. 40 < n <=80 �̰� 10 < sub matrix <= 15
�׷� 5. 80 < n<=100 �̰� 15 < sub matrix <= 20

[�Է�]

�� ù �ٿ��� �׽�Ʈ ���̽��� ������ �־�����.

�׸��� �׽�Ʈ ���̽��� �� ���ο� �־�����.

�� �׽�Ʈ ���̽��� (n+1) �ٷ� �����Ǹ�, ù �ٿ��� ���� ������ n�� �־�����, ���� n�ٿ��� n x n ����� (�� ���� �� �ٿ�) �־�����.

[���]

�� �׽�Ʈ ���̽� ������ ���� ���� ����Ѵ�.

�� ���� ��#x���� �����ϰ� ������ �ϳ� �� ����, �� �׽�Ʈ ���̽��� �־��� ��Ŀ��� ����� �κ� ��ĵ��� ������ �� �ڸ� �̾� ��ĵ��� ��� ���� ũ�⸦ ����Ѵ�. 

ũ��� ��� ���� ���� ������, ũ�Ⱑ ���� ������� ����Ѵ�.

���� ��� 3x4 ����� ũ��� 3*4 = 12 �̴�.

ũ�Ⱑ ���� ��� ���� ���� ������ ����Ѵ�.

���� ��� 12x4, 8x6 �� ���� ����� ���� ũ���̰� ���� ���� 12, 8 �̹Ƿ� 8 6 12 4 ������ ����Ѵ�.*/

#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;
struct Node {
	int subsize;
	int hang;
	int yeol;
	Node *next;
};
int dx[4] = { 1,0,-1,0 };
int dy[4] = { 0,1,0,-1 };
vector<int>v[1001];
void bfs(int **map, int **check, int x, int y, int n,int count)
{
	int start_idx = x;
	int start_idy = y;
	int last_idx;
	int last_idy;
	queue<int>que;
	que.push(x);
	que.push(y);
	check[x][y] = 1;

	while (!que.empty())
	{
		int xx = que.front();
		que.pop();
		int yy = que.front();
		que.pop();
		for (int i = 0; i < 4; i++)
		{
			int newx = xx + dx[i];
			int newy = yy + dy[i];
			if ((-1 < newx && newx < n) && (-1 < newy && newy < n) && (map[newx][newy] != 0) && (check[newx][newy] == 0))
			{
				que.push(newx);
				que.push(newy);
				check[newx][newy] = 1;
				last_idx = newx;
				last_idy = newy;
			}
		}
	}
	int row = last_idx - start_idx + 1;
	int column = last_idy - start_idy + 1;
	int subsize = row*column;
	v[count].push_back(subsize);
	v[count].push_back(row);
	v[count].push_back(column);
}
int main()
{
	int test_case;
	cin >> test_case;

	for (int i = 1; i <= test_case; i++)
	{
		int n;
		cin >> n;//n x n���
		int count = 0;//������� ����

		int **map = new int*[n];
		int **check = new int*[n];
		for (int j = 0; j < n; j++)
		{
			map[j] = new int[n];//map
			check[j] = new int[n];//check
			memset(check[j], 0, sizeof(int)*n);//check �ʱ�ȭ
		}
		for (int k = 0; k < n; k++)
		{
			for (int l = 0; l < n; l++)
			{
				cin >> map[k][l];//map�Է�
			}
		}

		for (int j = 0; j < n; j++)
		{
			for (int k = 0; k < n; k++)
			{
				if (map[j][k] != 0 && check[j][k] == 0)
				{
					count++;
					bfs(map, check, j, k,n,count);
				}
			}
		}
		cout << "#" << i << " ";
		cout << count << endl;

		int *arr;
		arr = new int[count];
		for (int j = 1; j <= count; j++)
		{
			arr[j] = v[j].at(0);//v[j].at(0)���� ũ�Ⱑ ���ִ� subsize
		}//int�� �迭�� �ϳ��� �Է�
		sort(arr, arr + count);//sort�Ѵ�

		for (int k = 1; k <= count; k++)
		{
			for (int j = 1; j <= count; j++)
			{
				if (arr[k] == v[j].at(0))
				{
					cout << v[j].at(1) << " " << v[j].at(2) << " ";
				}
			}
		}
		cout << endl;
	}
}
