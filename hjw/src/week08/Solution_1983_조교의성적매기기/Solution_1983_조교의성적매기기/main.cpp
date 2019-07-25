#include <cstdio>
#include <iostream>
#include <fstream>
#include <vector>
#include <algorithm>
struct student
{
	int stunum;
	int mid;
	int fin;
	int wor;
	double result;
};
bool compareweight(const student&a, const student &b)
{
	return a.result > b.result;
}
using namespace std;
vector<student> vc;
void cal(int x,int n)
{
	int i=0;
	int count = 0;
	while (1)
	{
		count++;
		i += n / 10;
		if (i >= x)
			break;
	}
	switch (count)
	{
	case 1:
		printf("A+\n");
		break;
	case 2:
		printf("A0\n");
		break;
	case 3:
		printf("A-\n");
		break;
	case 4:
		printf("B+\n");
		break;
	case 5:
		printf("B0\n");
		break;
	case 6:
		printf("B-\n");
		break;
	case 7:
		printf("C+\n");
		break;
	case 8:
		printf("C0\n");
		break;
	case 9:
		printf("C-\n");
		break;
	case 10:
		printf("D0\n");
		break;

	}
}
int main()
{
	//ifstream inf("C:\\Users\\admin\\Downloads\\input.txt");
	int test;
	scanf("%d", &test);
	//inf >> test;
	for (int i = 1; i <= test; i++)
	{
		int n, k;
		scanf("%d %d", &n, &k);
		//inf >> n >> k;
		for (int j = 0; j < n; j++)
		{
			int a, b, c;
			//inf >> a >> b >> c;
			scanf("%d %d %d", &a, &b, &c);
			double d = { (a*0.35) + (b*0.45) + (c*0.2) };
			student s;
			s.mid = a;
			s.fin = b;
			s.wor = c;
			s.stunum = j + 1;
			s.result = d;
			vc.push_back(s);

		}
		sort(vc.begin(), vc.end(), compareweight);
		int count = 0;
		for (auto z : vc)
		{
			count++;
			if (z.stunum == k)
			{
				printf("#%d ", i);
				cal(count,n);
				break;
			}
		}
		vc.clear();
	}
}