#include <iostream>
#include <vector>
#include <string>
using namespace std;
struct info {
	int core_num;
	int line_num;
};
struct xy {
	int x;
	int y;
};
int n;
int map[13][13];
int check[13][13];
vector<xy> core_location;
void east(int x, int y)
{

}
void west(int x, int y)
{

}
void north(int x, int y)
{

}
void south(int x, int y)
{

}
void go(int index)
{
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			check[i][j] = map[i][j];
		}
	}//sample map 생성
	
	for (int i = 0; i < core_location.size(); i++)
	{
		for (int j = 0; j < 5; j++)
		{
			east(core_location[i].x, core_location[i].y);
			west(core_location[i].x, core_location[i].y);
			north(core_location[i].x, core_location[i].y);
			south(core_location[i].x, core_location[i].y);
			//no_where();
		}
	}
}
void start(int index)
{
	if (index == core_location.size())
	{
		go();
		return;
	}
}
int main()
{
	int test;
	cin >> test;
	for (int t = 1; t <= test; t++)
	{
		cin >> n;
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				cin >> map[i][j];
				if (map[i][j] == 1)
				{
					core_location.push_back({ i,j });
				}
			}
		}
		int cnt = 0;
		for (int i = 0; i<core_location.size();)
		{
			if (core_location[i].x == 0 || core_location[i].x == n - 1 || core_location[i].y == 0 || core_location[i].y == n - 1)
			{
				core_location.erase(core_location.begin() + i);
				cnt++;//사이드에 붙어있는 코어의 개수
			}
			else
				i++;
		}
		go(0);
		core_location.clear();
	}
}