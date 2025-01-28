package FourStrings.Questions;

public class Five_SortSentence {
    public static void main(String[] args) {
        String s = "is2 sentence4 This1 a3";
        System.out.println(sort(s));
    }

    private static String sort(String s) {
        StringBuilder result = new StringBuilder();

        String[] shArr = s.split(" ");
        String[] tempArr = new String[shArr.length];

        for (int i = 0; i < shArr.length; i++) {

            int correctIndexNumber = (Integer.parseInt(String.valueOf(shArr[i].charAt(shArr[i].length() - 1))) - 1);

            tempArr[correctIndexNumber] = shArr[i].substring(0, shArr[i].length() - 1);
        }

        for (int i = 0; i < tempArr.length; i++) {
            if (i == tempArr.length - 1) {
                result.append(tempArr[i]);
            } else {
                result.append(tempArr[i] + " " + " . ");

            }
        }

        return result.toString();
    }
}
