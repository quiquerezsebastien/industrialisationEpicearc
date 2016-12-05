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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author johan.steiner
 */
public class TestOrder {
        
    @Test
    public void TestOrderNotNull() throws ParseException {
        
        SimpleDateFormat dateForm = new SimpleDateFormat("dd/MM/yy");
        Date date = dateForm.parse("15/05/13");
        
        Customer customer = new Customer(Long.valueOf(1), "Johan", "Steiner", "Clos Beausan 1", "2736", "Sorvilier", "0324921211", "johan.steiner@he-arc.ch");
        Product product = new Product(Long.valueOf(1), Float.valueOf(100), ConiferType.SPRUCE, ConiferSize.MINI);
        DeliveryDate dateDeliv = new DeliveryDate(Long.valueOf(1), date, ConiferType.SPRUCE);
        PickupDate datePickup = new PickupDate(Long.valueOf(1), date, ConiferType.SPRUCE);
        
        Order order = new Order(Long.valueOf(1), date, Float.valueOf(100), dateDeliv, datePickup, product, customer);
    }
    
    @Test
    public void TestNewOrderGetterSetter() throws ParseException {
        
        SimpleDateFormat dateForm = new SimpleDateFormat("dd/MM/yy");
        Date date = dateForm.parse("15/05/13");
        
        Customer customer = new Customer(Long.valueOf(1), "Johan", "Steiner", "Clos Beausan 1", "2736", "Sorvilier", "0324921211", "johan.steiner@he-arc.ch");
        Product product = new Product(Long.valueOf(1), Float.valueOf(100), ConiferType.SPRUCE, ConiferSize.MINI);
        DeliveryDate dateDeliv = new DeliveryDate(Long.valueOf(1), date, ConiferType.SPRUCE);
        PickupDate datePickup = new PickupDate(Long.valueOf(1), date, ConiferType.SPRUCE);
        
        Order order = new Order();  
        assertFalse(order==null);
        
        order.setId(Long.valueOf(1));
        order.setDate(date);
        order.setAmount(Float.valueOf(100));
        order.setDeliveryDate(dateDeliv);
        order.setPickupDate(datePickup);
        order.setProduct(product);
        order.setCustomer(customer);
        
        assertEquals(order.getId(), Long.valueOf(1));
        assertEquals(order.getDate(), date);
        assertEquals(order.getAmount(), Float.valueOf(100));
        assertEquals(order.getDeliveryDate(), dateDeliv);
        assertEquals(order.getPickupDate(), datePickup);
        assertEquals(order.getProduct(), product);
        assertEquals(order.getCustomer(), customer);
    }
    
}
