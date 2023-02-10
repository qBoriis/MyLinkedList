package angerbauer.mylist;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        MyList<String> list = new MyList<>();
        list.add("islam");
        list.add("boris");
        list.add("simon");


        LinkedList<String> l = new LinkedList<>();
        l.add("");
        System.out.println(        l.remove(""));
    }
}
