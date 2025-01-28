package FourStrings.Questions;

import java.util.Arrays;
import java.util.List;

public class Four_1773 {
    public static void main(String[] args) {
        List<List<String>> items = Arrays.asList(
                Arrays.asList("phone", "blue", "pixel"),
                Arrays.asList("computer", "silver", "lenovo"),
                Arrays.asList("phone", "gold", "iphone")
        );

        System.out.println(countMatches(items, "color", "silver"));
    }

    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int matching = 0;
        int checkIndex = 0;

        if (ruleKey.equals("color")) {
            checkIndex = 1;
        } else if (ruleKey.equals("name")) {
            checkIndex = 2;
        }

        for (List<String> individualList : items) {

            if (individualList.get(checkIndex).equals(ruleValue)) {
                matching++;
            }
        }

        return matching;
    }
}
