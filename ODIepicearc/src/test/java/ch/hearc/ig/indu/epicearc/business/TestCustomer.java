/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.indu.epicearc.business;

import ch.hearc.ig.odi.epicearc.business.Customer;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author sebastie.quiquere
 */
public class TestCustomer {
    
    @Test
    public void TestNewCustomerNotNull() {
        Customer custo1 = new Customer(new Long(1), "Jules", "Césard", "Rue des tests", "2000", "Neuchâtel", "0123456789", "info@test.ch");
        
        assertFalse(custo1 == null);
    }
    
    @Test
    public void TestNewCustomerGetterSetter() {
        Customer custo = new Customer();
        
        assertFalse(custo == null);
        
        custo.setAddress("Rue des tests");
        custo.setCity("Neuchâtel");
        custo.setEmail("info@test.ch");
        custo.setFirstName("Jules");
        custo.setLastName("Cézard");
        custo.setId(new Long(1));
        custo.setPhone("0123456789");
        custo.setZip("2000");
        
        assertEquals(new Long(1), custo.getId());
        assertEquals("Rue des tests", custo.getAddress());
        assertEquals("Neuchâtel", custo.getCity());
        assertEquals("info@test.ch", custo.getEmail());
        assertEquals("Jules", custo.getFirstName());
        assertEquals("Cézard", custo.getLastName());
        assertEquals("0123456789", custo.getPhone());
        assertEquals("2000", custo.getZip());
    }
    
    
    
}
