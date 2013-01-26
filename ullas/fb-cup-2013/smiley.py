#!/usr/bin/python

import sys

def doIt(infile):
    f = open(infile)
    n = int(f.readline())
    for i in range(1,n+1):
        d = {'(': 0, ')': 0}
        l = f.readline()
        # Empty case
        if len(l) == 0:
            print('Case #{0}: {1}'.format(i, 'YES'))
            continue
#        print('String: {0}'.format(l))
        if d.get(l[0])is not None: 
            d[c] = 1

        for j in range(1, len(l)):
            c = l[j]
#            print(j,c)
            if c == '(' or c == ')':
#                print(c)
                if l[j-1] != ':': d[c] = d.get(c) + 1
        if d['('] == d[')']: ans = 'YES'
        else: ans = 'NO'
        
        print('Case #{0}: {1}'.format(i, ans))

if __name__ == '__main__':
    doIt(sys.argv[1])
    
