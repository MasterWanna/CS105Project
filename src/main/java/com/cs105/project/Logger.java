package com.cs105.project;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class Logger {

    private static ArrayList<Record> records;

    static {
        records = new ArrayList<>();
    }

    static class Record {
        final long[] log;

        static long convert(boolean val) {
            return val ? 1 : 0;
        }

        public Record(long time, boolean robot_action, boolean robot_forward, boolean player_forward,
                long interact, long robot_score, long player_score) {
            this(time, convert(robot_action), convert(robot_forward), convert(player_forward),
                    interact, robot_score, player_score);
        }

        private Record(long... log) {
            this.log = log;
        }

        @Override
        public String toString() {
            StringBuilder str = new StringBuilder();
            for (long item : log) {
                str.append(item).append("\t");
            }
            return str.toString();
        }
    }

    public static void log(long time, boolean robot_action, boolean robot_forward,
            boolean player_forward, long interact, long robot_score,
            long player_score) {
        records.add(
                new Record(time, robot_action, robot_forward, player_forward, interact, robot_score,
                        player_score));
    }

    public static void flush() {
        try (PrintStream out = new PrintStream(new FileOutputStream("player.log", true))) {
            for (Record r : records) {
                out.println(r);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
