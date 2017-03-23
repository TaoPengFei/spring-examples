package cn.lee.jason.io.type.compress.zip.convert;

import java.io.File;
import java.util.List;

import cn.lee.jason.io.common.utils.convert.AbstractFileConverter;
import cn.lee.jason.io.type.compress.utils.zip.ZipFileUtils;

/**
 * Created by jason on 17-3-19.
 */
public class ZipFileConverter extends AbstractFileConverter {

    protected void doConvert(File file, String destPath) {
        List<File> files = ZipFileUtils.decompressZip(file.getPath(), destPath);
    }
}
