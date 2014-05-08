/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.training.copdtest.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Nook
 */
@Entity
@Table(name = "Follow_up_test")
public class FollowUpTest implements Serializable {

    @Id
    @Column(name = "followup_id")
    private String id;
    @Column(length = 5)
    private String hcode;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date svdDate;
    private String hn;
    @Column(length = 1)
    private String bch_dilator;
    private Float bw;
    private Float height;
    private String day_symp;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fv10;
    @Column(length = 1)
    private String fv12 = "0";
    @Column(length = 1)
    private String fv12x = "0";
    @Column(length = 1)
    private BigInteger FV14_1AN1;
    private String FV14_1C;
    @Column(length = 1)
    private String FV15 = "0";
    @Column(length = 1)
    private String FV16 = "0";
    @Column(length = 1)
    private String FV17 = "0";
    private Integer FV18;
    @Column(length = 1)
    private String FV4 = "0";
    private String FV4x;
    @Column(length = 1)
    private String FV5 = "0";
    private String FV5x1;
    private String FV5x2;
    @Column(length = 1)
    private String FV6 = "0";
    private String FV6x;
    @Column(length = 1)
    private String FV7_0 = "0";
    private String FV7_0x;
    private Float FV7_1;
    private Float FV7_1x;
    private Float FV7_1xp;
    private Float FV7_2;
    private Float FV7_2x;
    private Float FV7_2xp;
    private Float FV7_3;
    private Float FV7_3x;
    private Float FV7_3xp;
    private Integer FV7_4;
    private Float FV7_5;
    private Float FV7_6;
    private Float FV7_6x;
    private Float FV7_6xp;
    private Float FV7_7;
    private Float FV7_7x;
    private Float FV7_7xp;
    private Integer FVC1;
    private Integer FVC2;
    private Integer FVC3;
    private Integer FVC4;
    private Integer FVC5;
    private Integer FVC6;
    private Integer FVC7;
    private Integer FVC8;
    @Column(length = 1)
    private String MRC = "x";
    private Float MWD;
    @Column(length = 1)
    private String NIGHT_SYMP = "0";
    private Float PEFR;
    private Float PEF_PREDICT;
    @Column(length = 1)
    private String SMKCES = "1";
    @Column(length = 1)
    private String SMKST = "0";

    @ManyToOne(targetEntity = Patient.class)
    @Column(length = 15)
    private String pid;

    @ManyToMany(targetEntity = Drug.class, fetch = FetchType.LAZY)
    @JoinTable(name = "followup_drug",
            joinColumns = @JoinColumn(name = "followup_ids"),
            inverseJoinColumns = @JoinColumn(name = "drug_ids"))
    private List<Drug> drugIDs;

    public FollowUpTest() {

    }
    
