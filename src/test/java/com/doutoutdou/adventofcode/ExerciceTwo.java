package com.doutoutdou.adventofcode;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
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
    @DisplayName("Tests pour la partie 1 de lexercice 1")
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

}