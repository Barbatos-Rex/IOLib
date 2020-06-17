package barbatos_rex1.io.stream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

class ObjectToBinaryFile {
	/**
	 * The file's path
	 */
	private String filePath;

	/**
	 * The constructor for the exporter
	 * @param filePath The path for the file to be created and exported
	 */
	public ObjectToBinaryFile(String filePath) {
		this.filePath = filePath;
	}

	/**
	 * Saves the object into the file
	 * @param object The object to be saved
	 * @return The success of said attempt to save
	 */
	public boolean save(Object object){
		try{
			new ObjectOutputStream(new FileOutputStream(new File(filePath))).writeObject(object);
			return true;
		}catch(Exception e){
			return false;
		}
	}
}
