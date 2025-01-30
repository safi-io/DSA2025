package HackerRankProblems;

import java.util.ArrayList;
import java.util.List;

public class Two_Username {
    public static void main(String[] args) {
        List<String> username = new ArrayList<String>();
        username.add("foo");
        username.add("bar");
        username.add("baz");
        username.add("hydra");

        System.out.println(possibleChanges(username));
    }

    public static List<String> possibleChanges(List<String> usernames) {
        List<String> toReturn = new ArrayList<String>();

        for (String username : usernames) {
            boolean isEdit = false;
            outer:
            for (int i = 0; i < username.length(); i++) {
                int leftASCII = username.charAt(i);
                for (int j = i + 1; j < username.length(); j++) {
                    int rightASCII = username.charAt(j);
                    if (!(leftASCII <= rightASCII)) {
                        isEdit = true;
                        break outer;
                    }
                }
            }
            if (isEdit) {
                toReturn.add("YES");
            } else {
                toReturn.add("NO");
            }
        }

        return toReturn;

    }
}

