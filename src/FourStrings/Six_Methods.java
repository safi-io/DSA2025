package FourStrings;

import java.util.Arrays;

public class Six_Methods {
    public static void main(String[] args) {
        String name = "Safi Khan Hello World";
        System.out.println(Arrays.toString(name.toCharArray()));
        System.out.println(name.toLowerCase());
        System.out.println(name);
        System.out.println(name.indexOf('a'));
        System.out.println("     Safi   ".strip());
        System.out.println(Arrays.toString(name.split(" ")));
    }

}
