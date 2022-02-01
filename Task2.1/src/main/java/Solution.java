package main.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class Solution {
    private static final Map<Character, Character> pairs = Map.of(
        '(', ')',
        '{', '}',
        '[', ']'
    );

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Deque<Bracket> stack = new ArrayDeque<>();
            char[] chars = reader.readLine().toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (pairs.containsKey(chars[i])) {
                    stack.add(new Bracket(chars[i], i + 1));
                } else {
                    if (!pairs.containsValue(chars[i]))
                        continue;
                    if (stack.isEmpty() || !pairs.get(stack.peek().ch).equals(chars[i])) {
                        System.out.println(i + 1);
                        return;
                    } else {
                        stack.pop();
                    }
                }
            }

            System.out.println(stack.isEmpty() ? "SUCCESS" : stack.pop().index);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class Bracket {
        private final char ch;
        private final int index;

        public Bracket(char ch, int index) {
            this.ch = ch;
            this.index = index;
        }


    }
}
