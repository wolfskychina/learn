package leetcode.a400;

public class _468Solution {

    public String validIPAddress(String queryIP) {
        boolean if4 = true;
        boolean if6 = true;
        if (queryIP.chars().filter(ch -> ch == '.').count() != 3) {
            if4 = false;
        } else {
            String[] v4 = queryIP.split("\\.");
            if (v4.length == 4) {
                for (int i = 0; i < 4; i++) {
                    char[] seg = v4[i].toCharArray();
                    if (seg.length ==0 || (seg.length != 1 && seg[0] == '0') || (seg.length > 3)) {
                        if4 = false;
                        break;
                    }
                    int tmp = 0;
                    for (int j = 0; j < seg.length; j++) {
                        if (seg[j] >= '0' && seg[j] <= '9') {
                            tmp = tmp * 10 + seg[j] - '0';
                        } else {
                            if4 = false;
                            break;
                        }
                    }
                    if (tmp > 255 || tmp < 0)
                        if4 = false;
                    if (if4 == false)
                        break;

                }
            } else {
                if4 = false;
            }
        }

        if (if4)
            return "IPv4";

        if (queryIP.chars().filter(ch -> ch == ':').count() != 7) 
                return "Neither";
        // check ipv6
        for (int i = 0; i < queryIP.length(); i++) {
            char c = queryIP.charAt(i);
            if (c == ':')
                continue;
            if ((c - '0' >= 0 && c - '0' <= 9) || (c - 'a' >= 0 && c - 'a' <= 5) || (c - 'A' >= 0 && c - 'A' <= 5)) {
                continue;
            } else {
                return "Neither";
            }
        }
        if (if6 == false)
            return "Neither";
        String[] v6 = queryIP.split(":");
        if (v6.length != 8)
            return "Neither";
        for (int i = 0; i < 8; i++) {
            if (v6[i].length() == 0 || v6[i].length() > 4) {
                return "Neither";
            }
        }

        return "IPv6";

    }

    public static void main(String[] args) {

        _468Solution so = new _468Solution();
        so.validIPAddress("20EE:FGb8:85a3:0:0:8A2E:0370:7334");
        //so.validIPAddress("1920.168.0.1");
        //so.validIPAddress("192.168.00.1");
    }
}
