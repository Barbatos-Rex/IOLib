package lib;


import lib.barbatos_rex1.io.*;

public class Main {
	static IOManager io = new IOManager("src/test/resources/testFile.txt");

	public static void main(String[] args) {
		io.addLine(10, "Line: 10  Index:  9");
		System.out.println(io.getFileContent());
		io.addLine("Line: 11  Index: 10");
		io.addLine(19,"Line: 20  Index: 19",Key.INDEX);
		System.out.println(io.getFileContent());

	}
}
