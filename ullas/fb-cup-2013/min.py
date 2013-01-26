#!/usr/bin/python

import sys
import bisect

def doIt(infile):
    f = open(infile)
    n = int(f.readline())
    for i in range(1,n+1):
        n, k = f.readline().split(' ')
        n, k = int(n), int(k)
        a, b, c, r = f.readline().split(' ')
        a, b, c, r = int(a), int(b), int(c), int(r)

        m = [a]
        prev = a
        for j in range(1, k):
            e = (b*prev+c)%r
            m.append(e)
            prev = e

        msorted = m[:]
        msorted.sort()
        for j in range(k, n):
            for l in range(n):
                if contains(msorted, l) == False:
                    break
            m.append(l)
            x = m.pop(0)
            del msorted[index(msorted, x)]
            bisect.insort_left(msorted, l)
        
        ans = m[-1]
        print("Case #{0}: {1}".format(i, ans))

def index(a, x):
    i = bisect.bisect_left(a, x)
    if i != len(a) and a[i] == x:
        return i
    raise ValueError

def contains(a, x):
    try:
        if index(a, x) != -1:
            return True
        else:
            return False
    except ValueError:
        return False    
        
if __name__ == '__main__':
    if len(sys.argv) > 1:
        doIt(sys.argv[1])
    else:
        doIt('min_sample.txt')
    
