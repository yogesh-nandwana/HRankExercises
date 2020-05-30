package com.na.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Document{
	
	private int id;
	private String name;
	private long size;
	private Date createdBy;
	
	public Document() {
	}
	
	public Document(int id, String name, long size, Date createdBy) {
		this.id = id;
		this.name = name;
		this.size = size;
		this.createdBy = createdBy;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public Date getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Date createdBy) {
		this.createdBy = createdBy;
	}
	
	public int getDay(){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(createdBy);
		return calendar.get(Calendar.DAY_OF_MONTH);
	}
	
	public int getMonth(){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(createdBy);
		return calendar.get(Calendar.MONTH);
	}
	
	public int getYear(){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(createdBy);
		return calendar.get(Calendar.YEAR);
	}

	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Document [id=").append(id).append(", ");
		if (name != null)
			builder.append("name=").append(name).append(", ");
		builder.append("size=").append(size).append(", ");
		if (createdBy != null)
			builder.append("createdBy=").append(createdBy);
		builder.append("]");
		return builder.toString();
	}

	public boolean isSameDay(Date date1, Date date2) {
	    Calendar calendar1 = Calendar.getInstance();
	    calendar1.setTime(date1);
	    Calendar calendar2 = Calendar.getInstance();
	    calendar2.setTime(date2);
	    boolean sameYear = calendar1.get(Calendar.YEAR) == calendar2.get(Calendar.YEAR);
	    boolean sameMonth = calendar1.get(Calendar.MONTH) == calendar2.get(Calendar.MONTH);
	    boolean sameDay = calendar1.get(Calendar.DAY_OF_MONTH) == calendar2.get(Calendar.DAY_OF_MONTH);
	    return (sameDay && sameMonth && sameYear);
	}
}


class OuterClass{
	private int i;
	
	class InnerClass {
		int i;
	}
}

public class DateFilterTest {
	
	public static Date getFilterDate(){
		Calendar calendar = Calendar.getInstance();
		calendar.set(2018, 5, 30);
		return calendar.getTime();
	}
	
	public static void main(String[] args) {
		
		Document doc1 = new Document(1,"doc1",123,new Date());
		Document doc2 = new Document(2,"doc2",124,getFilterDate());
		Document doc3 = new Document(3,"doc3",125,new Date());
		Document doc4 = new Document(4,"doc4",126,new Date());
		Document doc5 = new Document(5,"doc5",127,new Date());

		List<Document> docList = new ArrayList<>();
		docList.add(doc1);
		docList.add(doc2);
		docList.add(doc3);
		docList.add(doc4);
		docList.add(doc5);
		
		
		
		List<Document> filteredDocList = docList.stream().filter(doc->doc.isSameDay(doc.getCreatedBy(), getFilterDate())).collect(Collectors.toList());
		System.out.println(filteredDocList);
		
	}
}