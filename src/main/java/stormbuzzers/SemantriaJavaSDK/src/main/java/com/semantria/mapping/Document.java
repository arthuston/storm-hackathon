package com.semantria.mapping;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name="document")
public final class Document 
{
	private String id = null;
	private String text = null;
	
	public Document() {}

	public Document(String id, String text)
	{
		this.id = id;
		this.text = text;
	}

	@XmlElement(name="id")
	public String getId() { return id; }
	@XmlElement(name="text")
	public String getText() { return text; }
	
	public void setId(String id) { this.id = id; }
	public void setText(String text) { this.text = text; }
}
