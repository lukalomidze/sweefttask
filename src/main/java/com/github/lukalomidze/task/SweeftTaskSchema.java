package com.github.lukalomidze.task;

import java.util.List;

import com.github.lukalomidze.util.ListNode;

public interface SweeftTaskSchema {
    public int evaluateExpression(String expression);

    public int numberOfHappyStrings(List<String> strings);

    public <T> ListNode<T> reverseList(ListNode<T> head);

    public int[] findIntersection(int[] nums1, int[] nums2);

    public int lenOfLongSubarr(int[] array, int k);

    public boolean isValidSequence(int[] array, int[] sequence);
}
