#include <iostream>

using namespace std;

int main()
{

	char str[80];
	int n;
	cin >> str;
	int i = 0;
	while (str[i] != '\0')
	{
		if ((int)str[i] >= 97 && (int)str[i] <= 122)
		{
			str[i] = str[i] - 32;
			printf("%c", str[i]);
		}
		else if (str[i] == '_')
			printf("%c", str[i]);
		else
			printf("%c", str[i]);
		i++;
	}

}
/*

*/
//printf("%d", a);//97
//printf("%d", A);//65-90