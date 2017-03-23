package cn.lee.jason.io.common.utils.convert;

import java.io.File;

/**
 * Created by jason on 17-3-19.
 */
public abstract class AbstractFileConverter implements FileConverter {

    public boolean support(File file) {
        return false;
    }

    public void convert(File file, String destPath) {
        if (support(file)) {
            this.doConvert(file, destPath);
        }
    }


    protected abstract void doConvert(File file, String destPath);
}
