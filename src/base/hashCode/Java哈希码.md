## 哈希码

### 一、概念

来自百度百科：

哈希码产生的依据：哈希码并不是完全唯一的，它是一种算法，让同一个类的对象按照自己不同的特征尽量的有不同的哈希码，但不表示不同的对象哈希码完全不同。也有相同的情况，看程序员如何写哈希码的算法。

`hashCode()` 的作用是获取哈希码，也称为散列码；它实际上是返回一个 int 整数。这个哈希码的作用是确定该对象在哈希表中的索引位置。`hashCode() `定义在 JDK 的 `Object` 类中，这就意味着 Java 中的任何类都包含有 `hashCode()` 函数。另外需要注意的是： `Object` 的 hashcode 方法是本地方法，也就是用 c 语言或 c++ 实现的，该方法通常用来将对象的 内存地址 转换为整数之后返回。

散列表存储的是键值对(key-value)，它的特点是：能根据“键”快速的检索出对应的“值”。这其中就利用到了散列码！（可以快速找到所需要的对象）

### 二、为什么要有hashCode

**我们以“`HashSet` 如何检查重复”为例子来说明为什么要有 hashCode：**

当你把对象加入 `HashSet` 时，`HashSet` 会先计算对象的 hashcode 值来判断对象加入的位置，同时也会与其他已经加入的对象的 hashcode 值作比较，如果没有相符的 hashcode，`HashSet` 会假设对象没有重复出现。但是如果发现有相同 hashcode 值的对象，这时会调用 equals（）方法来检查 hashcode 相等的对象是否真的相同。如果两者相同，`HashSet` 就不会让其加入操作成功。如果不同的话，就会重新散列到其他位置。这样我们就大大减少了 equals 的次数，相应就大大提高了执行速度。

```java
public native int hashCode();
```

###  二、示例

```java
public class Demo {
    public static void main(String[] args) {
        Object obj1 = new Object();
        Object obj2 = new Object();
        // hashCode 不相同
        System.out.println(obj1.hashCode());
        System.out.println(obj2.hashCode());

        String strObj1 = "String";
        String strObj2 = "String";
        // hashCode 相同
        System.out.println(strObj1.hashCode());
        System.out.println(strObj2.hashCode());

        Integer intNum1 = 8;
        Integer intNum2 = 8;
        // hashCode 相同
        System.out.println(intNum1.hashCode());
        System.out.println(intNum2.hashCode());
        
        Integer intNum3 = 7;
        Integer intNum4 = 8;
        System.out.println(intNum3.hashCode()); // 7
        System.out.println(intNum4.hashCode()); // 8
    }
}
```

### 三、为什么重写 `equals` 时必须重写 `hashCode` 方法？

如果两个对象相等，则 hashcode 一定也是相同的。两个对象相等,对两个对象分别调用 equals 方法都返回 true。但是，两个对象有相同的 hashcode 值，它们也不一定是相等的 。**因此，equals 方法被覆盖过，则 `hashCode` 方法也必须被覆盖。**

### 四、为什么两个对象有相同的 hashcode 值，它们也不一定是相等的？

因为 `hashCode()` 所使用的杂凑算法也许刚好会让多个对象传回相同的杂凑值。越糟糕的杂凑算法越容易碰撞，但这也与数据值域分布的特性有关（所谓碰撞也就是指的是不同的对象得到相同的 `hashCode`。



### 解决哈希冲突的方法

不同的对象拥有相同的哈希码，称为哈希冲突，解决哈希冲突的方法有三个：

- **开放定址法**

  - 从发生冲突的那个单元起，按照一定的次序，从哈希表中找到一个空闲的单元。
    然后把发生冲突的元素存入到该单元的一种方法。开放定址法需要的表长度要大于等于所需要存放的元素。
    在开放定址法中解决冲突的方法有：线行探查法、平方探查法、双散列函数探查法。
    开放定址法的缺点在于删除元素的时候不能真的删除，否则会引起查找错误，只能做一个特殊标记。
    只到有下个元素插入才能真正删除该元素。

- **链接地址法**

  - 思路是将哈希值相同的元素构成一个同义词的单链表，并将单链表的头指针存放在哈希表的第i个单元中，查找、插入和删除主要在同义词链表中进行。链表法适用于经常进行插入和删除的情况。

    **在Java中，链接地址法也是HashMap解决哈希冲突的方法之一**
    如下一组数字,(32、40、36、53、16、46、71、27、42、24、49、64)哈希表长度为13，哈希函数为H(key)=key%13,
    则链表法结果如下：

  - ```
    0
    1  -> 40 -> 27 -> 53
    2
    3  -> 16 -> 42
    4
    5
    6  -> 32 -> 71
    7  -> 46
    8
    9
    10 -> 36 -> 49
    11 -> 24
    12 -> 64
    ```

- **建立公共溢出区**

  - 将哈希表分为公共表和溢出表，当溢出发生时，将所有溢出数据统一放到溢出区。

- **再哈希法**

  - 就是同时构造多个不同的哈希函数：
    Hi = RHi(key) i= 1,2,3 ... k;
    当H1 = RH1(key) 发生冲突时，再用H2 = RH2(key) 进行计算，直到冲突不再产生。