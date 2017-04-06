/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.ac.seu.my.airlinereservationsys.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author shithilboss
 */
@Entity
@Table(name="bookingclass")
public class BookingClass {
    @Id
    private String classId;
    private String className;

    public BookingClass() {
    }

    public BookingClass(String classId, String className) {
        this.classId = classId;
        this.className = className;
    }

    public String getClassId() {
        return classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "Class{" + "classId=" + classId + ", className=" + className + '}';
    }
    
}
