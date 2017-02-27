#!/bin/bash
for i in  128 256 512 1024 2048 4096 8192 16384 32768 65536 131072
do
for c in 0 2 3 4
do
/usr/bin/time -lp ./randmst 0 $i 1 $c >> output.txt 2>> output.txt
./randmst 0 $i 50 $c >> output.txt
done
done
