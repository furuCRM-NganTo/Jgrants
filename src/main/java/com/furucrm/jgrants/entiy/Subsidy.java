package com.furucrm.jgrants.entiy;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "jg2_subsidy")
public class Subsidy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "acceptanceenddatetime")
    private Date acceptanceEndDatetime;

    @Column(name = "acceptancestartdatetime")
    private Date acceptanceStartDatetime;

    @Column(name = "canconsult", nullable = false)
    private boolean canConsult;

    @Column(name = "createdbyid", length = 18)
    private String createdById;

    @Column(name = "createddate", nullable = false)
    private Date createdDate;

    @Column(name = "detail", length = 131072)
    private String detail;

    @Column(name = "frontsubsidydetailpageurl", length = 1300)
    private String frontSubsidyDetailPageUrl;

    @Column(name = "industry", length = 4099)
    private String industry;

    @ManyToOne
    @JoinColumn(name = "institution")
    private Institution institution;

    @Column(name = "isenablemultiplerequest", nullable = false)
    private boolean isEnableMultipleRequest;

    @Column(name = "istest", nullable = false)
    private boolean isTest;

    @Column(name = "lastmodifiedbyid", length = 18)
    private String lastModifiedById;

    @Column(name = "lastmodifieddate", nullable = false)
    private Date lastModifiedDate;

    @Column(name = "opendataagreement")
    @Enumerated(EnumType.STRING)
    private OpenData openDataAgreement;

    public enum OpenData{
        同意しない("Disagree"),
        同意する("Agree");

        private String label;

        OpenData(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }

        public static OpenData toEnum(String openDataAgreement){
            for(OpenData item : OpenData.values()){
                if(item.getLabel().equals(openDataAgreement)) return item;
            }
            return null;
        }
    }

    @Column(name = "previewsubsidydetailpageurl", length = 1300)
    private String previewSubsidyDetailPageUrl;

    @Column(name = "projectenddeadline")
    private Date projectEndDeadline;

    @Column(name = "requestreceptionpresence", length = 255)
    private String requestReceptionPresence;

    @Column(name = "subsidycatchphrase", length = 255)
    private String subsidyCatchPhrase;

    @Column(name = "subsidymaxlimit")
    private Long subsidyMaxLimit;

    @Column(name = "subsidypublicsetting", length = 255)
    private String subsidyPublicSetting;

    @Column(name = "subsidyrate", length = 255)
    private String subsidyRate;

    @Column(name = "targetarea", length = 255)
    private String targetArea;

    @Column(name = "targetareasearch", length = 4099)
    private String targetAreaSearch;

    @Column(name = "targetnumberofemployees", length = 255)
    private String targetNumberOfEmployees;

    @Column(name = "title", length = 100)
    private String title;

    @Column(name = "usepurpose", length = 4099)
    private String usePurpose;

    @Column(name = "name", length = 80)
    private String name;

    @Column(name = "sfid", length = 18)
    private String sfid;

    @Column(length = 50)
    private String category;

}
