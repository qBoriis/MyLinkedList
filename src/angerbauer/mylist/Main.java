package angerbauer.mylist;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        MyList<String> list = new MyList<>();
        list.add("islam");
        list.add("boris");
        list.add("simon");


        for (int i = 0; i <= list.size() ; i++) {
            System.out.println(list.get(i));
        }
    }
}
