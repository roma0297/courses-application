package com.vitasoft.hibernatesearch.bridges;

import com.vitasoft.model.AuthorModel;
import java.util.Map;
import org.hibernate.search.bridge.ParameterizedBridge;
import org.hibernate.search.bridge.StringBridge;

public class AuthorStringBridge implements StringBridge, ParameterizedBridge {
	
	private int padding = 0;
	
	@Override
	public String objectToString(Object o) {
		AuthorModel author = (AuthorModel) o;
		
		
		return author.getName().substring(padding);
	}
	
	@Override
	public void setParameterValues(Map<String, String> map) {
		padding = Integer.parseInt(map.get("padding"));
	}
}
