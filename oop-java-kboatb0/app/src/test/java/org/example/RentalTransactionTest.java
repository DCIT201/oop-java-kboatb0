package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class RentalTransactionTest {
    private Vehicle car;
    private Customer customer;

    @BeforeEach
    void setUp() {
        car = new Car("tl", "Tesla", 43, true);
        customer = new Customer("Kwabena", 44);
    }

    @Test void testConstructor() {
        RentalTransaction rat = new RentalTransaction(23, customer, car, LocalDate.now(), 4);
        assertEquals(23, rat.getTransactionID(), "Value mismatch");
        assertEquals("Kwabena", rat.getCustomer().getName(), "Value mismatch");
        assertEquals(44, rat.getCustomer().getAge(), "Value mismatch");
        assertFalse(rat.isCompleted(), "Should be false");
    }

    @Test void testCompleted() {
        RentalTransaction rat = new RentalTransaction(23, customer, car, LocalDate.now(), 4);
        rat.setCompleted();
        assertTrue(rat.isCompleted(), "Should be true");
    }

}
