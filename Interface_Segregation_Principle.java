/**
 * A java program to demonstrate Interface Segregation Principle.
 * Illustrates separate interfaces for managing regular employees and managers.
 *
 * @author Noor Haider Khan
 * @version 1.0
 * @since 2024-04-21
 */

// Interface for managing employees
interface Employee {
    /**
     * Performs the work related to the employee's role.
     */
    void work();
}

// Interface for managing regular employees
interface RegularEmployee extends Employee {
    /**
     * Allows a regular employee to take a break.
     */
    void takeBreak();
}

// Interface for managing managers
interface Manager extends Employee {
    /**
     * Allows a manager to conduct a meeting.
     */
    void conductMeeting();
}

// Class representing a regular employee handler
class RegularEmployeeHandler implements RegularEmployee {
    @Override
    public void work() {
        System.out.println("Regular employee is working");
    }

    @Override
    public void takeBreak() {
        System.out.println("Regular employee is taking a break");
    }
}

// Class representing a manager handler
class ManagerHandler implements Manager {
    @Override
    public void work() {
        System.out.println("Manager is working");
    }

    @Override
    public void conductMeeting() {
        System.out.println("Manager is conducting a meeting");
    }
}

// Demo class demonstrating the Interface Segregation Principle
public class Interface_Segregation_Principle {
    public static void main(String[] args) {
        // Using regular employee functionalities
        RegularEmployee regularEmployee = new RegularEmployeeHandler();
        regularEmployee.work();
        regularEmployee.takeBreak();

        // Using manager functionalities
        Manager manager = new ManagerHandler();
        manager.work();
        manager.conductMeeting();
    }
}
