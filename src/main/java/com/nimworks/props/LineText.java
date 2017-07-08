package com.nimworks.props;

public class LineText implements Comparable<LineText>{

	private String key;
	private String value;
	
	private String text;
	private Long position = 0L;

	public LineText(Long position, String text) {
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
		return text.split("[=:]")[0];
	}

	public String getValue(){
		String[] texts = text.split("[=:]");
		if(texts.length < 2){
			return "";
		}
		return text.split("=")[1];
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	public boolean isKey(String key){
		if(isComment()){
			return false;
		}else{
			return key.equals(getKey());
		}
	}

	@Override
	public int compareTo(LineText o) {
		if(o == null){
			return -1;
		}
		return this.position.compareTo(o.getPosition());
	}

	@Override
	public String toString() {
		return "TextLine {line no: " + position + ", text: " + text + "}";
	}
	
	public static void main(String[] args) {
		String a = "awesome: two= fold";
		
		System.out.println(a.split("[=:]").length);
	}

}
