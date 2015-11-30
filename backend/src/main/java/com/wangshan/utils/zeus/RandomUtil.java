package com.wangshan.utils.zeus;

/**
 * Created by shan on 2015/11/30.
 */

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * 随机数处理
 */
public class RandomUtil {

    static int r3(int n) {
        final int offset = 1150207666;  // offset为固定值，避免被猜到种子来源（和密码学中的加salt有点类似）
        long seed = System.currentTimeMillis() + offset;
        SecureRandom secureRandom;
        try {
            secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(seed);
            return secureRandom.nextInt();
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 0;
    }

    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[20];
        random.nextBytes(bytes);
         RandomUtil ru = new RandomUtil();
        System.out.print(ru.r3(90));
    }
}
