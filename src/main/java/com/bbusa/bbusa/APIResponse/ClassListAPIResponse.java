package com.bbusa.bbusa.APIResponse;

import com.bbusa.bbusa.Entity.ClassesEntity;
import com.bbusa.bbusa.Entity.InstructorEntity;

import java.io.Serializable;
import java.util.List;

public class ClassListAPIResponse implements Serializable {


    private List<InstructorEntity> instructorEntities;

    private ClassesEntity classesEntity;

    public List<InstructorEntity> getInstructorEntities() {
        return instructorEntities;
    }

    public void setInstructorEntities(List<InstructorEntity> instructorEntities) {
        this.instructorEntities = instructorEntities;
    }

    public ClassesEntity getClassesEntity() {
        return classesEntity;
    }

    public void setClassesEntity(ClassesEntity classesEntity) {
        this.classesEntity = classesEntity;
    }
}
