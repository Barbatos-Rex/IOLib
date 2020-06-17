package barbatos_rex1.io.text;


import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class is a multipurpose class to help manage files, write to them and get its content without any difficulty.
 * @author Barbatos Rex - 1190387@isep.ipp.pt
 * @version 1.0.1
 *
 */

public class IOManager implements Serializable {
	/**
	 * The "Fire Wall of the class, if it has a "meltdown" then the hole class in serious trouble.
	 */
	private FileFireWall fireWall;
	/**
	 * Status of the class.
	 */
	private boolean IOShutDown = false;
	/**
	 * The id.
	 */
	private final int id;
	/**
	 * The number of instances the class has.
	 */
	private static int numberOfInstances=-1;

	/**
	 * Constructor of the class
	 *
	 * @param str The path to the file to be opened.
	 */
	public IOManager(String str) {
		this.fireWall = new FileFireWall(str);
		this.IOShutDown = this.fireWall.meltdown;
		this.id=numberOfInstances++;
	}

	/**
	 * Constructor of the class
	 *
	 * @param file The file to be opened.
	 */
	public IOManager(File file) {
		this.fireWall = new FileFireWall(file);
		this.IOShutDown = this.fireWall.meltdown;
		this.id=numberOfInstances++;
	}

	/**
	 * Deletes the file of the class. It also closes the class.
	 *
	 * @return The success of the method.
	 */
	public boolean deleteFile() {
		boolean t = this.fireWall.deleteFile();
		this.close();
		return t;
	}

	/**
	 * Creates a directory in a specific location. For being detached from a file, the class does not need to be open to create the directory.
	 *
	 * @param path The path of the directory to be created.
	 * @return The success of the method.
	 */
	public boolean makeDir(String path) {
		return this.fireWall.makeDir(path);
	}

	/**
	 * Returns the content of the file.
	 *
	 * @return The content of the file.
	 */
	public ArrayList<String> getFileContent() {
		if (this.isLocked()) {
			return null;
		}
		return new ArrayList<String>(this.fireWall.getFileCont());
	}

	/**
	 * Saves the current content in the file.
	 *
	 * @return The success of the method.
	 */
	public boolean saveFile() {
		if (this.isLocked()) {
			return false;
		}
		return this.fireWall.saveFile();
	}

	/**
	 * Adds a line of content to the content of the file.
	 *
	 * @param i   The line number.
	 * @param str The Content.
	 * @return The success of the method.
	 */
	public boolean addLine(int i, String str) {
		if (this.isLocked()) {
			return false;
		}
		if(fireWall.getFileCont().size()<i){
		    for(int j=fireWall.getFileCont().size();j<i-1;j++){
		        if(!fireWall.addLine("")){
		            return false;
                }
            }
        }
		return this.fireWall.addLine(i, str);
	}

    /**
     * Adds a line in a certain index/line number.
     * @param i The line number/index.
     * @param str The content of the line.
     * @param key The key of the function if LINE or INDEX.
     * @return The sucess of the method.
     */
	public boolean addLine(int i, String str, Key key) {
        if (this.isLocked()) {
            return false;
        }
        if (key.equals(Key.LINE)) {
            return this.addLine(i, str);
        }
        if(key.equals(Key.INDEX)){
            return this.addLine(i+1,str);
        }
        return false;
    }

	/** Adds the content to the last line of the file.
	 * @param str The content of the line.
	 * @return The success of the method.
	 */

	public boolean addLine(String str) {
		if (this.isLocked()) {
			return false;
		}
		return this.fireWall.addLine(str);
	}

	/**
	 * Sets the file content to a new content.
	 *
	 * @param newCont The new content of the file.
	 * @return The success of the method.
	 */
	public boolean setContent(ArrayList<String> newCont) {
		return this.fireWall.setContent(newCont);
	}

	/**
	 * Indicates the status of the file. If it is usable it returns true.
	 *
	 * @return The status of the file.
	 */
	public boolean isLocked() {
		return IOShutDown;
	}

	/**
	 * Safely closes the file and deletes any pointers of the file from the class. After that, the classes it imported are collected by the garbage collector.
	 *
	 * @return The success of the method.
	 */
	public boolean close() {
		this.fireWall.saveFile();
		this.fireWall = null;
		return (this.IOShutDown = true);
	}

	/**
	 * Deletes a certain line in the file
	 *
	 * @param line The line number
	 * @return The success of the method
	 */
	public boolean removeLine(int line) {
		return fireWall.removeLine(line - 1);
	}

	/**
	 * Deletes a certain line in the file
	 *
	 * @param line The line number or it's index
	 * @param key  The type of the line, if index or line
	 * @return The success of the method
	 */
	public boolean removeLine(int line, Key key) {
		if (key.equals(Key.INDEX)) {
			return removeLine(line + 1);
		}
		if (key.equals(Key.LINE)) {
			return removeLine(line);
		}
		return false;
	}
}
