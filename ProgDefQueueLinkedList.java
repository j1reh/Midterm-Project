/**
 * 
 * 
 * @author ji
 */
package MidtermProject;

public class ProgDefQueueLinkedList {
    
    private class Node {
        Employee employee;
        Node next;

        // constructor
        Node(Employee employee) {
            this.employee = employee;
        }
    }

    private Node head, tail;

    // add to end of queue
    public void enqueue(Employee employee) {
        Node newNode = new Node(employee);
        if (tail != null) {
            tail.next = newNode;
        }
        tail = newNode;
        if (head == null) {
            head = tail; 
        }
    }

    public Employee dequeue() {
        if (head == null) {
            return null; 
        }
        Employee dequeuedEmployee = head.employee;
        head = head.next; 
        if (head == null) { 
            tail = null; 
        }
        return dequeuedEmployee;
    }
    
    // search by id
    public Employee searchByID(int id) {
        Node current = head;
        while (current != null) {
            if (current.employee.getID() == id) {
                return current.employee; 
            }
            current = current.next;
        }
        // employee not found
        return null; 
    }

    // display as array
    public Employee[] getEmployees() {
        java.util.List<Employee> employeesList = new java.util.ArrayList<>();
        Node current = head;
        while (current != null) {
            employeesList.add(current.employee);
            current = current.next;
        }
        return employeesList.toArray(new Employee[0]);
    }
}
