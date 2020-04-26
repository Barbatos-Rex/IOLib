package lib.barbatos_rex1.io;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

class Exporter {
    private File file;
    public Exporter(File file){
        this.file=file;
    }
    public boolean save(ArrayList<String> content) throws IOException {
        PrintWriter ex = new PrintWriter(file);
        for (String s : content) {
            ex.println(s);
        }
        ex.close();
        return true;
    }
}
