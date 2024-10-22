/**
 *
 * @author ji
 */
package MidtermProject;

import java.util.LinkedList;

public class PredefinedLinkedList {
    
    private LinkedList<Employee> employeeList; // predefined linked list

    // constructor
    public PredefinedLinkedList() {
        employeeList = new LinkedList<>();
    }

    // add to tail
    public void add(Employee employee) {
        employeeList.add(employee);
    }
    
    // insert to head
    public void addAtHead(Employee employee) {
        employeeList.addFirst(employee);
    }

    // insert at index
    public boolean insertAtIndex(Employee employee, int index) {
        if (index < 0 || index > employeeList.size()) {
            return false;
        }
        employeeList.add(index, employee);
        return true;
    }
    
    // remove by id
    public boolean remove(int id) {
        return employeeList.removeIf(employee -> employee.getID() == id);
    }
    
    // remove first (head)
    public boolean removeFirst() {
        if (employeeList.isEmpty()) {
            return false; 
        }
        employeeList.removeFirst(); 
        return true;
    }
    
    // remove last (tail)
    public boolean removeLast() {
        if (employeeList.isEmpty()) {
            return false;
        }
        employeeList.removeLast(); 
        return true;
    }

    // remove by index
    public boolean removeByIndex(int index) {
        if (index < 0 || index >= employeeList.size()) {
            // index out of bounds
            return false; 
        }
        employeeList.remove(index);
        return true;
    }

    // search by id
    public Employee searchByID(int id) {
        for (Employee employee : employeeList) {
            if (employee.getID() == id) {
                return employee;
            }
        }
        // employee not found
        return null; 
    }
    
    // search by index
    public Employee searchByIndex(int index) {
        if (index < 0 || index >= employeeList.size()) {
            // index out of bounds
            return null; 
        }
        return employeeList.get(index);
    }

    // convert and display as array
    public Employee[] getEmployees() {
        return employeeList.toArray(new Employee[0]);
    }
}

