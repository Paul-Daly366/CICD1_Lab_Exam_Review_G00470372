package ie.atu.sample.controller;

import ie.atu.sample.dto.BookingRequest;
import ie.atu.sample.dto.BookingResponse;
import ie.atu.sample.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService service) {
        this.bookingService = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createBooking(BookingRequest bookingReq){
        return bookingService.createBooking(bookingReq);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookingResponse getBookingById(@PathVariable Long id){
        return bookingService.getBookingById(id);
    }
}