package com.codewithgaurav.blog.response;

import java.util.List;

import com.codewithgaurav.blog.dto.PostDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostPaginationResponse {

	private List<PostDto> content;
	private Integer pageNumber;
	private Integer pageSize;
	private Long totalElements;
	private Integer totalPage;
	private Boolean lastPage;
	
}
