package com.na.test;

import java.io.File;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.RecursiveTask;
import java.util.logging.Level;
import java.util.logging.Logger;

class DirLister extends RecursiveTask<Map<String,List<String>>> {
    private List<String>  readableDrives = null;
    
    public DirLister(List<String> list) {
        this.readableDrives = list;
    }
    
    @Override
    protected Map<String, List<String>> compute() {
        Map<String,List<String>>  dirFilesMap = new TreeMap<>();
        
        return dirFilesMap;
    }
}

/**
 *
 * @author Nandwana
 */
public class FileFinder {
    private static final Logger LOG = Logger.getLogger(FileFinder.class.getName());
    
    public static void main(String[] args) {
        FileSystem aDefault = FileSystems.getDefault();
        Iterable<Path> rootDirectories = aDefault.getRootDirectories();
        Iterator<Path> iterator = rootDirectories.iterator();
        
        List<String>  readableDrives = new ArrayList<>();
        while(iterator.hasNext()){
            Path next = iterator.next();
            File file = next.toFile();
            if(file.canRead() && file.isDirectory()){
                readableDrives.add(file.getPath());
            }
        }
        LOG.log(Level.INFO, "Readable drives are:{0}", readableDrives);
    }
    
    
}
