package com.tenco.server.board.repository.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Board{
	private Integer id;
	private String title;
	private String content;
	private String username;
	private Timestamp createdAt;
}
