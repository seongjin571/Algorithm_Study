/* counting sort method*/

#include <stdio.h>

int arr[10000 + 2];
int main() {
	int n, temp;
	scanf("%d", &n);

	while (n--) {
		scanf("%d", &temp);
		arr[temp]++;
	}

	for (int i = 1; i < 10000 + 1; i++) {
		while (arr[i]--) printf("%d\n", i);
	}

	return 0;
}WW