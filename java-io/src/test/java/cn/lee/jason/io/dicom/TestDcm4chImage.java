package cn.lee.jason.io.dicom;

import org.dcm4che3.tool.dcm2jpg.Dcm2Jpg;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;

/**
 * Created by jason on 17/3/10.
 */
public class TestDcm4chImage {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void testImage() {
        Resource resource = new ClassPathResource("/dicom/rightDicom");
        try {
            String path = resource.getFile().getPath() + ".jpg";
            System.out.println(path);
            new Dcm2Jpg().convert(resource.getFile(), new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
