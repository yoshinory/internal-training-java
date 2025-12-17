package com.example.LEGAREA.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor   // 全フィールドを引数に持つコンストラクタ
@NoArgsConstructor    // 引数なしコンストラクタ
public class StaffDetailEntity {
    private String staffId;
    private String name;
    private String division;
    private String firstName;
    private String lastName;
    private String position;
    private int age;
}