package leetcode.util.listnode;

public class PolyNode {

    public int coefficient;
    public int power;
    public PolyNode next = null;

    public PolyNode() {
    }

    PolyNode(int x, int y) {
        this.coefficient = x;
        this.power = y;
    }

    PolyNode(int x, int y, PolyNode next) {
        this.coefficient = x;
        this.power = y;
        this.next = next;
    }

}
