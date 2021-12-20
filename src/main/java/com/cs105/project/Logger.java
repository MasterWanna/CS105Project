package com.cs105.project;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class Logger {

    private static final ArrayList<Record> records;

    static {
        records = new ArrayList<>();
    }

    public static void log(long time, boolean robot_action, boolean robot_forward,
            boolean player_forward, long interact, long robot_score,
            long player_score, double range) {
        records.add(
                new Record(time, robot_action, robot_forward, player_forward, interact, robot_score,
                        player_score, range));
    }

    public static void flush() {
        try (PrintStream out = new PrintStream(new FileOutputStream("player.tsv", true))) {
            for (Record r : records) {
                out.println(r);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
