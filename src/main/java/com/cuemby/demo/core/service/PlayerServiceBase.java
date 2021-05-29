package com.cuemby.demo.core.service;

import com.cuemby.demo.core.dtos.PageDto;
import com.cuemby.demo.core.dtos.PlayersPagedResponse;
import com.cuemby.demo.core.repositories.PlayerRepository;

public class PlayerServiceBase implements PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerServiceBase(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public PlayersPagedResponse getPlayerByName(String name, PageDto pageable) {
        return playerRepository.findByNameContainingIgnoreCase(name, pageable);
    }

    @Override
    public PlayersPagedResponse getPlayerByTeam(String team, PageDto pageable) {
        return playerRepository.findByTeamContainingIgnoreCase(team, pageable);
    }

}
