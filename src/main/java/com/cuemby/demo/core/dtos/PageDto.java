package com.cuemby.demo.core.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PageDto {

    private int page;
    private int size;
    private String order;

    public PageDto(int page, int size, String order) {
        this.order = (order == null) ? "asc" : order;
        this.page = Math.max(page, 0);
        this.size = (size <= 1) ? 10 : size;
    }
}
