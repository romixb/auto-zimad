package com.todoist.auto.v1.dtos.tasks;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.annotation.Generated;
@Data
@Builder
@Generated("com.robohorse.robopojogenerator")
public class Due{

	@JsonProperty("date")
	private String date;

	@JsonProperty("datetime")
	private String datetime;

	@JsonProperty("string")
	private String string;

	@JsonProperty("timezone")
	private String timezone;
}