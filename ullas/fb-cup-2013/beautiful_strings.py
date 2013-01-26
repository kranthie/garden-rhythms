#!/usr/bin/python

import sys

def doIt(infile):
    f = open(infile)
    n = int(f.readline())
    for i in range(1,n+1):
        l = f.readline()
        d = {}
        for c in l:
            c = c.lower()
            if c.isalpha():
                d[c] = d.get(c,0) + 1
#        print(d)
        counts = [x for x in d.values()]
        counts.sort()
        counts.reverse()
#        print(counts)
        sum, val = 0, 26
        for x in counts:
            sum += x*val
            val -= 1
        print('Case #{0}: {1}'.format(i, sum))

if __name__ == '__main__':
    doIt(sys.argv[1])
    
