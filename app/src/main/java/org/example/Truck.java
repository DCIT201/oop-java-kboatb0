package org.example;

/**
 * Represents a Truck, a specific type of Vehicle.
 * Includes additional rental cost based on its weight.
 */
public class Truck extends Vehicle implements Rentable {
    private static final int WEIGHT = 100; // Fixed weight-based cost

    // Constructor to initialize Truck
    public Truck(String vehicleId, String model, double baseRentalRate) {
        super(vehicleId, model, baseRentalRate);
    }

    // Returns the fixed weight cost
    public static int getWeight() {
        return WEIGHT;
    }

    // Calculates the rental cost including weight-based cost
    @Override
    public double calculateRentalCost(int days) {
        return (getBaseRentalRate() * days + getWeight());
    }

    // Checks if the truck is available for rental
    @Override
    public boolean isAvailableForRental() {
        return super.getIsAvailable();
    }

    // Rents the truck to an eligible customer
    @Override
    public void rent(Customer customer, int days) {
        if (isAvailableForRental() && customer.checkEligibilityByAge()) {
            System.out.println(super.getModel() + " rented by " + customer.getName() + " for " + days + " days");
            super.setIsAvailable(false); // Mark truck as unavailable
        } else if (super.getIsAvailable() && !customer.checkEligibilityByAge()) {
            System.out.println("Ineligible to rent a vehicle");
        }
    }

    // Marks the truck as returned
    @Override
    public void returnVehicle() {
        System.out.println(super.getModel() + " returned");
        super.setIsAvailable(true); // Mark truck as available
    }
}
