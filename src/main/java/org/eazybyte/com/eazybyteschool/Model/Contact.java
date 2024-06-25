package org.eazybyte.com.eazybyteschool.Model;

import lombok.Data;
import org.springframework.stereotype.Repository;


@Data
public class Contact {
    private String name;
    private String mobileNum;
    private String email;
    private String subject;
    private String message;
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public String getMobileNum() {
//        return mobileNum;
//    }
//
//    public void setMobileNum(String mobileNum) {
//        this.mobileNum = mobileNum;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getSubject() {
//        return subject;
//    }
//
//    public void setSubject(String subject) {
//        this.subject = subject;
//    }
//
//    @Override
//    public String toString() {
//        return "Contact{" +
//                "email='" + email + '\'' +
//                ", name='" + name + '\'' +
//                ", mobileNum='" + mobileNum + '\'' +
//                ", subject='" + subject + '\'' +
//                ", message='" + message + '\'' +
//                '}';
//    }
}
