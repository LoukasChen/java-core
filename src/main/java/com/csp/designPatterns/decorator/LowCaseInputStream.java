package com.csp.designPatterns.decorator;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @desc:
 * @author: csp52872
 * @date: 2022/7/17
 */
public class LowCaseInputStream extends FilterInputStream {
    /**
     * Creates a <code>FilterInputStream</code>
     * by assigning the  argument <code>in</code>
     * to the field <code>this.in</code> so as
     * to remember it for later use.
     *
     * @param in the underlying input stream, or <code>null</code> if
     *           this instance is to be created without an underlying stream.
     */
    protected LowCaseInputStream(InputStream in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        int read = super.read();
        return read == -1 ? read : Character.toLowerCase(read);
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int read = super.read(b, off, len);
        for (int i = off; i < off + read; i++) {
            b[i] = (byte) Character.toLowerCase(b[i]);
        }
        return read;
    }

    public static void main(String[] args) throws IOException {
        int res;
        try (InputStream inputStream = new LowCaseInputStream(
                new BufferedInputStream(
                        Files.newInputStream(Paths.get("test.txt"))))) {
            while ((res = inputStream.read()) != -1) {
                System.out.println((char) res);
            }
        }
    }
}
