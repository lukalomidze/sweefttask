package com.github.lukalomidze.task;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.github.lukalomidze.util.ListNode;

public class SweeftTaskTest {
    private static SweeftTask sweeftTask;
    
    @BeforeAll
    public static void setUp() {
        sweeftTask = new SweeftTask();
    }

    @Test
    public void evaluateExpressionTest() {
        int evaluation = sweeftTask.evaluateExpression("5+20-8+5");

        assertEquals(22, evaluation);
    }

    @Test
    public void numberOfHappyStringsTest() {
        List<String> testList = new ArrayList<>();

        testList.add("abbcc");
        testList.add("abc");
        testList.add("abcabc");
        testList.add("cabcbb");

        int result = sweeftTask.numberOfHappyStrings(testList);

        assertEquals(2, result);
    }

    @Test
    public void reverseListTest() {
        ListNode<Integer> head = new ListNode<>(1);
        ListNode<Integer> current = head;

        for (int i = 2; i <=5; i++) {
            current.setNext(new ListNode<>(i));
            current = current.getNext();
        }

        current = head;

        List<Integer> originalLinkedList = new ArrayList<>();

        while (current != null) {
            originalLinkedList.add(current.getValue());
            current = current.getNext();
        }

        ListNode<Integer> reversedList = sweeftTask.reverseList(head);

        List<Integer> reversedLinkedList = new ArrayList<>();

        current = reversedList;

        while (current != null) {
            reversedLinkedList.add(current.getValue());
            current = current.getNext();
        }

        Collections.reverse(originalLinkedList);

        assertIterableEquals(originalLinkedList, reversedLinkedList);
    }

    @Test
    public void findIntersectionTest() {
        int[] nums1 = {1, 2, 3, 3, 4, 5};
        int[] nums2 = {3, 4, 4, 5, 6, 7};

        int[] intersection = sweeftTask.findIntersection(nums1, nums2);

        assertArrayEquals(new int[] {3, 4, 5}, intersection);
    }

    @Test
    public void lenOfLongSubarrTest() {
        int[] array = {6, 2, 2, 3, 4, 1};

        assertEquals(4, sweeftTask.lenOfLongSubarr(array, 8));
    }

    @Test
    public void isValidSequence() {
        int[] array = {5, 1, 22, 25, 6, -1, 8, 10};
        int[] sequence = {1, 6, -1, 10};

        assertEquals(true, sweeftTask.isValidSequence(array, sequence));
    }
}
