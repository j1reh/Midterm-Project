/**
 * 
 * 
 * @author ji
 */
package MidtermProject;

public class ProgDefStackArray {
    
    class EmployeeStackArray {
        private Employee[] stack;
        private int top;

        // constructor
        public EmployeeStackArray(int capacity) {
            stack = new Employee[capacity];
            top = -1;
        }

        // push
        public void push(Employee e) {
            if (top == stack.length - 1) {
                System.out.println("Stack is full");
            } else {
                stack[++top] = e;
            }
        }

        // pop
        public Employee pop() {
            if (top == -1) {
                System.out.println("Stack is empty");
                return null;
            }
            return stack[top--];
        }

        // search by ID
        public Employee searchByID(int id) {
            for (int i = 0; i <= top; i++) {
                if (stack[i] != null && stack[i].getID() == id) {
                    return stack[i]; 
                }
            }
            // employee not found
            return null; 
        }
        
        // display as array
        public Employee[] getEmployees() {
            Employee[] result = new Employee[top + 1];
            System.arraycopy(stack, 0, result, 0, top + 1);
            return result;
        }
    }
}