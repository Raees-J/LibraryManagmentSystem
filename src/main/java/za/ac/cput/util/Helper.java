/*
Helper.java
Author: Raees Johaadien (230558135)
Date: 14 March 2025
*/
package za.ac.cput.util;
import javax.swing.*;

public class Helper {
    public static boolean isNullOrEmpty(String s) {
        if (s.isEmpty() || s == null)
            return true;
        return false;
    }
}
