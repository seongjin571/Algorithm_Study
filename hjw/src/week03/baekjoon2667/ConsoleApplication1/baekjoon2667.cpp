#include <iostream>
#include <string.h>
using namespace std;
void function(int **arr, bool check[], int start)
{

	for (int i = 0; i < 3; i++)
	{
		for (int j = 0; j < 3; j++)
		{
			cout << (*arr)[i][j] << "\t";
		}
		cout << endl;
	}
}
int main()
{
	int n;//array size
	int a;//0 or 1 cin
	cin >> n;
	
	int **arr = new int*[n];//�� �����Ҵ�

	for (int i = 0; i < n; i++)
		arr[i] = new int[n];//�� �����Ҵ�

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			cin >> a;
		}
	}

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			cout << arr[i][j] << "\t";
		}
		cout << endl;
	}

	//fixed


	int start=0;
	bool check[125];
	fill(check, check + 125, false);


	function(arr,check, start);




	for (int i = 0; i < n; i++)
		delete[] arr[i];//�޸� ����

	delete[] arr;//�޸� ����
}