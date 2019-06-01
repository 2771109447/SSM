package com.smart.domain;

public class Class {

    private int classId;
    private String className;
    private String classDept;



    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }


    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassDept() {
        return classDept;
    }

    public void setClassDept(String classDept) {
        this.classDept = classDept;
    }

    @Override
    public String toString() {
        return "Class{" +
                "classId=" + classId +
                ", className='" + className + '\'' +
                ", classDept='" + classDept + '\'' +
                '}';
    }
}
