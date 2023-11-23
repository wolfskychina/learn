package leetcode.a600;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * 员工号为id的员工及所有下属的权重值
 */
public class _690Solution {

    int total = 0;

    /**
     * {level order traverse}
     * @param employees
     * @param id
     * @return
     */
    public int getImportance(List<Employee> employees, int id) {

        Queue<Employee> q = new LinkedList<>();
        int[] idx = new int[2001];

        for (int i = 0; i < employees.size(); i++) {
            q.offer(employees.get(i));
            idx[employees.get(i).id] = i;
        }

        while (!q.isEmpty()) {
            Employee e = q.poll();
            if (e.id != id) {
                for (int i : e.subordinates) {
                    q.offer(employees.get(idx[i]));
                }
            } else {
                // found tar
                Queue<Employee> qq = new LinkedList<>();
                qq.offer(e);
                while (!qq.isEmpty()) {

                    Employee ee = qq.poll();
                    total += ee.importance;
                    for (int i : ee.subordinates) {
                        qq.offer(employees.get(idx[i]));
                    }
                }

                return total;

            }
        }

        return total;

    }

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };
}
