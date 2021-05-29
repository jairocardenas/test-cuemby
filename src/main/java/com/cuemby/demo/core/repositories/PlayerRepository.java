package com.cuemby.demo.core.repositories;

import com.cuemby.demo.core.dtos.PageDto;
import com.cuemby.demo.core.dtos.PlayersPagedResponse;

public interface PlayerRepository {

    PlayersPagedResponse findByNameContainingIgnoreCase(String name, PageDto pageable);
    PlayersPagedResponse findByTeamContainingIgnoreCase(String team, PageDto pageable);

}
