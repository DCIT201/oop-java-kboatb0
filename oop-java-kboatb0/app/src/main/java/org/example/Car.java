package org.example;

/**
 * Represents a Car, a specific type of Vehicle.
 * Includes an optional air conditioning feature.
 */
public class Car extends Vehicle implements Rentable {
    private static boolean hasAirConditioner; // Indicates if the car has air conditioning

    // Constructor to initialize Car
    public Car(String vehicleId, String model, double baseRentalRate, boolean hasAirConditioner) {
        super(vehicleId, model, baseRentalRate);
        Car.hasAirConditioner = hasAirConditioner;
    }

    // Returns the air conditioning status
    public static boolean getHasAirConditioner() {
        return hasAirConditioner;
    }

    // Calculates the rental cost based on air conditioning status
    @Override
    public double calculateRentalCost(int days) {
        return (getBaseRentalRate() * days + (getHasAirConditioner() ? 1000 : 0)) / 2;
    }

    // Checks if the car is available for rental
    @Override
    public boolean isAvailableForRental() {
        return super.getIsAvailable();
    }

    // Rents the car to an eligible customer
    @Override
    public void rent(Customer customer, int days) {
        if (isAvailableForRental() && customer.checkEligibilityByAge()) {
            System.out.println(super.getModel() + " rented by " + customer.getName() + " for " + days + " days");
            super.setIsAvailable(false); // Mark car as unavailable
        }
    }

    // Marks the car as returned
    @Override
    public void returnVehicle() {
        super.setIsAvailable(true); // Mark car as available
        System.out.println(super.getModel() + " returned");
    }
}
