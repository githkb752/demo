package cn.nskjy.demo.excel;

import cn.nskjy.demo.vo.DataDemo;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import org.junit.Test;

public class Read {

    @Test
    public void test() {
        String path = "C:\\Users\\Administrator\\Desktop\\测试表.xls";
        EasyExcel.read(path, DataDemo.class, new AnalysisEventListener<DataDemo>() {

            public void invoke(DataDemo dataDemo, AnalysisContext analysisContext) {
                System.out.println(dataDemo);
            }

            public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                System.out.println("全部解析完被调用");
            }
        }).sheet().doRead();
    }
}
