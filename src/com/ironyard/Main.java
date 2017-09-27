package com.ironyard;

import javax.xml.ws.EndpointReference;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Entry> entries = Entry.populate();
        printEntries(entries);
        printTuesdays(entries);
        countTueWedThur(entries);
        weekendList(entries);
        weekdaySet(entries);
        printDurationGreaterThan10(entries);
        findMaxDuration(entries);
        listGreaterThan50(entries);
    }


    public static void printEntries(List<Entry> entries) {
        System.out.println("For Loop:");
        for (Entry entry : entries) {
            System.out.println(entry + ", ");
        }
        System.out.println("\nStream, forEach:");
        entries.stream().forEach(entry -> System.out.println(entry + ", "));
        System.out.println();
    }

    public static void printTuesdays(List<Entry> entries) {
        System.out.println("Print Tuesdays For Loop:");
        for (Entry entry : entries) {
            if (entry.getDay().equals(Day.TUESDAY)) {
                System.out.println(entry + ", ");
            }
        }
        System.out.println("\n Print Tuesdays Stream, filter, forEach:");
        entries.stream().filter(entry -> entry.getDay().equals(Day.TUESDAY))
                .forEach(entry -> System.out.println(entry));
        System.out.println();
    }

    public static void countTueWedThur(List<Entry> entries) {
        System.out.println("Count Tuesday, Wednesday, Thursday For Loop:");
        int count = 0;
        for (Entry e : entries) {
            if (e.getDay().equals(Day.TUESDAY) || e.getDay().equals(Day.WEDNESDAY) || e.getDay().equals(Day.THURSDAY)) {
                count += 1;
            }
        }
        System.out.println("Number of entries on Tuesday, Wednesday or Thursday: " + count);
        System.out.println("Stream, filter, count: ");
        long count1 = 0;
        count1 = entries.stream().filter(e -> e.getDay().equals(Day.TUESDAY) || e.getDay().equals(Day.WEDNESDAY) || e.getDay().equals(Day.THURSDAY))
                .count();
        System.out.println("Number of entries on Tuesday, Wednesday or Thursday: " + count1);
        System.out.println();
    }

    public static void weekendList(List<Entry> entries) {
        System.out.println("Weekend List For Loop:");
        List<Entry> weekends = new ArrayList<>();
        for (Entry entry : entries) {
            if (entry.getDay().equals(Day.SATURDAY) || entry.getDay().equals(Day.SUNDAY)) {
                weekends.add(entry);
            }
        }
        System.out.println(weekends);
        System.out.println("Stream, filter, collect:");
        weekends = entries.stream().filter(entry -> entry.getDay().equals(Day.SATURDAY) || entry.getDay().equals(Day.SUNDAY))
                .collect(Collectors.toList());
        System.out.println(weekends);
        System.out.println();
    }

    public static void weekdaySet(List<Entry> entries) {
        System.out.println("Weekday Set For Loop:");
        Set<String> weekdays = new HashSet<>();
        Set<String> weekdays1 = new HashSet<>();
        for (Entry e : entries) {
            if (!e.getDay().equals(Day.SATURDAY) && !e.getDay().equals(Day.SUNDAY)) {
                weekdays.add(e.toString());
            }
        }
        System.out.println(weekdays);
        System.out.println("Stream, filter, map, collect:");
        weekdays1 = entries.stream().filter(e -> !e.getDay().equals(Day.SATURDAY) && !e.getDay().equals(Day.SUNDAY))
                .map(e -> e.toString())
                .collect(Collectors.toSet());
        System.out.println(weekdays1);
        System.out.println();
    }

    public static void printDurationGreaterThan10(List<Entry> entries){
        System.out.println("Duration Greater Than 10 For Loop:");
        for (Entry e : entries) {
            if (e.getDuration() > 10) {
                System.out.println(e);
            }
        }
        System.out.println("Stream, filter, forEach:");
        entries.stream().filter(e -> e.getDuration() > 10)
                .forEach(e -> System.out.println(e));
        System.out.println();
    }

    public static void findMaxDuration(List<Entry> entries){
        System.out.println("For Loop:");
        int temp = 0;
        for (Entry e : entries) {
            if (e.getDuration() > temp) {
                temp = e.getDuration();
            }
        }
        System.out.println("The Max Duration is: " + temp);
        System.out.println("Stream, mapToInt, max, getAsInt:");
        temp = entries.stream().mapToInt(e -> e.getDuration())
                .max().getAsInt();
        System.out.println("The Max Duration is: " + temp);
        System.out.println();
    }

    public static void listGreaterThan50(List<Entry> entries){
        System.out.println("List Greater Than 50 For Loop:");
        List<Entry> greaterThan50 = new ArrayList<>();
        for (Entry e : entries) {
            if (e.getDuration() > 50) {
                greaterThan50.add(e);
            }
        }
        System.out.println(greaterThan50);
        System.out.println("Stream, filter, collect:");
        entries.stream().filter(e -> e.getDuration() > 50)
                .collect(Collectors.toList());
        System.out.println(greaterThan50);
        System.out.println();
    }
}
