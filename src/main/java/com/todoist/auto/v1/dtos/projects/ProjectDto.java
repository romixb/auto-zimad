package com.todoist.auto.v1.dtos.projects;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.annotation.Generated;
@Data
@Builder
@Generated("com.robohorse.robopojogenerator")
public class ProjectDto {

	@JsonProperty("comment_count")
	private long commentCount;

	@JsonProperty("name")
	private String name;

	@JsonProperty("id")
	private long id;

	@JsonProperty("order")
	private long order;

	@JsonProperty("shared")
	private boolean shared;

	@JsonProperty("color")
	private int color;

	@JsonProperty("inbox_project")
	private boolean inboxProject;
}