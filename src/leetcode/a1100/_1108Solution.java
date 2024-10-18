package leetcode.a1100;

/**
 * ip地址无效化
 * {easy}
 */
public class _1108Solution {

    public String defangIPaddr(String address) {

        return address.replace(".", "[.]");
    }
}
