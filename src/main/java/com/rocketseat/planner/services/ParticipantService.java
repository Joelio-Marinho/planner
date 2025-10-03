package com.rocketseat.planner.services;

import com.rocketseat.planner.entities.Participant;
import com.rocketseat.planner.entities.Trip;
import com.rocketseat.planner.rercords.ParticipantCreateResponse;
import com.rocketseat.planner.rercords.ParticipantData;

import java.util.List;
import java.util.UUID;

public interface ParticipantService {
    public void registerParticipantsToEvent(List<String> participantsToInvite, Trip trip);

    public void triggerConfirmationEmailToParticipants(UUID tripId);

    public void triggerConfirmationEmailToParticipant(String email);

    public ParticipantCreateResponse registerParticipantToEvent(String email, Trip trip);

    public List<ParticipantData> getAllParticipantsFromEventId(UUID TripId);
}
