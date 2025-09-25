package com.example.learnofannocation.demos.web;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Test05 extends Object{
    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Student();
        System.out.println(person.name);

        Class c1=  person.getClass();

        Class c2 = Class.forName("com.example.learnofannocation.demos.web.Student");

        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());

        Class c3 = Student.class;
        System.out.println(c3.hashCode());
    }


}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Person {
     String name;
}

class Student extends Person {
    public Student() {
        this.name="学生";
    }
}


class Teacher extends Person {
    public Teacher() {
        this.name="老师";
    }
}