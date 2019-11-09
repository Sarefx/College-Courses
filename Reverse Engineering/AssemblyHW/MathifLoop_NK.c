#include "stdio.h"

int i = 1;
int main(int argc, char** argv)
{
	int j = i + 1;
	int k = j + j - 1;
	if( k > i )
	{
		printf("Hello! %d, %d, %d", i, j, k);
	}
	else
	{
		printf("Goodbye! %d, %d, %d", k, j, i);
	}

	myFunction(10);
	
	return 0;


}

int myFunction(int x)
{
	int y = 0;
	while (y < x)
	{
		printf("\n%d...", y);
		y++;
	}
	return 0;
}