package barbatos_rex1.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class BinaryFileToObject<T> {
	private String filePath;
	public BinaryFileToObject(String filePath){
		this.filePath=filePath;
	}
	public T readObject(){
		try {
			return ((T) new ObjectInputStream(new FileInputStream(new File(filePath))).readObject());
		}catch (Exception e){
			return null;
		}
	}
}
