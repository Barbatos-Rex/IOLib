package barbatos_rex1.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The type Importer.
 */
class Importer implements Serializable {
    private final File file;

    /**
     * Instantiates a new Importer.
     *
     * @param file the file
     */
    public Importer(File file) {
        this.file = file;
    }

    /**
     * Get the file content in an ArrayList.
     *
     * @return the the content of the file
     * @throws FileNotFoundException the file not found exception
     */
    public ArrayList<String> get() throws FileNotFoundException {
        Scanner in = new Scanner(this.file);
        ArrayList<String> lista = new ArrayList<String>();
        while (in.hasNextLine()) {
            lista.add(in.nextLine());
        }
        in.close();
        return lista;
    }
}
