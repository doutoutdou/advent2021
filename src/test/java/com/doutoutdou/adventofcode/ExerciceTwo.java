package com.doutoutdou.adventofcode;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ExerciceTwo {

    List<String> loadFromFile() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("exercice2.txt").getFile());
        try {
            return FileUtils.readLines(file, "UTF-8");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @Nested
    @DisplayName("Tests pour la partie 1 de lexercice 2")
    class Part1 {
        @Test
        void version1() {
            List<String> loadFromFile = loadFromFile();


            Map<String, Integer> collect1 = loadFromFile.stream().map((t) ->
                            t.split(" ")
            ).collect(Collectors.toMap(strings -> strings[0], strings -> Integer.valueOf(strings[1]), Integer::sum));

            Integer up = collect1.get("down") - collect1.get("up");
            Integer forward = collect1.get("forward");
            Integer total = up * forward;

            System.out.println(total);
        }


    }

    @Nested
    @DisplayName("Tests pour la partie 2 de lexercice 1")
    class Part2 {
        @Test
        void version2() {
            List<String> loadFromFile = loadFromFile();


            List<String[]> list = loadFromFile.stream().map((t) ->
                    t.split(" ")
            ).toList();

            int forward = 0;
            int aim = 0;
            int depth = 0;

            for (String[] e : list) {
                String key = e[0];
                int value = Integer.parseInt(e[1]);

                if (Objects.equals(key, "forward")) {
                    forward = forward + value;
                    depth = aim * value + depth;
                }
                if (Objects.equals(key, "down")) {
                    aim = aim + value;
                }
                if (Objects.equals(key, "up")) {
                    aim = aim - value;
                }

            }

            System.out.println(forward);
            System.out.println(depth);
            System.out.println(depth * forward);
        }

    }

}