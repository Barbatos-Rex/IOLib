package barbatos_rex1.stream;

public class BinaryFileManager<T> {
	private BinaryFileToObject<?> importer;
	private ObjectToBinaryFile exporter;

	public BinaryFileManager(String filePath) {
		importer=new BinaryFileToObject<T>(filePath);
		exporter=new ObjectToBinaryFile(filePath);
	}

	public boolean save(Class<?> object){
		return exporter.save(object);
	}
	public T load(){
		return (T) importer.readObject();
	}
}
