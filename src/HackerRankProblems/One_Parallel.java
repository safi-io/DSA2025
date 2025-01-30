package HackerRankProblems;

import java.util.ArrayList;
import java.util.List;

public class One_Parallel {
    public static void main(String[] args) {
        int numCores = 231;
        int limit = 689;
        List<Integer> numbers = new ArrayList<>();
        numbers.add(34918422);
        numbers.add(590100357);
        numbers.add(860614062);
        numbers.add(295156785);
        numbers.add(914782407);
        numbers.add(582058092);
        numbers.add(325992975);
        numbers.add(416760036);
        numbers.add(570588480);
        numbers.add(574190925);
        numbers.add(913714263);
        numbers.add(663257133);
        numbers.add(786342480);
        numbers.add(468340488);
        numbers.add(970124463);
        numbers.add(601345899);
        numbers.add(425469660);
        numbers.add(389949483);
        numbers.add(286835934);
        numbers.add(402449586);
        numbers.add(747156333);
        numbers.add(34472592);
        numbers.add(106455657);
        numbers.add(624267336);
        numbers.add(807134559);
        numbers.add(20659485);
        numbers.add(137831232);
        numbers.add(641736711);
        numbers.add(107727543);
        numbers.add(884495766);
        numbers.add(105772128);
        numbers.add(201282774);
        numbers.add(148515906);
        numbers.add(905571744);
        numbers.add(32752335);
        numbers.add(130715277);
        numbers.add(920212986);
        numbers.add(552581568);
        numbers.add(175526736);
        numbers.add(805510167);
        numbers.add(286664994);
        numbers.add(992461701);
        numbers.add(294780486);
        numbers.add(54420366);
        numbers.add(781973808);
        numbers.add(425371485);
        numbers.add(135717813);
        numbers.add(554036175);
        numbers.add(68742828);
        numbers.add(929645640);
        numbers.add(506702427);
        numbers.add(677085024);
        numbers.add(633905811);
        numbers.add(247548147);
        numbers.add(526512063);
        numbers.add(970227489);
        numbers.add(388018785);
        numbers.add(380096409);
        numbers.add(354248433);
        numbers.add(546723408);
        numbers.add(452286912);
        numbers.add(989035971);
        numbers.add(242349261);
        numbers.add(193079502);
        numbers.add(904348368);
        numbers.add(477698991);
        numbers.add(960614193);
        numbers.add(700347186);
        numbers.add(101779062);
        numbers.add(81550161);
        numbers.add(953044092);
        numbers.add(573736086);
        numbers.add(460866021);
        numbers.add(126338058);
        numbers.add(407277024);
        numbers.add(242097471);
        numbers.add(10103016);
        numbers.add(281561511);
        numbers.add(357951363);

        System.out.println(minTime(numbers, numCores, limit));
    }

    public static long minTime(List<Integer> files, int numCores, int limit) {
        long minimumTime = 0;

        for (int i = 0; i < files.size(); i++) {
            if (files.get(i) % numCores == 0) {
                if (limit > 0) {
                    minimumTime += files.get(i) / numCores;
                    limit--;
                } else {
                    minimumTime += files.get(i);
                }
            } else {
                minimumTime += files.get(i);
            }
        }


        return minimumTime;
    }
}
