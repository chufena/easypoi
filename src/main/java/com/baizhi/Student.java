package com.baizhi;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Student {
    @Excel(name="id")
    private String id;
    @Excel(name="名字")
    private String name;
    @Excel(name="生日",orderNum = "3",format = "yyyy-MM-dd",width = 30)
    private Date bir;
    @Excel(name = "年龄")
    private Integer age;
    @Excel(name="性别",replace = {"男_1","女_2"},suffix = "生")
    private String sex;

}
