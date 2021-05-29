package com.cuemby.demo.core.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player {

    private String name;
    private String position;
    private String nation;
    private String team;

}
