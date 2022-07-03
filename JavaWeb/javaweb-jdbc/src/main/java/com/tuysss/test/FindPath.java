package com.tuysss.test;

import java.io.File;

public class FindPath {
    public static void main(String[] args) {
        File file =new File("src/main/db.properties");
        System.out.println(file.getAbsolutePath());
    }
}
