package leetcode.a1000;
/**
 * 有缺陷的传感器
 */
public class _1826Solution {
   
    public int badSensor(int[] sensor1, int[] sensor2) {
        int rst = -1;
        int index = 0;
        for ( ; index < sensor1.length - 1; index++) {
            if (sensor1[index] != sensor2[index]) break;
        }
        // System.out.println(index + " " + sensor1.length);
        if (index == sensor1.length - 1) return rst;
        boolean bad1 = badS(sensor1, sensor2, index);
        boolean bad2 = badS(sensor2, sensor1, index);

        if (bad1 && bad2) {
            rst = -1;
        } else if (bad1) {
            rst = 1;
        } else if (bad2) {
            rst = 2;
        }

        return rst;
    }

    public boolean badS(int[] sensor1, int[] sensor2, int index) {
        for (; index < sensor2.length - 1; index++) {
            if (sensor1[index] != sensor2[index + 1]) return false;
        }
        return true;
    }
}
