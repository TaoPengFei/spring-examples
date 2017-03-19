package cn.lee.jason.io.compress.zip;

import java.io.IOException;

import cn.lee.jason.io.type.compress.zip.ZipFileUtils;
import org.junit.Test;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * Created by jason on 17-3-18.
 */
public class TestZipFileUtils {

    @Test
    public void test() throws IOException {
        Resource resource = new ClassPathResource("/dicom/test.zip");
        ZipFileUtils.decompressZip(resource.getFile().getPath(),resource.getFile().getParent()+"/"+resource.getFilename());
    }
}
