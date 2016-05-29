package nw.commons.props;

import java.io.BufferedReader;
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
public abstract class KeyValueProperties extends Loggable{

	/**
	 * Property store
	 */
	private Map<String, String> store = new HashMap<String, String>();

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
		} catch (IOException e) {
			logger.error("A read error occurred while reading " + properties );
		}
	}

	/**
	 * saves a new property
	 * @param key
	 * @param value
	 */
	protected void save(String key, String value){
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
	 * @param key
	 * @param value
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
	 */
	protected synchronized void set(String key, String value) {
		store.put(key, value);
		update(key, value);
	}

	/**
	 * Adds a new property entry
	 * @param key
	 * @param value
	 * @param comments
	 */
	protected synchronized void add(String key, String value, String comments) {
		store.put(key, value);
		if(comments != null && !comments.isEmpty()){
			cursor +=1;
			TextLine cmts = new TextLine(cursor, "# " + comments);
			lines.add(cmts);
		}

		cursor +=1;
		TextLine text = new TextLine(cursor, key + "="+value);
		lines.add(text);
		save(key, value);
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
