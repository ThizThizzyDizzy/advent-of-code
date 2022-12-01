package aoc2021;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
public class Day3 implements Day{
    @Override
    public void run(){
        String input = "000011110010\n" +
"010000100100\n" +
"010011111111\n" +
"000101001111\n" +
"010100011111\n" +
"111100111011\n" +
"100111011010\n" +
"111001000001\n" +
"100000100110\n" +
"100110011000\n" +
"010101010111\n" +
"001100100001\n" +
"111100111111\n" +
"111010001000\n" +
"101011101110\n" +
"111101001000\n" +
"000000111101\n" +
"001010111011\n" +
"111101100010\n" +
"110001100111\n" +
"110011011011\n" +
"010000000110\n" +
"010111100111\n" +
"111001111000\n" +
"110001101111\n" +
"100010011011\n" +
"100100110001\n" +
"000001100111\n" +
"110001110000\n" +
"010011011010\n" +
"010111110010\n" +
"111100101111\n" +
"000110111101\n" +
"101101101001\n" +
"111110000100\n" +
"001110100100\n" +
"000000110011\n" +
"000001010000\n" +
"010110000011\n" +
"000101010100\n" +
"110010010100\n" +
"001110011011\n" +
"001011110011\n" +
"001011000100\n" +
"111011100101\n" +
"001000011101\n" +
"011110001010\n" +
"100110100111\n" +
"100100101100\n" +
"000101101011\n" +
"001100000110\n" +
"010101000010\n" +
"000111001011\n" +
"100001110100\n" +
"110000110110\n" +
"101001110011\n" +
"010001111001\n" +
"111110111000\n" +
"000110011010\n" +
"101110000001\n" +
"110000100001\n" +
"111001000011\n" +
"000000101001\n" +
"000001100101\n" +
"001101110111\n" +
"001100000001\n" +
"100111100100\n" +
"000111000001\n" +
"000100111011\n" +
"000000110100\n" +
"111100100100\n" +
"001001000000\n" +
"111001100111\n" +
"100101110010\n" +
"011000110101\n" +
"110100110111\n" +
"001001110101\n" +
"110010011100\n" +
"011001011111\n" +
"001010110111\n" +
"110101000111\n" +
"010010011001\n" +
"100010110001\n" +
"101110101011\n" +
"010010011000\n" +
"111001000110\n" +
"001001100001\n" +
"000001110111\n" +
"011100011011\n" +
"101101011001\n" +
"111000011111\n" +
"101001110101\n" +
"100100110000\n" +
"101000001111\n" +
"011001110100\n" +
"001000100101\n" +
"011100111011\n" +
"001100101110\n" +
"111000111111\n" +
"000001100100\n" +
"101010010001\n" +
"101100110001\n" +
"110011001100\n" +
"111000100111\n" +
"000011000111\n" +
"010001000011\n" +
"010111100000\n" +
"111001000101\n" +
"011000001011\n" +
"001111100110\n" +
"101111110011\n" +
"110011000001\n" +
"011011011100\n" +
"011101000011\n" +
"001111100100\n" +
"110010110010\n" +
"110100110110\n" +
"110000001000\n" +
"110010001000\n" +
"101111101010\n" +
"010000001100\n" +
"110010010011\n" +
"110000011000\n" +
"101100011110\n" +
"001010010000\n" +
"011010011101\n" +
"101110100100\n" +
"100010011010\n" +
"011010011000\n" +
"101110000111\n" +
"001010100110\n" +
"100000000101\n" +
"101100100101\n" +
"101001111010\n" +
"011110010111\n" +
"101000111000\n" +
"111111010110\n" +
"000001111000\n" +
"101010111110\n" +
"001101100011\n" +
"001010111100\n" +
"001001100111\n" +
"111010100001\n" +
"100101101100\n" +
"111101110110\n" +
"011010111000\n" +
"110100000001\n" +
"110101000110\n" +
"100000010000\n" +
"111010100011\n" +
"111110001100\n" +
"000001101100\n" +
"000011011000\n" +
"011101000000\n" +
"111011111010\n" +
"110011100001\n" +
"100000111101\n" +
"000101010101\n" +
"000001110100\n" +
"010010000100\n" +
"010110110001\n" +
"101000100110\n" +
"111110010000\n" +
"010100111100\n" +
"101101000100\n" +
"011100001111\n" +
"111000001111\n" +
"111011111100\n" +
"111011001011\n" +
"101000010110\n" +
"100000011111\n" +
"000100010111\n" +
"100010111111\n" +
"010111000111\n" +
"010100111001\n" +
"000000000001\n" +
"110011111000\n" +
"001010001010\n" +
"111100011110\n" +
"011001001011\n" +
"011101101110\n" +
"100100110111\n" +
"011010010101\n" +
"100001111100\n" +
"010010111001\n" +
"101100000100\n" +
"100001000110\n" +
"110101101000\n" +
"001010000100\n" +
"011100111100\n" +
"001110010100\n" +
"001100001100\n" +
"110100100011\n" +
"000111010101\n" +
"100010011111\n" +
"010110110111\n" +
"100111010000\n" +
"001101111100\n" +
"000110011110\n" +
"000100101010\n" +
"101011001010\n" +
"101111010101\n" +
"000001000011\n" +
"111001000010\n" +
"100011100010\n" +
"101000000111\n" +
"111000010111\n" +
"111001110110\n" +
"110000100110\n" +
"111010011001\n" +
"010101110101\n" +
"000111010000\n" +
"011110100110\n" +
"100100010111\n" +
"000110001100\n" +
"001110111110\n" +
"010001001111\n" +
"011011110111\n" +
"110000111011\n" +
"101010110001\n" +
"101101010011\n" +
"100110101001\n" +
"100010010101\n" +
"000011111111\n" +
"010110110110\n" +
"000100110111\n" +
"110101011101\n" +
"111001100001\n" +
"001100110100\n" +
"011001010101\n" +
"100010101110\n" +
"110001011110\n" +
"000100101011\n" +
"101110100010\n" +
"001101000000\n" +
"110111110101\n" +
"110100010110\n" +
"100111000000\n" +
"100001000101\n" +
"001100111011\n" +
"000010001001\n" +
"001101001010\n" +
"101010001101\n" +
"110101101111\n" +
"001101011001\n" +
"110001000001\n" +
"001110100000\n" +
"001010010011\n" +
"100000010010\n" +
"111001101011\n" +
"101011000111\n" +
"001000010011\n" +
"010111111101\n" +
"101111000111\n" +
"010100100101\n" +
"000100000110\n" +
"000010110011\n" +
"000111011110\n" +
"100011110111\n" +
"101010110011\n" +
"011111001110\n" +
"111011110100\n" +
"010011000001\n" +
"000011101110\n" +
"000101010011\n" +
"100011110101\n" +
"001101001111\n" +
"011000010001\n" +
"011010010000\n" +
"001101011110\n" +
"110010010001\n" +
"110111111100\n" +
"010111001100\n" +
"000000111000\n" +
"101100110100\n" +
"110001111000\n" +
"010101110110\n" +
"111000101001\n" +
"110110010011\n" +
"100000101010\n" +
"111101100011\n" +
"000110100110\n" +
"000110100111\n" +
"001111111101\n" +
"001101110010\n" +
"101101100010\n" +
"001110001011\n" +
"101101001111\n" +
"000110100101\n" +
"110010011101\n" +
"001100011100\n" +
"111010101001\n" +
"001111001001\n" +
"010001100101\n" +
"110001101001\n" +
"010110011011\n" +
"110111110110\n" +
"100110001110\n" +
"000011010100\n" +
"110000001011\n" +
"110101110100\n" +
"111110101100\n" +
"111100100110\n" +
"100000100101\n" +
"011011010010\n" +
"011000000000\n" +
"001110001010\n" +
"001011110110\n" +
"111111010101\n" +
"101000011011\n" +
"110001110110\n" +
"001110010011\n" +
"100111111010\n" +
"110110011110\n" +
"000011101010\n" +
"100010011000\n" +
"100100001111\n" +
"111110001101\n" +
"111011111001\n" +
"101010011100\n" +
"001100000000\n" +
"100010000010\n" +
"000001110110\n" +
"010100110111\n" +
"100010100000\n" +
"101001101010\n" +
"100000011010\n" +
"100110111011\n" +
"011100010111\n" +
"100110101101\n" +
"110011010101\n" +
"001011110101\n" +
"001110010000\n" +
"000010101010\n" +
"101110001011\n" +
"011000010011\n" +
"101001011000\n" +
"010101101001\n" +
"000111110010\n" +
"101101111111\n" +
"010000011000\n" +
"110011101011\n" +
"001011101001\n" +
"111000001100\n" +
"101110100110\n" +
"011100101001\n" +
"001101011011\n" +
"011110101001\n" +
"010111101011\n" +
"110010000100\n" +
"001101010000\n" +
"010011011100\n" +
"100000110000\n" +
"111101100110\n" +
"111110110100\n" +
"011101111100\n" +
"110111110100\n" +
"110100010101\n" +
"011110110111\n" +
"011011011000\n" +
"000000100101\n" +
"001001010011\n" +
"101100001101\n" +
"001010101011\n" +
"111100011101\n" +
"100101101110\n" +
"111000001010\n" +
"101010011010\n" +
"010001111101\n" +
"110011001101\n" +
"011000111011\n" +
"000111101001\n" +
"100101100111\n" +
"110111111000\n" +
"110000000010\n" +
"101010111011\n" +
"111001110010\n" +
"011100110101\n" +
"100010111001\n" +
"000110110101\n" +
"010110101110\n" +
"000001101111\n" +
"010110110010\n" +
"100000110001\n" +
"010000001110\n" +
"111100110011\n" +
"011101101111\n" +
"100111000001\n" +
"110000000101\n" +
"100011010111\n" +
"110001001011\n" +
"101111001011\n" +
"111110010011\n" +
"110111111101\n" +
"111111111101\n" +
"011111001010\n" +
"011011001101\n" +
"101111000100\n" +
"111000101111\n" +
"110010000000\n" +
"010010111110\n" +
"110110110110\n" +
"000100001101\n" +
"001010001011\n" +
"001000010100\n" +
"110100001111\n" +
"000101000101\n" +
"111101101111\n" +
"110011111111\n" +
"011010011011\n" +
"100101110111\n" +
"000110000111\n" +
"000100110100\n" +
"110110101010\n" +
"110001110100\n" +
"000001111111\n" +
"011000000111\n" +
"111000100010\n" +
"101000010001\n" +
"011111000010\n" +
"001010001101\n" +
"110010100001\n" +
"100111101000\n" +
"011001101110\n" +
"111100111001\n" +
"111101110011\n" +
"110101110010\n" +
"100100010100\n" +
"011001111111\n" +
"111001011110\n" +
"000010100111\n" +
"100010101000\n" +
"011100111101\n" +
"110111011000\n" +
"010001111110\n" +
"011001001001\n" +
"010000011111\n" +
"011000001001\n" +
"101100000111\n" +
"111110000000\n" +
"110100101111\n" +
"001000100011\n" +
"000011100010\n" +
"011100110001\n" +
"011010000100\n" +
"110110000001\n" +
"100001010101\n" +
"111111111011\n" +
"000001010110\n" +
"010001110111\n" +
"100100111110\n" +
"111111011011\n" +
"101000111110\n" +
"001010011010\n" +
"101010011111\n" +
"111010000011\n" +
"111011011111\n" +
"010100111000\n" +
"010010110111\n" +
"010010100101\n" +
"101100101100\n" +
"010110110100\n" +
"001111001101\n" +
"001101101001\n" +
"110011010100\n" +
"100010100101\n" +
"001001010010\n" +
"000011000010\n" +
"111110000111\n" +
"001011010100\n" +
"100001000100\n" +
"001110001100\n" +
"101001110010\n" +
"100010000100\n" +
"010001010001\n" +
"010100110001\n" +
"111101001011\n" +
"010111000110\n" +
"001110101011\n" +
"000101011100\n" +
"010100101110\n" +
"101111111000\n" +
"011100111110\n" +
"010110111001\n" +
"101101001110\n" +
"001000011000\n" +
"001101100100\n" +
"010111011101\n" +
"101101101111\n" +
"110100110100\n" +
"101110111100\n" +
"110111110001\n" +
"110000100101\n" +
"101111110010\n" +
"010101111100\n" +
"101000100111\n" +
"001010101101\n" +
"100000010011\n" +
"010101010011\n" +
"000011101000\n" +
"011001000000\n" +
"101010110100\n" +
"100101101010\n" +
"100100011000\n" +
"011100110011\n" +
"001010100001\n" +
"010000111000\n" +
"000101100111\n" +
"010001111111\n" +
"000011000110\n" +
"001011011010\n" +
"011101110011\n" +
"101101010100\n" +
"000100000000\n" +
"111101100000\n" +
"001111110000\n" +
"001101111010\n" +
"010110100110\n" +
"111001001111\n" +
"001101110001\n" +
"110110000010\n" +
"001101101000\n" +
"001100100101\n" +
"111101110100\n" +
"000101110001\n" +
"010010111011\n" +
"101000110100\n" +
"100110111001\n" +
"111001010000\n" +
"000011001111\n" +
"101000011101\n" +
"100111111100\n" +
"010111100100\n" +
"101001101011\n" +
"101000101001\n" +
"001010001110\n" +
"111001111101\n" +
"100011001011\n" +
"111101101011\n" +
"110111001100\n" +
"110100111010\n" +
"111101111010\n" +
"100111110011\n" +
"111100010000\n" +
"101110000010\n" +
"001000111000\n" +
"011001110110\n" +
"011001101011\n" +
"110100110001\n" +
"010100110010\n" +
"101000111001\n" +
"010110010110\n" +
"000010000000\n" +
"111100011100\n" +
"001110111111\n" +
"010010100110\n" +
"110001010010\n" +
"110101101010\n" +
"010011111000\n" +
"011101010110\n" +
"100001101100\n" +
"000101100011\n" +
"111100011111\n" +
"010111111111\n" +
"110000101111\n" +
"101110111101\n" +
"110011000100\n" +
"010010000000\n" +
"010100110100\n" +
"101011111101\n" +
"001011001110\n" +
"111000011100\n" +
"010110000100\n" +
"011110001000\n" +
"101010001110\n" +
"111001010111\n" +
"000001101011\n" +
"001010011001\n" +
"110001000000\n" +
"110011100101\n" +
"101000011100\n" +
"001000101001\n" +
"100100100101\n" +
"101010000110\n" +
"110001011111\n" +
"001000110100\n" +
"001000100111\n" +
"110010011001\n" +
"001001111011\n" +
"010101100100\n" +
"010110101101\n" +
"101101000110\n" +
"010011111101\n" +
"000000111111\n" +
"100111111110\n" +
"100101111100\n" +
"110010000001\n" +
"010100010111\n" +
"011110110000\n" +
"111100110001\n" +
"000010101101\n" +
"111111010011\n" +
"110110100000\n" +
"000000010100\n" +
"110000110100\n" +
"111101111111\n" +
"001001100100\n" +
"100000001110\n" +
"011101001000\n" +
"010001101111\n" +
"100101110110\n" +
"101011101101\n" +
"111011110111\n" +
"101110011010\n" +
"000001101110\n" +
"000100011111\n" +
"111111101010\n" +
"000101011101\n" +
"010110001001\n" +
"110001000110\n" +
"110101011110\n" +
"100110100011\n" +
"101100111000\n" +
"011011001110\n" +
"111000110000\n" +
"000110001110\n" +
"100110011110\n" +
"110011101101\n" +
"101100011111\n" +
"011111000101\n" +
"011101000100\n" +
"000111110001\n" +
"011111110011\n" +
"011001100101\n" +
"000100001100\n" +
"100100011101\n" +
"110011101110\n" +
"101000000110\n" +
"000100001111\n" +
"110010101000\n" +
"010110000101\n" +
"110000010010\n" +
"111010111001\n" +
"001001000110\n" +
"001000011010\n" +
"110110001011\n" +
"001101001110\n" +
"111010011100\n" +
"000101010110\n" +
"111111001000\n" +
"001001110000\n" +
"101011100111\n" +
"110101101001\n" +
"101111110110\n" +
"111010001011\n" +
"010100101100\n" +
"010110110000\n" +
"110011010010\n" +
"101010111010\n" +
"010011001101\n" +
"011101000101\n" +
"101111111101\n" +
"110000000100\n" +
"011011011101\n" +
"010101011000\n" +
"000011001101\n" +
"011101110000\n" +
"100111011101\n" +
"001100101001\n" +
"100101100000\n" +
"110010011010\n" +
"101111011001\n" +
"110010111010\n" +
"110001100000\n" +
"100100010110\n" +
"100101010111\n" +
"100110111110\n" +
"010111011000\n" +
"100100101011\n" +
"101010011110\n" +
"110011001011\n" +
"100011101110\n" +
"111000000110\n" +
"010011000100\n" +
"111011100011\n" +
"000000011100\n" +
"101011011000\n" +
"100110001011\n" +
"001011101101\n" +
"000000000010\n" +
"010011001111\n" +
"001001110010\n" +
"111011100100\n" +
"100100010101\n" +
"111110000001\n" +
"011110100101\n" +
"100110000100\n" +
"001011101110\n" +
"100010011110\n" +
"001000110000\n" +
"001100001010\n" +
"011001001110\n" +
"011010011001\n" +
"111110011010\n" +
"001010011111\n" +
"100001100001\n" +
"101011110111\n" +
"111111001110\n" +
"010000000001\n" +
"001011110010\n" +
"111010011111\n" +
"101000110001\n" +
"010011010100\n" +
"000111000011\n" +
"010101001110\n" +
"101000110111\n" +
"011010110001\n" +
"011010100001\n" +
"011010011110\n" +
"000101101101\n" +
"101101100101\n" +
"011101101011\n" +
"000011001001\n" +
"111000111001\n" +
"111100111000\n" +
"000111100111\n" +
"111101111101\n" +
"000101011011\n" +
"011111000100\n" +
"110101000001\n" +
"101000111011\n" +
"110011010001\n" +
"010011110101\n" +
"101000000010\n" +
"010111110101\n" +
"101101101000\n" +
"110111010011\n" +
"000111111110\n" +
"100001110110\n" +
"100110001000\n" +
"110110000101\n" +
"111101100100\n" +
"010001101010\n" +
"111001000100\n" +
"111001010100\n" +
"101110001000\n" +
"010000010110\n" +
"100001100110\n" +
"000110100010\n" +
"111101010010\n" +
"110000001111\n" +
"010001100111\n" +
"001000001010\n" +
"110000011010\n" +
"001011100110\n" +
"100101101101\n" +
"011001011100\n" +
"001100101101\n" +
"011110111001\n" +
"001010001100\n" +
"111011000011\n" +
"100100000111\n" +
"000100001010\n" +
"011100101100\n" +
"001101110100\n" +
"001100011110\n" +
"101010001111\n" +
"000011001011\n" +
"111001010010\n" +
"110000101110\n" +
"000101000011\n" +
"010010000011\n" +
"110010101101\n" +
"010101011011\n" +
"101011110001\n" +
"110111100100\n" +
"111010011010\n" +
"011101010101\n" +
"100001011100\n" +
"011011100010\n" +
"111000010100\n" +
"101011011001\n" +
"101110101100\n" +
"000010011011\n" +
"111110101101\n" +
"100000101100\n" +
"010000101010\n" +
"010011111100\n" +
"110110100001\n" +
"100011001000\n" +
"000001000010\n" +
"101110010110\n" +
"110101111000\n" +
"101001101000\n" +
"000001100000\n" +
"110010011110\n" +
"010111010110\n" +
"111101010101\n" +
"000010111011\n" +
"011110111000\n" +
"010101111010\n" +
"001000000011\n" +
"110001101010\n" +
"111001011010\n" +
"111010110011\n" +
"100001010010\n" +
"001011101111\n" +
"000011101111\n" +
"111011110010\n" +
"000011011001\n" +
"011110101100\n" +
"011001111101\n" +
"011010010111\n" +
"000100100101\n" +
"111100111100\n" +
"010000001001\n" +
"110011110000\n" +
"010010010001\n" +
"000111101000\n" +
"100011001001\n" +
"100111001010\n" +
"011101111011\n" +
"100110011011\n" +
"101011111001\n" +
"111111100011\n" +
"010010111000\n" +
"000001111001\n" +
"010110011001\n" +
"011100001011\n" +
"110001110111\n" +
"001010100111\n" +
"110110100010\n" +
"010111000101\n" +
"100100001100\n" +
"011110101110\n" +
"111110111010\n" +
"000000010011\n" +
"110000101011\n" +
"111010100100\n" +
"011110011000\n" +
"111010110001\n" +
"000010001110\n" +
"000001000111\n" +
"110010101111\n" +
"100001011111\n" +
"111001100100\n" +
"110000000110\n" +
"100011101100\n" +
"101011001001\n" +
"000100101101\n" +
"101101101011\n" +
"001001110100\n" +
"100100111100\n" +
"010010101011\n" +
"011110100000\n" +
"110101100011\n" +
"101101101010\n" +
"100101010110\n" +
"011000100000\n" +
"111000101000\n" +
"011110010110\n" +
"001000010111\n" +
"111010010111\n" +
"111100000111\n" +
"011000100011\n" +
"010000111111\n" +
"011001010111\n" +
"011110011010\n" +
"111111011100\n" +
"011111101101\n" +
"101111011101\n" +
"101100100000\n" +
"111111000000\n" +
"111111111111\n" +
"101011011101\n" +
"000010101100\n" +
"100101001101\n" +
"111111001010\n" +
"010100000000\n" +
"010111001011\n" +
"101110010101\n" +
"000011011100\n" +
"110101011000\n" +
"111001101101\n" +
"000001011101\n" +
"000101011010\n" +
"100110000110\n" +
"111111001111\n" +
"001011111110\n" +
"111010011110\n" +
"000011010110\n" +
"011010111110\n" +
"111110001001\n" +
"100011001110\n" +
"110111001101\n" +
"110100100101\n" +
"101011100110\n" +
"110100000110\n" +
"010011100101\n" +
"001000010110\n" +
"101001100101\n" +
"111111110001\n" +
"100110111000\n" +
"111101001100\n" +
"010001101000\n" +
"011100100101\n" +
"111101010011\n" +
"000110011001\n" +
"010100010100\n" +
"110100100010\n" +
"100101100100\n" +
"100011001101\n" +
"001000100001\n" +
"110100100111\n" +
"111010011011\n" +
"011000010010\n" +
"111001100011\n" +
"001111101011\n" +
"010110111101\n" +
"000001011010\n" +
"100000010110\n" +
"010100011011\n" +
"110000110011\n" +
"111111111010\n" +
"111000100100\n" +
"100100011011\n" +
"000111110110\n" +
"010000000010\n" +
"010111110111\n" +
"100011100001\n" +
"001101000100\n" +
"011111011111\n" +
"000010011111\n" +
"000101011110\n" +
"001100100111\n" +
"101001000100\n" +
"000011011010\n" +
"101101001101\n" +
"010010010110\n" +
"001100001110\n" +
"100101000001\n" +
"111100000101\n" +
"100000111111\n" +
"010111111011\n" +
"101101110110\n" +
"001000010001\n" +
"110111101000\n" +
"110101001111\n" +
"101110000100\n" +
"110001110011\n" +
"010010011010\n" +
"011010101111\n" +
"111110001010\n" +
"110010110000\n" +
"101001000110\n" +
"000010000001\n" +
"001100011111\n" +
"100101000110\n" +
"010101100011\n" +
"000100111100\n" +
"101011010101\n" +
"010001110001\n" +
"001010011110\n" +
"101100001110\n" +
"101111010001\n" +
"000000010000\n" +
"011111001111\n" +
"100011101111\n" +
"001000111100\n" +
"101001011111\n" +
"111111010111\n" +
"001010110110\n" +
"111101101110\n" +
"011000101011\n" +
"111011100110\n" +
"010001001000\n" +
"001010111001\n" +
"111010111011\n" +
"111111110110\n" +
"110110001000\n" +
"001000100010\n" +
"101010101110\n" +
"101010100011\n" +
"100100111101\n" +
"000110010001\n" +
"111110010110\n" +
"000101100001\n" +
"010100100111\n" +
"001101100010\n" +
"110011110111\n" +
"011100110110\n" +
"100101011000\n" +
"011101011111\n" +
"110110000011\n" +
"100010110100\n" +
"011011001000\n" +
"111000101101\n" +
"110100000101\n" +
"011001000001\n" +
"001011000111";
        System.out.println("Part one");
        String[] strs = input.split("\n");
        int[] ones = new int[strs[0].length()];
        int[] zeroes = new int[strs[0].length()];
        for(String s : strs){
            for(int i = 0; i<s.length(); i++){
                if(s.charAt(i)=='0')zeroes[i]++;
                if(s.charAt(i)=='1')ones[i]++;
            }
        }
        String most = "";
        String least = "";
        for(int i = 0; i<ones.length; i++){
            if(ones[i]>zeroes[i]){
                most+="1";
                least+="0";
            }else{
                most+="0";
                least+="1";
            }
        }
        System.out.println(Integer.parseInt(most, 2)*Integer.parseInt(least, 2));
        System.out.println("Part two");
        //oxygen
        List<String> strsLst = new ArrayList<>(Arrays.asList(strs));
        int index = 0;
        while(strsLst.size()>1){
            int numOnes = count(strsLst, index);
            int numZeroes = strsLst.size()-numOnes;
            if(numOnes>=numZeroes){
                //keep ones
                for(Iterator<String> it = strsLst.iterator(); it.hasNext();){
                    String next = it.next();
                    if(next.charAt(index)=='0')it.remove();
                }
            }else{
                //keep zeroes
                for(Iterator<String> it = strsLst.iterator(); it.hasNext();){
                    String next = it.next();
                    if(next.charAt(index)=='1')it.remove();
                }
            }
            index++;
        }
        int ogr = Integer.parseInt(strsLst.get(0), 2);
        //co2
        strsLst = new ArrayList<>(Arrays.asList(strs));
        index = 0;
        while(strsLst.size()>1){
            int numOnes = count(strsLst, index);
            int numZeroes = strsLst.size()-numOnes;
            if(numOnes<numZeroes){
                //keep ones
                for(Iterator<String> it = strsLst.iterator(); it.hasNext();){
                    String next = it.next();
                    if(next.charAt(index)=='0')it.remove();
                }
            }else{
                //keep zeroes
                for(Iterator<String> it = strsLst.iterator(); it.hasNext();){
                    String next = it.next();
                    if(next.charAt(index)=='1')it.remove();
                }
            }
            index++;
        }
        int co2 = Integer.parseInt(strsLst.get(0), 2);
        System.out.println(ogr*co2);
    }
    private int count(List<String> strs, int idx){
        int num = 0;
        for(String s : strs){
            if(s.charAt(idx)=='1')num++;
        }
        return num;
    }
}