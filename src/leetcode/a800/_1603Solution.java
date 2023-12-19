package leetcode.a800;
/**
 * 设计停车系统
 */
public class _1603Solution {

    /**
     * {design},{easy}
     */
    class ParkingSystem {

        int big = 0;
        int medium = 0;
        int small = 0;

        public ParkingSystem(int big, int medium, int small) {
            this.big = big;
            this.medium = medium;
            this.small = small;
        }

        public boolean addCar(int carType) {

            switch (carType) {
                case 1:
                    if (big != 0) {
                        big--;
                        return true;
                    } else {
                        return false;
                    }
                case 2:
                    if (medium != 0) {
                        medium--;
                        return true;
                    } else {
                        return false;
                    }
                case 3:
                    if (small != 0) {
                        small--;
                        return true;
                    } else {
                        return false;
                    }

            }
            return false;
        }
    }
}
