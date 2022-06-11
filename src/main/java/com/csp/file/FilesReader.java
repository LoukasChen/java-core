package com.csp.file;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.nio.file.StandardOpenOption.*;

/**
 * @author: csp52872
 * @date: 2022/5/5
 */
public class FilesReader {

    private static final String SRC_PATH = "/Users/csp/java-study/java-core/src/main/resources/file/hello.txt";

    private static final String DEST_PATH = "/Users/csp/java-study/java-core/src/main/resources/file/dest.txt";

    public static void main(String[] args) throws Exception {
        Path srcPath = Paths.get(SRC_PATH);
        Path destPath = Paths.get(DEST_PATH);

        // 读取文件所有内容
//        List<String> lines = Files.readAllLines(path);
//        System.out.println(lines);

        // 流式读取，分批，记得关闭文件资源
//        try (Stream<String> stream = Files.lines(path)) {
//            System.out.println(stream.collect(Collectors.toList()));
//        }

//        readAndCopyFileByByte();
//        readWriteFileByBuffer();
//        readWriteFileByBufferStream(srcPath, destPath);
        fileChannel(srcPath, destPath);
    }

    /**
     * 10w行数据
     * 一个字节一个字节的读写：45929 耗时
     */
    private static void readWriteFileByByte() throws Exception {
        long startTime = Instant.now().toEpochMilli();
        try (FileInputStream inputStream = new FileInputStream(SRC_PATH);
             FileOutputStream outputStream = new FileOutputStream(DEST_PATH)) {
            int i;
            while ((i = inputStream.read()) != -1) {
                outputStream.write(i);
            }
        }
        System.out.println(Instant.now().toEpochMilli() - startTime);
    }

    /**
     * 10w行数据
     * 100个字节缓冲区的读写：1462 耗时
     * 1000个字节缓冲区的读写：105 耗时
     */
    private static void readWriteFileByBuffer() throws Exception {
        long startTime = Instant.now().toEpochMilli();
        try (FileInputStream inputStream = new FileInputStream(SRC_PATH);
             FileOutputStream outputStream = new FileOutputStream(DEST_PATH)) {
            byte[] buffer = new byte[1000];
            int len;
            while ((len = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, len);
            }
        }
        System.out.println(Instant.now().toEpochMilli() - startTime);
    }

    /**
     * 10w行数据
     * bufferStream(默认8k缓冲区) 读取 : 566 耗时
     */
    private static void readWriteFileByBufferStream(Path srcPath, Path destPath) throws Exception {
        long startTime = Instant.now().toEpochMilli();
        try (BufferedInputStream inputStream = new BufferedInputStream(Files.newInputStream(srcPath));
             BufferedOutputStream outputStream = new BufferedOutputStream(Files.newOutputStream(destPath))) {
            int i;
            while ((i = inputStream.read()) != -1) {
                outputStream.write(i);
            }
        }
        System.out.println(Instant.now().toEpochMilli() - startTime);
    }

    /**
     * 10w行数据
     * FileChannel 读取 : 30 耗时
     */
    private static void fileChannel(Path srcPath, Path destPath) throws Exception {
        long startTime = Instant.now().toEpochMilli();
        FileChannel in = FileChannel.open(srcPath, READ);
        FileChannel out = FileChannel.open(destPath, CREATE, WRITE);
        in.transferTo(0, in.size(), out);
        System.out.println(Instant.now().toEpochMilli() - startTime);
    }

    private static void writeFile(Path path) throws IOException {
        long startTime = Instant.now().toEpochMilli();
        Files.write(path, IntStream.rangeClosed(1, 100000)
                        .mapToObj(i -> UUID.randomUUID().toString())
                        .collect(Collectors.toList())
                , UTF_8, CREATE, TRUNCATE_EXISTING);
        System.out.println(Instant.now().toEpochMilli() - startTime);
    }

}
