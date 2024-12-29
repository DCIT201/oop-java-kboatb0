package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class RentalAgencyTest {
    private RentalTransaction rat;
    private RentalAgency ratAgency;
    private Vehicle car;
    private Customer customer;

    @BeforeEach
    void setUp() {
        car = new Car("tl", "Tesla", 43, true);
        customer = new Customer("Kwabena", 44);
        rat = new RentalTransaction(1, customer, car, LocalDate.now(), 4);
        ratAgency = new RentalAgency();
    }

    @Test void testAddVehicle() {
        ratAgency.addVehicle(car);
        assertEquals("Tesla", car.getModel(), "Value mismatch");
        assertEquals("tl", car.getVehicleId(), "Value mismatch");
        assertEquals(43, car.getBaseRentalRate(), "Value mismatch");
    }

    @Test void testAddCustomer() {
        ratAgency.addCustomer(customer);
        assertEquals("Kwabena", customer.getName(), "Value mismatch");
        assertEquals(44, customer.getAge(), "Value mismatch");
    }

    @Test void testFindAvailableVehicle() {
        ratAgency.addVehicle(car);
        ratAgency.findAvailableVehicle("Tesla");
        assertEquals("Tesla", car.getModel(), "Value mismatch");
    }

    @Test void testProcessTransaction() {
        ratAgency.processTransaction("tl", "Kwabena", 4);
        assertEquals("Tesla", car.getModel(), "Value mismatch");
        assertEquals("tl", car.getVehicleId(), "Value mismatch");
        assertEquals(586, car.calculateRentalCost(4), "Value mismatch");
        assertEquals("Kwabena", customer.getName(), "Value mismatch");
        assertEquals(44, customer.getAge(), "Value mismatch");
    }

    @Test void testFindCustomer() {
        ratAgency.addCustomer(customer);
        ratAgency.findCustomer("Kwabena");
        assertEquals("Kwabena", customer.getName(), "Value mismatch");
    }
}
