package base._interface.simple_interface;

public class Demo {
    public static void main(String[] args) {
        ImpInterface obj = new FatherClassImpInterface();
        obj.method(); // My father methods called 继承优先于接口
        ImpInterface.publicStaticMethod();
    }
}



