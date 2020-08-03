package base.generic;

public interface MyGenericInterface<E> {
    default void genericInterfaceMethod(E o) {
        System.out.println("genericInterfaceMethod call:" + o);
    }

    public void test(E o);
}
