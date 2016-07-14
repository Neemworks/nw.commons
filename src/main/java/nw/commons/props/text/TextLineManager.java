package nw.commons.props.text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import nw.commons.logging.Loggable;

/**
 *
 * @author Ogwara O. Rowland
 *
 */
public abstract class TextLineManager extends Loggable{

	/**
	 * Property store
	 */
	protected Map<String, String> store = new HashMap<String, String>();

	/**
	 * Sorted list of lines
	 */
	private SortedSet<TextLine> lines = new TreeSet<TextLine>();

	/**
	 * Current file line number
	 */
	private Long cursor = 0L;

	/**
	 * file name
	 */
	private String properties = "application.properties";


	/**
	 * Reads all properties and comments from the active properties file
	 */
	protected void read(){
		try {
			new File(properties).createNewFile();
			FileReader fr = new FileReader(properties);
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			while ((line = br.readLine()) != null) {
				cursor +=1;
				TextLine text = new TextLine(cursor, line);
				lines.add(text);

				if(!text.isComment()){
					store.put(text.getKey(), text.getValue());
				}

			}
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			logger.error("No property file with name " + properties + " found" );
		} catch (IOException e) {
			logger.error("A read error occurred while reading " + properties );
		}
	}

	/**
	 * saves a new property
	 */
	protected void save(){
		try {
			FileWriter fw = new FileWriter(properties);
			for (TextLine textLine : lines) {
				fw.write(textLine.getText() + "\n");
			}
			fw.close();
		} catch (IOException e) {
			logger.error("A read error occurred while reading " + properties );
		}
	}

	/**
	 * Updates an existing property value
	 * @param key property key name
	 * @param value property key value
	 */
	protected void update(String key, String value){
		try {
			FileWriter fw = new FileWriter(properties);
			for (TextLine textLine : lines) {
				if(textLine.isKey(key)){
					textLine.setText(key + "="+value);
				}
				fw.write(textLine.getText() + "\n");
			}
			fw.close();
		} catch (IOException e) {
			logger.error("A read error occurred while reading " + properties );
		}
	}


	/**
	 * sets the value for a property.
	 *
	 * @param key reference key for property
	 * @param value property value
	 * @param comments description for property
	 */
	protected synchronized void set(String key, String value, String comments) {
		String prev = store.put(key, value);
		if(prev == null){
			// new entry
			add(key, value, comments);
		}else{
			update(key, value);
		}
	}

	/**
	 * Adds a new property entry
	 * @param key reference key for property
	 * @param value value property value
	 * @param comments description for property
	 */
	protected synchronized void add(String key, String value, String comments) {
		store.put(key, value);
		if(comments != null && !comments.isEmpty()){
			comment(comments);
		}

		cursor +=1;
		TextLine text = new TextLine(cursor, key + "="+value);
		lines.add(text);
		save();
	}

	/**
	 * Removes key from property list
	 * @param key reference to property
	 */
	protected synchronized void remove(String key) {
		store.remove(key);
		TextLine line = null;
		for (TextLine textLine : lines) {
			if(textLine.isKey(key)){
				line = textLine;
				break;
			}
		}
		lines.remove(line);
		save();
	}

	/**
	 * Adds a comments
	 * @param comment message
	 */
	protected void comment(String comment){
		cursor +=1;
		TextLine cmts = new TextLine(cursor, "# " + comment);
		lines.add(cmts);
	}

	/**
	 * Gets a property by key
	 * @param key key
	 * @return the property value
	 */
	protected synchronized String get(String key) {
		if(key == null){
			return null;
		}
		key = key.trim();
		String prev = store.get(key);
		return prev;
	}

	/**
	 * Sets the property file used for loading properties
	 * @param properties file name
	 */
	public void setProperties(String properties) {
		this.properties = properties;
	}

	public static void main(String[] args) throws IOException {
		SortedSet<TextLine> lines = new TreeSet<TextLine>();
		FileReader fr = new FileReader("application.properties");
		BufferedReader br = new BufferedReader(fr);
		String line = null;
		Long ptn = 0L;
		while ((line = br.readLine()) != null) {
			ptn +=1;
			TextLine text = new TextLine(ptn, line);
			lines.add(text);
		}
		br.close();
		fr.close();
		System.out.println(lines);

		FileWriter fw = new FileWriter("app.properties");
		for (TextLine textLine : lines) {
			fw.write(textLine.getText() + "\n");
		}
		fw.close();

	}

}
