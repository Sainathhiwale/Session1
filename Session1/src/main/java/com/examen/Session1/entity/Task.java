package com.examen.Session1.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Task {
    private String title;
    private String desc;
    private String assigned;
    private String status;
}
