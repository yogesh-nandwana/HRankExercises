package com.na.threads;

import java.io.File;
import java.io.FileFilter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nandwana
 */
public class WordCounter {

    public static void main(String[] args) {
//        if(args.length!=1){
//            System.out.println("Please pass folder path, containg some text files to process.");
//            System.exit(-1);
//        }
        final List<String> get = new ArrayList<>();
        Callable<List> wordCollector = () -> {
            List<String> lines = new ArrayList<>();
            Path path = Paths.get("C:\\testfolder");
            File file = path.toFile();
            if (file.isDirectory()) {
                FileFilter filter = (File pathname) -> (pathname.isFile() && pathname.getPath().contains(".txt"));
                File[] files = file.listFiles(filter);
                for (File aFile : files) {
                    lines.addAll(Files.readAllLines(Paths.get(aFile.getPath())));
                }
            } else {
                lines = Files.readAllLines(path);
                lines.addAll(lines);
            }
            return lines;
        };

        Callable<Map> wordCounter = () -> {
            Map<String, Integer> map = new TreeMap<>();
            Iterator<String> iterator = get.iterator();
            while(iterator.hasNext()){
                String line = iterator.next();
                line = line.replace(".,", "");
                String[] wordsArray = line.split(" ");
                for(String word:wordsArray){
                    Integer count = map.get(word);
                    if(count!=null){
                        map.put(word, count+1);
                    }else{
                        map.put(word, 1);
                    }
                }
            }
            return map;
        };
        long startTime = System.currentTimeMillis();
        ExecutorService newFixedThreadPool = Executors.newSingleThreadExecutor();
        Collection tasks = new ArrayList<>();
        tasks.add(wordCollector);
        try {
            newFixedThreadPool.invokeAll(tasks);
        } catch (InterruptedException ex) {
            Logger.getLogger(WordCounter.class.getName()).log(Level.SEVERE, null, ex);
        }
        Future<List> futures = newFixedThreadPool.submit(wordCollector);
        try {
            get.addAll(futures.get());
            System.out.println("get: " + get);
            Future<Map> wordMapFutrues = newFixedThreadPool.submit(wordCounter);
            Map wordMp  =wordMapFutrues.get();
            System.out.println("wordMp:"+wordMp);
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(WordCounter.class.getName()).log(Level.SEVERE, null, ex);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken(ms):"+(endTime - startTime));
        newFixedThreadPool.shutdown();
    }
}