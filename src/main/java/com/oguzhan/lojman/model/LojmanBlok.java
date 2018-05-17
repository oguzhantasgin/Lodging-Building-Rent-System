package com.oguzhan.lojman.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "LojmanBlok")
public class LojmanBlok implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "blok_id", nullable = false)
    private int id;

    @Column(name = "blok_adi", nullable = false)
    private String blokAdi;

    @Column(name = "daire_sayisi", nullable = false)
    private int daireSayisi;

    @OneToMany(targetEntity = LojmanDairesi.class, mappedBy = "blok",
            cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    private List<LojmanDairesi> daireler;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBlokAdi() {
        return blokAdi;
    }

    public void setBlokAdi(String blokAdi) {
        this.blokAdi = blokAdi;
    }

    public int getDaireSayisi() {
        return daireSayisi;
    }

    public void setDaireSayisi(int daireSayisi) {
        this.daireSayisi = daireSayisi;
    }

    public List<LojmanDairesi> getDaireler() {
        return daireler;
    }

    public void setDaireler(List<LojmanDairesi> daireler) {
        this.daireler = daireler;
    }
}
