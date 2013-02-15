package com.tearsofaunicorn.wordpress.api.model.converter;

import java.util.Map;

import com.tearsofaunicorn.wordpress.api.model.Category;

public class CategoryConverter implements Converter<Map<String, Object>, Category> {

	public Category convert(Map<String, Object> fromObject) {

		if (fromObject == null) {
			throw new IllegalArgumentException("fromObject must not be null");
		}

		String id = (String) fromObject.get("term_id");
		String name = (String) fromObject.get("name");
		String description = (String) fromObject.get("description");
		return new Category(id, name, description);
	}
}
