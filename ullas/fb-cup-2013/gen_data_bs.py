#! /usr/bin/python

import string
import random
import sys

def gen(m=50, s=500):
    f = open('bss_uhk.txt', 'w')
    l = string.ascii_letters
    f.write(str(m) + '\n')
    for _ in range(m):
        b = []
        for _ in range(s):
            c = l[random.randint(0, 51)]
            b.append(c)
        b.append('\n')
        f.write(''.join(b))    
    f.close()

if __name__ == '__main__':
    gen()

    
