package com.cuemby.demo.main.resources.requests;


import lombok.Data;

@Data
public class TeamSearchRequest {

    private String team;
    private String order;
    private int page;
    private int size;

    public TeamSearchRequest(String team, String order, int page, int size) {
        this.order = (order == null) ? "asc" : order;
        this.page = Math.max(page, 0);
        this.size = (size <= 1) ? 10 : size;
        this.team = team;
    }


}
