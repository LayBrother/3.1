package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //исходя из условий задачи предполагаем, что директория Games создана вручную, в нашем случае на диске E:
        List<String> inGames = Arrays.asList("src", "res", "savegames", "temp");
        List<String> inSrc = Arrays.asList("main", "test");
        List<String> inRes = Arrays.asList("drawables", "vectors", "icons");

        StringBuilder logTmp = new StringBuilder("\nЛог создания директорий и файлов.\n");

        logTmp.append(CreateDirFile.createDir(inGames, "E://Games//"));
        logTmp.append(CreateDirFile.createDir(inSrc, "E://Games//src//"));
        logTmp.append(CreateDirFile.createDir(inRes, "E://Games//res//"));

        logTmp.append(CreateDirFile.createFile("Main.java", "E://Games//src//main//"));
        logTmp.append(CreateDirFile.createFile("Utils.java", "E://Games//src//main//"));

        logTmp.append(CreateDirFile.createFile("temp.txt", "E://Games//temp//"));

        try (FileWriter writer = new FileWriter("E://Games//temp//temp.txt", true)) {
            writer.write(logTmp.toString());
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(logTmp);
    }
}