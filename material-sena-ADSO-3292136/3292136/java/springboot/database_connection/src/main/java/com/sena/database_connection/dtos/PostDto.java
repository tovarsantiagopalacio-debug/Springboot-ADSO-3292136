package com.sena.database_connection.dtos;

import lombok.Data;

@Data
public class PostDto {

    private String title;

    private String content;

    private Long userId;

}
