package com.rah.demo.tienda.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class PageModel {
	private List<CompraModel> content;
	private boolean last;
	private Integer totalPages;
	private Integer totalElements;

}
