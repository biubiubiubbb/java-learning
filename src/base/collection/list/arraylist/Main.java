package base.collection.list.arraylist;

import org.junit.Test;

import java.util.*;

/*
1.底层是一个数组，查询快，增删慢
2.此实现是非同步的
 */
public class Main {

    public static void main(String[] args) {
        // ArrayList<int> intList = new ArrayList<int>(); error
        List synchronizedList = Collections.synchronizedList(new ArrayList<>()); // 使同步，保证线程安全
        Map<String, String> map = new HashMap<>();
        map.put("key", "value");
        map.put("key1", null);
        Set<String> keys = map.keySet();
        for (var key : keys) {
            System.out.println(key + ":" + map.get(key));
        }
        for (var kv : map.entrySet()) {
            System.out.println(kv.getKey() + ":" + kv.getValue());
        }
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add(1, "D");
        System.out.println(list);  // A D B C
        System.out.println(list.get(0)); // A
        System.out.println(list.size()); // 4

        List<String> subStrList = list.subList(0, 3);
        System.out.println(subStrList);
        ; // A D B

        list.remove("A");
        System.out.println(list);  // D B C

        list.sort(String::compareTo);
        System.out.println(list);  // B C D  升序

        list.sort((Comparator.reverseOrder())); // C
        System.out.println(list);  // D C B 降序

        // 遍历
        for (var value : list) {
            System.out.println(value);
        }

        list.forEach(System.out::println);
    }


    @Test
    public void remove() {
        LinkedList<String> list = new LinkedList<>();
        list.add("张三");
        list.add("李四");
        list.add("张三");
        //第一种删除方式，下标删除，注意删除后将下标减一
//        for(int i = 0; i < list.size(); i++){
//            if(list.get(i).equals("张三")){
//                list.remove(i--);  //注意减1
//            }
//        }

        //第二种删除方式，迭代器删除
//        Iterator<String> iterator = list.iterator();
//        while(iterator.hasNext()){
//            if(iterator.next().equals("张三")){
//                iterator.remove(); //不要用list.remove
//            }
//        }

        //第三种删除方式，removeIf方法，本质也是通过迭代器删除
        list.removeIf(name -> name.equals("张三"));
        System.out.println(list);
    }
}
