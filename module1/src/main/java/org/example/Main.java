package org.example;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

    }

    public int[] solution(int brown, int yellow) {
        int[] answer = {};

        for (int width = 3; width < 5000; width++) {
            for (int height = 0; height <= width; height++) {
                int brown_calc = (width + height - 2) * 2;
                int yellow_calc = width * height - brown_calc;

                if (brown_calc == brown && yellow_calc == yellow) {
                    return new int[] {
                            width,
                            height
                    };
                }
            }
        }

        return null;
    }
}