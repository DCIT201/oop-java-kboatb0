package org.example;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Represents a rental agency.
 * Manages vehicles, customers, and rental transactions.
 */
public class RentalAgency {
    private final ArrayList<Vehicle> vehicles = new ArrayList<>();         // List of available vehicles
    private final ArrayList<RentalTransaction> transactions = new ArrayList<>(); // List of rental transactions
    private final ArrayList<Customer> customers = new ArrayList<>();      // List of registered customers

    // Adds a vehicle to the agency's inventory
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    // Registers a new customer
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    // Processes a rental transaction for a given vehicle and customer
    public void processTransaction(String vehicleModel, String customerName, int rentalDays) {
        try {
            Vehicle vehicle = findAvailableVehicle(vehicleModel);
            Customer customer = findCustomer(customerName);

            int transactionId = transactions.size() + 1;

            RentalTransaction transaction = new RentalTransaction(transactionId, customer, vehicle, LocalDate.now(), rentalDays);

            vehicle.rent(customer, rentalDays);

            transactions.add(transaction);

            System.out.println("Rental Successful");
            System.out.println(transaction);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    // Finds an available vehicle by model name
    public Vehicle findAvailableVehicle(String model) {
        return vehicles.stream()
                .filter(vehicle -> vehicle.getModel().equals(model) && vehicle.isAvailableForRental())
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Vehicle not found or Has already been rented"));
    }

    // Finds a registered customer by name
    public Customer findCustomer(String name) {
        return customers.stream()
                .filter(customer -> customer.getName().equalsIgnoreCase(name) && customer.checkEligibilityByAge())
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid age or Customer not found"));
    }

    // Displays all vehicles
    public void viewVehicles() {
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }

    // Displays all transactions
    public void viewTransactions() {
        for (RentalTransaction transaction : transactions) {
            System.out.println(transaction);
        }
    }

    // Displays all customers
    public void viewCustomers() {
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    // Completes a rental transaction by marking it as completed
    public void completeTransaction(int transactionID) {
        for (RentalTransaction transaction : transactions) {
            if (transaction.getTransactionID() == transactionID && !transaction.isCompleted()) {
                transaction.setCompleted();
                return;
            }
        }
        System.out.println("Transaction not found or Has already been completed");
    }
}
