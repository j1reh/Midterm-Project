
/**
 *
 * @author ji
 */
package MidtermProject;

public class ProgDefArray {
    
   final int arraySize = 100;
   Employee[] employeeList;
   int size;
   
   ProgDefArray(){
      employeeList = new Employee[arraySize];
      this.size = 0;
   }
   public void setSize(int size){
      this.size = size;
   }
   public int getSize(){
      return this.size;
   }
   
   // add employee - option 1
   public boolean addEmployee(Employee employee){
      if (searchByID(employee.getID()) != null) {
          return false;
      }
      employeeList[size] = new Employee(employee);
      this.size++;
      return true;
   }
   
   // add employee with index - option 2
   public boolean addEmployeeWithIndex(Employee employee, int index){
      if (searchByID(employee.getID()) != null) {
        return false; 
      }
      if (this.size == employeeList.length) {
         this.size++;
      }
      Employee temp = employeeList[index];
      employeeList[index] = employee;
      for (int i = index + 1; i <= this.size; i++) {
         Employee nextTemp = employeeList[i];
         employeeList[i] = temp;
         temp = nextTemp;
      }
      return true;
   }
   
   // remove by id
   public boolean removeEmployee(int id) {
      int indexToRemove;
      for (int i = 0; i < this.size; i++) {
         if (employeeList[i] != null && employeeList[i].getID() == id) {
            for (int x = i; x < this.size - 1; x++) {
               employeeList[x] = employeeList[x+1];
            }
            employeeList[this.size - 1] = null;
            this.size--;
            return true;
         }
      }
      return false;
   }
   
   // remove last
   public boolean removeLastIndex() {
      if (size > 0) {
         employeeList[size - 1] = null;
         size--;
         return true;
      }
      return false;
   }
   
   // remove by index
   public boolean removeEmployeeByIndex(int index){
      employeeList[index] = null;
      for (int x = index; x < this.size - 1; x++) {
         employeeList[x] = employeeList[x+1];
      }
      this.size--;
      return true;
   }
   
   // search by id
   public Employee searchByID(int id) {
      for (int i = 0; i < this.size; i++) {
         if (employeeList[i] != null && employeeList[i].getID() == id) {
            return employeeList[i]; 
         }
      }
      return null; 
   }
   
   // search by index
   public Employee searchByIndex(int index) {
      if(index >= 0 && index < this.size && employeeList[index] != null){
         return employeeList[index]; 
      }
      return null;
   }
   
   // search by name
   public Employee searchByName(String name) {
      for (int i = 0; i < this.size; i++) {
         if (employeeList[i] != null && employeeList[i].getName().equalsIgnoreCase(name)) {
            return employeeList[i]; 
         }
      }
      return null; 
   }
   
   // empty array
   public void makeEmpty() {
      employeeList = new Employee[arraySize];
      this.size = 0;
   }

   // display employee list
  public Employee[] getEmployees() {
        Employee[] result = new Employee[size];
        System.arraycopy(employeeList, 0, result, 0, size);
        return result;
    }
   
    // selection Sort
    public void selectionSort() {
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (employeeList[j].getID() < employeeList[minIndex].getID()) {
                    minIndex = j;
                }
            }
            Employee temp = employeeList[minIndex];
            employeeList[minIndex] = employeeList[i];
            employeeList[i] = temp;
        }
    }

    // bubble Sort
    public void bubbleSort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (employeeList[j].getID() > employeeList[j + 1].getID()) {
                    Employee temp = employeeList[j];
                    employeeList[j] = employeeList[j + 1];
                    employeeList[j + 1] = temp;
                }
            }
        }
    }

    // insertion Sort
    public void insertionSort() {
        for (int i = 1; i < size; i++) {
            Employee key = employeeList[i];
            int j = i - 1;
            while (j >= 0 && employeeList[j].getID() > key.getID()) {
                employeeList[j + 1] = employeeList[j];
                j--;
            }
            employeeList[j + 1] = key;
        }
    }

    // quick Sort
    public void quickSort() {
        quickSortHelper(0, size - 1);
    }

    private void quickSortHelper(int low, int high) {
        if (low < high) {
            int pi = partition(low, high);
            quickSortHelper(low, pi - 1);
            quickSortHelper(pi + 1, high);
        }
    }

    private int partition(int low, int high) {
        int pivot = employeeList[high].getID();
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (employeeList[j].getID() < pivot) {
                i++;
                Employee temp = employeeList[i];
                employeeList[i] = employeeList[j];
                employeeList[j] = temp;
            }
        }

        Employee temp = employeeList[i + 1];
        employeeList[i + 1] = employeeList[high];
        employeeList[high] = temp;

        return i + 1;
    }

    // merge Sort
    public void mergeSort() {
        mergeSortHelper(0, size - 1);
    }

    private void mergeSortHelper(int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSortHelper(left, mid);
            mergeSortHelper(mid + 1, right);
            merge(left, mid, right);
        }
    }

    private void merge(int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        Employee[] L = new Employee[n1];
        Employee[] R = new Employee[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = employeeList[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = employeeList[mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i].getID() <= R[j].getID()) {
                employeeList[k] = L[i];
                i++;
            } else {
                employeeList[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            employeeList[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            employeeList[k] = R[j];
            j++;
            k++;
        }
    }
}
