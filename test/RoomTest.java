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
import hotel.entities.Room;
import hotel.entities.RoomType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Isurika
 */
public class RoomTest {
    Guest guest;
    SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
    Date date;
    Booking booking;
    Room room;
    CreditCard creditCard;
    
    public RoomTest() throws ParseException {
        this.guest = new Guest("Isurika", "Dengdenon", 457896542);
        this.date = sd.parse("25-02-2019");
        this.room = new Room(101, RoomType.SINGLE);
        this.creditCard = new CreditCard(CreditCardType.VISA, 12345, 665);
        this.booking = new Booking(guest, room, date, 5, 1, creditCard);
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

     /**
     * Test of book method, of class Room.
     */
    @Test
    public void testBook() {
        System.out.println("book");
        Guest guestt = this.guest;
        Date arrivalDate = this.date;
        int stayLength = 5;
        int numberOfOccupants = 1;
        Room rooms = new Room(101, RoomType.SINGLE);
        Booking result = rooms.book(guest, arrivalDate, stayLength, numberOfOccupants, creditCard);
       
        
    }

    /**
     * Test of checkin method, of class Room.
     */
    @Test
    public void testCheckin() {
        System.out.println("checkin");
        Room instance = new Room(101, RoomType.DOUBLE);
        
        Exception exp = null;
        try {
            instance.checkin();
        } catch (Exception e) {
            exp = e;
        }
        assertEquals(exp instanceof Exception, false);
    }

    /**
     * Test of checkout method, of class Room.
     */
    @Test
    public void testCheckout() {
        System.out.println("checkout");
        //error message should be thrown according to not in occupied
        Booking booking = new Booking(guest, room, date, 5, 1, creditCard);
        Room room = new Room(101, RoomType.SINGLE);
        
        
        Exception exp = null;
        try {
            room.checkout(booking);
        } catch (Exception e) {
            exp = e;
        }
        assertEquals(exp instanceof Exception, true);
        
        
    }
    
}
