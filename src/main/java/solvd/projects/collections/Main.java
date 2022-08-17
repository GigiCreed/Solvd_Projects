package solvd.projects.collections;
import solvd.projects.collections.customlinkedlist.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args){

        CustomLinkedList<Triangle> c =new CustomLinkedList<Triangle>();
        c.insert(new Triangle(3,5,6));
        c.insert(new Triangle(5,5,5));
        c.insert(new Triangle(4,4,4));
        c.insertAtStart(new Triangle(2,2,2));
        c.insertAtLast(new Triangle(1,1,1));
        c.insertAt(3,new Triangle(7,7,7));
        c.deleteAt(0);
        c.show();


//        List<Triangle>list =new LinkedList<Triangle>();
//        list.add(new Triangle(5,6,7));
//        list.add(new Triangle(5,5,5));
//        list.add(new Triangle(1,1,1));
//        list.add(0,new Triangle(3,3,3));
//        list.remove(2);
//        for (Object o:list) {
//            logger.info(o);
//        }
//        System.out.println();
////
//
//        Queue<Triangle>queue = new PriorityQueue<Triangle>();
//        queue.add(new Triangle(1,1,1));
//        queue.add(new Triangle(5,5,5));
//        queue.add(new Triangle(3,3,3));
//        while (queue.size()>0){
//            logger.info(queue.poll());
//        }
//        System.out.println();
//
//        Map<Integer,Triangle>map = new HashMap<Integer,Triangle>();
//        map.put(1,new Triangle(1,1,1));
//        map.put(2,new Triangle(5,5,5));
//        map.put(3,new Triangle(3,3,3));
//        Set set2 = map.entrySet();
//        for (Object o:set2) {
//            logger.info(o);
//        }
//        System.out.println();
//
//
//
//        Set<Triangle>set = new TreeSet<Triangle>();
//        set.add(new Triangle(1,1,1));
//        set.add(new Triangle(4,4,4));
//        set.add(new Triangle(2,2,2));
//        for (Object o:set) {
//            logger.info(o);
//        }

    }
}
