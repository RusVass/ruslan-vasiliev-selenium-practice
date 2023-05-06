package org.brit.Brit.Lesson18_19_20_21;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class MyFileUtils {

    public static void main(String[] args) {
        File file = generateTestFile();
        System.out.println();
    }

    public static File generateTestFile() {
        File template = new File("files/text.txt");
        String baseName = FilenameUtils.getBaseName(template.getName());
        String extension = FilenameUtils.getExtension(template.getName());
        File fileTemp = new File("files/"
                + baseName
                + new Date().getTime()
                + "."
                + extension);
        try {
            FileUtils.copyFile(template, fileTemp);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //fileTemp.deleteOnExit();
        return fileTemp;
    }

}

