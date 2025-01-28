package FourStrings.Questions;

public class Two_Shuffle {
    public static void main(String[] args) {
        String s = "codeleet";
        int[] indices = new int[]{4, 5, 6, 7, 0, 2, 1, 3};

        System.out.println(restoreString(s, indices));
    }

    public static String restoreString(String s, int[] indices) {
        char[] ch = new char[s.length()];

        for (int i = 0; i < indices.length; i++) {
            int index = indices[i]; // 4
            ch[index] = s.charAt(i);
        }


        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < ch.length; i++)
            sb.append(ch[i]);

        return sb.toString();

    }
}
