package com.quickblox.qmdev.tests;


public class Test {

    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));

        StringBuilder result = new StringBuilder();
        String windows = "Windows";
        String systemProp = System.getProperty("os.name");
        char [] windChars = windows.toCharArray();
        char [] sysPropChars = systemProp.toCharArray();
        for (char windChar : windChars) {
            for (char sysPropChar : sysPropChars) {
                if (windChar == sysPropChar) {
                    result.append(windChar);
                }
            }
        }
        if ("Windows".equals(result.toString())) {
            System.out.println("tada");
        }
    }
}
