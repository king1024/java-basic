package com.king.spring1.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

import lombok.extern.slf4j.Slf4j;

/**
 * @author duanyong
 * 2019年4月11日 上午11:06:10
 */
@WebListener
@Slf4j
public class TestListener implements ServletRequestListener{
 
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("++++++++++++++++++++++++++监听器：销毁");
    }
 
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
    	System.out.println("++++++++++++++++++++++++++监听器：初始化");
    }
}
