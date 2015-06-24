package ua.denysov;

/**
 * Created by Alex on 23.06.2015.
 */
public class Decomposite {
    public static void main(String[] args) {

        String[] words = {"five", "fivetwo", "fourfive", "fourfivetwo", "one", "onefiveone", "two", "twofivefourone"};
        int i = findLongestComplexWord(words);
        if (i < 0) {
            System.out.print("There is no complex words");
        } else {
            System.out.print(words[i]);
        }


    }

    public static int findLongestComplexWord(String[] words) {

        int result = -1;
        for (int i = 0; i < words.length; i++) {
            //checking each element, is it complex word and which one longer?
            if ( isComplex(words, i, 0) && (result < 0 || words[i].length() > words[result].length()) ) {
                result =  i;
            }
        }
        return result;
    }

    //offset - index of character from which to start substring
    public static boolean isComplex(String[] words, int current, int offset) {

        for (int i = 0; i < words.length; i++) {
            //don't check itself or  don't check words bigger then current
            if (i == current || words[current].length() < (offset + words[i].length())) {
                continue;
            }
            //getting piece of current word, piece length == words[i]
            String piece =  words[current].substring(offset, offset + words[i].length());
            //checking for equals
            if (piece.equals(words[i])) {
                // return if checked whole word or make bigger offset for 1 checked subword
                return ((offset + piece.length()) == words[current].length()) || isComplex(words, current, piece.length() + offset );
            }
        }
        return false;
    }



}
