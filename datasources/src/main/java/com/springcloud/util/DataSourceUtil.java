package com.springcloud.util;

/**
 * @author: HD
 * @create: 2023/5/12
 * @remark:
 */
public class DataSourceUtil {

    private static final ThreadLocal<String> contextHolder = new ThreadLocal();

    /**
     * 设置数据源名
     * @param dbType
     */
    public static void setDB(String dbType) {
        contextHolder.set(dbType);
    }

    /**
     * 获取数据源名
     * @return
     */
    public static String getDB() {
        return contextHolder.get();
    }

    /**
     * 清除数据源名
     */
    public static void clearDB() {
        contextHolder.remove();
    }
}