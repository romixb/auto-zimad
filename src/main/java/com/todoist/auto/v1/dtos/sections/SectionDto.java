package com.todoist.auto.v1.dtos.sections;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.annotation.Generated;
@Data
@Builder
@Generated("com.robohorse.robopojogenerator")
public class SectionDto{

	@JsonProperty("project_id")
	private long projectId;

	@JsonProperty("name")
	private String name;

	@JsonProperty("id")
	private long id;

	@JsonProperty("order")
	private long order;
}