package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final BufferedReader READER = new BufferedReader(
        new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        long[] inputParams = Arrays.stream(READER.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long[] inputValues = Arrays.stream(READER.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        int n = (int) inputParams[0];
        PriorityQueue<Thread> sortedThreads = new PriorityQueue<>(n, (o1, o2) -> {
            if (o1.countTicks == o2.countTicks)
                return o1.number > o2.number ? 1 : -1;
            return o1.countTicks > o2.countTicks ? 1 : -1;
        });

        for (long i = 0; i < n; i++) {
            sortedThreads.add(new Thread(i, 0));
        }


        Thread thread;
        for (long value : inputValues) {
            thread = sortedThreads.poll();
            System.out.println(thread.toString());
            thread.countTicks += value;
            sortedThreads.add(thread);

        }
    }


    static class Thread {
        private final long number;
        private long countTicks;

        Thread(long number, long countTicks) {
            this.number = number;
            this.countTicks = countTicks;
        }

        @Override
        public String toString() {
            return number + " " + countTicks;
        }
    }
}
