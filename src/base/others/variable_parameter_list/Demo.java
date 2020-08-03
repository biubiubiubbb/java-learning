package base.others.variable_parameter_list;

/*
 *可变参数列表可接受不限个数的参数。
 *它的本质是一个数组，根据参数个数的不同，
 *创建不同长度的数组，来存储这些参数的个数
 */
public class Demo {
    public static void main(String[] args) {
        System.out.println(add(1, 2));
        System.out.println(add(1, 2, 3, 4, 5, "string"));
    }

    public static int add(Object... params) {
        for (var param : params) {
            System.out.println(param);
        }
        return params.length;
    }
}
