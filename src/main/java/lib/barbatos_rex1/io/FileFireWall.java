package lib.barbatos_rex1.io;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

class FileFireWall {
    public boolean meltdown;
    private Manager manager;

    public FileFireWall(String str) {
        try {
            this.manager = new Manager(str);
            this.meltdown = false;
        } catch (IOException e) {
            this.meltdown = true;
        }
    }

    public FileFireWall(File file) {
        try {
            this.manager = new Manager(file);
            this.meltdown = false;
        } catch (IOException e) {
            this.meltdown = true;
        }
    }

    public boolean deleteFile() {
        return this.manager.deleteFile();
    }

    public boolean makeDir(String path) {
        try {
            return this.manager.makeDir(path);
        } catch (Exception e) {
            return false;
        }
    }

    public ArrayList<String> getFileCont() {
        try {
            return this.manager.getCont();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean saveFile() {
        try {
            return this.manager.saveText();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean addLine(int i, String str) {
        try {
            return this.manager.addLine(i, str);
        } catch (Exception e) {
            return false;
        }
    }
    public boolean addLine(String str) {
        try {
            return this.manager.addLine(str);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean setContent(ArrayList<String> newCont) {
        try {
            return this.manager.setContent(newCont);
        }catch (Exception e){
            return false;
        }
    }
}
