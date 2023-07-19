package org.example;

public enum TestEnum {
    me(2),
    you(3);

    int num;

    TestEnum(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }
}
