package com.rocketseat.planner.services;

import java.util.List;
import java.util.UUID;

public interface ParticipantService {
    public void registerParticipantsToEvent(List<String> participantsToInvite, UUID tripId);

    public void triggerConfirmationEmailToParticipants(UUID tripId);
}
