/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.entities;

import hotel.credit.CreditCard;
import hotel.credit.CreditCardType;
import java.util.Date;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ravi
 */
public class BookingTest {

    Guest guest;
    Room room;
    Booking booking;

    public BookingTest() {
        this.guest = new Guest("Luca", "Noble park", 424559875);
        this.room = new Room(5, RoomType.SINGLE);
        Date arriveDate = new Date();
        CreditCard creditcard = new CreditCard(CreditCardType.VISA, 12345, 567);
        this.booking = new Booking(guest, room, arriveDate, 3/*stay length*/, 1/*occupants*/, creditcard);
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }


   
    /**
     * Test of checkIn method, of class Booking.
     */
    @Test
    public void testCheckIn() {
        System.out.println("checkIn");
        Booking bookingIntance = this.booking;
        bookingIntance.checkIn();
        // checkin method should return boolean value therefore, expected result
        //compared with true
        assertEquals(booking.isCheckedIn(), true);

    }

    /**
     * Test of addServiceCharge method, of class Booking.
     */
    @Test
    public void testAddServiceCharge() {
        System.out.println("addServiceCharge");
        ServiceType serviceType = ServiceType.ROOM_SERVICE;
        double cost = 300.0;
        Booking bookingInstance = this.booking;

        //for clean test, booking status should be checkin , else system should return a run time exception
        bookingInstance.checkIn();
        //before adding new service charge 
        List<ServiceCharge> charges = booking.getCharges();
        int beforeSize = charges.size();

        bookingInstance.addServiceCharge(serviceType, cost);

        //after adding new service charge       
        List<ServiceCharge> charges2 = booking.getCharges();
        int afterSize = charges2.size();

        assertTrue(afterSize > beforeSize);

    }

    /**
     * Test of checkOut method, of class Booking.
     */
    @Test
    public void testCheckOut() {
        System.out.println("checkOut");
        // initialize booking instance that we have created in constructor
        Booking bookingInstance = this.booking;

        //for clean test, booking status should be checkin , else system should return a run time exception
        bookingInstance.checkIn();
        bookingInstance.checkOut();
        assertEquals(booking.isCheckedOut(), true);

    }

}
