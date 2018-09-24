/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.hotel.checkout;

import hotel.checkout.CheckoutCTL;
import hotel.credit.CreditCardType;
import hotel.entities.Hotel;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ranith
 */
public class CheckoutCTLTest {
    
    public CheckoutCTLTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    
    /**
     * Test of creditDetailsEntered method, of class CheckoutCTL.
     */
    @Test
    public void testCreditDetailsEntered() {
        System.out.println("creditDetailsEntered");
        CreditCardType type = CreditCardType.VISA;
        int number = 12345;
        int ccv = 556;
        Hotel hotel = new Hotel();
        CheckoutCTL instance = new CheckoutCTL(hotel);
        
       
        Exception exception = null;
        try {
            instance.creditDetailsEntered(type, number, ccv);
        } catch (Exception e) {
            exception = e;
        }
        assertEquals(exception instanceof Exception, true);
    }

   
    
}
