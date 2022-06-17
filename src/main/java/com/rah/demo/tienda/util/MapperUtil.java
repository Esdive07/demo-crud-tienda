package com.rah.demo.tienda.util;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class MapperUtil {

	private ObjectMapper objectMapper;

	public MapperUtil() {
		this.objectMapper = new ObjectMapper();
		this.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	public <T> T mapperObject(Object input, Class<T> output) {
		return this.objectMapper.convertValue(input, output);
	}

}
