package com.rocketseat.planner.repository;

import com.rocketseat.planner.entities.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ParticipantRepository extends JpaRepository<Participant, UUID> {
}