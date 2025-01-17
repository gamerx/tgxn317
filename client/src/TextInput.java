
public final class TextInput {
    
    public static char aCharArray631[] = new char[100];
    private static Stream stream = new Stream(new byte[100]);
    private static char validChars[] = {
        ' ', 'e', 't', 'a', 'o', 'i', 'h', 'n', 's', 'r',
        'd', 'l', 'u', 'm', 'w', 'c', 'y', 'f', 'g', 'p',
        'b', 'v', 'k', 'x', 'j', 'q', 'z', '0', '1', '2',
        '3', '4', '5', '6', '7', '8', '9', ' ', '!', '?',
        '.', ',', ':', ';', '(', ')', '-', '&', '*', '\\',
        '\'', '@', '#', '+', '=', '\243', '$', '%', '"', '[',
        ']', '>', '<', '^', '/'
    };
    
    public static String method525(int i, Stream stream) {
        int j = 0;
        int k = -1;
        for (int l = 0; l < i; l++) {
            int i1 = stream.readUnsignedByte();
            aCharArray631[j++] = validChars[i1];
        }
        boolean flag1 = true;
        for (int k1 = 0; k1 < j; k1++) {
            char c = aCharArray631[k1];
            if (flag1 && c >= 'a' && c <= 'z') {
                aCharArray631[k1] += '\uFFE0';
                flag1 = false;
            }
            if (c == '.' || c == '!' || c == '?') {
                flag1 = true;
            }
        }
        return new String(aCharArray631, 0, j);
    }

    public static void method526(String s, Stream stream) {
        if (s.length() > 80) {
            s = s.substring(0, 80);
        }
        s = s.toLowerCase();
        int i = -1;
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            int k = 0;
            for (int l = 0; l < validChars.length; l++) {
                if (c != validChars[l]) {
                    continue;
                }
                k = l;
                break;
            }
            stream.writeWordBigEndian(k);
        }
    }

    public static String processText(String s) {
        stream.currentOffset = 0;
        method526(s, stream);
        int j = stream.currentOffset;
        stream.currentOffset = 0;
        String s1 = method525(j, stream);
        return s1;
    }
}
