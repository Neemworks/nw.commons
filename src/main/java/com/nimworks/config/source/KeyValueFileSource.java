package com.nimworks.config.source;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nimworks.config.ISource;
import com.nimworks.props.LineText;

/**
 * 
 * @author Ogwara O. Rowland
 * @since Jul 7, 2017
 *
 */
public class KeyValueFileSource implements ISource {
	
	private File file;
	
	/**
	 * Current file line number
	 */
	private Long cursor = 0L;
	
	/**
	 * Sorted list of lines
	 */
	private SortedSet<LineText> lines = new TreeSet<LineText>();
	
	private static Logger logger = LoggerFactory.getLogger(KeyValueFileSource.class);
	
	public KeyValueFileSource(File file) {
		this.file = file;
	}

	@Override
	public Map<String, Object> read() {
		
		Map<String, Object> store = new HashMap<String, Object>();
		try {
			file.createNewFile();
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			while ((line = br.readLine()) != null) {
				cursor +=1;
				LineText text = new LineText(cursor, line);
				lines.add(text);

				if(!text.isComment()){
					store.put(text.getKey(), text.getValue());
				}

			}
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			logger.error("No property file with name " + file + " found" );
		} catch (IOException e) {
			logger.error("A read error occurred while reading " + file );
		}
		return store;
	}

	@Override
	public void write(Map<String, Object> configs) {
		// TODO Auto-generated method stub

	}

}
