package hotel.entities;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import hotel.credit.CreditCard;
import hotel.utils.IOUtils;

public class Hotel {
	
	private Map<Integer, Guest> guests;
	public Map<RoomType, Map<Integer,Room>> roomsByType;
	public Map<Long, Booking> bookingsByConfirmationNumber;
	public Map<Integer, Booking> activeBookingsByRoomId;
	
	
	public Hotel() {
		guests = new HashMap<>();
		roomsByType = new HashMap<>();
		for (RoomType rt : RoomType.values()) {
			Map<Integer, Room> rooms = new HashMap<>();
			roomsByType.put(rt, rooms);
		}
		bookingsByConfirmationNumber = new HashMap<>();
		activeBookingsByRoomId = new HashMap<>();
	}

	
	public void addRoom(RoomType roomType, int id) {
		IOUtils.trace("Hotel: addRoom");
		for (Map<Integer, Room> rooms : roomsByType.values()) {
			if (rooms.containsKey(id)) {
				throw new RuntimeException("Hotel: addRoom : room number already exists");
			}
		}
		Map<Integer, Room> rooms = roomsByType.get(roomType);
		Room room = new Room(id, roomType);
		rooms.put(id, room);
	}

	
	public boolean isRegistered(int phoneNumber) {
		return guests.containsKey(phoneNumber);
	}

	
	public Guest registerGuest(String name, String address, int phoneNumber) {
		if (guests.containsKey(phoneNumber)) {
			throw new RuntimeException("Phone number already registered");
		}
		Guest guest = new Guest(name, address, phoneNumber);
		guests.put(phoneNumber, guest);		
		return guest;
	}

	
	public Guest findGuestByPhoneNumber(int phoneNumber) {
		Guest guest = guests.get(phoneNumber);
		return guest;
	}

	
	public Booking findActiveBookingByRoomId(int roomId) {
		Booking booking = activeBookingsByRoomId.get(roomId);;
		return booking;
	}


	public Room findAvailableRoom(RoomType selectedRoomType, Date arrivalDate, int stayLength) {
		IOUtils.trace("Hotel: checkRoomAvailability");
		Map<Integer, Room> rooms = roomsByType.get(selectedRoomType);
		for (Room room : rooms.values()) {
			IOUtils.trace(String.format("Hotel: checking room: %d",room.getId()));
			if (room.isAvailable(arrivalDate, stayLength)) {
				return room;
			}			
		}
		return null;
	}

	
	public Booking findBookingByConfirmationNumber(long confirmationNumber) {
		return bookingsByConfirmationNumber.get(confirmationNumber);
	}

	
    public long book(Room room, Guest guest, Date arrivalDate, int stayLength, int occupantNumber,
            CreditCard creditCard) {
        // handle the room booking by calling book method of room.
        Booking booking = room.book(guest, arrivalDate, stayLength, occupantNumber, creditCard);
        long confirmationNumber = booking.getConfirmationNumber();
        this.bookingsByConfirmationNumber.put(new Long(confirmationNumber), booking);
        return confirmationNumber;
    }

	
	public void checkin(long confirmationNumber) {

    // this method implement in order to checking, is there active booking , that associate to confirmation Number
        Booking booking = findBookingByConfirmationNumber(confirmationNumber);
        if (booking == null) {
            throw new RuntimeException("No Active booking for confirmation number : " + confirmationNumber);
        }

        int roomId = booking.getRoomId();
        booking.checkIn();
        this.activeBookingsByRoomId.put(new Integer(roomId), booking);
	}


	public void addServiceCharge(int roomId, ServiceType serviceType, double cost) {
		// checking whether is there active booking , that associate to roomId
        Booking booking = findActiveBookingByRoomId(roomId);
        if (booking == null) {
            throw new RuntimeException("No Active booking for room id : " + roomId);
        }
        booking.addServiceCharge(serviceType, cost);
	}

	
	public void checkout(int roomId) {
    
		// checkinh whether is there active booking , that associate to roomId
        Booking booking = findActiveBookingByRoomId(roomId);
        if (booking == null) {
            throw new RuntimeException("No Active booking for room id : " + roomId);
        }

        booking.checkOut();
        // remove the booking instance from active bookings map
        this.activeBookingsByRoomId.remove(new Integer(roomId));
	}


}
