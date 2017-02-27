#!/bin/bash
/usr/bin/time -lp ./randmst 0 32768 1 4 >> output_last.txt 2>> output_last.txt
/usr/bin/time -lp ./randmst 0 131072 1 4 >> output_last.txt 2>> output_last.txt
./randmst 0 131072 5 3 >> output_last.txt
./randmst 0 131072 5 4 >> output_last.txt
