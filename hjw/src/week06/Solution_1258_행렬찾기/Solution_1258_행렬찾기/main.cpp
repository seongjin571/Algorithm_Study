/*유엔 조사단은 화학 물질이 담긴 용기들로부터 3가지 사항을 발견하였다.

1. 화학 물질이 담긴 용기들이 사각형을 이루고 있다. 또한, 사각형 내부에는 빈 용기가 없다.

예를 들어, 위의 그림에는 3개의 화학 물질이 담긴 용기들로 이루어진 사각형 A, B, C가 있다.

2. 화학 물질이 담긴 용기들로 이루어진 사각형들은 각각 차원(가로의 용기 수 x 세로의 용기 수)이 다르다.

예를 들어, 위의 그림에서 A는 3x4, B는 2x3, C는 4x5이다.

3. 2개의 화학 물질이 담긴 용기들로 이루어진 사각형들 사이에는 빈 용기들이 있다.

예를 들어, 위의 그림에서 A와 B 사이와 B와 C 사이를 보면, 빈 용기를 나타내는 ‘0’ 원소들이 2개의 사각형 사이에 있는 것을 알 수 있다.

단, A와 C의 경우와 같이 대각선 상으로는 빈 용기가 없을 수도 있다.

유엔 조사단은 창고의 용기들에 대한 2차원 배열에서 행렬(화학 물질이 든 용기들로 이루어진 사각형)들을 찾아내고 정보를 수집하고자 한다.

찾아낸 행렬들의 정보를 출력하는 프로그램을 작성하시오.

[제약 사항]

n은 100 이하이다.

부분 행렬의 열의 개수는 서로 다르며 행렬의 행의 개수도 서로 다르다.

예를 들어, 3개의 부분행렬 행렬 (A(3x4), B(2x3), C(4x5))이 추출되었다면, 각 부분 행렬의 행의 수는 3, 2, 4로 서로 다르다.

마찬가지로 각 부분 행렬의 열의 수도 4, 3, 5로 서로 다르다.

테스트 케이스는 여러 개의 그룹으로 구성되며 아래와 같다.
그룹 1. n <= 10 이고 sub matrix의 개수 5개 이하
그룹 2. n <= 40 이고 5 < sub matrix <= 10
그룹 3. 40 < n <=80 이고 5 < sub matrix <= 10
그룹 4. 40 < n <=80 이고 10 < sub matrix <= 15
그룹 5. 80 < n<=100 이고 15 < sub matrix <= 20

[입력]

맨 첫 줄에는 테스트 케이스의 개수가 주어진다.

그리고 테스트 케이스가 각 라인에 주어진다.

각 테스트 케이스는 (n+1) 줄로 구성되며, 첫 줄에는 양의 정수인 n이 주어지고, 다음 n줄에는 n x n 행렬이 (각 행이 한 줄에) 주어진다.

[출력]

각 테스트 케이스 각각에 대한 답을 출력한다.

각 줄은 ‘#x’로 시작하고 공백을 하나 둔 다음, 각 테스트 케이스에 주어진 행렬에서 추출된 부분 행렬들을 개수와 그 뒤를 이어 행렬들의 행과 열의 크기를 출력한다. 

크기는 행과 열을 곱한 값으로, 크기가 작은 순서대로 출력한다.

예를 들어 3x4 행렬의 크기는 3*4 = 12 이다.

크기가 같을 경우 행이 작은 순으로 출력한다.

예를 들어 12x4, 8x6 두 개의 행렬은 같은 크기이고 행은 각각 12, 8 이므로 8 6 12 4 순으로 출력한다.*/

#include <iostream>
#include <string.h>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;
struct rectangle {
	int subsize;
	int row;
	int colum;
};
int dx[4] = { 1,0,-1,0 };
int dy[4] = { 0,1,0,-1 };
vector <rectangle> v;
bool compareweight(const rectangle &a, const rectangle &b) {
	if (a.subsize == b.subsize)
		return a.row < b.row;
	else
		return a.subsize < b.subsize;
}
void bfs(int **map, int **check, int x, int y, int n,int count)
{
	rectangle rec;
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
	
	rec.colum = column;
	rec.row = row;
	rec.subsize = subsize;

	v.push_back(rec);
	
}
int main()
{
	int test_case;
	cin >> test_case;

	for (int i = 1; i <= test_case; i++)
	{
		int n;
		cin >> n;//n x n행렬
		int count = 0;//저장고의 개수

		int **map = new int*[n];
		int **check = new int*[n];
		for (int j = 0; j < n; j++)
		{
			map[j] = new int[n];//map
			check[j] = new int[n];//check
			memset(check[j], 0, sizeof(int)*n);//check 초기화
		}
		for (int k = 0; k < n; k++)
		{
			for (int l = 0; l < n; l++)
			{
				cin >> map[k][l];//map입력
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
		cout << count << " ";

		
		sort(v.begin(), v.end(), compareweight);

		for (int j=0;j<count;j++)
		{
			cout << v.at(j).row <<  " " << v.at(j).colum << " ";
		}
		cout << endl;

		vector<rectangle>::iterator it;
		it = v.begin();
		v.erase(it, it + count);
	}
}
