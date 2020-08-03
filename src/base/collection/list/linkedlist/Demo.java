package base.collection.list.linkedlist;

import java.util.LinkedList;

/*
1.底层为双向链表结构，增删快，查询慢
2.此实现不是同步的
 */

public class Demo {
    public static void main(String[] args) {
        LinkedList<String> linkList = new LinkedList<>();
        linkList.add("a");  // a  尾插入
        linkList.add("b");  // a b
        linkList.addFirst("d");  // d a b  头插入
        linkList.addFirst("c");  // c d a b
        linkList.push("e"); // e c d a b 头插入

        String head1 = linkList.poll(); // d a b  去头
        String head2 = linkList.pop();  // a b  去头

        System.out.println(linkList);

        var isContains = linkList.contains("a"); // true
        var size = linkList.size();


        linkList.clear();
        size = linkList.size();
        isContains = linkList.contains("a"); // false

    }
}
