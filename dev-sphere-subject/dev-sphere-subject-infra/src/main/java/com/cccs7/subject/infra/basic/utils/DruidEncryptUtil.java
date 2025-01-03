package com.cccs7.subject.infra.basic.utils;

import com.alibaba.druid.filter.config.ConfigTools;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

/**
 * Druid 加密工具
 *
 * @author cccs7 - csq020611@gmail.com
 * @date 2025/01/02
 */
public class DruidEncryptUtil {

    private static String publicKey;

    private static String privateKey;

    static {

        try {
            String[] pair = ConfigTools.genKeyPair(512);
            privateKey = pair[0];
            System.out.println("privateKey:" + privateKey);
            publicKey = pair[1];
            System.out.println("publicKey:" + publicKey);
        } catch (NoSuchAlgorithmException | NoSuchProviderException e) {
            throw new RuntimeException(e);
        }
    }

    public static String encrypt(String plainText) throws Exception {
        String encrypt = ConfigTools.encrypt(privateKey, plainText);
        System.out.println("encrypt:" + encrypt);
        return encrypt;
    }

    public static String decrypt(String encryptText) throws Exception {
        String decrypt = ConfigTools.decrypt(publicKey, encryptText);
        System.out.println("decrypt:" + decrypt);
        return decrypt;
    }

    public static void main(String[] args) throws Exception {
        String encrypt = encrypt("C020611.");
        System.out.println("encrypt:" + encrypt);
    }
}
