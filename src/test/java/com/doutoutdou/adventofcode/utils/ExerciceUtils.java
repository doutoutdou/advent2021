package com.doutoutdou.adventofcode.utils;

import lombok.experimental.UtilityClass;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

@UtilityClass
public class ExerciceUtils {

    public static List<String> loadFromFile(String day) {
        ClassLoader classLoader = ExerciceUtils.class.getClassLoader();
        var file = new File(classLoader.getResource("exercice" + day + ".txt").getFile());
        try {
            return FileUtils.readLines(file, "UTF-8");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
