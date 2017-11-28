/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.each.enquadra.service.bd.amazon.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author juan_
 */
@Embeddable
public class TecnicoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "user_rg")
    private int userRg;
    @Basic(optional = false)
    @NotNull
    @Column(name = "time_idtime")
    private int timeIdtime;

    public TecnicoPK() {
    }

    public TecnicoPK(int userRg, int timeIdtime) {
        this.userRg = userRg;
        this.timeIdtime = timeIdtime;
    }

    public int getUserRg() {
        return userRg;
    }

    public void setUserRg(int userRg) {
        this.userRg = userRg;
    }

    public int getTimeIdtime() {
        return timeIdtime;
    }

    public void setTimeIdtime(int timeIdtime) {
        this.timeIdtime = timeIdtime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) userRg;
        hash += (int) timeIdtime;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TecnicoPK)) {
            return false;
        }
        TecnicoPK other = (TecnicoPK) object;
        if (this.userRg != other.userRg) {
            return false;
        }
        if (this.timeIdtime != other.timeIdtime) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.each.enquadra.service.bd.amazon.entities.TecnicoPK[ userRg=" + userRg + ", timeIdtime=" + timeIdtime + " ]";
    }
    
}
