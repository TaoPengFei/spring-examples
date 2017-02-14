package cn.lee.jason.core.di.output;

/**
 * Created by jason on 17/2/11.
 */
public class OutputHelper {

    IOutputGenerator outputGenerator;

    public void generateOutput() {
        outputGenerator.generateOutput();
    }

    public void setOutputGenerator(IOutputGenerator outputGenerator) {
        this.outputGenerator = outputGenerator;
    }

}
