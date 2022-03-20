package com.company;

import java.io.File;
import java.io.IOException;
import java.util.List;

class CreateDirFile {
    static StringBuilder createDir(List<String> createDir, String parentDir) {
        StringBuilder logTmp = new StringBuilder();

        for (String nameDir : createDir) {
            File dir = new File(parentDir + nameDir);

            if (dir.mkdir()) {
                logTmp.append("Каталог ").append(parentDir).append(nameDir).append(" создан успешно\n");
            } else {
                logTmp.append("Ошибка при создании каталога ").append(parentDir).append(nameDir).append("\n");
            }
        }
        return logTmp;
    }

    static StringBuilder createFile(String nameFile, String parentDir) {
        StringBuilder logTmp = new StringBuilder();
        File file = new File(parentDir, nameFile);

        try {
            if (file.createNewFile()) {
                return logTmp.append("Файл ").append(parentDir).append(nameFile).append(" создан успешно\n");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return logTmp.append(ex.getMessage()).append(" Ошибка создания Файла ").append(parentDir).append(nameFile).append("\n");
        }
        return logTmp.append("Ошибка создания Файла ").append(parentDir).append(nameFile).append("\n");
    }
}