package com.gopher.system.util;


import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;

/**
 * BASE 64工具
 */
@SuppressWarnings("restriction")
public class Base64Utils {
    /**
     * <p>将文件转成base64 字符串</p>
     *
     * @param path 文件路径
     * @return
     * @throws Exception
     */
    public static String encodeBase64File(String path) throws Exception {
        File file = new File(path);
        FileInputStream inputFile = new FileInputStream(file);
        byte[] buffer = new byte[(int) file.length()];
        inputFile.read(buffer);
        inputFile.close();
        return new BASE64Encoder().encode(buffer);
    }

    /**
     * <p>将base64字符解码保存文件</p>
     *
     * @param base64Code
     * @param targetPath
     * @throws Exception
     */
    public static void decoderBase64File(String base64Code, String targetPath) {
        byte[] buffer;
        FileOutputStream out = null;
        try {
            buffer = new BASE64Decoder().decodeBuffer(base64Code);
            out = new FileOutputStream(targetPath);
            out.write(buffer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * <p>将base64字符保存文本文件</p>
     *
     * @param base64Code
     * @param targetPath
     * @throws Exception
     */
    public static void toFile(String base64Code, String targetPath) {
        byte[] buffer;
        FileOutputStream outputStream = null;
        try {
            buffer = base64Code.getBytes();
            outputStream = new FileOutputStream(targetPath);
            outputStream.write(buffer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            String base64Code = encodeBase64File("/Users/Crazy/Pictures/zyb2.jpg");
            System.out.println(base64Code);
            decoderBase64File(base64Code, "/Users/Crazy/Desktop/zyb.png");
            toFile(base64Code, "/Users/Crazy/Desktop/zyb.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
