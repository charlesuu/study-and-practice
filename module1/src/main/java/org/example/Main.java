package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args){
        int ordinal = TestEnum.me.ordinal();
        int num = TestEnum.me.getNum();

        System.out.println("컴파일러가 선언한 ordinal :     " + ordinal);
        System.out.println("우리가 선언한 num :      " + num);
    }
}