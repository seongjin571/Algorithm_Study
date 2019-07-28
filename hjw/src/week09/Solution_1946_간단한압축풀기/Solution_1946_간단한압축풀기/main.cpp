#include <cstdio>
#include <vector>

using namespace std;
vector<char>vc;

int main()
{
	int test;
	scanf("%d", &test);

	for (int z = 1; z <= test; z++)
	{
		vc.clear();
		int n;
		scanf("%d", &n);
		
		for (int i = 0; i < n; i++)
		{
			char alp;
			int num;
			scanf(" %c %d", &alp, &num);

			for (int j = 0; j < num; j++)
			{
				vc.push_back(alp);
			}
		}

		int count = 0;
		printf("#%d\n", z);
		for (auto i : vc)
		{
			printf("%c", i);
			count++;
			if (count == 10)
			{
				count = 0;
				printf("\n");
			}
		}
		printf("\n");
	}
}
//A 65 Z 90
