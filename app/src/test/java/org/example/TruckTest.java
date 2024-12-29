package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TruckTest {
    @Test void testConstructor() {
        Truck tk = new Truck("tk1", "DAF", 53);
        assertEquals("tk1", tk.getVehicleId(), "Value mismatch");
        assertEquals("DAF", tk.getModel(), "Value mismatch");
        assertEquals(53, tk.getBaseRentalRate(), "Value mismatch");
    }

    @Test void testAvailability() {
        Car car = new Car("ct", "Tesla", 54, true);
        assertTrue(car.isAvailableForRental(), "Should be true");
    }

    @Test void testRental() {
        Car car1 = new Car("cr", "Range", 87, true);
        car1.rent(new Customer("Kwabena", 43), 48);
        assertFalse(car1.isAvailableForRental(),"Should be false");
    }

    @Test void testReturnVehicle() {
        Car car1 = new Car("cr", "Range", 87, true);
        car1.rent(new Customer("Kwabena", 43), 48);
        car1.returnVehicle();
        assertTrue(car1.isAvailableForRental(),"Should be true");
    }

    @Test void testCalculateCost() {
        Car car1 = new Car("cr", "Range", 10, true);
        assertEquals(550, car1.calculateRentalCost(10), "Value mismatch");
    }
}
