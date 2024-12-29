package org.example;

/**
 * Represents a Motorcycle, a specific type of Vehicle.
 * Includes additional cost for protective clothing.
 */
public class Motocycle extends Vehicle implements Rentable {
    private static final int PROTECTIVE_CLOTHING_COST = 100; // Cost for protective clothing

    // Constructor to initialize Motorcycle
    public Motocycle(String vehicleId, String model, double baseRentalRate) {
        super(vehicleId, model, baseRentalRate);
    }

    // Returns the protective clothing cost
    public static int getProtectiveClothingCost() {
        return PROTECTIVE_CLOTHING_COST;
    }

    // Calculates the rental cost including protective clothing cost
    @Override
    public double calculateRentalCost(int days) {
        return (getBaseRentalRate() * days + getProtectiveClothingCost());
    }

    // Checks if the motorcycle is available for rental
    @Override
    public boolean isAvailableForRental() {
        return super.getIsAvailable();
    }

    // Rents the motorcycle to an eligible customer
    @Override
    public void rent(Customer customer, int days) {
        if (isAvailableForRental() && customer.checkEligibilityByAge()) {
            System.out.println(super.getModel() + " rented by " + customer.getName() + " for " + days + " days");
            super.setIsAvailable(false); // Mark motorcycle as unavailable
        } else if (super.getIsAvailable() && !customer.checkEligibilityByAge()) {
            System.out.println("Ineligible to rent a vehicle");
        }
    }

    // Marks the motorcycle as returned
    @Override
    public void returnVehicle() {
        System.out.println(super.getModel() + " returned");
        super.setIsAvailable(true); // Mark motorcycle as available
    }
}
