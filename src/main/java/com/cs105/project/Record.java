package com.cs105.project;

import java.util.List;

public class Record {
    final List<Object> log;

    static long convert(boolean val) {
        return val ? 1 : 0;
    }

    public Record(long time, boolean robot_action, boolean robot_forward, boolean player_forward,
                  long interact, long robot_score, long player_score, double range) {
        this(time, convert(robot_action), convert(robot_forward), convert(player_forward),
            interact, robot_score, player_score, range);
    }

    private Record(Object... log) {
        this.log = List.of(log);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Object item : log) {
            str.append(item).append("\t");
        }
        return str.toString();
    }
}
