package com.na.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

class Document1 {

    private final int id;
    private final String name;
    private final Date lastModifiedOn;

    public Document1(int id, String name, Date lastModifiedOn) {
        this.id = id;
        this.name = name;
        this.lastModifiedOn = lastModifiedOn;
    }
    
	public Date getLstModifiedOn() {
        return lastModifiedOn;
    }

    @Override
    public String toString() {
        return "Document1{" + "id=" + id + ", name=" + name + ", lastModifiedOn=" + lastModifiedOn + '}';
    }
}

/**
 *
 * @author Nandwana
 */
public class StreamFilterTest {

    public static void main(String[] args) {
        Document1 doc1 = new Document1(1, "doc1", getDate(2016, 5, 30));
        Document1 doc2 = new Document1(2, "doc2", getDate(2018, 6, 1));
        Document1 doc3 = new Document1(3, "doc3", getDate(2017, 7, 2));
        Document1 doc4 = new Document1(4, "doc4", getDate(2016, 8, 3));
        Document1 doc5 = new Document1(5, "doc5", getDate(2018, 1, 4));

        List<Document1> list = new ArrayList<>();
        list.add(doc1);
        list.add(doc2);
        list.add(doc3);
        list.add(doc4);
        list.add(doc5);

        filteAndPrintDocForGivenCritera(list, getDate(2016, 5, 30));
    }

    private static Date getDate(int year, int m, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, m, day);
        return cal.getTime();
    }

    private static void filteAndPrintDocForGivenCritera(List<Document1> list, Date criteraDate) {
        List<Document1> filteredDocList = list.stream().filter(doc -> !doc.getLstModifiedOn().equals(criteraDate)).collect(Collectors.toList());
        System.out.println(filteredDocList);
    }
}