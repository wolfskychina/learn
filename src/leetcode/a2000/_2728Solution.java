package leetcode.a2000;
/**
 * 计算环形街道上的房子数量
 * {easy}
 */
public class _2728Solution {

    interface Street {

        public void openDoor();

        public void closeDoor();

        public boolean isDoorOpen();

        public void moveRight();

        public void moveLeft();
    }

    public int houseCount(Street street, int k) {

        for (int i = 0; i < k; i++) {
            street.closeDoor();
            street.moveRight();
        }
        int count = 0;
        while (!street.isDoorOpen()) {
            count++;
            street.openDoor();
            street.moveRight();
        }

        return count;
    }
}
