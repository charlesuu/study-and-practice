package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MyCollection<String> myCollection = new MyCollection<>(Arrays.asList("현호", "하하", "호호"));

        myCollection.foreach(d -> System.out.println(d));
    }
}


