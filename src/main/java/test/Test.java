package test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String decodeString = solution.decodeString("3[a]2[bc]");
        System.out.println(decodeString);

        Supplier<String> supplier= new Supplier<String>() {
            @Override
            public String get() {
                return "sibilbildv";
            }
        };

        Stream<String> generate = Stream.generate(() -> "sibilbildv");
        generate.forEach(System.out::println);
    }
}

class Solution {
    public String decodeString(String s) {

        Stack<Character> stack = new Stack<>();

        StringBuilder temp = new StringBuilder();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ']') {
                StringBuilder str = new StringBuilder();
                while (stack.peek() != '[') {
                    str.append(stack.pop());
                }
                stack.pop();
                str.reverse();
                str.append(temp);
                StringBuilder currentString = new StringBuilder();
                int count = Character.getNumericValue(stack.pop());
                for (int j = 0; j < count; j++) {
                    currentString.append(str);
                }
                result.append(currentString);
                if (!stack.empty()) {
                    temp = currentString;
                }
            } else {
                stack.push(c);
            }
        }

        return result.toString();
    }
}