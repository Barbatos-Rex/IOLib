package lib.barbatos_rex1.io;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * The type Exporter.
 */
class Exporter {
    private final File file;

    /**
     * Instantiates a new Exporter.
     *
     * @param file the file
     */
    public Exporter(File file){
        this.file=file;
    }

    /**
     * Saves an ArrayList to a file.
     *
     * @param content the content
     * @return the success
     * @throws IOException the io exception
     */
    public boolean save(ArrayList<String> content) throws IOException {
        PrintWriter ex = new PrintWriter(file);
        for (String s : content) {
            ex.println(s);
        }
        ex.close();
        return true;
    }
}
