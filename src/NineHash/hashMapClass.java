package NineHash;

import java.util.*;

public class hashMapClass {
    public static void main(String[] args) {

        HashMap<Integer, String> classRoom = new HashMap<>();

        // Insertions
        classRoom.put(1, "ASAD");
        classRoom.put(2, "SAAD");
        classRoom.put(3, "SAFI");

        System.out.println(classRoom);

        // Update
        classRoom.put(2, "SAAD-KHAN");

        // Deletion
        classRoom.remove(1);

        System.out.println(classRoom);


        // Searching
        if(classRoom.containsValue("SAFI")) {
            System.out.println("FOUND");
        }else {
            System.out.println("NOT FOUND");
        }

        // Traversal

        for( Map.Entry<Integer, String> e : classRoom.entrySet() ) {
            System.out.print(e.getKey() + "=" + e.getValue() +", ");
        }

    }
}
