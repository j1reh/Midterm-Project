/**
 *
 * 
 * @author ji
 */
package MidtermProject;

public class ProgDefDoublyLinkedList {
    
    private class Node {
        Employee employee;
        Node next, prev;

        Node(Employee employee) {
            this.employee = employee;
        }
    }
    
    private Node head, tail;

    // add employee to tail
    public void add(Employee employee) {
        Node newNode = new Node(employee);
        
        if (head == null) { 
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }
    
    // insert employee at the head
    public void addAtHead(Employee employee) {
        Node newNode = new Node(employee);
        
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // insert at a specific index
    public boolean insertAtIndex(Employee employee, int index) {
        if (index < 0) return false;
        
        Node newNode = new Node(employee);
        Node current = head;
        int count = 0;
        
        if (index == 0) {
            addAtHead(employee);
            return true;
        }
        
        while (current != null && count < index) {
            count++;
            if (count == index) {
                newNode.next = current.next;
                newNode.prev = current;
                
                if (current.next != null) {
                    current.next.prev = newNode;
                } else {
                    tail = newNode; 
                }
                current.next = newNode;
                return true;
            }
            current = current.next;
        }
        // index out of bounds
        return false; 
    }

    
    // remove by id
    public boolean remove(int id) {
        Node current = head;
        
        while (current != null) {
            if (current.employee.getID() == id) { 
                if (current.prev != null) {
                    current.prev.next = current.next; 
                } else {
                    head = current.next; 
                }

                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev; 
                }
                
                return true; 
            }
            current = current.next;
        }
        // employee not found
        return false; 
    }
    
    // remove first record (head)
    public boolean removeFirst() {
        if (head == null) return false; // list is empty
        
        if (head == tail) { // only one element
            head = tail = null; 
        } else {
            head = head.next;
            head.prev = null;
        }
        return true;
    }
    
    // remove last record (tail)
    public boolean removeLast() {
        if (tail == null) return false; // List is empty
        
        if (head == tail) {
            head = tail = null; // Only one element
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        return true;
    }

    // remove a record by index
    public boolean removeByIndex(int index) {
        if (index < 0 || head == null) return false;
        
        Node current = head;
        int count = 0;
        
        if (index == 0) {
            return removeFirst();
        }
        
        while (current != null) {
            if (count == index) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }
                
                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }
                return true;
            }
            count++;
            current = current.next;
        }
        // index out of bounds
        return false; 
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
    
    // search by index
    public Employee searchByIndex(int index) {
        if (index < 0) return null;

        Node current = head;
        int count = 0;

        while (current != null) {
            if (count == index) {
                return current.employee;
            }
            count++;
            current = current.next;
        }

        return null; // Index out of bounds
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
