package cn.lee.jason.io.common.utils.convert;

import java.io.File;

/**
 * Created by jason on 17-3-19.
 */
public interface FileConverter {
    /**
     * 是否支持
     *
     * @param file
     * @return
     */
    boolean support(File file);

    /**
     * 转换
     *
     * @param file
     * @param destPath 目标文件路径
     */
    void convert(File file, String destPath);
}
