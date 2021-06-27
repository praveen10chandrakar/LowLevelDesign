package com.praveen10.learn.java.LowLevelDesign.filesystem;

import java.util.ArrayList;
import java.util.List;

public class Directory extends Entry {

    protected List<Entry> contents;

    public Directory(String name, Directory parent) {
        super(name, parent);
        contents = new ArrayList<>();
    }

    @Override
    public int size() {
        int size = 0;
        for (Entry entry: contents){
            size += entry.size();
        }
        return size;
    }

    public boolean deleteEntry(Entry entry){
        return contents.remove(entry);
    }

    public void addEntry(Entry entry){
        contents.add(entry);
    }

    public int numberOfFiles(){
        int count = 0;

        for (Entry entry: contents){
            if(entry instanceof Directory){
                count++;

                count += ((Directory) entry).numberOfFiles();
            } else if(entry instanceof File){
                count++;
            }
        }

        return count;
    }
}
