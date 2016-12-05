/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.indu.epicearc.business;

import ch.hearc.ig.odi.epicearc.business.ConiferSize;
import ch.hearc.ig.odi.epicearc.business.ConiferType;
import ch.hearc.ig.odi.epicearc.business.Product;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author johan.steiner
 */
public class TestProduct {
    
    @Test
    public void TestNewProductGetterSetter() {

        ConiferSize size = ConiferSize.BIG;
        ConiferType type = ConiferType.NORDMANN;
        Product prod = new Product();
        
        assertFalse(prod == null);
        
        prod.setId(Long.valueOf(1));
        prod.setPrice(Float.valueOf(100));
        prod.setConiferSize(size);
        prod.setConiferType(type);
        
        assertEquals(prod.getId(), new Long(1));
        assertEquals(prod.getPrice(), new Float(100));
        assertEquals(prod.getConiferSize().getCode().toUpperCase(), size.getCode().toUpperCase());
        assertEquals(prod.getConiferType().getCode().toUpperCase(), type.getCode().toUpperCase());
        
    }
    
}
