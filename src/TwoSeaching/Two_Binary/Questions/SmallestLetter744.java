package TwoSeaching.Two_Binary.Questions;

public class SmallestLetter744 {
    public static void main(String[] args) {
        char[] characters = {'c', 'f', 'j'};
        char target = 'j';
        int targetASCII = target;
        int[] charactersASCII = new int[characters.length];
        for (int i = 0; i < charactersASCII.length; i++) {
            charactersASCII[i] = characters[i];
        }

        System.out.println((char) smallestLetter(charactersASCII, targetASCII));
    }

    static int smallestLetter(int[] lettersASCII, int targetASCII) {

        if (targetASCII >= lettersASCII[lettersASCII.length - 1]) {
            return lettersASCII[0];
        }

        int start = 0;
        int end = lettersASCII.length - 1;
        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if(lettersASCII[mid]==targetASCII) {
                for(int i=0;  i<lettersASCII.length;  i++) {
                    if(lettersASCII[i] > targetASCII && lettersASCII[i] != targetASCII ){
                        return lettersASCII[i];
                    }
                }
            }
            else if (lettersASCII[mid] < targetASCII) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return lettersASCII[start];

    }
}
