package lib;


import lib.barbatos_rex1.io.IOManager;

public class Main {
	public static void main(String[] args) {
		IOManager manager = new IOManager("teste.txt");
		manager.addLine("1");
		manager.saveFile();
		manager.addLine("2");
		manager.addLine("3");
		manager.saveFile();
	}
}
