#!/usr/bin/python

import sys

def doIt(infile):
    f = open(infile)
    n = int(f.readline())
    for i in range(1,n+1):
        #print('_____________________')
        n, k = f.readline().split(' ')
        n, k = int(n), int(k)
        a, b, c, r = f.readline().split(' ')
        a, b, c, r = int(a), int(b), int(c), int(r)
        #print(n, k, a, b, c, r)

        m = [a]
        prev = a
        for j in range(1, k):
            e = (b*prev+c)%r
#            m.add(e)
            m.append(e)
            prev = e

        for j in range(k, n):
            copy = m[:]
            copy.sort()
            for l in range(n):
                if l not in copy:
                    break
            m.append(l)
            m.pop(0)
        
        ans = m.pop()
        print("Case #{0}: {1}".format(i, ans))


if __name__ == '__main__':
    doIt(sys.argv[1])
    
