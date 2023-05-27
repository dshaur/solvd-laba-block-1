package com.solvd.block1.reflection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class SoccerPlayer {

    private static final Logger LOGGER = LogManager.getLogger(SoccerPlayer.class);
    private String name;
    private int age;
    private String position;
    private Map<String, Integer> stats;

    public SoccerPlayer(String name, int age, String position) {
        this.name = name;
        this.age = age;
        this.position = position;
        this.stats = new HashMap<>();
    }

    public void addStat(String category, int value) {
        stats.put(category, value);
    }

    public void getStats() throws Exception {
        Class<?> cls = this.getClass();
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (!field.getName().equals("stats")) {
                LOGGER.info(field.getName() + ": " + field.get(this));
            } else {
                Map<String, Integer> stats = (Map<String, Integer>) field.get(this);
                for (Map.Entry<String, Integer> entry : stats.entrySet()) {
                    LOGGER.info(entry.getKey() + ": " + entry.getValue());
                }
            }
        }
    }

    public static SoccerPlayer createPlayer(String name, int age, String position) throws Exception {
        Class<?> cls = Class.forName("com.solvd.block1.reflection.SoccerPlayer");
        Constructor<?> constructor = cls.getConstructor(String.class, int.class, String.class);
        SoccerPlayer player = (SoccerPlayer) constructor.newInstance(name, age, position);
        return player;
    }

    public void performAction(String actionName, Object... args) throws Exception {
        Class<?> cls = this.getClass();
        Class<?>[] paramTypes = new Class<?>[args.length];
        for (int i = 0; i < args.length; i++) {
            paramTypes[i] = args[i].getClass();
        }
        Method method = cls.getDeclaredMethod(actionName, String.class, int.class);
        method.invoke(this, args);
    }
}
