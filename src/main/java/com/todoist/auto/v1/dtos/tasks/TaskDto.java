package com.todoist.auto.v1.dtos.tasks;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.annotation.Generated;

@Data
@Builder
@Generated("com.robohorse.robopojogenerator")
public class TaskDto {

	@JsonProperty("comment_count")
	private int commentCount;

	@JsonProperty("section_id")
	private int sectionId;

	@JsonProperty("due")
	private Due due;

	@JsonProperty("project_id")
	private int projectId;

	@JsonProperty("completed")
	private boolean completed;

	@JsonProperty("id")
	private int id;

	@JsonProperty("priority")
	private int priority;

	@JsonProperty("content")
	private String content;

	@JsonProperty("url")
	private String url;

	@JsonProperty("order")
	private int order;
}