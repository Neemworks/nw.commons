/*
 * File:	TextLine.java
 * Author				Date			Change
 * Rowland				Jun 18, 2016			Created
 *
 *
 * Property of Neemworks, do not reproduce or reuse without permission
 * contact dev@neemworks.net for further information.
 *
 * Copyright Neemworks
 * http://www.neemworks.net
 */
package nw.commons.props.text;

/**
 * Represents a line in a properties files, which can either be a comment of a key value separated by
 * equals sign
 */
public class TextLine implements Comparable<TextLine>{

	/** The line number for the text. */
	private Long position = 0L;

	/** The actual text. */
	private String text;

	/**
	 * Instantiates a new text line.
	 *
	 * @param position the position
	 * @param text the text
	 */
	public TextLine(Long position, String text) {
		this.text = text;
		this.position = position;
	}

	/**
	 * Gets the text.
	 *
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Sets the text.
	 *
	 * @param text the new text
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * Gets the position.
	 *
	 * @return the position
	 */
	public Long getPosition() {
		return position;
	}

	/**
	 * Sets the position.
	 *
	 * @param position the new position
	 */
	public void setPosition(Long position) {
		this.position = position;
	}

	/**
	 * Checks if text is a comment.
	 * E.g #highest player score
	 *
	 * @return true, if is comment
	 */
	public boolean isComment(){
		return text.startsWith("#");
	}

	/**
	 * Gets the key.
	 *
	 * @return the key
	 */
	public String getKey(){
		return text.split("=")[0];
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public String getValue(){
		String[] texts = text.split("=");
		if(texts.length < 2){
			return "";
		}
		return text.split("=")[1];
	}

	/**
	 * Checks if is key.
	 *
	 * @param key the key
	 * @return true, if is key
	 */
	public boolean isKey(String key){
		if(isComment()){
			return false;
		}else{
			return key.equals(getKey());
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(TextLine o) {
		if(o == null){
			return -1;
		}
		return this.position.compareTo(o.getPosition());
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TextLine {line no: " + position + ", text: " + text + "}";
	}

}
