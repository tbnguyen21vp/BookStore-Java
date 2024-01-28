package app.home;

public class Persion {
    private String name;
    private int age;

    public Persion() {
        this.name = "default";
        this.age = 0;
    }

    public Persion(String name, int age) {
        this.name = name;
        this.age = age;
    }


    void sayHello() {
        System.out.println("Hello, my name is " + this.name + ", I'm " + this.age + " years old.");
    }

}
