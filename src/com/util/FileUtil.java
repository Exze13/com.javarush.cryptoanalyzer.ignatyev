package com.util;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileUtil {

    String filePath;
    String fileContent;

    /**
     * @return Возвращаем содержимое файла
     */
    public String getFileContent() {
        return fileContent;
    }

    /**
     * @param filePath - Путь до файла
     * @throws IOException
     */
    public FileUtil(String filePath) throws IOException {
        this.filePath = filePath;
        this.fileContent = Files.readString(Path.of(filePath));
    }

    /**
     * @param text - Контент записываемый в файл
     * @throws IOException
     */
    public void writeFile(String text) throws IOException {
        Files.writeString(Path.of(this.filePath), text);
    }
}
