package cn.zhangdx.improve.seqcollection;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.SequencedMap;
import java.util.SequencedSet;
import java.util.UUID;

/**
 *
 * @author zhangdx
 * @date 2026/7/28 20:34
 */
public class SeqCollectionDemo {

    public static void main(String[] args) {
        testSeqList();
        testSeqSet();
        testSeqMap();
    }

    private static void testSeqList() {
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i <20; i++) {
            arrayList.add(i + 1);
        }
        System.out.println("arrayList first value: " + arrayList.getFirst());
        System.out.println("arrayList last value: " + arrayList.getLast());
        List<Integer> reversedList = arrayList.reversed();
        System.out.println("reversedList value: " + reversedList);
        arrayList.addFirst(68);
        arrayList.addFirst(86);
        System.out.println("arrayList value: " + arrayList);
    }

    private static void testSeqSet() {
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        for (int i = 0; i <20; i++) {
            linkedHashSet.add(i + 1);
        }
        System.out.println("linkedHashSet first value: " + linkedHashSet.getFirst());
        System.out.println("linkedHashSet last value: " + linkedHashSet.getLast());
        SequencedSet<Integer> reversedSet = linkedHashSet.reversed();
        System.out.println("reversedList value: " + reversedSet);
        linkedHashSet.addFirst(68);
        linkedHashSet.addLast(86);
        System.out.println("linkedHashSet value: " + linkedHashSet);
    }

    private static void testSeqMap() {
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
        for (int i = 0; i <20; i++) {
            linkedHashMap.put(i, UUID.randomUUID().toString());
        }
        System.out.println("linkedHashMap first value: " + linkedHashMap.firstEntry());
        System.out.println("linkedHashMap last value: " + linkedHashMap.lastEntry());
        SequencedMap<Integer, String> reversedMap = linkedHashMap.reversed();
        System.out.println("reversedMap value: " + reversedMap);
        linkedHashMap.putFirst(68, "firstValue");
        linkedHashMap.putLast(86, "lastValue");
        System.out.println("linkedHashMap value: " + linkedHashMap);
    }
}
