package leetcode.a600;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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

    
    private Map<Integer, Employee> employeeMap;

    /**
     * 使用{hashmap}快速查找
     * @param employees
     * @param id
     * @return
     */
    public int getImportance1(List<Employee> employees, int id) {
        // 创建一个哈希表来快速查找员工
        employeeMap = new HashMap<>();
        for (Employee employee : employees) {
            employeeMap.put(employee.id, employee);
        }

        // 使用DFS计算总重要性值
        return dfs(id);
    }

    private int dfs(int id) {
        Employee employee = employeeMap.get(id);
        int totalImportance = employee.importance;
        for (int subId : employee.subordinates) {
            totalImportance += dfs(subId);
        }
        return totalImportance;
    }
}
