package com.praveen10.learn.java.LowLevelDesign.filesystem;

public class File extends Entry {
    private String content;
    private int size;

    public File(String name, Directory parent, int size) {
        super(name, parent);
        this.size = size;
    }

    @Override
    public int size() {
        return 0;
    }

    public String getContent() {
        return content;
    }

    public int getSize() {
        return size;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

