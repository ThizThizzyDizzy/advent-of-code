package com.thizthizzydizzy.aoc2021;
public class Day2 implements Day{
    @Override
    public void run(){
        String input = "forward 6\n" +
"forward 8\n" +
"down 6\n" +
"down 6\n" +
"forward 9\n" +
"down 7\n" +
"down 3\n" +
"forward 4\n" +
"forward 7\n" +
"up 3\n" +
"forward 9\n" +
"up 4\n" +
"forward 4\n" +
"down 3\n" +
"up 2\n" +
"forward 2\n" +
"down 4\n" +
"forward 9\n" +
"up 4\n" +
"forward 8\n" +
"up 9\n" +
"forward 3\n" +
"down 7\n" +
"down 4\n" +
"down 7\n" +
"up 5\n" +
"down 5\n" +
"down 5\n" +
"forward 5\n" +
"up 9\n" +
"down 5\n" +
"down 3\n" +
"up 3\n" +
"forward 2\n" +
"forward 2\n" +
"down 2\n" +
"forward 1\n" +
"down 4\n" +
"down 1\n" +
"down 6\n" +
"down 9\n" +
"forward 4\n" +
"forward 7\n" +
"down 4\n" +
"up 7\n" +
"forward 8\n" +
"down 3\n" +
"down 6\n" +
"down 5\n" +
"down 2\n" +
"down 1\n" +
"up 9\n" +
"forward 2\n" +
"forward 3\n" +
"up 3\n" +
"forward 5\n" +
"down 4\n" +
"up 3\n" +
"up 9\n" +
"forward 6\n" +
"up 5\n" +
"up 8\n" +
"up 8\n" +
"forward 6\n" +
"up 1\n" +
"forward 4\n" +
"down 4\n" +
"forward 9\n" +
"down 9\n" +
"down 7\n" +
"forward 5\n" +
"down 7\n" +
"forward 7\n" +
"up 2\n" +
"down 9\n" +
"down 2\n" +
"forward 8\n" +
"forward 9\n" +
"down 4\n" +
"down 4\n" +
"down 7\n" +
"down 4\n" +
"down 8\n" +
"forward 4\n" +
"down 9\n" +
"down 6\n" +
"forward 8\n" +
"down 8\n" +
"down 8\n" +
"forward 7\n" +
"up 9\n" +
"forward 7\n" +
"up 3\n" +
"down 5\n" +
"forward 9\n" +
"down 7\n" +
"down 5\n" +
"down 8\n" +
"forward 5\n" +
"down 1\n" +
"down 5\n" +
"down 5\n" +
"forward 8\n" +
"down 8\n" +
"up 8\n" +
"down 6\n" +
"down 3\n" +
"forward 1\n" +
"down 2\n" +
"down 3\n" +
"up 4\n" +
"forward 8\n" +
"down 6\n" +
"up 8\n" +
"forward 2\n" +
"forward 8\n" +
"forward 9\n" +
"forward 5\n" +
"forward 5\n" +
"forward 2\n" +
"forward 1\n" +
"down 8\n" +
"forward 8\n" +
"forward 9\n" +
"up 8\n" +
"up 8\n" +
"down 7\n" +
"down 5\n" +
"forward 1\n" +
"forward 1\n" +
"up 9\n" +
"up 3\n" +
"forward 5\n" +
"down 8\n" +
"down 4\n" +
"up 2\n" +
"down 7\n" +
"down 4\n" +
"down 3\n" +
"forward 3\n" +
"forward 7\n" +
"forward 3\n" +
"forward 1\n" +
"forward 8\n" +
"down 9\n" +
"up 4\n" +
"down 8\n" +
"down 3\n" +
"down 9\n" +
"up 8\n" +
"up 6\n" +
"up 9\n" +
"up 2\n" +
"down 9\n" +
"down 9\n" +
"down 6\n" +
"up 3\n" +
"down 4\n" +
"down 3\n" +
"down 9\n" +
"forward 2\n" +
"forward 2\n" +
"forward 7\n" +
"forward 9\n" +
"up 5\n" +
"up 8\n" +
"forward 8\n" +
"down 8\n" +
"up 7\n" +
"forward 4\n" +
"up 7\n" +
"up 7\n" +
"down 9\n" +
"down 7\n" +
"down 1\n" +
"forward 4\n" +
"forward 6\n" +
"up 4\n" +
"forward 7\n" +
"up 4\n" +
"down 6\n" +
"forward 2\n" +
"up 4\n" +
"forward 2\n" +
"up 2\n" +
"down 4\n" +
"down 2\n" +
"forward 4\n" +
"forward 8\n" +
"down 9\n" +
"up 7\n" +
"forward 3\n" +
"down 5\n" +
"down 2\n" +
"down 7\n" +
"up 9\n" +
"down 2\n" +
"up 5\n" +
"down 9\n" +
"down 4\n" +
"forward 8\n" +
"forward 9\n" +
"down 7\n" +
"up 3\n" +
"down 4\n" +
"up 3\n" +
"down 3\n" +
"down 3\n" +
"up 5\n" +
"forward 7\n" +
"down 8\n" +
"down 1\n" +
"up 7\n" +
"forward 8\n" +
"forward 9\n" +
"forward 3\n" +
"forward 1\n" +
"up 4\n" +
"forward 4\n" +
"down 6\n" +
"forward 3\n" +
"down 9\n" +
"forward 2\n" +
"up 8\n" +
"down 4\n" +
"forward 7\n" +
"forward 1\n" +
"up 9\n" +
"forward 6\n" +
"down 1\n" +
"down 8\n" +
"forward 7\n" +
"forward 8\n" +
"forward 2\n" +
"up 6\n" +
"forward 3\n" +
"forward 2\n" +
"forward 7\n" +
"down 6\n" +
"up 8\n" +
"down 2\n" +
"down 8\n" +
"forward 6\n" +
"forward 1\n" +
"up 9\n" +
"down 8\n" +
"down 4\n" +
"forward 3\n" +
"down 2\n" +
"forward 1\n" +
"forward 8\n" +
"down 9\n" +
"down 9\n" +
"forward 3\n" +
"down 5\n" +
"down 5\n" +
"down 1\n" +
"down 3\n" +
"up 3\n" +
"down 6\n" +
"forward 9\n" +
"forward 7\n" +
"up 5\n" +
"forward 8\n" +
"up 1\n" +
"up 4\n" +
"down 8\n" +
"up 3\n" +
"forward 1\n" +
"up 9\n" +
"forward 5\n" +
"down 8\n" +
"down 1\n" +
"up 3\n" +
"down 1\n" +
"down 7\n" +
"forward 2\n" +
"down 9\n" +
"forward 3\n" +
"down 2\n" +
"up 5\n" +
"down 5\n" +
"forward 9\n" +
"down 2\n" +
"down 3\n" +
"forward 4\n" +
"forward 2\n" +
"down 5\n" +
"forward 9\n" +
"down 5\n" +
"forward 9\n" +
"down 9\n" +
"down 8\n" +
"forward 8\n" +
"forward 9\n" +
"down 2\n" +
"forward 4\n" +
"forward 9\n" +
"up 1\n" +
"down 2\n" +
"down 5\n" +
"forward 8\n" +
"forward 5\n" +
"up 5\n" +
"forward 2\n" +
"up 8\n" +
"forward 3\n" +
"down 2\n" +
"forward 1\n" +
"forward 7\n" +
"forward 7\n" +
"forward 1\n" +
"up 9\n" +
"down 5\n" +
"down 3\n" +
"down 7\n" +
"forward 2\n" +
"up 5\n" +
"forward 1\n" +
"forward 7\n" +
"up 7\n" +
"down 3\n" +
"up 5\n" +
"down 1\n" +
"forward 9\n" +
"down 7\n" +
"forward 4\n" +
"forward 5\n" +
"down 1\n" +
"down 5\n" +
"up 7\n" +
"forward 1\n" +
"down 4\n" +
"down 8\n" +
"down 6\n" +
"forward 8\n" +
"forward 4\n" +
"forward 2\n" +
"up 8\n" +
"down 5\n" +
"down 2\n" +
"forward 2\n" +
"down 1\n" +
"down 8\n" +
"down 5\n" +
"forward 5\n" +
"forward 8\n" +
"down 9\n" +
"forward 1\n" +
"forward 3\n" +
"down 3\n" +
"down 1\n" +
"down 5\n" +
"forward 6\n" +
"forward 6\n" +
"down 3\n" +
"forward 5\n" +
"forward 8\n" +
"down 9\n" +
"down 9\n" +
"forward 4\n" +
"forward 4\n" +
"forward 1\n" +
"forward 7\n" +
"down 6\n" +
"up 2\n" +
"down 2\n" +
"up 6\n" +
"forward 7\n" +
"forward 8\n" +
"up 3\n" +
"down 7\n" +
"up 9\n" +
"down 5\n" +
"down 7\n" +
"down 7\n" +
"forward 3\n" +
"down 3\n" +
"up 9\n" +
"up 5\n" +
"forward 4\n" +
"down 7\n" +
"down 7\n" +
"forward 1\n" +
"down 1\n" +
"down 2\n" +
"forward 8\n" +
"down 9\n" +
"down 2\n" +
"forward 3\n" +
"forward 5\n" +
"down 4\n" +
"up 7\n" +
"forward 1\n" +
"forward 4\n" +
"forward 7\n" +
"forward 1\n" +
"up 1\n" +
"down 6\n" +
"forward 2\n" +
"down 1\n" +
"forward 2\n" +
"forward 7\n" +
"forward 7\n" +
"up 3\n" +
"down 8\n" +
"forward 6\n" +
"forward 1\n" +
"down 6\n" +
"down 8\n" +
"down 1\n" +
"up 3\n" +
"up 6\n" +
"down 6\n" +
"down 1\n" +
"up 8\n" +
"forward 6\n" +
"up 6\n" +
"forward 5\n" +
"up 4\n" +
"up 7\n" +
"up 4\n" +
"down 5\n" +
"forward 2\n" +
"forward 7\n" +
"down 1\n" +
"forward 6\n" +
"down 5\n" +
"up 3\n" +
"up 4\n" +
"forward 1\n" +
"up 4\n" +
"forward 7\n" +
"up 5\n" +
"up 1\n" +
"up 2\n" +
"forward 4\n" +
"forward 2\n" +
"forward 7\n" +
"down 6\n" +
"forward 1\n" +
"up 5\n" +
"up 2\n" +
"down 8\n" +
"forward 5\n" +
"up 2\n" +
"down 9\n" +
"up 4\n" +
"down 2\n" +
"down 1\n" +
"forward 8\n" +
"down 2\n" +
"up 8\n" +
"down 8\n" +
"up 7\n" +
"up 4\n" +
"up 2\n" +
"forward 8\n" +
"up 1\n" +
"up 6\n" +
"forward 8\n" +
"forward 8\n" +
"forward 2\n" +
"down 5\n" +
"up 2\n" +
"down 1\n" +
"forward 2\n" +
"up 5\n" +
"forward 4\n" +
"forward 9\n" +
"down 1\n" +
"down 6\n" +
"forward 4\n" +
"down 3\n" +
"down 7\n" +
"down 5\n" +
"down 6\n" +
"up 6\n" +
"forward 4\n" +
"down 2\n" +
"down 4\n" +
"down 3\n" +
"forward 3\n" +
"forward 2\n" +
"up 7\n" +
"forward 7\n" +
"forward 6\n" +
"forward 3\n" +
"forward 1\n" +
"forward 8\n" +
"forward 3\n" +
"forward 2\n" +
"forward 3\n" +
"forward 9\n" +
"down 3\n" +
"forward 9\n" +
"up 9\n" +
"up 1\n" +
"down 8\n" +
"down 2\n" +
"up 9\n" +
"down 8\n" +
"forward 5\n" +
"down 8\n" +
"up 8\n" +
"down 3\n" +
"up 7\n" +
"down 3\n" +
"down 7\n" +
"up 9\n" +
"up 8\n" +
"down 5\n" +
"down 1\n" +
"forward 1\n" +
"down 9\n" +
"forward 5\n" +
"down 1\n" +
"forward 5\n" +
"forward 6\n" +
"up 2\n" +
"forward 5\n" +
"down 2\n" +
"up 3\n" +
"forward 8\n" +
"forward 9\n" +
"down 1\n" +
"up 9\n" +
"forward 6\n" +
"down 9\n" +
"down 2\n" +
"forward 2\n" +
"forward 4\n" +
"forward 9\n" +
"forward 3\n" +
"down 6\n" +
"down 9\n" +
"forward 8\n" +
"forward 3\n" +
"down 9\n" +
"up 6\n" +
"forward 5\n" +
"forward 8\n" +
"down 7\n" +
"forward 9\n" +
"forward 5\n" +
"forward 4\n" +
"forward 3\n" +
"down 9\n" +
"forward 7\n" +
"forward 7\n" +
"forward 8\n" +
"down 7\n" +
"down 3\n" +
"up 5\n" +
"forward 2\n" +
"up 6\n" +
"down 6\n" +
"down 5\n" +
"up 2\n" +
"down 1\n" +
"forward 7\n" +
"forward 3\n" +
"down 2\n" +
"up 4\n" +
"forward 8\n" +
"down 8\n" +
"down 2\n" +
"forward 8\n" +
"up 8\n" +
"forward 1\n" +
"forward 1\n" +
"down 1\n" +
"forward 4\n" +
"forward 7\n" +
"forward 2\n" +
"forward 6\n" +
"down 9\n" +
"down 2\n" +
"up 7\n" +
"up 5\n" +
"forward 4\n" +
"down 3\n" +
"down 4\n" +
"up 7\n" +
"forward 7\n" +
"up 6\n" +
"forward 6\n" +
"up 4\n" +
"forward 5\n" +
"forward 7\n" +
"forward 3\n" +
"down 2\n" +
"forward 2\n" +
"forward 2\n" +
"up 1\n" +
"down 8\n" +
"up 7\n" +
"down 4\n" +
"down 9\n" +
"forward 2\n" +
"forward 9\n" +
"down 7\n" +
"down 4\n" +
"down 8\n" +
"forward 9\n" +
"up 1\n" +
"forward 6\n" +
"forward 7\n" +
"down 3\n" +
"forward 9\n" +
"forward 3\n" +
"down 3\n" +
"up 2\n" +
"down 8\n" +
"down 7\n" +
"forward 1\n" +
"down 9\n" +
"up 3\n" +
"forward 6\n" +
"forward 1\n" +
"forward 7\n" +
"down 3\n" +
"forward 2\n" +
"forward 1\n" +
"down 8\n" +
"down 7\n" +
"forward 1\n" +
"forward 5\n" +
"down 7\n" +
"up 7\n" +
"forward 4\n" +
"down 3\n" +
"forward 7\n" +
"forward 2\n" +
"up 2\n" +
"forward 1\n" +
"up 2\n" +
"up 6\n" +
"forward 3\n" +
"forward 2\n" +
"down 3\n" +
"down 7\n" +
"down 2\n" +
"down 9\n" +
"down 6\n" +
"forward 8\n" +
"down 4\n" +
"forward 6\n" +
"up 7\n" +
"down 8\n" +
"up 5\n" +
"down 8\n" +
"up 6\n" +
"down 2\n" +
"down 1\n" +
"forward 9\n" +
"forward 8\n" +
"down 6\n" +
"down 3\n" +
"up 8\n" +
"down 1\n" +
"forward 2\n" +
"down 6\n" +
"forward 4\n" +
"forward 9\n" +
"forward 6\n" +
"down 2\n" +
"down 9\n" +
"up 3\n" +
"forward 8\n" +
"forward 1\n" +
"forward 6\n" +
"forward 8\n" +
"forward 4\n" +
"forward 8\n" +
"up 7\n" +
"down 7\n" +
"forward 7\n" +
"down 6\n" +
"forward 1\n" +
"down 9\n" +
"forward 5\n" +
"down 3\n" +
"down 6\n" +
"down 6\n" +
"down 9\n" +
"forward 8\n" +
"forward 5\n" +
"down 4\n" +
"forward 1\n" +
"down 8\n" +
"down 5\n" +
"down 5\n" +
"down 9\n" +
"forward 1\n" +
"forward 1\n" +
"forward 9\n" +
"forward 5\n" +
"down 4\n" +
"forward 3\n" +
"down 2\n" +
"forward 3\n" +
"up 7\n" +
"down 2\n" +
"down 5\n" +
"down 4\n" +
"up 2\n" +
"forward 7\n" +
"down 3\n" +
"down 4\n" +
"down 8\n" +
"down 2\n" +
"forward 3\n" +
"up 8\n" +
"down 9\n" +
"down 1\n" +
"down 2\n" +
"forward 3\n" +
"down 1\n" +
"down 7\n" +
"down 9\n" +
"forward 9\n" +
"forward 7\n" +
"down 2\n" +
"down 5\n" +
"up 8\n" +
"forward 1\n" +
"forward 2\n" +
"forward 6\n" +
"up 3\n" +
"forward 3\n" +
"down 6\n" +
"forward 1\n" +
"up 8\n" +
"down 3\n" +
"down 1\n" +
"forward 6\n" +
"up 7\n" +
"forward 3\n" +
"down 5\n" +
"down 5\n" +
"up 8\n" +
"down 4\n" +
"forward 1\n" +
"up 5\n" +
"down 4\n" +
"forward 5\n" +
"up 6\n" +
"forward 2\n" +
"up 4\n" +
"forward 9\n" +
"forward 1\n" +
"forward 9\n" +
"forward 5\n" +
"forward 9\n" +
"up 2\n" +
"forward 8\n" +
"forward 6\n" +
"down 5\n" +
"forward 9\n" +
"forward 7\n" +
"down 1\n" +
"forward 7\n" +
"forward 7\n" +
"forward 3\n" +
"up 9\n" +
"down 2\n" +
"up 7\n" +
"down 1\n" +
"up 7\n" +
"forward 6\n" +
"forward 2\n" +
"forward 5\n" +
"forward 6\n" +
"down 4\n" +
"down 8\n" +
"forward 6\n" +
"down 1\n" +
"forward 7\n" +
"up 8\n" +
"forward 7\n" +
"up 5\n" +
"down 2\n" +
"forward 9\n" +
"forward 7\n" +
"forward 8\n" +
"up 2\n" +
"down 9\n" +
"forward 5\n" +
"forward 8\n" +
"forward 5\n" +
"forward 7\n" +
"down 8\n" +
"down 8\n" +
"up 4\n" +
"down 8\n" +
"up 2\n" +
"up 6\n" +
"down 2\n" +
"forward 2\n" +
"forward 9\n" +
"forward 8\n" +
"forward 3\n" +
"up 3\n" +
"up 1\n" +
"down 3\n" +
"forward 7\n" +
"down 2\n" +
"up 2\n" +
"forward 5\n" +
"down 3\n" +
"forward 2\n" +
"forward 4\n" +
"up 2\n" +
"down 1\n" +
"down 5\n" +
"up 6\n" +
"down 7\n" +
"up 7\n" +
"up 6\n" +
"forward 5\n" +
"down 7\n" +
"forward 9\n" +
"forward 2\n" +
"up 8\n" +
"down 1\n" +
"down 6\n" +
"forward 9\n" +
"down 8\n" +
"up 7\n" +
"down 6\n" +
"forward 9\n" +
"forward 2\n" +
"down 1\n" +
"up 4\n" +
"up 7\n" +
"down 7\n" +
"up 6\n" +
"forward 4\n" +
"up 1\n" +
"forward 5\n" +
"forward 9\n" +
"down 3\n" +
"up 2\n" +
"down 3\n" +
"up 7\n" +
"down 8\n" +
"forward 1\n" +
"down 9\n" +
"down 1\n" +
"down 9\n" +
"forward 8\n" +
"down 4\n" +
"down 7\n" +
"down 7\n" +
"forward 4\n" +
"up 5\n" +
"forward 1\n" +
"forward 7\n" +
"down 9\n" +
"forward 6\n" +
"up 8\n" +
"down 5\n" +
"down 8\n" +
"up 9\n" +
"forward 6\n" +
"down 1\n" +
"forward 8\n" +
"up 8\n" +
"up 1\n" +
"up 7\n" +
"down 9\n" +
"forward 8\n" +
"down 8\n" +
"forward 4\n" +
"down 1\n" +
"down 5\n" +
"forward 9\n" +
"down 7\n" +
"forward 3\n" +
"forward 1\n" +
"forward 2\n" +
"down 9\n" +
"up 2\n" +
"up 1\n" +
"forward 6\n" +
"up 1\n" +
"down 3\n" +
"forward 3\n" +
"down 7\n" +
"down 4\n" +
"forward 2\n" +
"forward 8\n" +
"forward 7\n" +
"down 6\n" +
"up 1\n" +
"forward 8\n" +
"down 8\n" +
"forward 5\n" +
"down 4\n" +
"forward 2\n" +
"up 8\n" +
"down 5\n" +
"down 9\n" +
"forward 1\n" +
"down 8\n" +
"down 5\n" +
"forward 6\n" +
"down 1\n" +
"down 6\n" +
"up 5\n" +
"up 8\n" +
"forward 7\n" +
"forward 4\n" +
"down 5\n" +
"down 1\n" +
"forward 4\n" +
"up 9\n" +
"forward 9\n" +
"up 7\n" +
"down 4\n" +
"forward 8\n" +
"forward 5\n" +
"up 8\n" +
"down 9\n" +
"up 8\n" +
"forward 7\n" +
"down 8\n" +
"forward 4\n" +
"down 8\n" +
"up 7\n" +
"forward 4\n" +
"down 9\n" +
"forward 5\n" +
"up 7\n" +
"forward 5\n" +
"forward 9\n" +
"down 6\n" +
"up 6\n" +
"forward 2\n" +
"down 4\n" +
"down 8\n" +
"forward 9\n" +
"forward 4\n" +
"forward 6\n" +
"up 6\n" +
"down 6\n" +
"forward 6\n" +
"forward 7\n" +
"forward 5\n" +
"forward 3\n" +
"forward 7\n" +
"up 3\n" +
"down 6\n" +
"forward 2\n" +
"down 9\n" +
"up 8\n" +
"down 2\n" +
"forward 7\n" +
"down 9\n" +
"down 3\n" +
"up 9\n" +
"up 6\n" +
"down 6\n" +
"forward 8\n" +
"up 2\n" +
"up 1\n" +
"down 5\n" +
"forward 4\n" +
"down 2\n" +
"up 2\n" +
"forward 2\n" +
"forward 3\n" +
"up 5\n" +
"down 6\n" +
"forward 9\n" +
"up 3\n" +
"forward 6\n" +
"forward 4\n" +
"down 3\n" +
"up 9\n" +
"forward 1\n" +
"up 6\n" +
"down 9\n" +
"down 7\n" +
"forward 5\n" +
"down 2\n" +
"down 6\n" +
"forward 5\n" +
"forward 1\n" +
"forward 5\n" +
"forward 8\n" +
"up 2\n" +
"forward 9\n" +
"down 8\n" +
"forward 2\n" +
"down 6\n" +
"down 1\n" +
"down 9\n" +
"forward 6";
        System.out.println("Part one");
        int pos = 0, depth = 0;
        String[] commands = input.split("\n");
        for(String s : commands){
            String[] args = s.split(" ");
            int val = Integer.parseInt(args[1]);
            switch(args[0]){
                case "forward":
                    pos+=val;
                    break;
                case "up":
                    depth-=val;
                    break;
                case "down":
                    depth+=val;
                    break;
            }
        }
        System.out.println(pos*depth);
        System.out.println("Part two");
        pos = depth = 0;
        int aim = 0;
        for(String s : commands){
            String[] args = s.split(" ");
            int val = Integer.parseInt(args[1]);
            switch(args[0]){
                case "forward":
                    pos+=val;
                    depth+=val*aim;
                    break;
                case "up":
                    aim-=val;
                    break;
                case "down":
                    aim+=val;
                    break;
            }
        }
        System.out.println(pos*depth);
    }
}