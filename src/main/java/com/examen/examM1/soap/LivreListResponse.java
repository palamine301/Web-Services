package com.examen.examM1.soap;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "LivreListResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class LivreListResponse {

    @XmlElement(name = "livre")
    private List<LivreSoapDTO> livres;

    public List<LivreSoapDTO> getLivres() {
        return livres;
    }

    public void setLivres(List<LivreSoapDTO> livres) {
        this.livres = livres;
    }
}
