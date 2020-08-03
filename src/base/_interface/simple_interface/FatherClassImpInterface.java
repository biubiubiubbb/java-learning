package base._interface.simple_interface;

public class FatherClassImpInterface extends SubClass implements ImpInterface {

    //所有的抽象方法都必须实现
    @Override
    public void interfaceMethod() {

    }

    @Override
    public void subInterfaceMethod1() {

    }

    @Override
    public void subInterfaceMethod2() {

    }
}

class SubClass {
    public void method() {
        System.out.println("My father method called");
    }
}