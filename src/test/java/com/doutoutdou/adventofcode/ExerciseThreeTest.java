package com.doutoutdou.adventofcode;

import com.doutoutdou.adventofcode.utils.ExerciceUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

@Slf4j
class ExerciseThreeTest {

    /**
     * on calcule la somme totale pour 1 digit
     *
     * @param loadFromFile le fichier d'entrée
     * @param i            le digit à lire pour chaque string
     * @return la somme pour le digit
     */
    private int getSum(List<String> loadFromFile, int i) {
        return loadFromFile.stream().map(s -> Character.getNumericValue(s.charAt(i))).mapToInt(Integer::intValue).sum();
    }

    @Nested
    class Part1 {
        @Test
        void version1() {
            List<String> loadFromFile = ExerciceUtils.loadFromFile("3");
            int size = loadFromFile.size();
            StringBuffer gammaBuffer = new StringBuffer();
            StringBuffer epsilonBuffer = new StringBuffer();

            for (int i = 0; i < 12; i++) {
                int sum = getSum(loadFromFile, i);
                // Si la somme est supérieure à la moitié de la taille alors le bit 1 est le most common bit
                gammaBuffer.append(sum > (size / 2) ? 1 : 0);
                epsilonBuffer.append(sum > (size / 2) ? 0 : 1);
            }
            int gammaRate = Integer.parseInt(gammaBuffer.toString(), 2);
            int epsilonRate = Integer.parseInt(epsilonBuffer.toString(), 2);

            log.info(String.valueOf(gammaRate * epsilonRate));
        }


    }

    @Nested
    class Part2 {
        @Test
        void version1() {
            List<String> loadFromFile = ExerciceUtils.loadFromFile("3");

        }
    }

}