    public FollowUpTest(String pid) {
        this.pid = pid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getHcode() {
        return hcode;
    }

    public void setHcode(String hcode) {
        this.hcode = hcode;
    }

    public Date getSvdDate() {
        if (svdDate == null) {

        }
        return svdDate;
    }

    public void setSvdDate(Date svdDate) {
        this.svdDate = svdDate;
    }

    public String getHn() {
        return hn;
    }

    public void setHn(String hn) {
        this.hn = hn;
    }

    public String getBch_dilator() {
        return bch_dilator;
    }

    public void setBch_dilator(String bch_dilator) {
        this.bch_dilator = bch_dilator;
    }

    public Float getBw() {
        return bw;
    }

    public void setBw(Float bw) {
        this.bw = bw;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public String getDay_symp() {
        return day_symp;
    }

    public void setDay_symp(String day_symp) {
        this.day_symp = day_symp;
    }

    public Date getFv10() {
        return fv10;
    }

    public void setFv10(Date fv10) {
        this.fv10 = fv10;
    }

    public String getFv12() {
        return fv12;
    }

    public void setFv12(String fv12) {
        this.fv12 = fv12;
    }

    public String getFv12x() {
        return fv12x;
    }

    public void setFv12x(String fv12x) {
        this.fv12x = fv12x;
    }

    public BigInteger getFV14_1AN1() {
        return FV14_1AN1;
    }

    public void setFV14_1AN1(BigInteger FV14_1AN1) {
        this.FV14_1AN1 = FV14_1AN1;
    }

    public String getFV14_1C() {
        return FV14_1C;
    }

    public void setFV14_1C(String FV14_1C) {
        this.FV14_1C = FV14_1C;
    }

    public String getFV15() {
        return FV15;
    }

    public void setFV15(String FV15) {
        this.FV15 = FV15;
    }

    public String getFV16() {
        return FV16;
    }

    public void setFV16(String FV16) {
        this.FV16 = FV16;
    }

    public String getFV17() {
        return FV17;
    }

    public void setFV17(String FV17) {
        this.FV17 = FV17;
    }

    public Integer getFV18() {
        return FV18;
    }

    public void setFV18(Integer FV18) {
        this.FV18 = FV18;
    }

    public String getFV4() {
        return FV4;
    }

    public void setFV4(String FV4) {
        this.FV4 = FV4;
    }

    public String getFV4x() {
        return FV4x;
    }

    public void setFV4x(String FV4x) {
        this.FV4x = FV4x;
    }

    public String getFV5() {
        return FV5;
    }

    public void setFV5(String FV5) {
        this.FV5 = FV5;
    }

    public String getFV5x1() {
        return FV5x1;
    }

    public void setFV5x1(String FV5x1) {
        this.FV5x1 = FV5x1;
    }

    public String getFV5x2() {
        return FV5x2;
    }

    public void setFV5x2(String FV5x2) {
        this.FV5x2 = FV5x2;
    }

    public String getFV6() {
        return FV6;
    }

    public void setFV6(String FV6) {
        this.FV6 = FV6;
    }

    public String getFV6x() {
        return FV6x;
    }

    public void setFV6x(String FV6x) {
        this.FV6x = FV6x;
    }

    public String getFV7_0() {
        return FV7_0;
    }

    public void setFV7_0(String FV7_0) {
        this.FV7_0 = FV7_0;
    }

    public String getFV7_0x() {
        return FV7_0x;
    }

    public void setFV7_0x(String FV7_0x) {
        this.FV7_0x = FV7_0x;
    }

    public Float getFV7_1() {
        return FV7_1;
    }

    public void setFV7_1(Float FV7_1) {
        this.FV7_1 = FV7_1;
    }

    public Float getFV7_1x() {
        return FV7_1x;
    }

    public void setFV7_1x(Float FV7_1x) {
        this.FV7_1x = FV7_1x;
    }

    public Float getFV7_1xp() {
        return FV7_1xp;
    }

    public void setFV7_1xp(Float FV7_1xp) {
        this.FV7_1xp = FV7_1xp;
    }

    public Float getFV7_2() {
        return FV7_2;
    }

    public void setFV7_2(Float FV7_2) {
        this.FV7_2 = FV7_2;
    }

    public Float getFV7_2x() {
        return FV7_2x;
    }

    public void setFV7_2x(Float FV7_2x) {
        this.FV7_2x = FV7_2x;
    }

    public Float getFV7_2xp() {
        return FV7_2xp;
    }

    public void setFV7_2xp(Float FV7_2xp) {
        this.FV7_2xp = FV7_2xp;
    }

    public Float getFV7_3() {
        return FV7_3;
    }

    public void setFV7_3(Float FV7_3) {
        this.FV7_3 = FV7_3;
    }

    public Float getFV7_3x() {
        return FV7_3x;
    }

    public void setFV7_3x(Float FV7_3x) {
        this.FV7_3x = FV7_3x;
    }

    public Float getFV7_3xp() {
        return FV7_3xp;
    }

    public void setFV7_3xp(Float FV7_3xp) {
        this.FV7_3xp = FV7_3xp;
    }

    public Integer getFV7_4() {
        return FV7_4;
    }

    public void setFV7_4(Integer FV7_4) {
        this.FV7_4 = FV7_4;
    }

    public Float getFV7_5() {
        return FV7_5;
    }

    public void setFV7_5(Float FV7_5) {
        this.FV7_5 = FV7_5;
    }

    public Float getFV7_6() {
        return FV7_6;
    }

    public void setFV7_6(Float FV7_6) {
        this.FV7_6 = FV7_6;
    }

    public Float getFV7_6x() {
        return FV7_6x;
    }

    public void setFV7_6x(Float FV7_6x) {
        this.FV7_6x = FV7_6x;
    }

    public Float getFV7_6xp() {
        return FV7_6xp;
    }

    public void setFV7_6xp(Float FV7_6xp) {
        this.FV7_6xp = FV7_6xp;
    }

    public Float getFV7_7() {
        return FV7_7;
    }

    public void setFV7_7(Float FV7_7) {
        this.FV7_7 = FV7_7;
    }

    public Float getFV7_7x() {
        return FV7_7x;
    }

    public void setFV7_7x(Float FV7_7x) {
        this.FV7_7x = FV7_7x;
    }

    public Float getFV7_7xp() {
        return FV7_7xp;
    }

    public void setFV7_7xp(Float FV7_7xp) {
        this.FV7_7xp = FV7_7xp;
    }

    public Integer getFVC1() {
        return FVC1;
    }

    public void setFVC1(Integer FVC1) {
        this.FVC1 = FVC1;
    }

    public Integer getFVC2() {
        return FVC2;
    }

    public void setFVC2(Integer FVC2) {
        this.FVC2 = FVC2;
    }

    public Integer getFVC3() {
        return FVC3;
    }

    public void setFVC3(Integer FVC3) {
        this.FVC3 = FVC3;
    }

    public Integer getFVC4() {
        return FVC4;
    }

    public void setFVC4(Integer FVC4) {
        this.FVC4 = FVC4;
    }

    public Integer getFVC5() {
        return FVC5;
    }

    public void setFVC5(Integer FVC5) {
        this.FVC5 = FVC5;
    }

    public Integer getFVC6() {
        return FVC6;
    }

    public void setFVC6(Integer FVC6) {
        this.FVC6 = FVC6;
    }

    public Integer getFVC7() {
        return FVC7;
    }

    public void setFVC7(Integer FVC7) {
        this.FVC7 = FVC7;
    }

    public Integer getFVC8() {
        return FVC8;
    }

    public void setFVC8(Integer FVC8) {
        this.FVC8 = FVC8;
    }

    public String getMRC() {
        return MRC;
    }

    public void setMRC(String MRC) {
        this.MRC = MRC;
    }

    public Float getMWD() {
        return MWD;
    }

    public void setMWD(Float MWD) {
        this.MWD = MWD;
    }

    public String getNIGHT_SYMP() {
        return NIGHT_SYMP;
    }

    public void setNIGHT_SYMP(String NIGHT_SYMP) {
        this.NIGHT_SYMP = NIGHT_SYMP;
    }

    public Float getPEFR() {
        return PEFR;
    }

    public void setPEFR(Float PEFR) {
        this.PEFR = PEFR;
    }

    public Float getPEF_PREDICT() {
        return PEF_PREDICT;
    }

    public void setPEF_PREDICT(Float PEF_PREDICT) {
        this.PEF_PREDICT = PEF_PREDICT;
    }

    public String getSMKCES() {
        return SMKCES;
    }

    public void setSMKCES(String SMKCES) {
        this.SMKCES = SMKCES;
    }

    public String getSMKST() {
        return SMKST;
    }

    public List<Drug> getDrugIDs() {
        return drugIDs;
    }

    public void setDrugIDs(List<Drug> drugIDs) {
        this.drugIDs = drugIDs;
    }

    public void setSMKST(String SMKST) {
        this.SMKST = SMKST;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FollowUpTest other = (FollowUpTest) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
