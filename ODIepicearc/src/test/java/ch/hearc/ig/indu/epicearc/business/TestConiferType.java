/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.indu.epicearc.business;

import ch.hearc.ig.odi.epicearc.business.ConiferType;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author johan.steiner
 */
public class TestConiferType {
    
    @Test
    public void TestNewConiferTypeGetterSetter() {
        ConiferType type = ConiferType.NOBILIS;
        assertEquals(type.getCode().toUpperCase(), "NOBILIS");
        
        type.setCode("SPRUCE");
        assertEquals(type.getCode().toUpperCase(), "SPRUCE");
    }
    
}
