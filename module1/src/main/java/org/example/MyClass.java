package org.example;

public class MyClass {

    private int privateMember;

    public MyClass(int privateMember) {
        this.privateMember = privateMember;
    }

    public int addOtherMember(MyClass otherClass) {
        return privateMember + otherClass.privateMember;
    }
}
