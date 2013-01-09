#include <stdio.h>
#include <string.h>

int main(void)
{
  char s[] = "Fat bottomed girls";
  int mid, n;
  char t;
  
  n = strlen(s)-1;
  mid = n/2;
  for (int i=0; i<=mid; ++i) {
    t = s[i];
    s[i] = s[n-i];
    s[n-i] = t;
  }
  puts(s);
  return(0);
}
