package barbatos_rex1.io.text;


import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * The type File fire wall.
 */
class FileFireWall implements Serializable {
	/**
	 * The Meltdown. If the file is usable the this variable is false.
	 */
	public boolean meltdown;
	/**
	 * The Manager
	 */
	private Manager manager;

	/**
	 * Instantiates a new File fire wall.
	 *
	 * @param str the file path
	 */
	public FileFireWall(String str) {
		try {
			this.manager = new Manager(str);
			this.meltdown = false;
		} catch (IOException e) {
			this.meltdown = true;
		}
	}

	/**
	 * Instantiates a new File fire wall.
	 *
	 * @param file the file
	 */
	public FileFireWall(File file) {
		try {
			this.manager = new Manager(file);
			this.meltdown = false;
		} catch (IOException e) {
			this.meltdown = true;
		}
	}

	/**
	 * Delete file.
	 *
	 * @return the success
	 */
	public boolean deleteFile() {
		return this.manager.deleteFile();
	}

	/**
	 * Make dir.
	 *
	 * @param path the path
	 * @return the success
	 */
	public boolean makeDir(String path) {
		try {
			return this.manager.makeDir(path);
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Gets file content.
	 *
	 * @return the file content
	 */
	public ArrayList<String> getFileCont() {
		try {
			return this.manager.getCont();
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Saves file content.
	 *
	 * @return the success
	 */
	public boolean saveFile() {
		try {
			return this.manager.saveText();
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Adds a line.
	 *
	 * @param i   the line number
	 * @param str the content
	 * @return the success
	 */
	public boolean addLine(int i, String str) {
		try {
			return this.manager.addLine(i, str);
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Adds a line in the end of the file.
	 *
	 * @param str the content
	 * @return the success
	 */
	public boolean addLine(String str) {
		try {
			return this.manager.addLine(str);
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Sets the content of the file.
	 *
	 * @param newCont the new content
	 * @return the success
	 */
	public boolean setContent(ArrayList<String> newCont) {
		try {
			return this.manager.setContent(newCont);
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Remove line.
	 *
	 * @param i the line number
	 * @return the success
	 */
	public boolean removeLine(int i) {
		try {
			return manager.removeLine(i);
		} catch (Exception e) {
			return false;
		}
	}
}
