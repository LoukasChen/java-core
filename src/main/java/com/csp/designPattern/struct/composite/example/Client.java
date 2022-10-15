package com.csp.designPattern.struct.composite.example;

/**
 * @author csp
 * @date 2022/9/18
 */
public class Client {

    public static void main(String[] args) {
        Folder folder1 = new Folder("folder1");
        Folder folder2 = new Folder("folder2");

        ImageFile imageFile = new ImageFile("imageFile");
        TextFile textFile = new TextFile("textFile");
        folder1.add(imageFile);
        folder1.add(textFile);

        folder2.add(imageFile);
        folder2.add(textFile);

        folder1.killVirus();

        folder2.killVirus();
    }
}
