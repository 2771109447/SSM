package com.smart.service;
import com.smart.dao.ClassDao;
import com.smart.domain.Class;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("classService")
public class ClassService {
    @Autowired
    private ClassDao classDao;

    //查询所有班级信息
    public List<Class> getAllClass(){
        return  classDao.getAllClass();
    }
    //通过id查询班级信息
    public Class seletClassById(Integer id){
        return classDao.getClassById(id);
    }
    //将List<Class>添加到Map中
    public Map listToMap(){
        List<Class> classList=classDao.getAllClass();
        Map<Integer,Class> classMap=new HashMap<>();
        for(int i=0;i<classList.size();i++){
            classMap.put(i,classList.get(i));
        }
        return  classMap;
    }
}
