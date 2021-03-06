package linkedlist;

import linkedlist.circledoublelist.DoubleCircleLinkedList;
import linkedlist.circlesinglelist.SingleCircleLinkedList;
import linkedlist.doublelist.DoubleLinkedList;
import linkedlist.josephus.JosephusDoubleCircleLinkedList;
import utils.Asserts;

/**
 * @author Leron
 * @version 1.0.0
 * @create 2020/4/22 22:06
 */
public class Main {
    static void testList(List<Integer> list) {
        list.add(11);
        list.add(22);
        list.add(33);
        list.add(44);

        list.add(0, 55); // [55, 11, 22, 33, 44]
        list.add(2, 66); // [55, 11, 66, 22, 33, 44]
        list.add(list.size(), 77); // [55, 11, 66, 22, 33, 44, 77]

        list.remove(0); // [11, 66, 22, 33, 44, 77]
        list.remove(2); // [11, 66, 33, 44, 77]
        list.remove(list.size() - 1); // [11, 66, 33, 44]

        Asserts.test(list.indexOf(44) == 3);
        Asserts.test(list.indexOf(22) == List.ELEMENT_NOT_FOUND);
        Asserts.test(list.contains(33));
        Asserts.test(list.get(0) == 11);
        Asserts.test(list.get(1) == 66);
        Asserts.test(list.get(list.size() - 1) == 44);

        System.out.println(list);
    }

    static void josephus() {
        JosephusDoubleCircleLinkedList<Integer> list = new JosephusDoubleCircleLinkedList<>();
        for (int i = 1; i <= 8; i++) {
            list.add(i);
        }

        // 指向头结点（指向1）
        list.reset();

        while (list.size != 1) {
            list.next();
            list.next();
            System.out.println(list.remove());
        }
        System.out.println("我是最强的仔，活到最后：" + list);
    }

    public static void main(String[] args) {


//        List<Integer> arrayList = new SingleCircleLinkedList<>();
//        for(int i = 0; i < 50; i++) {
//            arrayList.add(i);
//        }
//
//        for(int i = 0; i < 50; i++) {
//            arrayList.remove(0);
//        }
//
//        System.out.println(arrayList);


//        testList(new ArrayList<>());
//        testList(new DoubleLinkedList<>());
//
//        testList(new SingleCircleLinkedList<>());
//        testList(new DoubleCircleLinkedList<>());

        // 解决约瑟夫问题
        josephus();
    }
}
