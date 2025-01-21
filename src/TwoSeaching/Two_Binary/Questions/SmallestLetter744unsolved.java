package TwoSeaching.Two_Binary.Questions;

public class SmallestLetter744unsolved {
    public static void main(String[] args) {
       char[] characters = {'c', 'f', 'j'};
       char target = 'c';


       int smallestDistance = Integer.MAX_VALUE;
       for(char ch : characters) {
           int distance = (int)ch - (int)target;
           if((distance < smallestDistance) && distance !=0) {
               smallestDistance = distance;
           }
       }
       char toReturnChar = (char) ((char)smallestDistance + target);

        System.out.println(toReturnChar);
    }

}
