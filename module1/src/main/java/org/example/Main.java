package org.example;
public class Main {

    public static void main(String[] args) {
        long t = System.currentTimeMillis(); // 현재 시간(밀리초)를 저장

        Long sum = 0L; // 래퍼 객체로 오토 박싱으로 정수 값을 저장

        // 백만번 도는 동안 더하기 연산
        for (long i = 0; i < 1000000; i++) {
            sum += i;
        }

        System.out.println("processing time: " + (System.currentTimeMillis() - t) + " ms") ;
        //processing time: 34 ms


//        long t = System.currentTimeMillis();
//
//        long sum = 0L; // 기본형 정수 타입인 long 자료형에 정수 저장
//
//        for (long i = 0; i < 1000000; i++) {
//            sum += i;
//        }
//
//        System.out.println("processing time: " + (System.currentTimeMillis() - t) + " ms") ;
//        //processing time: 5 ms
    }
}


