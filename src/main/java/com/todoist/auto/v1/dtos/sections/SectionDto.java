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
	private int projectId;

	@JsonProperty("name")
	private String name;

	@JsonProperty("id")
	private int id;

	@JsonProperty("order")
	private int order;
}