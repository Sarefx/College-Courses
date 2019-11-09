 /* MathIf.c */
#include "stdio.h"

int i = 1;

int main(int argc, char** argv)
{
	int j = i + 1;
	int k = j * 2 - 1;
	if (k > i)
		printf("Hello! %d, %d, %d", i, j, k);
	else
		printf("Hello! %d, %d, %d", k, j, i);
	return 0;
}