package angerbauer.mylist;


/**
 * @author Boris Angerbauer
 */

public class Main {
    public static void main(String[] args) {
        MyList<String> list = new MyList<>();
        list.add("islam");
        list.add("enrico");
        list.add("marc");


        for (int i = 0; i < list.size() ; i++) {
            System.out.println(list.get(i));
        }
    }
}
