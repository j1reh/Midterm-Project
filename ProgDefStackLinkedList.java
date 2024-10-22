/**
 *
 * 
 * @author ji
 */
package MidtermProject;

public class ProgDefStackLinkedList {

    private class Node {
        Employee employee;
        Node next;

        // constructor
        Node(Employee employee) {
            this.employee = employee;
        }
    }

    private Node head; 

    // push
    public void push(Employee employee) {
        Node newNode = new Node(employee);
        newNode.next = head;
        head = newNode;
    }

    // pop
    public Employee pop() {
        if (head == null) {
            // stack isEmpty
            return null; 
        }
        Employee poppedEmployee = head.employee;
        head = head.next; 
        return poppedEmployee;
    }

    // Search by id
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

    // displays employees as array 
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