package com.todoist.auto.v1.dtos.tasks.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.annotation.Generated;

@Data
@Builder
@Generated("com.robohorse.robopojogenerator")
public class TaskRequestDto {

	@JsonProperty("due_lang")
	private String dueLang;

	@JsonProperty("priority")
	private int priority;

	@JsonProperty("content")
	private String content;

	@JsonProperty("due_string")
	private String dueString;

	@JsonProperty("project_id")
	private long projectId;

	@JsonProperty("section_id")
	private long sectionId;

}