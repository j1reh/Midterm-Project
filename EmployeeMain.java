package MidtermProject;

import javax.swing.*;

public class EmployeeMain {
    public static void main(String[] args) {
        // Create instances of the data structure classes
        PredefinedArrayList arrayList = new PredefinedArrayList();
        PredefinedLinkedList linkedList = new PredefinedLinkedList();
        PredefinedQueue queue = new PredefinedQueue();
        PredefinedStack stack = new PredefinedStack();

        String[] options = {"ArrayList", "LinkedList", "Queue", "Stack", "Exit"};
        String input;

        while (true) {
            // Show the option dialog
            input = (String) JOptionPane.showInputDialog(null,
                    "Choose a data structure:",
                    "Data Structure Selector",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);

            if (input == null || input.equals("Exit")) {
                break; // Exit the loop if canceled or "Exit" is selected
            }

            // Perform actions based on selected data structure
            switch (input) {
                case "ArrayList":
                    handleArrayList(arrayList);
                    break;
                case "LinkedList":
                    handleLinkedList(linkedList);
                    break;
                case "Queue":
                    handleQueue(queue);
                    break;
                case "Stack":
                    handleStack(stack);
                    break;
            }
        }
    }

    private static void handleArrayList(PredefinedArrayList arrayList) {
        String[] options = {"Add Employee", "Remove Employee", "Search Employee", "Display Employees", "Back"};
        String input;
        while (true) {
            input = (String) JOptionPane.showInputDialog(null,
                    "Choose an operation for ArrayList:",
                    "ArrayList Operations",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);

            if (input == null || input.equals("Back")) {
                break;
            }

            switch (input) {
                case "Add Employee":
                    String name = JOptionPane.showInputDialog("Enter name:");
                    String position = JOptionPane.showInputDialog("Enter position:");
                    byte age = Byte.parseByte(JOptionPane.showInputDialog("Enter age:"));
                    int id = Integer.parseInt(JOptionPane.showInputDialog("Enter ID:"));
                    arrayList.add(new Employee(name, position, age, id));
                    break;
                case "Remove Employee":
                    int removeId = Integer.parseInt(JOptionPane.showInputDialog("Enter ID to remove:"));
                    if (arrayList.remove(removeId)) {
                        JOptionPane.showMessageDialog(null, "Employee removed successfully.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Employee not found.");
                    }
                    break;
                case "Search Employee":
                    int searchId = Integer.parseInt(JOptionPane.showInputDialog("Enter ID to search:"));
                    Employee employee = arrayList.searchByID(searchId);
                    if (employee != null) {
                        JOptionPane.showMessageDialog(null, employee.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "Employee not found.");
                    }
                    break;
                case "Display Employees":
                    Employee[] employees = arrayList.getEmployees();
                    StringBuilder display = new StringBuilder("Employees:\n");
                    for (Employee emp : employees) {
                        display.append(emp.toString()).append("\n\n");
                    }
                    JOptionPane.showMessageDialog(null, display.toString());
                    break;
            }
        }
    }

    private static void handleLinkedList(PredefinedLinkedList linkedList) {
        String[] options = {"Add Employee", "Remove Employee", "Search Employee", "Display Employees", "Back"};
        String input;
        while (true) {
            input = (String) JOptionPane.showInputDialog(null,
                    "Choose an operation for LinkedList:",
                    "LinkedList Operations",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);

            if (input == null || input.equals("Back")) {
                break;
            }

            switch (input) {
                case "Add Employee":
                    String name = JOptionPane.showInputDialog("Enter name:");
                    String position = JOptionPane.showInputDialog("Enter position:");
                    byte age = Byte.parseByte(JOptionPane.showInputDialog("Enter age:"));
                    int id = Integer.parseInt(JOptionPane.showInputDialog("Enter ID:"));
                    linkedList.add(new Employee(name, position, age, id));
                    break;
                case "Remove Employee":
                    int removeId = Integer.parseInt(JOptionPane.showInputDialog("Enter ID to remove:"));
                    if (linkedList.remove(removeId)) {
                        JOptionPane.showMessageDialog(null, "Employee removed successfully.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Employee not found.");
                    }
                    break;
                case "Search Employee":
                    int searchId = Integer.parseInt(JOptionPane.showInputDialog("Enter ID to search:"));
                    Employee employee = linkedList.searchByID(searchId);
                    if (employee != null) {
                        JOptionPane.showMessageDialog(null, employee.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "Employee not found.");
                    }
                    break;
                case "Display Employees":
                    Employee[] employees = linkedList.getEmployees();
                    StringBuilder display = new StringBuilder("Employees:\n");
                    for (Employee emp : employees) {
                        display.append(emp.toString()).append("\n\n");
                    }
                    JOptionPane.showMessageDialog(null, display.toString());
                    break;
            }
        }
    }

