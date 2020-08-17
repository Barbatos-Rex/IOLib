package barbatos_rex1.io.text;


import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * The type Manager.
 */
class Manager implements Serializable {
    /**
     *The file.
     */
    private final File file;
    /**
     * The file content.
     */
    private ArrayList<String> content;
    /**
     * The importer.
     */
    private final Importer in;
    /**
     * The exporter
     */
    private final Exporter ex;

    /**
     * Instantiates a new Manager.
     *
     * @param str the file path
     * @throws IOException the barbatos_rex1.io exception
     */
    public Manager(String str) throws IOException {
        makeDir(new File(str).getParent());
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
     * @throws IOException the barbatos_rex1.io exception
     */
    public Manager(File file) throws IOException {
        this(file.getPath());
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
        String[] dirPath= path.split("\\w*\\.[\\w]{1,100}");
        return new File(dirPath[0]).mkdirs();
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
     * @throws IOException the barbatos_rex1.io exception
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
     * @param i the line number.
     * @return the success
     */
    public boolean removeLine(int i) {
        return this.content.remove(i) != null;
    }
}
