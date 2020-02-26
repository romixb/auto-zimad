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
	private int commentCount;

	@JsonProperty("name")
	private String name;

	@JsonProperty("id")
	private int id;

	@JsonProperty("order")
	private int order;
}