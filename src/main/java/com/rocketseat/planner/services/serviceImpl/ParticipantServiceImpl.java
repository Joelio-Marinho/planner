package com.rocketseat.planner.services.serviceImpl;

import com.rocketseat.planner.entities.Participant;
import com.rocketseat.planner.repository.ParticipantRepository;
import com.rocketseat.planner.services.ParticipantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ParticipantServiceImpl implements ParticipantService {

    private final ParticipantRepository participantRepository;

    @Override
    public void registerParticipantsToEvent(List<String> participantsToInvite, UUID tripId) {

        List<Participant> participants = participantsToInvite.stream().map(email -> new Participant(email, tripId));

        this.participantRepository.saveAll(participants);
    }

    @Override
    public void triggerConfirmationEmailToParticipants(UUID tripId) {
    }
}
