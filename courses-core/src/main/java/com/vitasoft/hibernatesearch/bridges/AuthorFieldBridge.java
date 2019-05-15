package com.vitasoft.hibernatesearch.bridges;

import com.vitasoft.model.AuthorModel;
import org.apache.lucene.document.Document;
import org.hibernate.search.bridge.FieldBridge;
import org.hibernate.search.bridge.LuceneOptions;

public class AuthorFieldBridge implements FieldBridge {
	
	
	@Override
	public void set(String name, Object o, Document document, LuceneOptions luceneOptions) {
		AuthorModel author = (AuthorModel) o;
		
		luceneOptions.addFieldToDocument(name + ".description", author.getDescription(), document);
		luceneOptions.addFieldToDocument(name + ".name", author.getName(), document);
		luceneOptions.addFieldToDocument(name + ".age", String.valueOf(author.getAge()), document);
	}
}
