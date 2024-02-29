package com.github.lukalomidze.task;

import java.util.Arrays;
import java.util.List;

import com.github.lukalomidze.util.ListNode;

public class SweeftTask implements SweeftTaskSchema {
    public int evaluateExpression(String expression) {
        String tokenizerRegex = "(?<=[+-])|(?=[+-])";

        String[] tokenizedExpression = expression.split(tokenizerRegex);

        int evaluation = Integer.parseInt(tokenizedExpression[0]);

        for (int i = 1; i < tokenizedExpression.length; i += 2) {
            if (tokenizedExpression[i].equals("+")) {
                evaluation += Integer.parseInt(tokenizedExpression[i + 1]);
            } else {
                evaluation -= Integer.parseInt(tokenizedExpression[i + 1]);
            }
        }

        return evaluation;
    }

    public int numberOfHappyStrings(List<String> strings) {
        int happyStrings = (int) strings.stream()
            .filter(string -> {
                char[] charArray = string.toCharArray();

                for (int i = 0; i < charArray.length - 1; i++) {
                    if (charArray[i] == charArray[i + 1]) {
                        return false;
                    }
                }

                return true;
            })
        .count();

        return happyStrings;
    }

    public <T> ListNode<T> reverseList(ListNode<T> head) {
        ListNode<T> currentNode = head;
        ListNode<T> previousNode = null;

        while (currentNode != null) {
            ListNode<T> nextNode = currentNode.getNext();

            currentNode.setNext(previousNode);
            previousNode = currentNode;
            currentNode = nextNode;
        }

        return previousNode;
    }

    public int[] findIntersection(int[] nums1, int[] nums2) {
        int[] intersection = Arrays.stream(nums1)
            .distinct()
            .filter(
                num -> Arrays.stream(nums2).anyMatch(num2 -> num2 == num)
            )
        .toArray();

        return intersection;
    }

    public int lenOfLongSubarr(int[] array, int k) {
        return lenOfLongSubarr(array, k, 0, 0);
    }

    private int lenOfLongSubarr(
        int[] array,
        int k,
        int count,
        int i
    ) {
        if (i >= array.length) return count;

        if (k == 0) return count;

        if (k < 0) return -1;

        return Math.max(
            lenOfLongSubarr(array, k - array[i], count + 1, i + 1),
            lenOfLongSubarr(array, k, count, i + 1)
        );
    }

    public boolean isValidSequence(int[] array, int[] sequence) {
        int j = 0;

        for (var i : array) {
            try {
                if (i == sequence[j]) j++;
            } catch (ArrayIndexOutOfBoundsException e) {
                return true;
            }
        }

        return j >= sequence.length;
    }
}
