package com.doutoutdou.adventofcode;

import com.doutoutdou.adventofcode.utils.ExerciceUtils;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

class ExerciseTwoTest {

    @Nested
    class Part1 {
        @Test
        void version1() {
            List<String> loadFromFile = ExerciceUtils.loadFromFile("2");

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
    class Part2 {
        @Test
        void version1() {
            List<String> loadFromFile = ExerciceUtils.loadFromFile("2");

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