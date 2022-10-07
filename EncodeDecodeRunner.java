import java.io.*;
import java.util.concurrent.ThreadLocalRandom;

public class EncodeDecodeRunner {
    private static final String HASH_STR = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789()*+,-./";

    public EncodeDecodeRunner() {

    }

    /**
     * Encodes the unencoded string from user
     * 
     * @param toUnencode
     * @param sb
     * @return encodedString
     */
    public String encode(String toUnencode, StringBuilder sb) {
        int min = 0;
        int max = 43;

        int offSetIndex = ThreadLocalRandom.current().nextInt(min, max + 1);
        String offsetChar = String.valueOf(HASH_STR.charAt(offSetIndex));
        sb.append(offsetChar);

        char[] uncodedCharArr = toUnencode.toCharArray();
        for (char currChar : uncodedCharArr) {
            if (currChar == ' ') {
                sb.append(' ');
            } else {
                String currCharStringVal = String.valueOf(currChar);
                int currCharIdx = HASH_STR.indexOf(currCharStringVal.toUpperCase());
                if (currCharIdx == -1) {
                    sb.append(currCharStringVal);
                } else {
                    currCharIdx += offSetIndex;
                    if (currCharIdx > 43) {
                        currCharIdx = currCharIdx % 43;
                    }

                    sb.append(String.valueOf(HASH_STR.charAt(currCharIdx)));
                }
            }
        }

        return sb.toString();
    }

    /**
     * Decodes an encoded string from user
     * 
     * @param toDecode
     * @param sb
     * @return decodedString
     */
    public String decode(String toDecode, StringBuilder sb) {

        String decodeVal = String.valueOf(toDecode.charAt(0));
        toDecode = toDecode.substring(1);

        int offSetIndex = HASH_STR.indexOf(decodeVal);

        char[] toDecodeCharArr = toDecode.toCharArray();

        for (char currChar : toDecodeCharArr) {
            if (currChar == ' ') {
                sb.append(' ');
            } else {
                String currCharStringVal = String.valueOf(currChar);
                int currCharIdx = HASH_STR.indexOf(currCharStringVal.toUpperCase());
                if (currCharIdx == -1) {
                    sb.append(currCharStringVal);
                } else {
                    currCharIdx -= offSetIndex;
                    if (currCharIdx < 0) {
                        currCharIdx = 43 + currCharIdx;
                    }
                    sb.append(String.valueOf(HASH_STR.charAt(currCharIdx)));
                }
            }
        }

        return sb.toString();
    }
}