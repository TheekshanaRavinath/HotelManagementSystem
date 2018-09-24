/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.hotel.entities;

import hotel.credit.CreditCard;
import hotel.credit.CreditCardType;
import hotel.entities.Booking;
import hotel.entities.Guest;
import hotel.entities.Hotel;
import hotel.entities.Room;
import hotel.entities.RoomType;
import hotel.entities.ServiceType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ranith
 */
public class HotelTest {
    Room room;
    Guest guest;
    SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
    Date date;
    CreditCard creditCardd;
    ServiceType serviceType;
    
    public HotelTest() throws ParseException {
        this.room = new Room(101, RoomType.DOUBLE);
        this.guest = new Guest("Ranith", "Tarnit", 457896542);
        this.date = sd.parse("25-02-2019");
        this.creditCardd = new CreditCard(CreditCardType.VISA, 12345, 558);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    /**
     * Test of book method, of class Hotel.
     */
    @Test
    public void testBook() {
        System.out.println("book");
        Room room = this.room;
        Guest guest = this.guest;
        Date arrivalDate = this.date;
        int stayLength = 5;
        int occupantNumber = 2;
        CreditCard creditCard = this.creditCardd;
        Hotel instance = new Hotel();
        long expResult = 2512019101l;
        long result = instance.book(room, guest, arrivalDate, stayLength, occupantNumber, creditCard);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of checkin method, of class Hotel.
     */
    @Test
    public void testCheckin() {
        System.out.println("checkin");
               
        long confirmationNumber = 2512019101l;
        Hotel instance = new Hotel();
        
        
        //an error should be thrown as "No Active booking for confirmation number : 2512019101"
        //because there is no any reserved room already
        Exception exception = null;
        try {
            instance.checkin(confirmationNumber);
        } catch (Exception e) {
            exception = e;
        }
        assertEquals(exception instanceof Exception, true);
    }

    /**
     * Test of addServiceCharge method, of class Hotel.
     */
    @Test
    public void testAddServiceCharge() {
        System.out.println("addServiceCharge");
        int roomId = 101;
        ServiceType serviceType = null;
        double cost = 0.0;
        Hotel instance = new Hotel();
        
        
        Exception exception = null;
        try {
            instance.addServiceCharge(roomId, serviceType, cost);
        } catch (Exception e) {
            exception = e;
        }
        assertEquals(exception instanceof Exception, true);
    }

    /**
     * Test of checkout method, of class Hotel.
     */
    @Test
    public void testCheckout() {
        System.out.println("checkout");
        int roomId = 101;
        Hotel instance = new Hotel();
        
        Exception exception = null;
        try {
            instance.checkout(roomId);
        } catch (Exception e) {
            exception = e;
        }
        assertEquals(exception instanceof Exception, true);
    }

    private String RuntimeException(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
