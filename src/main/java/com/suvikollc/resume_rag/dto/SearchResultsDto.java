package com.suvikollc.resume_rag.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class SearchResultsDto {

	private String jdUrl;
	private List<ResumeResultsDto> resumeResults;

}
