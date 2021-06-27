package com.praveen10.learn.java.LowLevelDesign.filesystem;

public abstract class Entry {
    protected Directory parent;
    protected long createdAt;
    protected long lastUpdated;
    protected long lastAccessed;
    protected String name;

    public Entry(String name, Directory parent){
        this.name = name;
        this.parent = parent;
        createdAt = System.currentTimeMillis();
        lastAccessed = System.currentTimeMillis();
        lastUpdated = System.currentTimeMillis();
    }

    public boolean delete(Entry entry){
        if(parent == null){
            return  false;
        }
        return  parent.deleteEntry(entry);
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public long getLastUpdated() {
        return lastUpdated;
    }

    public long getLastAccessed() {
        return lastAccessed;
    }

    public String getName() {
        return name;
    }

    public abstract int size();

    public void setName(String name) {
        this.name = name;
    }
}
