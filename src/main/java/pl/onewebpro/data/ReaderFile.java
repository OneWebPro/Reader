package pl.onewebpro.data;

import java.io.File;

public class ReaderFile {
    private File file;

    public ReaderFile(File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
