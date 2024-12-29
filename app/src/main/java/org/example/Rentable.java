package org.example;

/**
 * Interface defining rental operations.
 * To be implemented by all rental objects (e.g., vehicles).
 */
public interface Rentable {

    /**
     * Rent the object to a customer for a specified number of days.
     * customer the customer renting the object
     * days the rental period in days
     */
    void rent(Customer customer, int days);

    /**
     * Mark the object as returned.
     */
    void returnVehicle();
}
