import angerbauer.mylist.MyList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Boris Angerbauer
 */

public class test {

    static MyList otherList;
    static ArrayList<String> javaList = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        otherList = new MyList();
        javaList = new ArrayList<>();
    }


    /**
     * Test of add method, of class MyList.
     */
    @Test
    public void testAdd_String() {
        System.out.println("add null");
        for (int i = 0; i < 1000; i++) {
            otherList.add(null);
            javaList.add(null);
            assertEquals(javaList.get(i), otherList.get(i));

        }
        System.out.println("add String");
        for (int i = 0; i < 1000; i++) {
            otherList.add("test" + i);
            javaList.add("test" + i);
            assertEquals(javaList.get(i), otherList.get(i));
        }

    }

    /**
     * Test of add method, of class MyList.
     */
    @Test
    public void testAdd_int_String() {
        System.out.println("add int");
        for (int i = 0; i < 1000; i++) {
            otherList.add(i, String.valueOf(i));
            javaList.add(i, String.valueOf(i));
            assertEquals(javaList.get(i), otherList.get(i));
        }
    }

    /**
     * Test of get method, of class MyList.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        boolean javaL = false;
        boolean otherL = false;
        try {
            javaList.get(0);
        } catch (Exception e) {
            javaL = true;
        }
        try {
            otherList.get(0);
        } catch (Exception e) {
            otherL = true;
        }
        assertEquals(javaL, otherL);

        for (int i = 0; i < 1000; i++) {
            javaList.add(String.valueOf(i));
            otherList.add(String.valueOf(i));
        }
        for (int i = 0; i < 1000; i++) {
            assertEquals(javaList.get(i), otherList.get(i));
        }
    }


    /**
     * Test of remove method, of class MyList.
     */
    @Test
    public void testRemove_String() {
        System.out.println("remove");
        otherList.add("test");
        javaList.add("test");
        otherList.remove("test");
        javaList.remove("test");
        boolean javaL = false;
        boolean otherL = false;
        try {
            javaList.get(0);
        } catch (IndexOutOfBoundsException exception) {
            javaL = true;
        }
        try {
            otherList.get(0);
        } catch (IndexOutOfBoundsException exception) {
            otherL = true;
        }
        assertEquals(javaL, otherL);

    }

    /**
     * Test of remove method, of class MyList.
     */
    @Test
    public void testRemove_int() {
        System.out.println("remove");
        otherList.add(0, "test");
        javaList.add(0, "test");
        otherList.remove(0);
        javaList.remove(0);
        boolean javaL = false;
        boolean otherL = false;
        try {
            javaList.get(0);
        } catch (IndexOutOfBoundsException e) {
            javaL = true;
        }
        try {
            otherList.get(0);
        } catch (IndexOutOfBoundsException e) {
            otherL = true;
        }
        assertEquals(javaL, otherL);
    }

    /**
     * Test of set method, of class MyList.
     */
    @Test
    public void testSet() {
        System.out.println("set");
        otherList.add("test");
        otherList.set(0, "overwrite");
        javaList.add("test");
        javaList.set(0, "overwrite");
        assertEquals(javaList.get(0), otherList.get(0));
        otherList.set(0, null);
        javaList.set(0, null);
        assertEquals(javaList.get(0), otherList.get(0));
    }

    /**
     * Test of contains method, of class MyList.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        assertEquals(javaList.contains(null), otherList.contains(null));
        javaList.add("overwrite");
        otherList.add("overwrite");
        assertEquals(javaList.contains("overwrite"), otherList.contains("overwrite"));
        javaList.add(null);
        otherList.add(null);
        assertEquals(javaList.contains(null), otherList.contains(null));
    }

    /**
     * Test of indexOf method, of class MyList.
     */
    @Test
    public void testIndexOf() {
        System.out.println("indexOf");
        assertEquals(javaList.indexOf(null), otherList.indexOf(null));
        String one = new String("overwrite");
        javaList.add(one);
        String two = new String("overwrite");
        otherList.add(two);
        assertEquals(javaList.indexOf("overwrite"), otherList.indexOf("overwrite"));
        javaList.add(null);
        otherList.add(null);
        assertEquals(javaList.indexOf(null), otherList.indexOf(null));
    }

    /**
     * Test of size method, of class MyList.
     */
    @Test
    public void testSizeOne() {
        System.out.println("size");
        assertEquals(javaList.size(), otherList.size());
        javaList.add("test");
        otherList.add("test");
        javaList.add(null);
        otherList.add(null);
        assertEquals(javaList.size(), otherList.size());
    }

    @Test
    public void testSizeNull() {
        System.out.println("size");
        assertEquals(javaList.size(), otherList.size());
        javaList.add(null);
        otherList.add(null);
        assertEquals(javaList.size(), otherList.size());
    }

    /**
     * Test of isEmpty method, of class MyList.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        javaList.add(null);
        otherList.add(null);
        assertEquals(javaList.isEmpty(), otherList.isEmpty());
    }
}
