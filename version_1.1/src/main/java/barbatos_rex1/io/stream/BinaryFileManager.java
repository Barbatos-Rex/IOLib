package barbatos_rex1.io.stream;

/**
 * The class that manages binary files
 * @param <T> The type of the object that the file holds
 */
public class BinaryFileManager<T> {
	/**
	 * The class responsible for load the object
	 */
	private BinaryFileToObject<?> importer;
	/**
	 * The class responsible for save the object
	 */
	private ObjectToBinaryFile exporter;

	/**
	 * The constructor of the manager
	 * @param filePath The path to the binary file to be read/save
	 */
	public BinaryFileManager(String filePath) {
		importer=new BinaryFileToObject<T>(filePath);
		exporter=new ObjectToBinaryFile(filePath);
	}

	/**
	 * Saves an object to the file
	 * @param object The object that is the manager's type
	 * @return The success of the save
	 */
	public boolean save(T object){
		return exporter.save(object);
	}

	/**
	 * Loads the object that is in the file
	 * @return The object of the file. In case of failure it returns null
	 */
	public T load(){
		return (T) importer.readObject();
	}
}
