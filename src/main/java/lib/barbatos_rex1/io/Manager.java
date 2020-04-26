package lib.barbatos_rex1.io;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

class Manager {
    private File file;
    private ArrayList<String> content;
    private Importer in;
    private Exporter ex;

    public Manager(String str) throws IOException {
        this.file = new File(str);
        this.in = new Importer(this.file);
        this.ex=new Exporter(this.file);
        this.file.createNewFile();
        this.content = in.get();
    }

    public Manager(File file) throws IOException {
        this.file = file;
        this.file.createNewFile();
        this.in = new Importer(file);
        this.ex=new Exporter(file);
        this.content = in.get();
    }

    public boolean deleteFile() {
        return this.file.delete();
    }

    public boolean makeDir(String path) {
        return new File(path).mkdirs();
    }

    public ArrayList<String> getCont() {
        return this.content;
    }

    public boolean saveText() throws IOException {
        return this.ex.save(this.content);
    }

    public boolean addLine(int i, String str) {
        this.content.add(i-1, str);
        return true;
    }
    public boolean addLine(String str) {
        this.content.add(str);
        return true;
    }

    public boolean setContent(ArrayList<String> newCont) {
        this.content=new ArrayList<>(newCont);
        return true;
    }
}
