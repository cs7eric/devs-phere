package com.cccs7.core.utils;

public class SystemUtils {

    /**
     * 判断操作系统是否是 Windows
     *
     * @return true：操作系统是 Windows
     * false：其它操作系统
     */
    public static boolean isWindows() {
        String osName = getOsName();

        return osName != null && osName.startsWith("Windows");
    }

    /**
     * 判断操作系统是否是 MacOS
     *
     * @return true：操作系统是 MacOS
     * false：其它操作系统
     */
    public static boolean isMacOs() {
        String osName = getOsName();

        return osName != null && osName.startsWith("Mac");
    }

    /**
     * 判断操作系统是否是 Linux
     *
     * @return true：操作系统是 Linux
     * false：其它操作系统
     */
    public static boolean isLinux() {
        String osName = getOsName();

        return (osName != null && osName.startsWith("Linux")) || (!isWindows() && !isMacOs());
    }

    /**
     * 获取操作系统名称
     *
     * @return os.name 属性值
     */
    public static String getOsName() {
        return System.getProperty("os.name");
    }
}