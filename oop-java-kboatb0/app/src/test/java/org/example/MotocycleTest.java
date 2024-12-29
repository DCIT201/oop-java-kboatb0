package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class MotocycleTest {
    @Test void testConstructor() {
        Motocycle moto = new Motocycle("car2", "Yamaha", 54);
        assertEquals("car2", moto.getVehicleId(), "Value mismatch");
        assertEquals("Yamaha", moto.getModel(), "Value mismatch");
        assertEquals(54, moto.getBaseRentalRate(), "Value mismatch");
    }

    @Test void testAvailability() {
        Motocycle moto = new Motocycle("car2", "Yamaha", 54);
        assertTrue(moto.isAvailableForRental(), "Should be true");
    }

    @Test void testRental() {
        Motocycle moto = new Motocycle("car2", "Yamaha", 54);;
        moto.rent(new Customer("Kwabena", 43), 48);
        assertFalse(moto.isAvailableForRental(),"Should be false");
    }

    @Test void testReturnVehicle() {
        Motocycle moto = new Motocycle("car2", "Yamaha", 54);
        moto.rent(new Customer("Kwabena", 43), 48);
        moto.returnVehicle();
        assertTrue(moto.isAvailableForRental(), "Should be true");
    }

    @Test void testCalculateCost() {
        Motocycle moto = new Motocycle("car2", "Yamaha", 10);
        assertEquals(200, moto.calculateRentalCost(10), "Value mismatch");
    }
}
