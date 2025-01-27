package FourStrings;

public class One_Comparisons {
    public static void main(String[] args) {

        // These must be stored in String pool
        String s1 = "HW";
        String s2 = "HW";

        // Here, we are creating a new object, It is not in POOL.
        String s3 = new String("HW");

        // We can even store string in pool, which is created by new using intern.
        String s4 = new String("HW").intern();

        // Comparisons. Are they pointing to Same or not!?
        
        // == checks if reference variable are pointing to same
        System.out.println(s1==s2); // True
        System.out.println(s1==s3); // False
        System.out.println(s1==s4); // True

        // .equals checks if values are same or not
        System.out.println(s4.equals(s1)); // TRUE
    }
}
