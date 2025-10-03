package com.rocketseat.planner.services.serviceImpl;

import com.rocketseat.planner.entities.Participant;
import com.rocketseat.planner.entities.Trip;
import com.rocketseat.planner.repository.ParticipantRepository;
import com.rocketseat.planner.rercords.ParticipantCreateResponse;
import com.rocketseat.planner.rercords.ParticipantData;
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
    public void registerParticipantsToEvent(List<String> participantsToInvite, Trip trip) {

        List<Participant> participants = participantsToInvite.stream().map(email -> new Participant(email, trip))
                .toList();

        this.participantRepository.saveAll(participants);
    }

    @Override
    public ParticipantCreateResponse registerParticipantToEvent(String email, Trip trip) {
        Participant newParticipant = new Participant(email, trip);
        this.participantRepository.save(newParticipant);

        return new ParticipantCreateResponse(newParticipant.getId());
    }

    @Override
    public List<ParticipantData> getAllParticipantsFromEventId(UUID tripId) {
        return this.participantRepository.findByTripId(tripId).stream()
                .map(participant -> new ParticipantData(participant.getId(),
                        participant.getName(),
                        participant.getEmail(),
                        participant.getIsConfirmed())).toList();
    }

    @Override
    public void triggerConfirmationEmailToParticipants(UUID tripId) {
    }

    @Override
    public void triggerConfirmationEmailToParticipant(String email) {

    }

}
