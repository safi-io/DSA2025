package TwoSeaching.One_Linear.Questions;

public class searchString {
    public static void main(String[] args) {
        String name = "Safi";
        char target = 'z';
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) == (target)) {
                System.out.println("Character Found at Index: " + i);
            }
        }


    }
}
