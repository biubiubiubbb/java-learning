package base.collection.set.treeset;

import org.junit.Test;

/*
   有序的set
 */
import java.util.TreeSet;

public class Demo {
    @Test
    public void demo(){
        TreeSet<Integer> treeSet = new TreeSet<>((o1, o2)-> o2 - o1);
        treeSet.add(1);
        treeSet.add(3);
        treeSet.add(2);
        for (Integer integer : treeSet) {
            System.out.println(integer);
        }
        System.out.println(treeSet);
    }
}
