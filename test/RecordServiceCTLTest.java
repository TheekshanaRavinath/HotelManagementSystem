/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.hotel.service;

import hotel.entities.Hotel;
import hotel.entities.ServiceType;
import hotel.service.RecordServiceCTL;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Isurika
 */
public class RecordServiceCTLTest {
   
    public RecordServiceCTLTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }


    /**
     * Test of serviceDetailsEntered method, of class RecordServiceCTL.
     */
    @Test
    public void testServiceDetailsEntered() {
        System.out.println("serviceDetailsEntered");
        Exception exp = null;
        
        ServiceType serviceType = ServiceType.BAR_FRIDGE;
        double cost = 300.0;
        Hotel hotel = new Hotel();
        RecordServiceCTL instance = new RecordServiceCTL(hotel);
        try {
            instance.serviceDetailsEntered(serviceType, cost);
        } catch (Exception e) {
            exp = e;
        }
        
        assertEquals(exp instanceof Exception, true);
        
        
    }

    
}
