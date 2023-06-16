package com.furucrm.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.furucrm.jgrants.entiy.Institution;

import lombok.Data;

@Data
public class SubsidyDTO {
    private Long id;
    
    private String title;
    
    private String lastModifiedDate;

    private String subsidyMaxLimit;

    private String category;

    private String institutionName;

    public static String setDateFromat(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日　HH時mm分");
        return sdf.format(date);
    }

    public void setInstitutionName(Institution institution){
        this.institutionName = institution.getName();
    }
}
