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
	private long commentCount;

	@JsonProperty("section_id")
	private long sectionId;

	@JsonProperty("due")
	private Due due;

	@JsonProperty("project_id")
	private long projectId;

	@JsonProperty("completed")
	private boolean completed;

	@JsonProperty("parent")
	private long parent;

	@JsonProperty("id")
	private long id;

	@JsonProperty("priority")
	private int priority;

	@JsonProperty("content")
	private String content;

	@JsonProperty("url")
	private String url;

	@JsonProperty("label_ids")
	private String labelId[];

	@JsonProperty("created")
	private String created;

	@JsonProperty("order")
	private long order;
}