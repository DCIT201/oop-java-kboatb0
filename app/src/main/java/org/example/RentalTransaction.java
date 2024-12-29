package org.example;

import java.time.LocalDate;

/**
 * Represents a rental transaction between a customer and the rental agency.
 * Tracks details such as transaction ID, rental period, and total cost.
 */
public class RentalTransaction {
    private int TransactionID;       // Unique identifier for the transaction
    private Customer customer;       // Customer involved in the transaction
    private Vehicle vehicle;         // Vehicle being rented
    private LocalDate StartDate;     // Start date of the rental
    private LocalDate EndDate;       // End date of the rental
    private double totalCost;        // Total cost of the rental
    private boolean isCompleted;     // Status of the transaction

    // Constructor to initialize a rental transaction
    public RentalTransaction(int TransactionID, Customer customer, Vehicle vehicle, LocalDate StartDate, int days) {
        this.TransactionID = TransactionID;
        this.customer = customer;
        this.vehicle = vehicle;
        this.StartDate = StartDate;
        this.EndDate = LocalDate.now().plusDays(days);
        this.totalCost = vehicle.calculateRentalCost(days);
        isCompleted = false; // Transaction is ongoing by default
    }

    // Getter methods for transaction details
    public int getTransactionID() {
        return TransactionID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public LocalDate getStartDate() {
        return StartDate;
    }

    public LocalDate getEndDate() {
        return EndDate;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    // Marks the transaction as completed and returns the vehicle
    public void setCompleted() {
        isCompleted = true;
        vehicle.returnVehicle();
    }

    // String representation of the rental transaction
    @Override
    public String toString() {
        return "TransactionId: " + getTransactionID() + '\n' + "Customer: " + getCustomer().getName() + '\n' +
                "Vehicle: " + getVehicle().getModel() + '\n' + "Start Date: " + getStartDate() + '\n' +
                "End Date: " + getEndDate() + '\n' + "Total Cost: $" + getTotalCost() + '\n' +
                "Status: " + (isCompleted ? "Returned" : "Ongoing") + "\n";
    }
}
