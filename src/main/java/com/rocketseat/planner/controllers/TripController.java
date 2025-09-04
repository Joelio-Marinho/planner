package com.rocketseat.planner.controllers;

import com.rocketseat.planner.entities.Trip;
import com.rocketseat.planner.repository.TripRepository;
import com.rocketseat.planner.rercords.TripCreateResponse;
import com.rocketseat.planner.rercords.TripRequestPayload;
import com.rocketseat.planner.services.ParticipantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/trips")
@RequiredArgsConstructor
public class TripController {

    private final ParticipantService participantService;

    private final TripRepository tripRepository;

    @PostMapping
    public ResponseEntity<TripCreateResponse> createTrip(@RequestBody TripRequestPayload payload) {

        Trip newTrip = new Trip(payload);

        this.tripRepository.save(newTrip);
        this.participantService.registerParticipantsToEvent(payload.emails_to_invite(), newTrip.getId());

        return ResponseEntity.ok(new TripCreateResponse(newTrip.getId()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trip> getTripDetails(@PathVariable UUID id){
        Optional<Trip> trip = this.tripRepository.findById(id);

        return  trip.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }
}
