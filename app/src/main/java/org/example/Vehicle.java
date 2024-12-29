package org.example;

/**
 * Abstract class representing a generic vehicle.
 * Implements Rentable interface for rental functionalities.
 */
public abstract class Vehicle implements Rentable {
    private String vehicleId;       // Unique identifier for the vehicle
    private String model;           // Model name of the vehicle
    private double baseRentalRate;  // Base rental rate per day
    private boolean isAvailable;    // Availability status of the vehicle

    // Constructor to initialize the vehicle
    public Vehicle(String vehicleId, String model, double baseRentalRate) {
        this.vehicleId = vehicleId;
        this.model = model;
        this.baseRentalRate = baseRentalRate;
        isAvailable = true; // Vehicle is available by default
    }

    // Getter and setter methods for the attributes
    public String getVehicleId() {
        return vehicleId;
    }

    public String getModel() {
        return model;
    }

    public double getBaseRentalRate() {
        return baseRentalRate;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setBaseRentalRate(double baseRentalRate) {
        this.baseRentalRate = baseRentalRate;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    // String representation of the vehicle
    @Override
    public String toString() {
        return "VehicleID: " + getVehicleId() + ", Model: " + getModel();
    }

    // Equality check based on object instance
    @Override
    public boolean equals(Object obj) {
        return (this == obj);
    }

    // Abstract methods to be implemented by subclasses
    public abstract double calculateRentalCost(int days);
    public abstract boolean isAvailableForRental();
    public abstract void rent(Customer customer, int rentalDays);
    public abstract void returnVehicle();
}
