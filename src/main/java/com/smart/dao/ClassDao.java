package com.smart.dao;

import com.smart.domain.Class;

import java.util.List;

public interface ClassDao {
    Class getClassById(Integer id);
    List<Class> getAllClass();
}
