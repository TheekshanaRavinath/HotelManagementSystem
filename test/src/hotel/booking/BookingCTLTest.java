/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.hotel.booking;

import hotel.booking.BookingCTL;
import hotel.credit.CreditCard;
import hotel.credit.CreditCardType;

import hotel.entities.Guest;
import hotel.entities.Hotel;
import hotel.entities.Room;
import hotel.entities.RoomType;
import java.util.Date;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ravi
 */
public class BookingCTLTest {

    Guest guest;
    Room room;
    Hotel hotel;
    BookingCTL bookingCTL;

    public BookingCTLTest() {
        this.guest = new Guest("Lukaa", "gari baldi", 1231411);
        this.room = new Room(5, RoomType.SINGLE);
        Date arriveDate = new Date();
        CreditCard creditcard = new CreditCard(CreditCardType.VISA, 1234, 567);
        hotel = new Hotel();

        this.bookingCTL = new BookingCTL(hotel);
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }


    /**
     * Test of creditDetailsEntered method, of class BookingCTL.
     */
    @Test
    public void testCreditDetailsEntered() {
        System.out.println("creditDetailsEntered");
        CreditCardType type = CreditCardType.VISA;
        int number = 1234;
        int ccv = 543;
        BookingCTL bookingCtlInstance = this.bookingCTL;
            Exception exp=null;
        try {
            bookingCtlInstance.creditDetailsEntered(type, number, ccv);

        } catch (Exception e) {
            exp = e;
        }
        
        assertEquals(exp instanceof Exception ,true);

    }


}
