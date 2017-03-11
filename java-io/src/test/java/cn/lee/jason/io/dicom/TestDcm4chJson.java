package cn.lee.jason.io.dicom;

import java.io.File;
import java.io.IOException;
import javax.xml.transform.TransformerConfigurationException;

import org.dcm4che3.tool.dcm2json.Dcm2Json;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * Created by jason on 17-3-11.
 */
public class TestDcm4chJson {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void testImage() {
        Resource resource = new ClassPathResource("/dicom/rightDicom");
        doConvert(resource);
    }

    @Test
    public void testWrong() {
        Resource resource = new ClassPathResource("/dicom/wrongDicom");
        doConvert(resource);
    }

    private void doConvert(Resource resource) {
        try {
            String path = resource.getFile().getPath() + ".json";
            logger.info(path);
            Dcm2Json dcm2Json = new Dcm2Json();
            dcm2Json.convert(resource.getFile(), new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }
    }
}
