package com.cuemby.demo.main.controllers;


import com.cuemby.demo.core.dtos.PageDto;
import com.cuemby.demo.core.dtos.PlayersPagedResponse;
import com.cuemby.demo.core.service.PlayerService;
import com.cuemby.demo.main.resources.requests.TeamSearchRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping("/team")
    public PlayersPagedResponse getPlayerByTeam(@RequestBody() TeamSearchRequest requestDto) {
        assert requestDto.getOrder() != null;

        return this.playerService.getPlayerByTeam(requestDto.getTeam(),
                new PageDto(requestDto.getPage(),
                        requestDto.getSize(),
                        requestDto.getOrder()));
    }

    @GetMapping(path = "/players")
    public PlayersPagedResponse getPlayerByName(@RequestParam() String name,
                                                @RequestParam(defaultValue = "asc") String order,
                                                @RequestParam(defaultValue = "0") int page,
                                                @RequestParam(defaultValue = "10") int size) {
        return this.playerService.getPlayerByName(name, new PageDto(page, size, order));
    }
}
