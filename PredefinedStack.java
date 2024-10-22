/**
 *
 * @author ji
 */
package MidtermProject;
import java.util.Stack;

public class PredefinedStack {

        private Stack<Employee> stack; //predefined stack

        // constructor
        public PredefinedStack() {
            stack = new Stack<>();
        }

        // push
        public void push(Employee e) {
            stack.push(e);
        }

        // pop
        public Employee pop() {
            if (stack.isEmpty()) {
                System.out.println("Stack is empty");
                return null;
            }
            return stack.pop();
        }

        // Searche by id
        public Employee searchByID(int id) {
            for (Employee e : stack) {
                if (e != null && e.getID() == id) {
                    return e; 
                }
            }
            // Employee not found
            return null; 
        }
        
        // display as array
        public Employee[] getEmployees() {
            return stack.toArray(new Employee[0]);
        }
}


