package cn.lee.jason.io.compress.zip;

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

    /**
     * @param destFilePath
     * @return
     * @throws IOException
     */
    public static String readFileToString(String destFilePath) throws IOException {
        FileReader reader = new FileReader(new File(destFilePath));
        return FileCopyUtils.copyToString(reader);
    }

    /**
     * 文件的导出
     * isDown = true 用于下载   response原文件
     * isDown = false 用于查看  response水印文件
     *
     * @param up
     * @param response
     */
    public static void exportFile(FileUpload up, HttpServletResponse response, boolean isDown) {

        response.reset();
        OutputStream os = null;
        try {
            os = response.getOutputStream();
            //判断传入up对象为MultipleMediaFile的实例则,强转为MultipleMediaMarkFile类型,并获取水印图名称,生成水印图字节码

            String fileName = up.getDownloadFilenName();
            byte[] bytes = fileName.getBytes();
            fileName = new String(bytes, "ISO-8859-1");
            response.setHeader("content-disposition", "attachment;filename=" + fileName);
            if(StringUtils.isNotBlank(up.getDownloadFilePath()) && new File(up.getDownloadFilePath()).exists()){
                os.write(org.apache.commons.io.FileUtils.readFileToByteArray(new File(up.getDownloadFilePath())));
            }
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 文件的导出
     *
     * @param response
     */
    public static void exportFile(String filePath, String attachFileName,
                                  HttpServletResponse response) {
        response.reset();
        OutputStream os = null;
        try {
            os = response.getOutputStream();
            response.setHeader("content-disposition", "attachment;filename="
                    + new String(attachFileName.getBytes("utf-8"), "iso8859-1"));
            os.write(org.apache.commons.io.FileUtils.readFileToByteArray(new File(filePath)));
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
