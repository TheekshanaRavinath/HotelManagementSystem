/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.hotel.checkin;

import hotel.checkin.CheckinCTL;
import hotel.entities.Hotel;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ranith
 */
public class CheckinCTLTest {
    
    public CheckinCTLTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of checkInConfirmed method, of class CheckinCTL.
     */
    @Test
    public void testCheckInConfirmed() {
        System.out.println("checkInConfirmed");
        boolean confirmed = false;
        Hotel hotel = new Hotel();
        CheckinCTL instance = new CheckinCTL(hotel);
        
        Exception exception = null;
        
        try {
            instance.checkInConfirmed(confirmed);
        } catch (Exception e) {
            exception = e;
        }
        assertEquals(exception instanceof Exception, true);
    }

    
}
