#include <cstdio>
#include <queue>
#include <vector>
struct info {
	int num;
	int dir;
};
using namespace std;
int arr1[8];
int arr2[8];
int arr3[8];
int arr4[8];
queue<info> que;
vector<int>vc;
void one(int);
void two(int);
void three(int);
void four(int);
void func();
int main()
{
	for (int i = 0; i < 8; i++)
		scanf("%1d", &arr1[i]);
	for (int i = 0; i < 8; i++)
		scanf("%1d", &arr2[i]);
	for (int i = 0; i < 8; i++)
		scanf("%1d", &arr3[i]);
	for (int i = 0; i < 8; i++)
		scanf("%1d", &arr4[i]);
	int rotate;
	scanf("%d", &rotate);
	int num, dir;
	for (int i = 0; i < rotate; i++)
	{
		scanf("%d %d", &num,&dir);
		que.push({ num,dir });
	}

	func();
	int result = 0;
	if (arr1[0] == 1)
		result += 1;
	if (arr2[0] == 1)
		result += 2;
	if (arr3[0] == 1)
		result += 4;
	if (arr4[0] == 1)
		result += 8;
	printf("%d", result);
}
void one(int dir)
{
	int flag = 0;
	//int cnt = -1;
	for (int i = 0; i<vc.size();)
	{
		if (vc.at(i) == 1)
		{
			vc.erase(vc.begin() + i);
			flag = 1;
		}
		else
			i++;
	}
	if (flag == 1)
	{
		if (dir == 1)//시계방향
		{
			int go = 0;
			dir = -1;
			if (arr1[2] != arr2[6])
				go = 1;
			int temp = arr1[7];
			for (int i = 7; i > 0; i--)
				arr1[i] = arr1[i - 1];
			arr1[0] = temp;

			if (go == 1)
				two(dir);

		}
		else//반시계방향
		{
			int go = 0;
			if (arr1[2] != arr2[6])
				go = 1;
			int temp = arr1[0];
			for (int i = 0; i < 7; i++)
				arr1[i] = arr1[i + 1];
			arr1[7] = temp;
			dir = 1;
			if (go == 1)
				two(dir);
		}
	}
	else
		return;
}
void two(int dir)
{
	int flag = 0;
	//int cnt = -1;
	for (int i = 0; i<vc.size();)
	{
		if (vc.at(i) == 2)
		{
			vc.erase(vc.begin() + i);
			flag = 1;
		}
		else
			i++;
	}
	if (flag == 1)
	{
		if (dir == 1)//시계방향
		{
			int go1 = 0;
			int go3 = 0;
			dir = -1;
			if (arr2[6] != arr1[2])
				go1 = 1;
			if (arr2[2] != arr3[6])
				go3 = 1;
			int temp = arr2[7];
			for (int i = 7; i > 0; i--)
				arr2[i] = arr2[i - 1];
			arr2[0] = temp;

			if (go1 == 1)
				one(dir);
			if (go3 == 1)
				three(dir);

		}
		else//반시계방향
		{
			int go1 = 0;
			int go3 = 0;
			if (arr2[6] != arr1[2])
				go1 = 1;
			if (arr2[2] != arr3[6])
				go3 = 1;
			int temp = arr2[0];
			for (int i = 0; i < 7; i++)
				arr2[i] = arr2[i + 1];
			arr2[7] = temp;
			dir = 1;
			if (go1 == 1)
				one(dir);
			if (go3 == 1)
				three(dir);
		}
	}
	else
		return;
}
void three(int dir)
{
	int flag = 0;
	//int cnt = -1;
	for (int i = 0; i<vc.size();)
	{
		if (vc.at(i) == 3)
		{
			vc.erase(vc.begin() + i);
			flag = 1;
		}
		else
			i++;
	}
	if (flag == 1)
	{
		if (dir == 1)//시계방향
		{
			int go2 = 0;
			int go4 = 0;
			dir = -1;
			if (arr3[6] != arr2[2])
				go2 = 1;
			if (arr3[2] != arr4[6])
				go4 = 1;
			int temp = arr3[7];
			for (int i = 7; i > 0; i--)
				arr3[i] = arr3[i - 1];
			arr3[0] = temp;

			if (go2 == 1)
				two(dir);
			if (go4 == 1)
				four(dir);

		}
		else//반시계방향
		{
			int go2 = 0;
			int go4 = 0;
			if (arr3[6] != arr2[2])
				go2 = 1;
			if (arr3[2] != arr4[6])
				go4 = 1;
			int temp = arr3[0];
			for (int i = 0; i < 7; i++)
				arr3[i] = arr3[i + 1];
			arr3[7] = temp;
			dir = 1;
			if (go2 == 1)
				two(dir);
			if (go4 == 1)
				four(dir);
		}
	}
	else
		return;
}
void four(int dir)
{
	int flag = 0;
	//int cnt = -1;
	for (int i = 0; i<vc.size();)
	{
		if (vc.at(i) == 4)
		{
			vc.erase(vc.begin() + i);
			flag = 1;
		}
		else
			i++;
	}
	if (flag == 1)
	{
		if (dir == 1)//시계방향
		{
			int go = 0;
			dir = -1;
			if (arr4[6] != arr3[2])
				go = 1;
			int temp = arr4[7];
			for (int i = 7; i > 0; i--)
				arr4[i] = arr4[i - 1];
			arr4[0] = temp;

			if (go == 1)
				three(dir);

		}
		else//반시계방향
		{
			int go = 0;
			if (arr4[6] != arr3[2])
				go = 1;
			int temp = arr4[0];
			for (int i = 0; i < 7; i++)
				arr4[i] = arr4[i + 1];
			arr4[7] = temp;
			dir = 1;
			if (go == 1)
				three(dir);
		}
	}
	else
		return;
}
void func()
{
	while (!que.empty())
	{
		for (int j = 0; j < 4; j++)
			vc.push_back(j + 1);
		int num = que.front().num;
		int dir = que.front().dir;
		switch (num)
		{
		case 1: one(dir); break;
		case 2: two(dir); break;
		case 3: three(dir); break;
		case 4: four(dir); break;
		default:
			break;
		}
		que.pop();
		vc.clear();
	}
}