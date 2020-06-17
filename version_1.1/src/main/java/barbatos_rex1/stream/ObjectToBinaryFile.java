package barbatos_rex1.stream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

class ObjectToBinaryFile {
	private String filePath;

	public ObjectToBinaryFile(String filePath) {
		this.filePath = filePath;
	}

	public boolean save(Object object){
		try{
			new ObjectOutputStream(new FileOutputStream(new File(filePath))).writeObject(object);
			return true;
		}catch(Exception e){
			return false;
		}
	}
}
