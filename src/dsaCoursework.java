public class dsaCoursework {
    public static void main(String[] args) {
        String a = "tt";
        String pattern = "ts#";

        int aIndex = 0;
        int patternIndex = 0;
        while (patternIndex < pattern.length()) {
            if (pattern.charAt(patternIndex) == '@') {
                patternIndex++;
                aIndex = a.length();
                break;
            } else if (aIndex < a.length() && (pattern.charAt(patternIndex) == '#' || a.charAt(aIndex) == pattern.charAt(patternIndex))) {
                aIndex++;
                patternIndex++;
            } else {
                System.out.println("false");
                return;
            }
        }

        if (aIndex == a.length() && patternIndex == pattern.length()) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
