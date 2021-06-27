package com.praveen10.learn.java.LowLevelDesign.filesystem;

public class Main {
    public static void main(String[] args) {
        var directory = new Directory("D1", null);
        var subDirectory = new Directory("SD1", directory);
        var file = new File("ABC", directory, 100);
        directory.addEntry(file);
        directory.addEntry(subDirectory);

        System.out.println(directory.numberOfFiles());
    }
}
