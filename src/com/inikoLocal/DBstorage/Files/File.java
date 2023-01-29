package com.inikoLocal.DBstorage.Files;

import java.nio.file.Path;

public class File {

    private int Id;
    private String FileName;
    private java.io.File file;
    private Path filePath;

    public File()
    {}
    public File(int id, String fileName, Path filePath) {
        Id = id;
        FileName = fileName;
        this.file = file;
        this.filePath = filePath;
    }

    public File(int id, String fileName, java.io.File file, Path filePath) {
        Id = id;
        FileName = fileName;
        this.file = file;
        this.filePath = filePath;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getFileName() {
        return FileName;
    }

    public void setFileName(String fileName) {
        FileName = fileName;
    }

    public java.io.File getFile() {
        return file;
    }

    public void setFile(java.io.File file) {
        this.file = file;
    }

    public Path getFilePath() {
        return filePath;
    }

    public void setFilePath(Path filePath) {
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        return "File{" +
                "Id=" + Id +
                ", FileName='" + FileName + '\'' +
                ", filePath=" + filePath +
                '}';
    }
}
