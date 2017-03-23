package cn.lee.jason.io.type.compress.utils.zip;


import java.io.*;
import java.util.Enumeration;
import java.util.List;

import cn.lee.jason.io.common.utils.FileUtils;
import com.google.common.collect.Lists;
import org.apache.commons.compress.archivers.zip.Zip64Mode;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by jason on 17-3-13.
 * Zip文件工具类
 */
public class ZipFileUtils {


    private final static Logger logger = LoggerFactory.getLogger(ZipFileUtils.class);

    /**
     * 文件压缩为zip格式
     *
     * @param filePaths   带压缩文件的绝对路径
     * @param zipFilePath 压缩后文件路径
     */
    public static void compressFiles2Zip(String[] filePaths, String zipFilePath) {
        List<File> lists = Lists.newArrayList();
        for (String path : filePaths) {
            lists.add(new File(path));
        }
        compressFiles2Zip(lists.toArray(new File[lists.size()]), zipFilePath);
    }

    /**
     * 把文件压缩成zip格式
     *
     * @param files       需要压缩的文件
     * @param zipFilePath 压缩后的zip文件路径 ,如"D:/test/aa.zip";
     */
    public static void compressFiles2Zip(File[] files, String zipFilePath) {
        ZipArchiveOutputStream zaos = null;
        try {
            FileUtils.createFile(zipFilePath);
            if (isEndsWithZip(zipFilePath)) {
                File zipFile = new File(zipFilePath);
                zaos = new ZipArchiveOutputStream(zipFile);
                if (files != null && files.length > 0) {
                    // Use Zip64 extensions for all entries where they are
                    // required
                    zaos.setUseZip64(Zip64Mode.Always);

                    // 将每个文件用ZipArchiveEntry封装
                    // 再用ZipArchiveOutputStream写到压缩文件中
                    for (File file : files) {
                        if (file != null) {
                            ZipArchiveEntry zipArchiveEntry = new ZipArchiveEntry(file,
                                    file.getName());
                            zaos.putArchiveEntry(zipArchiveEntry);
                            InputStream is = null;
                            try {
                                is = new FileInputStream(file);
                                byte[] buffer = new byte[1024 * 5];
                                int len = -1;
                                while ((len = is.read(buffer)) != -1) {
                                    // 把缓冲区的字节写入到ZipArchiveEntry
                                    zaos.write(buffer, 0, len);
                                }
                                // Writes all necessary data for this entry.
                                zaos.closeArchiveEntry();
                            } catch (Exception e) {
                                e.printStackTrace();
                            } finally {
                                if (is != null)
                                    is.close();
                            }

                        }
                    }
                }
                zaos.finish();
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(zipFilePath + " 压缩不成功!");
        } finally {
            try {
                if (zaos != null) {
                    zaos.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            logger.info(zipFilePath + " 压缩成功!");
        }
    }

    /**
     * 把zip文件解压到指定的文件夹
     *
     * @param zipFilePath zip文件路径, 如 "D:/test/aa.zip"
     * @param saveFileDir 解压后的文件存放路径, 如"D:/test/"
     */
    public static List<File> decompressZip(String zipFilePath, String saveFileDir) {
        List<File> allFiles = Lists.newArrayList();
        if (isEndsWithZip(zipFilePath)) {
            File file = new File(zipFilePath);
            if (file.exists()) {
                BufferedInputStream bis = null;
                BufferedOutputStream bos = null;
                try {
                    ZipFile zipFile = new ZipFile(zipFilePath);
                    Enumeration<?> entries = zipFile.getEntries();// 拿到zip包里的所有元素
                    while (entries.hasMoreElements()) {
                        ZipEntry entry = (ZipEntry) entries.nextElement();
                        String entryFileName = entry.getName();
                        // 构造解压出来的文件存放路径
                        String entryFilePath = saveFileDir + entryFileName;
                        if (entry.isDirectory()) {
                            //目录不需要直接从zip中输出，直接在输出具体文件时创建父级目录即可
                        } else {
                            File destFile = FileUtils.createFile(entryFilePath);
                            allFiles.add(destFile);
                            bis = new BufferedInputStream(
                                    zipFile.getInputStream(entry));
                            byte[] bytes = new byte[bis.available()];
                            bos = new BufferedOutputStream(
                                    new FileOutputStream(destFile));
                            while ((bis.read(bytes) != -1)) {
                                bos.write(bytes);
                            }
                            bos.flush();
                            bis.close();
                            bos.close();
                        }
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                } finally {
                    try {
                        if (bos != null) {
                            bos.close();
                        }
                        if (bis != null) {
                            bis.close();
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        return allFiles;
    }

    /**
     * 判断文件名是否以.zip为后缀
     *
     * @param fileName 需要判断的文件名
     * @return 是zip文件返回true, 否则返回false
     */
    public static boolean isEndsWithZip(String fileName) {
        boolean flag = false;
        if (fileName != null && !"".equals(fileName.trim())) {
            if (fileName.endsWith(".ZIP") || fileName.endsWith(".zip")) {
                flag = true;
            }
        }
        return flag;
    }
}

