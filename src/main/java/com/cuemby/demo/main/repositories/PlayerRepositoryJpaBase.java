package com.cuemby.demo.main.repositories;

import com.cuemby.demo.core.dtos.PageDto;
import com.cuemby.demo.core.dtos.PlayersPagedResponse;
import com.cuemby.demo.core.entities.Player;
import com.cuemby.demo.core.repositories.PlayerRepository;
import com.cuemby.demo.main.models.PlayerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PlayerRepositoryJpaBase implements PlayerRepository {

    private final PlayerRepositoryJpa repositoryJpa;

    @Autowired
    public PlayerRepositoryJpaBase(PlayerRepositoryJpa repositoryJpa) {
        this.repositoryJpa = repositoryJpa;
    }

    @Override
    public PlayersPagedResponse findByNameContainingIgnoreCase(String name, PageDto pageable) {
        return convertToPlayerResponse(
                repositoryJpa.findByNameContainingIgnoreCase(
                        name, convertPageDtoToPageable(pageable, "name"))
        );
    }

    @Override
    public PlayersPagedResponse findByTeamContainingIgnoreCase(String team, PageDto pageable) {
        return convertToPlayerResponse(
                repositoryJpa.findByTeamContainingIgnoreCase(
                        team, convertPageDtoToPageable(pageable, "name"))
        );
    }

    private Pageable convertPageDtoToPageable(PageDto pageDto, String sortField) {
        return PageRequest.of(pageDto.getPage(),
                pageDto.getSize(),
                Sort.Direction.fromString(pageDto.getOrder()),
                sortField);
    }

    private PlayersPagedResponse convertToPlayerResponse(Page<PlayerModel> players) {
        return new PlayersPagedResponse(players.getNumber(),
                players.getTotalPages(),
                players.getNumberOfElements(),
                (int) players.getTotalElements(),
                convertListToDtos(players.getContent()));
    }

    private List<Player> convertListToDtos(List<PlayerModel> players) {
        return players.stream().map(this::convertDatatoDto).collect(Collectors.toList());
    }

    private Player convertDatatoDto(PlayerModel playerModel) {
        return new Player(playerModel.getName(),
                playerModel.getPosition(),
                playerModel.getNation(),
                playerModel.getTeam());
    }
}
