package com.company;

import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Solution {

  public int getImportance(List<Employee> employees, int id) {
    int result = 0;

    Stack<Employee> levelEmployees = new Stack<>();
    for (Employee employee : employees) {
      if (employee.id == id) {
        levelEmployees.push(employee);
      }
    }

    while (levelEmployees.size() != 0) {
      Employee e = levelEmployees.pop();
      result += e.importance;
      for (Integer subId : e.subordinates) {
        for (Employee employee : employees) {
          if (employee.id == subId) {
            levelEmployees.push(employee);
          }
        }
      }
    }
    return result;
  }
}
