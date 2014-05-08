/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.training.copdtest.model;

import th.co.geniustree.training.copdtest.enumpack.Type;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Nook
 */
@Entity
//@Table(name = "drug")
public class Drug implements Serializable {

    @Id
    @Column(name = "DRUG_ID")
    private String drugId;
    private String hcode;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date svdDate;
    @Enumerated(EnumType.STRING)
    private Type type;
    @Column(name = "drug_name")
    private String drugName;
    @ManyToMany(targetEntity = FollowUpTest.class,mappedBy = "drugIDs")
    private List<FollowUpTest> followUpIds;

    public Drug() {

    }

    public Drug(String drugId) {
        this.drugId = drugId;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getDrugId() {
        return drugId;
    }

    public void setDrugId(String drugId) {
        this.drugId = drugId;
    }

    public String getHcode() {
        return hcode;
    }

    public void setHcode(String hcode) {
        this.hcode = hcode;
    }

    public Date getSvdDate() {
        return svdDate;
    }

    public void setSvdDate(Date svdDate) {
        this.svdDate = svdDate;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public List<FollowUpTest> getFollowUpIds() {
        return followUpIds;
    }

    public void setFollowUpIds(List<FollowUpTest> followUpIds) {
        this.followUpIds = followUpIds;
    }
    


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.drugId);
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
        final Drug other = (Drug) obj;
        if (!Objects.equals(this.drugId, other.drugId)) {
            return false;
        }
        return true;
    }

}
