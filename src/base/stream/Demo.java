package base.stream;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Demo {
    @Test
    public void demo1(){
        List<String> list = new LinkedList<>();
        list.add("dasssfj");
        list.add("1434");
        list.add("1434");
        list.add("ajfai99193");
        Stream<String> stream = list.stream();
        Optional<String> any = stream.filter(str -> str.length() < 8)
                .distinct()
                .findAny();
        System.out.println(any);
    }
}
