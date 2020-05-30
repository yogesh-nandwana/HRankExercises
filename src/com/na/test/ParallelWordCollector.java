package com.na.test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
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
public class ParallelWordCollector {
    
    private static final Logger LOG = Logger.getLogger(ParallelWordCollector.class.getName());
    private static final String DIR_PATH = "C:\\testfolder";
    private static final String FILTER_PATTERN = ".txt";
    
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        File file = Paths.get(DIR_PATH).toFile();
        final Map<String,Long> resultMap = new TreeMap<>();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        LOG.log(Level.INFO,"Avaialable Processors:{0}",availableProcessors);
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(5);
        
        final File[] files;
        if (file.isDirectory()) {
            files = Paths.get(DIR_PATH).toFile().listFiles((File pathname) -> pathname.getName().contains(FILTER_PATTERN));
            if (files.length > 0) {
                LOG.log(Level.INFO, "Files count:{0}", files.length);
                List<Callable<Map<String,Long>>> callableList = new ArrayList<>(files.length );
                for (File aFile : files) {
                    callableList.add(() -> {
                        LOG.log(Level.INFO,"{0}- is processing file:{1}",new Object[]{Thread.currentThread().getName(),aFile.getName()});
                        Map<String, Long> wordCountMap = null;
                        List<String> lines = Files.readAllLines(aFile.toPath());
                        if (null != lines && !lines.isEmpty()) {
                            wordCountMap = new TreeMap<>();
                            Iterator<String> iterator = lines.iterator();
                            while (iterator.hasNext()) {
                                String cleanLine = iterator.next().trim().replaceAll("[,.\t]", "");
                                String[] words = cleanLine.split("[\\s]");
                                for (String word : words) {
                                    Long count = wordCountMap.get(word);
                                    count = (count == null) ? 1 : count + 1;
                                    wordCountMap.put(word, count);
                                }
                            }
                        } else {
                            LOG.log(Level.INFO, "{0} is an empty file.", aFile.getAbsolutePath());
                        }
                        return wordCountMap;
                    });
                }
                List<Future<Map<String, Long>>> futures;
                try {
                    LOG.log(Level.INFO,"callableList size:{0}",callableList.size());
                    futures = newFixedThreadPool.invokeAll(callableList);
                    for(Future<Map<String,Long>> future:futures){
                        try {
                            Map<String, Long> map = future.get();
                            resultMap.putAll(map);
                        } catch (InterruptedException | ExecutionException ex) {
                            Logger.getLogger(ParallelWordCollector.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    LOG.log(Level.INFO, "resultMap:{0}", resultMap);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ParallelWordCollector.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        newFixedThreadPool.shutdown();
        long endTime = System.currentTimeMillis();
        LOG.log(Level.INFO, "Time taken(in ms):{0}", endTime - startTime);
    }
}