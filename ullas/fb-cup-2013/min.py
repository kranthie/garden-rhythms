#!/usr/bin/python

import sys

def doIt(infile):
    f = open(infile)
    n = int(f.readline())
    for i in range(1,n+1):
        n, k = f.readline().split(' ')
        n, k = int(n), int(k)
        a, b, c, r = f.readline().split(' ')
        a, b, c, r = int(a), int(b), int(c), int(r)
        print(n, k, a, b, c, r)

        m = []
        min = a
        m.append(a)
        for i in range(1, k):
            e = (b*m[i-1]+c)%r
            if min > e: min = e
            m.append(e)
        print(m)
        m = set(m)
        all = set(range(n))
        t = list(all.difference(m))
        ans = t[n-k-1]
        print('Case #{0}: {1}'.format(i, ans))

if __name__ == '__main__':
    doIt(sys.argv[1])
    
