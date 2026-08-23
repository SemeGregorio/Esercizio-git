package com.example.demo_custom_queries_1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/flights")
public class FlightController {

    private final FlightRepository flightRepository;

    public FlightController(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @GetMapping("/provision")
    public List<Flight> provisionFlights() {

        List<Flight> flights = new ArrayList<>();

        for (int i = 0; i < 50; i++) {

            Flight flight = new Flight();

            flight.setDescription(randomString());
            flight.setFromAirport(randomString());
            flight.setToAirport(randomString());
            flight.setStatus(FlightStatus.ONTIME);

            flights.add(flight);
        }

        return flightRepository.saveAll(flights);
    }

    @GetMapping
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    private String randomString() {
        Random random = new Random();

        return random.ints(8, 65, 91)
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
    }
}