/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MidtermProject;

import java.util.LinkedList;
import java.util.Queue;
/**
 *
 * @author ji
 */
public class PredefinedQueue {
    
    private Queue<Employee> queue; // predefined queue

    // constructor
    public PredefinedQueue() {
        queue = new LinkedList<>(); 
    }

    // Add to end of queue
    public void enqueue(Employee employee) {
        queue.offer(employee);
    }

    public Employee dequeue() {
        return queue.poll(); 
    }
    
    // serach by id
    public Employee searchByID(int id) {
        for (Employee employee : queue) {
            if (employee != null && employee.getID() == id) {
                return employee;
            }
        }
        // employee not found
        return null; 
    }

    // convert and display as array
    public Employee[] getEmployees() {
        return queue.toArray(new Employee[0]);
    }
}

