package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String equation = reader.readLine();
        String[] equationArr = equation.split("-");

        int ret = 0;

        for (int i = 0; i < equationArr.length; i++) {
            int sum = 0;

            String[] arr = equationArr[i].split("\\+");
            for (String num : arr) {
                sum += Integer.parseInt(num);
            }
            if (i == 0) {
                ret += sum;
            } else {
                ret -= sum;
            }
        }
        System.out.println(ret);
    }
}