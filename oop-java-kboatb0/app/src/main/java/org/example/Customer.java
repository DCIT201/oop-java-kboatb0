package org.example;

/**
 * Represents a customer in the rental system.
 * Stores customer details and tracks loyalty points.
 */
public class Customer {
    private String name;            // Name of the customer
    private int age;                // Age of the customer
    private int loyaltyPoints;      // Loyalty points earned by the customer

    // Constructor to initialize a new customer
    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
        this.loyaltyPoints = 0; // Initial loyalty points
    }

    // Setter methods for name and age
    public void setName(String name) {
        this.name = name;
    }

    public final void setAge(int age) {
        this.age = age;
    }

    // Getter methods for customer attributes
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    // Checks if the customer is eligible to rent based on age
    public boolean checkEligibilityByAge() {
        return getAge() >= 18;
    }

    // Adds loyalty points to the customer's account
    public void addLoyaltyPoints(int points) {
        loyaltyPoints += points;
    }

    // String representation of the customer
    @Override
    public String toString() {
        return "Customer name: " + getName() + ", Age: " + getAge();
    }
}
