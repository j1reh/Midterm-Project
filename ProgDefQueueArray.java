/**
 *
 * @author ji
 */
package MidtermProject;

public class ProgDefQueueArray {
    private final Employee[] queue;
    private int front, rear, size;

    public ProgDefQueueArray(int capacity) {
        queue = new Employee[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(Employee employee) {
        if (size < queue.length) {
            rear = (rear + 1) % queue.length; 
            queue[rear] = employee;
            size++;
        } 
    }

    public Employee dequeue() {
        if (size == 0) {
            return null; 
        }
        Employee dequeuedEmployee = queue[front];
        front = (front + 1) % queue.length; 
        size--;
        return dequeuedEmployee;
    }
    
    public Employee searchByID(int id) {
        for (int i = 0; i < size; i++) {
            int index = (front + i) % queue.length;
            if (queue[index] != null && queue[index].getID() == id) {
                return queue[index]; 
            }
        }
        return null; 
    }

    public Employee[] getEmployees() {
        Employee[] employees = new Employee[size];
        for (int i = 0; i < size; i++) {
            employees[i] = queue[(front + i) % queue.length];
        }
        return employees;
    }
}

