package CollectionFramework;

import java.util.*;
import org.apache.log4j.Logger;
public class Main {
    public static Logger logger = Logger.getLogger(Main.class);
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        Set<Student> set = new HashSet<>();
        Map<Student, Integer> map = new HashMap<>();

        Student s1 = new Student(1, "Alice");
        Student s2 = new Student(2, "Bob");
        Student s3 = new Student(3, "Charles");
        Student s4 = new Student(4, "David");

        //adding to list
        list.add(s4);
        list.add(s1);
        list.add(s3);
        list.add(s2);

        //list traversal
        for(Student student: list){
            logger.info(student.getName());
        }

        //adding all students in set using addAll method
        set.addAll(list);

        //getting the size of set
        logger.info(set.size());

        //size does not change if a student object is added again
        set.add(s1);
        logger.info(set.size());

        //mapping students with marks using hashmap
        map.put(s1, 34);
        map.put(s2, 94);
        map.put(s3, 69);
        map.put(s4, 76);

        for (Map.Entry<Student,Integer> mapElement : map.entrySet()) {
            logger.info("Student " + mapElement.getKey().getName() + " has scored " + mapElement.getValue());
        }
        //sorting list using comparator interface
        Comparator<Student> comparator = new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                if(s1.getId() > s2.getId()) return 1;
                return -1;
            }
        };

        list.sort(comparator);
        for(Student student: list){
            logger.info(student.getName());
        }


    }
}
