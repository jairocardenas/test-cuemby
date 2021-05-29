package com.cuemby.demo.core.dtos;

import com.cuemby.demo.core.entities.Player;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayersPagedResponse {
    private int page;
    private int totalPages;
    private int items;
    private int totalItems;
    private List<Player> players;

}
