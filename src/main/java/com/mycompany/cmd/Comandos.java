package com.mycompany.cmd;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Comandos {

    File elFile = null;

    public boolean mkdir(String name) {
        elFile = new File(elFile.getAbsolutePath() + "/" + name);
        return elFile.mkdirs();
    }

    public boolean mfile(String name) throws IOException {
        elFile = new File(elFile.getAbsolutePath() + "/" + name);
        return elFile.createNewFile();
    }

    public boolean rm(String name) {
        elFile = new File(name);
        return elFile.delete();
    }

    public File cd(String name) {
        File file = new File(elFile.getAbsolutePath() + "/" + name);
        if (file.exists() == true) {
            elFile = new File(elFile.getAbsoluteFile() + "/" + name);
        }
        return null;
    }

    public File regreso() {
        return elFile = new File(elFile.getAbsoluteFile().getParentFile().getAbsolutePath());
    }

    public String dir() {
        String text = " ";
        for (File child : elFile.listFiles()) {
            if (child.isDirectory()) {
                text += "<dir>" + child.getName() + "\n";
            }
        }
        for (File child : elFile.listFiles()) {
            if (child.isFile()) {
                text += child.getName() + "\t" + child.length();
            }
        }
        return text;
    }

    public String date() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate = new Date();
        String formattedDate = dateFormat.format(currentDate);

        return "Fecha actual: " + formattedDate;
    }

    public String time() {
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        Date currentTime = new Date();
        String formattedTime = timeFormat.format(currentTime);

        return "Hora actual: " + formattedTime;
    }

    public void escribir(String fileName, String content) {
        try {
            File file = new File(elFile, fileName);
            java.nio.file.Files.write(file.toPath(), content.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String leer(String fileName) {
        try {
            File file = new File(elFile, fileName);
            return new String(java.nio.file.Files.readAllBytes(file.toPath()));
        } catch (Exception e) {
            e.printStackTrace();
            return "Error reading file.";
        }
    }
}
