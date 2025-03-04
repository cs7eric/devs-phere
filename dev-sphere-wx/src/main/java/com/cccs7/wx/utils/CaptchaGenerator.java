package com.cccs7.wx.utils;

import java.security.SecureRandom;

/**
 * 验证码生成工具类
 *
 * @author cccs7 - csq020611@gmail.com
 * @date 2025/03/04
 */
public class CaptchaGenerator {
    // 排除易混淆字符：0/O, 1/I/l 等
    private static final String NUMBER_POOL = "23456789";
    private static final String LETTER_POOL = "ABCDEFGHJKLMNPQRSTUVWXYZabcdefghjkmnopqrstuvwxyz";
    private static final String ALL_CHAR_POOL = NUMBER_POOL + LETTER_POOL;
    
    private static final SecureRandom RANDOM = new SecureRandom();
    private static final int CODE_LENGTH = 6;

    // 私有构造方法防止实例化
    private CaptchaGenerator() {}

    /**
     * 生成随机验证码（至少包含1个数字和1个字母）
     */
    public static String generate() {
        char[] code = new char[CODE_LENGTH];
        
        // 保证至少包含1个数字和1个字母
        code[0] = randomChar(NUMBER_POOL);    // 第1位是数字
        code[1] = randomChar(LETTER_POOL);    // 第2位是字母
        
        // 剩余4位自由组合
        for (int i = 2; i < CODE_LENGTH; i++) {
            code[i] = randomChar(ALL_CHAR_POOL);
        }
        
        // 打乱前两位的顺序
        shuffleArray(code);
        return new String(code);
    }

    /**
     * 从字符池中随机选取一个字符
     */
    private static char randomChar(String charPool) {
        return charPool.charAt(RANDOM.nextInt(charPool.length()));
    }

    /**
     * Fisher-Yates 洗牌算法
     */
    private static void shuffleArray(char[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            int index = RANDOM.nextInt(i + 1);
            char temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }
}