package base.generic;

public class Do<E> extends MyGenericClass<E> implements MyGenericInterface<E> {

    @Override
    public void genericClassMethod(E o) {
        System.out.println("Subclass genericClassMethod call:" + o);
    }

    @Override
    public void test(E o) {
        genericInterfaceMethod(o);
    }
}
