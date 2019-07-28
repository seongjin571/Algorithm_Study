#include <cstdio>
#include <vector>
#include <iostream>
#include <fstream>
using namespace std;
vector<int> vc;
int main()
{
	int test;
	scanf("%d", &test);
	//ifstream inf("C:\\Users\\admin\\Downloads\\input.txt");
	//inf >> test;
	for (int z = 1; z <= test; z++)
	{
		int n;
		//inf >> n;
		scanf("%d", &n);
		vc.clear();
		int result = 0;
		int speed = 0;
		for (int i = 0; i < n; i++)
		{
			int a;
			//inf >> a;
			scanf("%d", &a);
			vc.push_back(a);
			if (a == 0)
			{
				continue;
			}
			else
			{
				int b;
				//inf >> b;
				scanf("%d", &b);
				vc.push_back(b);
			}
		}
		for (int i=0;i<vc.size();i++)
		{
			if (vc.at(i) == 1)
			{
				speed += vc.at(i + 1);
				result +=  speed;
				i++;
			}
			else if (vc.at(i) == 2)
			{
				if (speed <= vc.at(i + 1))
					speed = 0;
				else
					speed -= vc.at(i + 1);
				result += speed;
				i++;
			}
			else if (vc.at(i) == 0)
			{
				result += speed;
				continue;
			}
		}	
		printf("#%d %d\n", z, result);
	}
}