package lists;
import lists.DLL;
import org.junit.Test;

public class DLLTest {

    @Test
    public void test() {
        DLL list = new DLL();

        list.addFirst(10);

        list.addLast(20);
//
        list.addLast(30);
//
//        list.deleteFirst();
//
//        list.deleteLast();

        list.addLast(20);

        list.addLast(30);

        list.insert(25, 2);
        list.deleteAt(2);

        System.out.println("---------------");
        list.print();
    }
}