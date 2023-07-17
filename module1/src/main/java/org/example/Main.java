package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String eq = br.readLine();
        String[] equationArr = eq.split("-");

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