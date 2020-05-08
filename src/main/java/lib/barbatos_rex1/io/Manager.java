package lib.barbatos_rex1.io;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * The type Manager.
 */
class Manager {
    private final File file;
    private ArrayList<String> content;
    private final Importer in;
    private final Exporter ex;

    /**
     * Instantiates a new Manager.
     *
     * @param str the file path
     * @throws IOException the io exception
     */
    public Manager(String str) throws IOException {
        this.file = new File(str);
        this.in = new Importer(this.file);
        this.ex=new Exporter(this.file);
        this.file.createNewFile();
        this.content = in.get();
    }

    /**
     * Instantiates a new Manager.
     *
     * @param file the file
     * @throws IOException the io exception
     */
    public Manager(File file) throws IOException {
        this.file = file;
        this.file.createNewFile();
        this.in = new Importer(file);
        this.ex=new Exporter(file);
        this.content = in.get();
    }

    /**
     * Deletes file.
     *
     * @return the success
     */
    public boolean deleteFile() {
        return this.file.delete();
    }

    /**
     * Make dir.
     *
     * @param path the path
     * @return the success
      */
    public boolean makeDir(String path) {
        return new File(path).mkdirs();
    }

    /**
     * Gets cont.
     *
     * @return the content of the file
     */
    public ArrayList<String> getCont() {
        return this.content;
    }

    /**
     * Save text.
     *
     * @return the success
     * @throws IOException the io exception
     */
    public boolean saveText() throws IOException {
        return this.ex.save(this.content);
    }

    /**
     * Add line boolean.
     *
     * @param i   the line number
     * @param str the line content
     * @return the success
     */
    public boolean addLine(int i, String str) {
        this.content.add(i-1, str);
        return true;
    }

    /**
     * Add line in the end of the file.
     *
     * @param str the line content
     * @return the boolean
     */
    public boolean addLine(String str) {
        this.content.add(str);
        return true;
    }

    /**
     * Sets the file content.
     *
     * @param newCont the new content
     * @return the success
     */
    public boolean setContent(ArrayList<String> newCont) {
        this.content=new ArrayList<>(newCont);
        return true;
    }

    /**
     * Remove line.
     *
     * @param i the
     * @return the success
     */
    public boolean removeLine(int i) {
        return this.content.remove(i) != null;
    }
}
