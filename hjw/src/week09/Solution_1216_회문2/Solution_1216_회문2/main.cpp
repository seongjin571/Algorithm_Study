#include <cstdio>
#include <vector>
using namespace std;

char map[100][100];
int result;
vector<char>vc;
void right()
{

}
void down()
{

}
int main()
{
	for (int t = 1; t < 11; t++)
	{
		int test;
		scanf("%d", &test);

		for (int i = 0; i < 100; i++)
		{
			for (int j = 0; j < 100; j++)
			{
				scanf("%c", &map[i][j]);
			}
		}
		result = 0;
		right();
		down();

		printf("#%d %d\n", test, result);
	}
}