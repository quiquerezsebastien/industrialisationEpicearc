/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.indu.epicearc.business;

import ch.hearc.ig.odi.epicearc.business.ConiferSize;
import ch.hearc.ig.odi.epicearc.business.ConiferType;
import ch.hearc.ig.odi.epicearc.business.Customer;
import ch.hearc.ig.odi.epicearc.business.DeliveryDate;
import ch.hearc.ig.odi.epicearc.business.Order;
import ch.hearc.ig.odi.epicearc.business.PickupDate;
import ch.hearc.ig.odi.epicearc.business.Product;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author johan.steiner
 */
public class TestOrder {
        
    @Test
    public void TestOrderNotNull() {
        Customer customer = new Customer(Long.valueOf(1), "Johan", "Steiner", "Clos Beausan 1", "2736", "Sorvilier", "0324921211", "johan.steiner@he-arc.ch");
        Product product = new Product(Long.valueOf(1), Float.valueOf(100), ConiferType.SPRUCE, ConiferSize.MINI);
        DeliveryDate dateDeliv = new DeliveryDate(Long.valueOf(1), "15.05.13", ConiferType.SPRUCE);
        PickupDate datePickup = new PickupDate(Long.valueOf(1), "18.05.15", ConiferType.SPRUCE);
        
        Order order = new Order(Long.valueOf(1), "13.05.13", Float.valueOf(100), dateDeliv, datePickup, product, customer);
    }
    
    @Test
    public void TestNewOrderGetterSetter() {
        
        Order order = new Order();
        
        assertFalse(order==null);
    }
    
}
