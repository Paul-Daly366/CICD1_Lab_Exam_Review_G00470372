package ie.atu.sample.service;

import ie.atu.sample.dto.BookingRequest;
import ie.atu.sample.dto.BookingResponse;
import ie.atu.sample.model.Booking;
import ie.atu.sample.repository.BookingRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class BookingService {
    private final BookingRepository repo;

    public BookingService(BookingRepository repo) {
        this.repo = repo;
    }

    // NEED TO CHECK ATTENDEE & ROOM ID WITH OPENFEIGN
    // CHECK IF ROOM ALREADY ACTIVE?
    public BookingResponse createBooking(BookingRequest bookingReq){
        Booking booking = new Booking();
        booking.setRoomStatus("ACTIVE");
        booking.setBookingId(null);
        booking.setOrganiserName(bookingReq.getOrganiserName());
        booking.setAttendeeCount(bookingReq.getAttendeeCount());
        booking.setRoomId(bookingReq.getRoomId());
        repo.save(booking);
        BookingResponse bookingResponse = new BookingResponse();
        bookingResponse.setBookingId(booking.getBookingId());
        bookingResponse.setOrganiserName(booking.getOrganiserName());
        bookingResponse.setAttendeeCount(booking.getAttendeeCount());
        bookingResponse.setRoomId(booking.getRoomId());
        bookingResponse.setRoomStatus("ACTIVE");
        return bookingResponse;
    }

    public BookingResponse getBookingById(Long id){
        Booking booking = repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Booking not found"));
        BookingResponse bookingResponse = new BookingResponse();
        bookingResponse.setBookingId(booking.getBookingId());
        bookingResponse.setOrganiserName(booking.getOrganiserName());
        bookingResponse.setAttendeeCount(booking.getAttendeeCount());
        bookingResponse.setRoomId(booking.getRoomId());
        bookingResponse.setRoomStatus("Active");
        return bookingResponse;
    }
}