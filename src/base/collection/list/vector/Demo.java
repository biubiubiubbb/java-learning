package base.collection.list.vector;

import java.util.Vector;

/*
Vector：
1.底层是一个数组，固进行插入和删除操作效率较低
2.Vector空间(capacity)满后，扩容一倍
3.Vector因为是线程同步，所以它是线程安全的，但这也是效率低的原因
 */

public class Demo {
    public static void main(String[] args) {
        Vector<Integer> vc = new Vector<>();
        vc.add(2);
        vc.add(3);
        var capacity = vc.capacity(); // 10
        var size = vc.size();
        for (int i = 0; i < 9; i++) {
            vc.add(i);
        }

        capacity = vc.capacity(); // 20
        size = vc.size(); // 11
    }
}
