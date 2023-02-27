package Coursework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Question5A {
    public static int[][] getBorderLine(int[][] height) {
        List<Integer> xCoords = new ArrayList<>();
        for (int[] h : height) {
            System.out.println("h"+ Arrays.toString(h));
            xCoords.add(h[0]);
            xCoords.add(h[1]);
        }
        Collections.sort(xCoords);
        System.out.println(xCoords);

        int[][] keyPoints = new int[xCoords.size()][2];
        int prevHeight = 0;
        int index = 0;
        for (int x : xCoords) {
            System.out.println("x"+x);
            int maxHeight = 0;
            for (int[] h : height) {
                System.out.println(Arrays.toString(h));
                if (x >= h[0] && x < h[1]) {
                    maxHeight = Math.max(maxHeight, h[2]);
                    System.out.println("maxHeight"+maxHeight);
                }
            }
            if (maxHeight != prevHeight) {
                keyPoints[index][0] = x;
                keyPoints[index][1] = maxHeight;
                prevHeight = maxHeight;
                index++;
                for (int i = 0; i < index; i++) {
                    System.out.println(Arrays.toString(keyPoints[i])+"Key");
                }
            }
        }
        System.out.println("index"+index);

        // trim keyPoints array to remove unused elements
        int[][] result = new int[index][2];
        for (int i = 0; i < index; i++) {
            result[i] = keyPoints[i];
//            System.out.println(Arrays.toString(keyPoints[i])+"Key");
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] height = {{1,4,10},{2,5,15},{5,8,12},{9,11,1},{11,13,15}};
        int[][] borderLine = getBorderLine(height);
        System.out.println(height.length);
        for (int[] point : borderLine) {
            System.out.println(point[0] + "," + point[1]);
        }
    }
}
//    This code defines a method called getBorderLine which takes a two-dimensional array of integers called height as input and returns a two-dimensional array of integers. The height array contains information about rectangular buildings, where each row represents a building and contains three integers: the starting position of the building on the x-axis, the ending position of the building on the x-axis, and the height of the building.
//
//        The goal of the getBorderLine method is to find the outline of the buildings by determining the highest point at each x-coordinate where a building starts or ends. The method returns an array of points that represent the outline, where each point is represented by an x-coordinate and a y-coordinate.
//
//        The method first creates an empty ArrayList called xCoords. Then, for each building in the height array, it adds the starting and ending x-coordinates to the xCoords list. This list is then sorted using the Collections.sort() method.
//
//        The method then creates a new two-dimensional array called keyPoints, with the same number of rows as xCoords and two columns. Each row of this array will represent a point on the outline of the buildings.
//
//        Next, the method loops through the sorted xCoords list and for each x-coordinate, it checks the height of each building that contains that coordinate. The maximum height of all buildings that contain the current x-coordinate is stored in the maxHeight variable.
//
//        If the maxHeight at the current x-coordinate is different from the prevHeight, then a new point is added to the keyPoints array. This point has an x-coordinate equal to the current x-coordinate and a y-coordinate equal to the maxHeight.
//
//        Finally, the method creates a new two-dimensional array called result with the same number of rows as the number of points in keyPoints that were actually used. It then copies the used points from keyPoints into result and returns it.
//
//        In the main method, the getBorderLine method is called with an example height array. The resulting borderLine array is then printed out to the console, with each point represented as an x-coordinate and a y-coordinate separated by a comma.