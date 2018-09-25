/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hotel.checkout;

import hotel.credit.CreditCardType;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sithija Madusanka
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
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of run method, of class CheckoutCTL.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        CheckoutCTL instance = null;
        instance.run();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of roomIdEntered method, of class CheckoutCTL.
     */
    @Test
    public void testRoomIdEntered() {
        System.out.println("roomIdEntered");
        int roomId = 0;
        CheckoutCTL instance = null;
        instance.roomIdEntered(roomId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of chargesAccepted method, of class CheckoutCTL.
     */
    @Test
    public void testChargesAccepted() {
        System.out.println("chargesAccepted");
        boolean accepted = false;
        CheckoutCTL instance = null;
        instance.chargesAccepted(accepted);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of creditDetailsEntered method, of class CheckoutCTL.
     */
    @Test
    public void testCreditDetailsEntered() {
        System.out.println("creditDetailsEntered");
        CreditCardType type = null;
        int number = 0;
        int ccv = 0;
        CheckoutCTL instance = null;
        instance.creditDetailsEntered(type, number, ccv);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cancel method, of class CheckoutCTL.
     */
    @Test
    public void testCancel() {
        System.out.println("cancel");
        CheckoutCTL instance = null;
        instance.cancel();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of completed method, of class CheckoutCTL.
     */
    @Test
    public void testCompleted() {
        System.out.println("completed");
        CheckoutCTL instance = null;
        instance.completed();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
