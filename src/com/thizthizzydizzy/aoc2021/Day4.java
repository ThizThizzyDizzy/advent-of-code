package com.thizthizzydizzy.aoc2021;
import java.util.ArrayList;
import java.util.Iterator;
public class Day4 implements Day{
    @Override
    public void run(){
        String[] calls = "69,88,67,56,53,97,46,29,37,51,3,93,92,78,41,22,45,66,13,82,2,7,52,40,18,70,32,95,89,64,84,68,83,26,43,0,61,36,57,34,80,39,6,63,72,98,21,54,23,28,65,16,76,11,20,33,96,4,10,25,30,19,90,24,55,91,15,8,71,99,58,14,60,48,44,17,47,85,74,87,86,27,42,38,81,79,94,73,12,5,77,35,9,62,50,31,49,59,75,1".split(",");
        String[] boards = ("78 27 82 68 20\n" +
"14  2 34 51  7\n" +
"58 57 99 37 81\n" +
" 9  4  0 76 45\n" +
"67 69 70 17 23\n" +
"\n" +
"38 60 62 34 41\n" +
"39 58 91 45 10\n" +
"66 74 94 50 17\n" +
"68 27 75 97 49\n" +
"36 64  5 98 15\n" +
"\n" +
"17 50 13 53 20\n" +
"68 57 76 10 86\n" +
" 2 91 67 27 11\n" +
"94 70 84 69 25\n" +
"32 90 45 75 41\n" +
"\n" +
"71 84 42 49 81\n" +
"26 40 24 73 18\n" +
"41 37 19 25 75\n" +
"76 63 48 56 55\n" +
"85 51 29 88 23\n" +
"\n" +
"27 10 11 75 59\n" +
"61 96 44 58 64\n" +
"24 68 90 60 87\n" +
"28 55 34 80  9\n" +
"41 98 91 78 62\n" +
"\n" +
"91 95 70 64 30\n" +
"34 43 32 16 57\n" +
"49 80 87 51 62\n" +
"61 10  8 75 21\n" +
"85 66  2 55 56\n" +
"\n" +
"50  4 11 58 48\n" +
"30 10 57 16 95\n" +
"93 96 68 92 81\n" +
"94 17 69 86 79\n" +
"52 34 99  6 19\n" +
"\n" +
" 2 16 50 26 84\n" +
"97 24 32 51  8\n" +
"70  0  3 52  9\n" +
" 1 59 43 64 80\n" +
"22 23 17 92 88\n" +
"\n" +
"84  7 37 71 81\n" +
"80 97 17 94  9\n" +
"27 95 39 25  5\n" +
"98 46 58 77  2\n" +
"60  1 73 23 18\n" +
"\n" +
" 1 14 67 20 48\n" +
"75 51 36 87 73\n" +
"57 84 74 47 19\n" +
"89  8 13 50 24\n" +
"61 12 65 46 83\n" +
"\n" +
"82 87  8  9 85\n" +
"16 22 98 91 55\n" +
"26 69 42 11 93\n" +
"65 15  2 63 43\n" +
"71 37 28 88 12\n" +
"\n" +
"59  7 51  1 43\n" +
"17 45 15 96 93\n" +
"49 88 79 84 92\n" +
"40 36 25 18 22\n" +
"70 57 34 62  6\n" +
"\n" +
" 1 18  5 47 46\n" +
"12 27 24 40  2\n" +
"53 54 20 14 42\n" +
"15 51 26 58  9\n" +
"31 92 34 74  7\n" +
"\n" +
"41 84 14 32  8\n" +
"38  1 60 22 88\n" +
"64 70 10 91 97\n" +
"94 90 65 54 50\n" +
" 7 58 18 87 33\n" +
"\n" +
"93 25 26 71 42\n" +
"86 85 61 32 51\n" +
"20 88 67 35 29\n" +
"46 28 92  9 16\n" +
"34 30 97 91 44\n" +
"\n" +
"34 88 90 99 83\n" +
"22 24  4 25 18\n" +
"51 41 29 53 72\n" +
"75 42 66 98 79\n" +
"74  7  0 73 33\n" +
"\n" +
"99 24 44 83 47\n" +
" 2 21 94 35  4\n" +
"96 87 31  1 22\n" +
"67  3 37 43 46\n" +
"85 55 10  6 80\n" +
"\n" +
" 4 75 29 54 15\n" +
"66 17 89 98 27\n" +
"46  5 64  3 22\n" +
"97 50  0 51 52\n" +
"26 39 30 32 48\n" +
"\n" +
"39 17 46 48 63\n" +
"52 13 98 40 91\n" +
"14 80 28 23 60\n" +
"90 88 15 89 74\n" +
"56  7  2 41 58\n" +
"\n" +
"82 51  6  7 22\n" +
"87  9 60 63 95\n" +
"80  0  5  8 77\n" +
"85  3 68 84 39\n" +
"15 45 31 55 26\n" +
"\n" +
"48 82 38 29 55\n" +
"87 46 79 61 51\n" +
" 1 97 69 91 83\n" +
"35 89 45 59 39\n" +
"43 28 21 44 24\n" +
"\n" +
"71 97 34 43 23\n" +
"44 65 92 90 31\n" +
"74 87 54 79 93\n" +
"55 88 66 12 53\n" +
"14 56 17 52 83\n" +
"\n" +
"91 33 20 59 67\n" +
"71 78 15 94 68\n" +
" 8 90 72 57 36\n" +
"27 40 92  1 44\n" +
"18 80  7 32 19\n" +
"\n" +
"67 20 94 89 10\n" +
"85 78 70 35  0\n" +
"87 66 75 73 23\n" +
"36  8 17 83 21\n" +
"40 52 93 62 96\n" +
"\n" +
" 8 37 66 26 63\n" +
" 7 90 21 18 33\n" +
"31 56 81 77 55\n" +
"34 15 19 27 57\n" +
"13 85  0 59  4\n" +
"\n" +
"67 77 48 26  6\n" +
"31 72 89 76 45\n" +
"66  4  7 43 78\n" +
"15 53 81 85 70\n" +
" 0 10 40 30 94\n" +
"\n" +
"79 37  8 29 27\n" +
"41 14 12 99 28\n" +
"75 40 30 25 77\n" +
"36 78 39 32 11\n" +
"91 58 17 96 51\n" +
"\n" +
"36  8 35 30 51\n" +
"28 61  4 95 67\n" +
"29 69 32 80 48\n" +
"55 63 98 10 22\n" +
"27 87 83 62 21\n" +
"\n" +
"24 36 52 72 16\n" +
"53  1  4 96 37\n" +
"31  7 69 47 57\n" +
"38 97  3 26 59\n" +
"74 14 29 32 40\n" +
"\n" +
" 8 73 68 62 38\n" +
"43 92 15 69 46\n" +
"56 58 48 28 44\n" +
"25 64 13 50 97\n" +
"66 34 21 49 10\n" +
"\n" +
"63 41 71 22 18\n" +
"56 82 95 60 35\n" +
"53 48 79 30 86\n" +
"17 51 57 70 27\n" +
"75 66 42 32 43\n" +
"\n" +
"60 59 40 42 90\n" +
"65 22 43  0 49\n" +
"82 96 29 52 73\n" +
"67 17 20 53 24\n" +
"72  5 91 50 85\n" +
"\n" +
"94 47  2 93 74\n" +
"90 10 27 17  5\n" +
"92 26 28 77 88\n" +
"69 43 33 19 53\n" +
"34 50 54 36 60\n" +
"\n" +
"73 36 90 50 37\n" +
"11 80 81 93 74\n" +
"78 56 86  6 39\n" +
"15 94  7 91 42\n" +
"33  8 64 40 28\n" +
"\n" +
"73 37 57 65  0\n" +
"64 26 52 79 69\n" +
"15 41  3  2  1\n" +
"71 48  8 43 31\n" +
" 5 93 86 42 27\n" +
"\n" +
"59 35 19 17 83\n" +
"15 93 53  2  4\n" +
"26 51 85 71 22\n" +
"31 52 74 12 57\n" +
"70 40 68 39 24\n" +
"\n" +
" 3  6 45 81 20\n" +
"82 30 15 62 80\n" +
"21 70 56 23 32\n" +
"68 19 50 16 14\n" +
"46 89 72 59 40\n" +
"\n" +
"17 27 72 36 12\n" +
"55 30  6 88 69\n" +
"34 91 87 45 82\n" +
"48 15 18 21  7\n" +
"44  4 81 14 93\n" +
"\n" +
"55 84 58 24 53\n" +
"99 44 88 54 37\n" +
" 2 56 57 50 35\n" +
"13 90 26 30 96\n" +
" 7 97 12 19 71\n" +
"\n" +
"31 26 87 54 76\n" +
"68 24 20 27 98\n" +
"53 75 15 95  8\n" +
"63  2 45 50  9\n" +
"49 17 88 55  1\n" +
"\n" +
"91 78 45 26 30\n" +
"63 95 67 60 58\n" +
"34 39 44 20 11\n" +
"38 29 73 22 80\n" +
"56 12 77 37  4\n" +
"\n" +
"24 18 65 21  6\n" +
"76 45 85  2 78\n" +
"67 69 55 91 57\n" +
"96 61 39 36 83\n" +
" 8 54 12 38 70\n" +
"\n" +
"33 71 24 82 84\n" +
"53 32 45  9 34\n" +
"89 28 30 42 96\n" +
"49 95 69 51 12\n" +
"80 41 31 48 75\n" +
"\n" +
"40 60  0 92 13\n" +
"87  9 45 98 77\n" +
"14 91 35  1 95\n" +
"79 39 19 89 51\n" +
"61 56  8 97 32\n" +
"\n" +
"89 70  2 81 34\n" +
"21 59 39 84 64\n" +
"28 94 97 29 30\n" +
"35 27 99 32 55\n" +
"23 47 14 88  0\n" +
"\n" +
"46 14 92 49 94\n" +
"90 80  2 65 30\n" +
"54 32 35 56 27\n" +
"29 55 97 39 37\n" +
"81 72 47 66 42\n" +
"\n" +
"53  1  0 34 82\n" +
"26 28 30 65 41\n" +
"17  4 57 49 40\n" +
"84 46 27 35 91\n" +
"56 38 20 81 86\n" +
"\n" +
"10 31 98 66 22\n" +
"87 99 24 34 93\n" +
" 7 95 28 78 73\n" +
"61 25 14  5  1\n" +
"42 85 16 47 43\n" +
"\n" +
"92 43  9 68 40\n" +
"41 65 18 69 89\n" +
"35 88 62 67 75\n" +
"64  4 17 42 93\n" +
"78 33 94 87 81\n" +
"\n" +
"18 61 10 19 87\n" +
"46 99 55  3 28\n" +
"16 41 45 39 27\n" +
" 8 13 43 64 52\n" +
"23 34 47 11 92\n" +
"\n" +
"21 59 74 36 38\n" +
"81 29 79 80 44\n" +
"84 30 37 62 57\n" +
"69 82 60 10 52\n" +
" 7 55 93 12  0\n" +
"\n" +
"37 23 52  2 94\n" +
"19 96  8 68 29\n" +
"99 57 53  9 48\n" +
"62 11 35 95 98\n" +
"93 72 58 16 36\n" +
"\n" +
"80 53 82 29 76\n" +
"77 17 85 62 81\n" +
"34 92 25 55 20\n" +
"91 39 23 50 31\n" +
"64 37 79 96  2\n" +
"\n" +
"40  5 57 36 14\n" +
"91 53 56 73 27\n" +
"11 55 74  7  9\n" +
"90 58 12 22 26\n" +
"82 38 59 97 85\n" +
"\n" +
"54 79 75  0 30\n" +
" 7 15 26 84 40\n" +
"91 76 42  3 19\n" +
"65 77 53 21 67\n" +
"45 50  2 14 46\n" +
"\n" +
"23 51 40 13 72\n" +
"54 61 59 18 14\n" +
" 0 41  5 24 82\n" +
"73 11 46 36 17\n" +
"16 28 25 60  4\n" +
"\n" +
"85 42 22 54 18\n" +
" 3 27 12 15 99\n" +
"13 26 89 93 76\n" +
"23 87 77 64 25\n" +
" 9 17 74 57 81\n" +
"\n" +
"47 64 85 69 89\n" +
"59 17  4 83 88\n" +
"80 70 53  7 67\n" +
"73 18 81 44 30\n" +
"45 37 90 57  3\n" +
"\n" +
"72 48 35 39 31\n" +
"44 85 91 52 46\n" +
"73 61 68 66 12\n" +
"74 95 76 75 36\n" +
"83 21 15  2 10\n" +
"\n" +
"63 82 95 31 51\n" +
"93  3 53 15 70\n" +
" 0 36 44 19  5\n" +
"11 17 62 55 83\n" +
"80 91  4 18 66\n" +
"\n" +
"44  8 45 90 64\n" +
"30 33  9 27 47\n" +
"68 53 81 77 35\n" +
"63  4 82 80 67\n" +
" 3 28 66 22 43\n" +
"\n" +
"48 86 57 16  7\n" +
"69 51 11  8 61\n" +
"25 12 43 88 71\n" +
"83 36 31 77  5\n" +
"50 21  9 76 63\n" +
"\n" +
"27 39  6 87 49\n" +
"16 66  3 25 10\n" +
" 7 70  8 94 42\n" +
"95 20 55  9 29\n" +
" 0 46 36 79 18\n" +
"\n" +
"27 21 36 14 79\n" +
"23 48 56 74 94\n" +
"18 99 73 93 32\n" +
"98 77 37 35 69\n" +
"43 34 63 59  9\n" +
"\n" +
"27 96 78 94 20\n" +
"34  5 49 84 99\n" +
"68 74 21 57  1\n" +
"93 85 29 47 65\n" +
"54 97 42 70 40\n" +
"\n" +
"29 28 64 26 46\n" +
"39 48 13 51  2\n" +
"42 91 96 93 66\n" +
"12 60 70  8 24\n" +
"18 21 83 56 45\n" +
"\n" +
"64 43 76 40 97\n" +
"30 10 22 84 53\n" +
"51 13 68 93 15\n" +
"75 27 18 39 82\n" +
"62 61 91 12 88\n" +
"\n" +
"72  6 61 10 45\n" +
"65 62 57  2 91\n" +
"30 24 76 42 69\n" +
"32 36 43 63 75\n" +
"92 44 58 82 49\n" +
"\n" +
"30 39 58 75 76\n" +
"62 53 59 70 97\n" +
"29 31 54 27 89\n" +
"90 32 37 86  1\n" +
" 7 34 42 61 91\n" +
"\n" +
"98 94 10 72 26\n" +
"96 78 69 77 44\n" +
"45  5 88 42 73\n" +
"74 91 25 22 99\n" +
"16 79 60 71 37\n" +
"\n" +
"44 33 34 27 87\n" +
"46 89 75 37  4\n" +
"71 63 16 35 17\n" +
"83 99 28 51 97\n" +
"66 86 14 61  9\n" +
"\n" +
" 2 54  7 32 79\n" +
"33 36 37 35 81\n" +
"25 50 84 59 21\n" +
"18 16 48 26 15\n" +
"94 73 61 67 44\n" +
"\n" +
"18 34 66 57 31\n" +
"74 92 71 59 19\n" +
"36 94 16 80 24\n" +
"35 54 58 87 64\n" +
"73 90 41 49 88\n" +
"\n" +
"74  5 57 40 21\n" +
"61 11 50 80 66\n" +
"35 58 52 10 56\n" +
"92 67 82 46 72\n" +
"32 18 33 34 55\n" +
"\n" +
"66 79 27 24 46\n" +
"98  4 30 80 49\n" +
"19 23 68 18 90\n" +
"41 91 83 63 77\n" +
"84 12  8 10 21\n" +
"\n" +
"23 47 58  5 20\n" +
"30 32 61  6 28\n" +
"24 11  8 33 10\n" +
"52 93 95  0 45\n" +
"22 27  3 82 40\n" +
"\n" +
"11 51 47 83 38\n" +
"28 85  9 10 48\n" +
"80 60 46 55 32\n" +
"89 14 90 71 50\n" +
" 0 65 24 40 19\n" +
"\n" +
"12  2 37 62 93\n" +
"78 69 53 43 33\n" +
"85 76 26 21 92\n" +
"36 54 89 46 91\n" +
"29 18 72  9 51\n" +
"\n" +
"82 36 47 95 30\n" +
"65  2 98 92 12\n" +
"93 73 44 48  6\n" +
"31 74 62 27 42\n" +
"32 13 11 99 50\n" +
"\n" +
"89 31 94  1 78\n" +
"77 24 46 64 26\n" +
"11 16 28 30 45\n" +
"80 22  5  8 52\n" +
"32 38 76 65 90\n" +
"\n" +
"92 96 35 86 51\n" +
"47 75 17 87 30\n" +
"43 29 55 50 11\n" +
"77 99 48 24 20\n" +
"37  7 91 23  8\n" +
"\n" +
"26 12 82 95 78\n" +
"41 65 80 53 44\n" +
"75 43 32 46 84\n" +
"63 99 69 45 88\n" +
"56 48 87 38 49\n" +
"\n" +
" 8 87 21 27 15\n" +
"84 44 26 61 82\n" +
"10 66 29 95 65\n" +
" 4 86 38 91 28\n" +
"14 49 22 52 54\n" +
"\n" +
"27 43 13 35 33\n" +
"20 66 77 70 31\n" +
" 5 17 94 98 83\n" +
"11 22 39 55 75\n" +
"53 61 46 38 89\n" +
"\n" +
"84 49 52 32 51\n" +
"90 46 97 91 54\n" +
" 2 42 65 10 25\n" +
"80 77 31 81 16\n" +
"58 17 15 26 55\n" +
"\n" +
"19 83 57 21 95\n" +
" 4 29 11 64  0\n" +
"17 63 13 27 58\n" +
"14 96 43 22 56\n" +
"97 84 81 67 94\n" +
"\n" +
"47 49  4 70 65\n" +
"60 88  9 77  3\n" +
"63 72 33 50 97\n" +
"68 84 98 78 89\n" +
"10 79 25 24 54\n" +
"\n" +
"81 70 39 73 11\n" +
"86 30 38 14 91\n" +
" 9 18 72 21 24\n" +
"54 83 80 78 66\n" +
"23 93 36 31 53\n" +
"\n" +
"34 58 18 69 28\n" +
"57 70 54 50 64\n" +
"35 36  4 56 72\n" +
"32 16 45 33 17\n" +
"83 60 39 22 47\n" +
"\n" +
"31 73 56 21 63\n" +
"66 14 42 45 80\n" +
"60 57 47 36 78\n" +
"93 75 44 22 11\n" +
"68 89 58 88 17\n" +
"\n" +
"74 16 65 13 45\n" +
"86 20  6 34 15\n" +
"70 46 59 75 57\n" +
"28 62 67 71 98\n" +
"77 63 25 61 64\n" +
"\n" +
"71 20 42 65 47\n" +
"29 80 53 78 99\n" +
"70 57 18 45 32\n" +
"86 46 35 77 26\n" +
"15 91 93 55 67\n" +
"\n" +
"27 16 31 41 42\n" +
"77 34 10 90 18\n" +
"28 99 44 20 68\n" +
"98 82  3 75 62\n" +
"88 85 47 17 71\n" +
"\n" +
"31 95 98 60 93\n" +
"80 81 23 35 70\n" +
" 4 57 38 69 76\n" +
"18  0 41 86 54\n" +
"47 26 90 65 39\n" +
"\n" +
"79 86 59 66 50\n" +
"49 64 65 95  6\n" +
"90 67 36 32 46\n" +
"10 20 25 27  1\n" +
"87 21 17 78 13\n" +
"\n" +
"16  8 95 35 43\n" +
"14  0 72 89 68\n" +
"52 11 12 67 25\n" +
"63 64 13 32 15\n" +
"53 98 55 81 75\n" +
"\n" +
"51 85 15 91 10\n" +
"24 68 80 22  8\n" +
"55 18 36 30 66\n" +
"27 21 46 63 26\n" +
"81  5 14  2 13\n" +
"\n" +
"71 39 19 40 69\n" +
"58 70 65 46 78\n" +
"98 14 59 94 60\n" +
"12 55 68 91  0\n" +
"18 35 25 61 86\n" +
"\n" +
"85 74 56 43 44\n" +
"98 78 17 95  8\n" +
"70 30 66 55 94\n" +
"57 62 82 49 77\n" +
"61 32 97 88 58\n" +
"\n" +
"23  1 53 65 30\n" +
"45 15  9 26 28\n" +
" 2 21 42 27 12\n" +
"84 68 71 19 13\n" +
"58 57 35 77 14").split("\n\n");
        String input = "";
        System.out.println("Part one");
        ArrayList<Board> boardsList = new ArrayList<>();
        for(String board : boards){
            boardsList.add(new Board(board));
        }
        CALLS:for(String call : calls){
            for(Board board : boardsList){
                board.call(Integer.parseInt(call));
                if(board.isFinished()){
                    System.out.println(board.getResult());
                    break CALLS;
                }
            }
        }
        System.out.println("Part two");
        boardsList = new ArrayList<>();
        for(String board : boards){
            boardsList.add(new Board(board));
        }
        String result = "";
        CALLS:for(String call : calls){
            for(Iterator<Board> it = boardsList.iterator(); it.hasNext();){
                Board board = it.next();
                board.call(Integer.parseInt(call));
                if(board.isFinished()){
                    result = board.getResult();
                    it.remove();
                }
            }
        }
        System.out.println(result);
    }
    private static class Board{
        public int[][] nums = new int[5][5];
        public boolean[][] called = new boolean[5][5];
        private int lastCalled;
        public Board(String str){
            String[] rows = str.split("\n");
            for(int y = 0; y<rows.length; y++){
                String row = rows[y];
                String[] nums = row.replace("  ", " ").replace("  ", " ").trim().split(" ", 0);
                for(int x = 0; x<nums.length; x++){
                    String num = nums[x];
                    this.nums[x][y] = Integer.parseInt(num);
                }
            }
        }
        private void call(int parseInt){
            lastCalled = parseInt;
            for(int x = 0; x<nums.length; x++){
                int[] num = nums[x];
                for(int y = 0; y<num.length; y++){
                    int i = num[y];
                    if(i==parseInt)called[x][y] = true;
                }
            }
        }
        private boolean isFinished(){
            FOR:for(int x = 0; x<called.length; x++){
                for(int y = 0; y<called.length; y++){
                    if(!called[x][y])continue FOR;
                }
                return true;
            }
            FOR:for(int x = 0; x<called.length; x++){
                for(int y = 0; y<called.length; y++){
                    if(!called[y][x])continue FOR;
                }
                return true;
            }
            return false;
        }
        private String getResult(){
            int sum = 0;
            for(int x = 0; x<nums.length; x++){
                for(int y = 0; y<nums.length; y++){
                    if(!called[x][y])sum+=nums[x][y];
                }
            }
            return (sum*lastCalled)+"";
        }
    }
}