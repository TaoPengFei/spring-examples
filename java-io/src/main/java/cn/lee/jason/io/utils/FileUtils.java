package cn.lee.jason.io.utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.http.HttpServletResponse;

import cn.infisa.io.file.upload.FileUpload;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.util.FileCopyUtils;

public class FileUtils {

    private final static Logger logger = LoggerFactory.getLogger(FileUtils.class);

    /**
     * 新建文件.
     *
     * @param path 文件路径
     * @throws Exception
     */
    public static File createFile(String path) throws Exception {
        if (StringUtils.isEmpty(path)) {
            return null;
        }
        try {
            // 获得文件对象
            File f = new File(path);
            if (f.exists()) {
                return f;
            }
            // 如果路径不存在,则创建
            if (!f.getParentFile().exists()) {
                f.getParentFile().mkdirs();
            }
            f.createNewFile();
            return f;
        } catch (Exception e) {
            logger.error("创建文件错误.path=" + path, e);
            throw e;
        }
    }

}