    private static void handleQueue(PredefinedQueue queue) {
        String[] options = {"Add Employee", "Remove Employee", "Search Employee", "Display Employees", "Back"};
        String input;
        while (true) {
            input = (String) JOptionPane.showInputDialog(null,
                    "Choose an operation for Queue:",
                    "Queue Operations",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);

            if (input == null || input.equals("Back")) {
                break;
            }

            switch (input) {
                case "Add Employee":
                    String name = JOptionPane.showInputDialog("Enter name:");
                    String position = JOptionPane.showInputDialog("Enter position:");
                    byte age = Byte.parseByte(JOptionPane.showInputDialog("Enter age:"));
                    int id = Integer.parseInt(JOptionPane.showInputDialog("Enter ID:"));
                    queue.enqueue(new Employee(name, position, age, id));
                    break;
                case "Remove Employee":
                    Employee removed = queue.dequeue();
                    if (removed != null) {
                        JOptionPane.showMessageDialog(null, "Removed: " + removed.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "Queue is empty.");
                    }
                    break;
                case "Search Employee":
                    int searchId = Integer.parseInt(JOptionPane.showInputDialog("Enter ID to search:"));
                    Employee employee = queue.searchByID(searchId);
                    if (employee != null) {
                        JOptionPane.showMessageDialog(null, employee.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "Employee not found.");
                    }
                    break;
                case "Display Employees":
                    Employee[] employees = queue.getEmployees();
                    StringBuilder display = new StringBuilder("Employees:\n");
                    for (Employee emp : employees) {
                        display.append(emp.toString()).append("\n\n");
                    }
                    JOptionPane.showMessageDialog(null, display.toString());
                    break;
            }
        }
    }

    private static void handleStack(PredefinedStack stack) {
        String[] options = {"Add Employee", "Remove Employee", "Search Employee", "Display Employees", "Back"};
        String input;
        while (true) {
            input = (String) JOptionPane.showInputDialog(null,
                    "Choose an operation for Stack:",
                    "Stack Operations",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);

            if (input == null || input.equals("Back")) {
                break;
            }

            switch (input) {
                case "Add Employee":
                    String name = JOptionPane.showInputDialog("Enter name:");
                    String position = JOptionPane.showInputDialog("Enter position:");
                    byte age = Byte.parseByte(JOptionPane.showInputDialog("Enter age:"));
                    int id = Integer.parseInt(JOptionPane.showInputDialog("Enter ID:"));
                    stack.push(new Employee(name, position, age, id));
                    break;
                case "Remove Employee":
                    Employee popped = stack.pop();
                    if (popped != null) {
                        JOptionPane.showMessageDialog(null, "Removed: " + popped.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "Stack is empty.");
                    }
                    break;
                case "Search Employee":
                    int searchId = Integer.parseInt(JOptionPane.showInputDialog("Enter ID to search:"));
                    Employee employee = stack.searchByID(searchId);
                    if (employee != null) {
                        JOptionPane.showMessageDialog(null, employee.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "Employee not found.");
                    }
                    break;
                case "Display Employees":
                    Employee[] employees = stack.getEmployees();
                    StringBuilder display = new StringBuilder("Employees:\n");
                    for (Employee emp : employees) {
                        display.append(emp.toString()).append("\n\n");
                    }
                    JOptionPane.showMessageDialog(null, display.toString());
                    break;
            }
        }
    }
}
