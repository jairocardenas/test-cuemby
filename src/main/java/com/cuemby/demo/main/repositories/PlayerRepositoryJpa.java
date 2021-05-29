package com.cuemby.demo.main.repositories;


import com.cuemby.demo.main.models.PlayerModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepositoryJpa extends JpaRepository<PlayerModel, Integer> {

    Page<PlayerModel> findByNameContainingIgnoreCase(String name, Pageable pageable);
    Page<PlayerModel> findByTeamContainingIgnoreCase(String team, Pageable pageable);
}

