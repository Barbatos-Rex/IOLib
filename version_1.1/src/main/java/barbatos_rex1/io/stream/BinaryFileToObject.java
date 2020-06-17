package barbatos_rex1.io.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * The class responsible for loading object from binary files
 * @param <T> The type of the object to be read
 */
class BinaryFileToObject<T> {
	/**
	 * The path of the file
	 */
	private String filePath;

	/**
	 * The constructor of the loader
	 * @param filePath The path for the file to be loaded
	 */
	public BinaryFileToObject(String filePath){
		this.filePath=filePath;
	}

	/**
	 * Reads the object from the specified file
	 * @return The object that was in the file. Null if it is not from the declared type or there 
	 * was an error while accessing the file. 
	 */
	public T readObject(){
		try {
			return ((T) new ObjectInputStream(new FileInputStream(new File(filePath))).readObject());
		}catch (Exception e){
			return null;
		}
	}
}
