package com.oguzhan.lojman.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "LojmanDairesi")
public class LojmanDairesi implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "daire_id", nullable = false)
    private int id;

    @Column(name = "daire_no")
    private int daireNo;

    @Column(name = "giris_tarihi")
    @Temporal(TemporalType.DATE)
    private Date girisTarihi;

    @Column(name = "cikis_tarihi")
    @Temporal(TemporalType.DATE)
    private Date cikisTarihi;

    @Column(name = "oda_sayisi")
    private int odaSayisi;

    @ManyToOne
    @JoinColumn(name = "blok_id", referencedColumnName = "blok_id")
    private LojmanBlok blok;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDaireNo() {
        return daireNo;
    }

    public void setDaireNo(int daireNo) {
        this.daireNo = daireNo;
    }

    public Date getGirisTarihi() {
        return girisTarihi;
    }

    public void setGirisTarihi(Date girisTarihi) {
        this.girisTarihi = girisTarihi;
    }

    public Date getCikisTarihi() {
        return cikisTarihi;
    }

    public void setCikisTarihi(Date cikisTarihi) {
        this.cikisTarihi = cikisTarihi;
    }

    public int getOdaSayisi() {
        return odaSayisi;
    }

    public void setOdaSayisi(int odaSayisi) {
        this.odaSayisi = odaSayisi;
    }

    public LojmanBlok getBlok() {
        return blok;
    }

    public void setBlok(LojmanBlok blok) {
        this.blok = blok;
    }
}
