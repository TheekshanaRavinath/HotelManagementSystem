package hotel.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import hotel.credit.CreditCard;
import hotel.utils.IOUtils;

public class Room {
	
	private enum State {READY, OCCUPIED}
	
	int id;
	RoomType roomType;
	List<Booking> bookings;
	State state;

	
	public Room(int id, RoomType roomType) {
		this.id = id;
		this.roomType = roomType;
		bookings = new ArrayList<>();
		state = State.READY;
	}
	

	public String toString() {
		return String.format("Room : %d, %s", id, roomType);
	}


	public int getId() {
		return id;
	}
	
	public String getDescription() {
		return roomType.getDescription();
	}
	
	
	public RoomType getType() {
		return roomType;
	}
	
	public boolean isAvailable(Date arrivalDate, int stayLength) {
		IOUtils.trace("Room: isAvailable");
		for (Booking b : bookings) {
			if (b.doTimesConflict(arrivalDate, stayLength)) {
				return false;
			}
		}
		return true;
	}
	
	
	public boolean isReady() {
		return state == State.READY;
	}


	public Booking book(Guest guest, Date arrivalDate, int stayLength, int numberOfOccupants, CreditCard creditCard) {
		// TODO Auto-generated method stub
		// check the availability of booking system
		if (!isAvailable(arrivalDate, stayLength)) {
			throw new RuntimeException("Booking is not available!");
		}
		// create booking by making booking status as "PENDING"
		Booking booking = new Booking(guest, this, arrivalDate, stayLength, numberOfOccupants, creditCard);
		this.bookings.add(booking);
		return booking;
	}


	public void checkin() {
		// TODO Auto-generated method stub
		// handle the check-in for room booking
		if (!isReady()) {
			throw new RuntimeException("The Room is not ready");
		}
		this.state = State.OCCUPIED;
	}


	public void checkout(Booking booking) {
		// TODO Auto-generated method stub
		if (this.state != State.OCCUPIED)
			throw new RuntimeException("The Room is not OCCUPIED");
		// remove the booking from the booking list
		this.bookings.remove(booking);
		this.state = State.READY;
	}

}
