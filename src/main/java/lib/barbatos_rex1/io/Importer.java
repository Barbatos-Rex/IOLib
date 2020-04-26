package lib.barbatos_rex1.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class Importer {
    private File file;

    public Importer(File file) {
        this.file = file;
    }

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
