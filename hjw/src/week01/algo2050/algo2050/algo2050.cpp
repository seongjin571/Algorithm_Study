#include <iostream>

using namespace std;

int main()
{
	int dif = 0;

	char str[200];
	int i = 0;
	cin >> str;
	while (str[i] != '\0')
	{
		dif = str[i] - '0';
		dif = dif - 16;
		printf("%d ", dif);
		i++;
	}

	return 0;
}
//65