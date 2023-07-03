package org.example;
public class Main {

    public static void main(String[] args) {
        MyClass A = new MyClass(6);
        MyClass B = new MyClass(4);

        System.out.println(A.addOtherMember(B));//결과 : 10
    }
}


