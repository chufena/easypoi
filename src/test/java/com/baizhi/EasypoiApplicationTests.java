package com.baizhi;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.params.ExcelExportEntity;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EasypoiApplicationTests {

    @Test
    public void contextLoads() throws IOException {
        Student student = new Student("1", "小东", new Date(), 19,"1");
        Student student2 = new Student("2", "小西", new Date(), 20,"2");
        List<Student> list = new ArrayList<>();
        list.add(student);
        list.add(student2);
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("160班学生", "学生"), Student.class, list);
        workbook.write(new FileOutputStream(new File("D:/easy.xls")));
    }

    @Test
    public void test1() throws Exception {
        ImportParams importParams = new ImportParams();
        importParams.setTitleRows(1);
        importParams.setHeadRows(1);
        List<Object> objects = ExcelImportUtil.importExcel(new FileInputStream(new File("D:/easy.xls")), Student.class, importParams);
        System.out.println(objects);
    }

}
