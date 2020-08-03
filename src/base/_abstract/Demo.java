package base._abstract;

public class Demo {
    public static void main(String[] args) {
        // Animal animal = new Animal();  错误 抽象类不能实例化对象
        Animal cat = new Cat();
        Animal dog = new Dog();
        cat.eat();
        dog.eat();
    }
}
