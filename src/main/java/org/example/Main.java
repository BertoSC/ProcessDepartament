package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        File root = new File("C:\\Users\\a23albertogc\\Desktop\\departments");
        File[] listaF = root.listFiles();

        try (PrintWriter writer = new PrintWriter(new FileWriter("prueba.txt"))) {
            for (File f : listaF) {

                File temp = f;
                String arg = f.getAbsolutePath();
                ProcessBuilder pb = new ProcessBuilder("java", "-cp", "target\\classes", "org.example.SumFile", arg);
                Process p = pb.start();
                try (BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()))) {

                    String line;
                    writer.println(f.getName());
                    writer.println("====================");

                    while ((line = br.readLine()) != null) {
                        writer.println(line); // Escribir cada línea de salida en el archivo de resultados
                    }

                    writer.println("====================");
                }

            }

        }
    }
}