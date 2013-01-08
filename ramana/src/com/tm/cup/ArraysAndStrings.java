package com.tm.cup;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ArraysAndStrings {
    public static boolean areAllCharactersUnique(String s) {
        Set<Character> characters = new HashSet<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (characters.contains(s.charAt(i)))
                return false;
            characters.add(s.charAt(i));
        }
        return true;
    }

    public static boolean areAllCharactersUniqueWithNoAdditionalDataStructures(String s) {
        for (int i = 0; i < s.length(); i++)
            for (int j = i + 1; j < s.length(); j++)
                if (s.charAt(i) == s.charAt(j))
                    return false;
        return true;
    }

    public static String reverse(String s) {
        if (s == null || s.length() < 1)
            throw new RuntimeException("Check your String");
        int len = s.length() - 1;
        if (s.charAt(len) != (char) 0)
            throw new RuntimeException("Check the last character of your string");
        byte[] b = s.getBytes();
        for (int i = 0; i < len / 2; i++) {
            byte temp = b[i];
            b[i] = b[len - 1 - i];
            b[len - 1 - i] = temp;
        }
        return new String(b);
    }

    public static String removeDuplicates(String s) {
        byte[] b = s.getBytes();
        int shiftBy = 0;
        for (int i = 1; i < b.length; i++) {
            boolean repeat = false;
            for (int j = 0; j < (i - shiftBy); j++)
                if (b[i] == b[j]) {
                    repeat = true;
                    break;
                }
            if (repeat) {
                shiftBy++;
                continue;
            }
            if (shiftBy > 0)
                b[i - shiftBy] = b[i];
        }
        return new String(b, 0, b.length - shiftBy);
    }

    public static boolean areTheyAnagrams(String s, String t) {
        byte[] bs = s.getBytes();
        Arrays.sort(bs);
        byte[] bt = t.getBytes();
        Arrays.sort(bt);
        return Arrays.equals(bs, bt);
    }

    public static String replaceSpacesWithPercent20(String s) {
        int len = s.length();
        char[] c = new char[len * 3];
        int shiftBy = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == ' ') {
                c[i + shiftBy] = '%';
                c[i + shiftBy + 1] = '2';
                c[i + shiftBy + 2] = '0';
                shiftBy += 2;
                continue;
            }
            c[i + shiftBy] = s.charAt(i);
        }
        return new String(c, 0, len + shiftBy);
    }

    public static void rotateMatrix(String[][] a) {
        for (int i = 0; i < a.length; i++)
            for (int j = i + 1; j < a[i].length; j++) {
                String temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
    }

    public static void zeros(int[][] a) {
        Set<Integer> rows = new HashSet<Integer>();
        Set<Integer> columns = new HashSet<Integer>();
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[i].length; j++)
                if (a[i][j] == 0) {
                    rows.add(i);
                    columns.add(j);
                }
        for (Iterator<Integer> i = rows.iterator(); i.hasNext();) {
            int row = i.next();
            for (int j = 0; j < a[row].length; j++)
                a[row][j] = 0;
        }
        for (Iterator<Integer> i = columns.iterator(); i.hasNext();) {
            int column = i.next();
            for (int j = 0; j < a.length; j++)
                a[j][column] = 0;
        }
    }

    public static boolean isRotated(String s1, String s2) {
        return (s1 + s1).indexOf(s2) >= 0;
    }

    public static void main(String[] args) {
        System.out.println(areAllCharactersUnique("asdf"));
        System.out.println(areAllCharactersUnique("asdesf"));
        System.out.println(areAllCharactersUniqueWithNoAdditionalDataStructures("asdf"));
        System.out.println(areAllCharactersUniqueWithNoAdditionalDataStructures("asdesf"));
        byte[] b = new byte[5];
        for (int i = 0; i < 4; i++)
            b[i] = (byte) (65 + i);
        b[4] = (byte) 0;
        System.out.println(reverse(new String(b)));
        System.out.println(removeDuplicates("asssdafdf"));
        System.out.println(areTheyAnagrams("cat", "atc"));
        System.out.println(areTheyAnagrams("cat", "bat"));
        System.out.println(replaceSpacesWithPercent20("Top Monkeys rock!"));
        String[][] s = { { "ants", "bats" }, { "cats", "dogs" } };
        rotateMatrix(s);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++)
                System.out.print(s[i][j] + " ");
            System.out.println();
        }
        int[][] a = { { 1, 0, 3 }, { 0, 0, 6 }, { 7, 8, 9 } };
        zeros(a);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++)
                System.out.print(a[i][j] + " ");
            System.out.println();
        }
        System.out.println(isRotated("waterbottle", "erbottlewat"));
        System.out.println(isRotated("waterbottle", "erbottlewax"));
    }
}
