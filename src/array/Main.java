package array;

import utils.Asserts;

/**
 * @author Leron
 * @version 1.0.0
 * @create 2020/4/22 18:25
 */
public class Main {
    public static void main(String[] args) {
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(5);
//        list.add(3);
//        list.add(6);
//        list.add(7);
//        list.add(1);
//        System.out.println(list);
//        list.remove(3);
//        System.out.println(list);
//        list.remove(3);
//        System.out.println(list);
//        list.add(3, 4);
//        System.out.println(list);
//        list.add(3, 9);
//        System.out.println(list);
//
//        list.set(3, 10);
//        System.out.println(list);
//        Asserts.test(list.get(3) == 10);
//        Asserts.test(list.get(3) == 9);
//        list.get(-10);

        Person person = new Person(15, "Rose");
        System.out.println(person);

        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person(10, "Jack"));
        persons.add(null);
        persons.add(new Person(15, "Rose"));
        persons.add(null);
        persons.add(new Person(12, "James"));
        persons.add(null);
        System.out.println(persons);
//        System.out.println(persons.indexOf(null));
//        persons.clear();
        Person person2 = persons.remove(2);
        System.out.println(persons.indexOf(person));
        System.out.println(person2);
        System.out.println(persons);
        // 提醒JVM垃圾回收
        System.gc();

    }
}
