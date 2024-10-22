/**
 * 
 * 
 * @author ji
 */
package MidtermProject;

import java.util.ArrayList;

public class PredefinedArrayList {
    
    private final ArrayList<Employee> employees; // predefined arraylist

    // constructor
    public PredefinedArrayList() {
        employees = new ArrayList<>();
    }

    // add to list
    public void add(Employee employee) {
        employees.add(employee);
    }

    // remove by id
    public boolean remove(int id) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getID() == id) {
                employees.remove(i);
                return true; 
            }
        }
        return false; 
    }
    
    // search by id
    public Employee searchByID(int id) {
        for (Employee employee : employees) {
            if (employee.getID() == id) {
                return employee; 
            }
        }
        // employee not found
        return null; 
    }

    // convert and display as array
    public Employee[] getEmployees() {
        return employees.toArray(new Employee[0]);
    }
}
