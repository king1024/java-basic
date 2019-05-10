package com.king.spring1.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import org.springframework.util.StringUtils;

/**
 * @author duanyong
 * 2019年3月28日 下午5:32:49
 */
public class SequenceUtil {

	public static String createSequence(String type) {
		if (StringUtils.isEmpty(type)) {
			type="YONG";
		}
		return type+new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())+getRandom();
	}
	
    /**
     * 获取位数为7位的随机数
     * @return
     * */
    public static String getRandom() {
        Random random = new Random();
        int nextInt = random.nextInt(9000000)+1000000;
        return nextInt+"";
    }
}
