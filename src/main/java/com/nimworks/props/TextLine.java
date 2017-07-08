package com.nimworks.props;

public class TextLine implements Comparable<TextLine>{

	private Long position = 0L;
	private String text;

	public TextLine(Long position, String text) {
		this.text = text;
		this.position = position;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Long getPosition() {
		return position;
	}

	public void setPosition(Long position) {
		this.position = position;
	}

	public boolean isComment(){
		return text.startsWith("#");
	}

	public String getKey(){
		return text.split("=")[0];
	}

	public String getValue(){
		String[] texts = text.split("=");
		if(texts.length < 2){
			return "";
		}
		return text.split("=")[1];
	}

	public boolean isKey(String key){
		if(isComment()){
			return false;
		}else{
			return key.equals(getKey());
		}
	}

	@Override
	public int compareTo(TextLine o) {
		if(o == null){
			return -1;
		}
		return this.position.compareTo(o.getPosition());
	}

	@Override
	public String toString() {
		return "TextLine {line no: " + position + ", text: " + text + "}";
	}

}
