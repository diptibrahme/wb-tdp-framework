package com.wb.tdp.ms.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *   This class contains the pagination properties
 * 
 */


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaginationDTO extends ResponseDto{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 563913917911850285L;
	
	/**
	 * The Current page
	 */
	private Integer currentPage;
	/**
	 * The page Size
	 */
	private Integer pageSize;
	/**
	 * The total elements
	 */
	private Long totalElements;
	/**
	 * The total number of pages
	 */
	private Integer totalNumberOfPages;

}
