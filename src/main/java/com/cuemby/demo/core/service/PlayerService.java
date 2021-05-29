package com.cuemby.demo.core.service;

import com.cuemby.demo.core.dtos.PageDto;
import com.cuemby.demo.core.dtos.PlayersPagedResponse;

public interface PlayerService {

    PlayersPagedResponse getPlayerByName(String name, PageDto pageable);

    PlayersPagedResponse getPlayerByTeam(String team, PageDto pageable);

}
