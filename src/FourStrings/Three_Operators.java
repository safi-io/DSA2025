package FourStrings;

public class Three_Operators {
    public static void main(String[] args) {

        System.out.println('a' + 'a'); // CONCEPT OF ASCII VALUES
        System.out.println("H" + "W"); // String contamination

        System.out.println((char) ('a' + 1)); // It will print b

        System.out.println("Hello" + 2);

        // If we pass object here, it will simply call its toString Method
        System.out.println("SAFI" + new int[]{1, 2, 3, 4, 5});

        // + in java, Can only be used with primitives, or complex expressions, but at-least one expression
    }
}
