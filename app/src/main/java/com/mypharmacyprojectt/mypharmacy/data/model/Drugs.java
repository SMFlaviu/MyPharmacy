package com.mypharmacyprojectt.mypharmacy.data.model;

import com.google.gson.annotations.SerializedName;

public class Drugs {
    @SerializedName("data-dencom")
    String denCom;

    @SerializedName("data-dci")
    String dci;

    @SerializedName("data-formafarm")
    String formaFarm;

    @SerializedName("data-conc")
    String concentratie;

    @SerializedName("data-codatc")
    String codAtc;

    @SerializedName("data-actter")
    String actiuneTerapeutica;

    @SerializedName("data-prescript")
    String prescriptie;

    @SerializedName("data-ambalaj")
    String descriereAmbalaj;

    @SerializedName("data-volumamb")
    String volumAmbalaj;

    @SerializedName("data-valabamb")
    String valabilitateAmbalaj;

    @SerializedName("data-cim")
    String codCim;

    @SerializedName("data-firmtarp")
    String firmaProducatoare;

    @SerializedName("data-firmtard")
    String firmaDistribuitoare;

    @SerializedName("data-nrdtamb")
    String nrDtAmbalaj;

    @SerializedName("data-linkrcp")
    String rezumatCaractProdus;

    @SerializedName("data-linkpro")
    String prospect;

    @SerializedName("data-linkamb")
    String ambalaj;

    @SerializedName("data-linkrcp-fname")
    String fnameRezumatCaractProdus;

    @SerializedName("data-linkpro-fname")
    String fnameProspect;

    @SerializedName("data-linkamb-fname")
    String fnameAmbalaj;

    @SerializedName("md-uuid")
    String medId;

    public String getDenCom() {
        return denCom;
    }

    public void setDenCom(String denCom) {
        this.denCom = denCom;
    }

    public String getDci() {
        return dci;
    }

    public void setDci(String dci) {
        this.dci = dci;
    }

    public String getFormaFarm() {
        return formaFarm;
    }

    public void setFormaFarm(String formaFarm) {
        this.formaFarm = formaFarm;
    }

    public String getConcentratie() {
        return concentratie;
    }

    public void setConcentratie(String concentratie) {
        this.concentratie = concentratie;
    }

    public String getCodAtc() {
        return codAtc;
    }

    public void setCodAtc(String codAtc) {
        this.codAtc = codAtc;
    }

    public String getActiuneTerapeutica() {
        return actiuneTerapeutica;
    }

    public void setActiuneTerapeutica(String actiuneTerapeutica) {
        this.actiuneTerapeutica = actiuneTerapeutica;
    }

    public String getPrescriptie() {
        return prescriptie;
    }

    public void setPrescriptie(String prescriptie) {
        this.prescriptie = prescriptie;
    }

    public String getDescriereAmbalaj() {
        return descriereAmbalaj;
    }

    public void setDescriereAmbalaj(String descriereAmbalaj) {
        this.descriereAmbalaj = descriereAmbalaj;
    }

    public String getVolumAmbalaj() {
        return volumAmbalaj;
    }

    public void setVolumAmbalaj(String volumAmbalaj) {
        this.volumAmbalaj = volumAmbalaj;
    }

    public String getValabilitateAmbalaj() {
        return valabilitateAmbalaj;
    }

    public void setValabilitateAmbalaj(String valabilitateAmbalaj) {
        this.valabilitateAmbalaj = valabilitateAmbalaj;
    }

    public String getCodCim() {
        return codCim;
    }

    public void setCodCim(String codCim) {
        this.codCim = codCim;
    }

    public String getFirmaProducatoare() {
        return firmaProducatoare;
    }

    public void setFirmaProducatoare(String firmaProducatoare) {
        this.firmaProducatoare = firmaProducatoare;
    }

    public String getFirmaDistribuitoare() {
        return firmaDistribuitoare;
    }

    public void setFirmaDistribuitoare(String firmaDistribuitoare) {
        this.firmaDistribuitoare = firmaDistribuitoare;
    }

    public String getNrDtAmbalaj() {
        return nrDtAmbalaj;
    }

    public void setNrDtAmbalaj(String nrDtAmbalaj) {
        this.nrDtAmbalaj = nrDtAmbalaj;
    }

    public String getRezumatCaractProdus() {
        return rezumatCaractProdus;
    }

    public void setRezumatCaractProdus(String rezumatCaractProdus) {
        this.rezumatCaractProdus = rezumatCaractProdus;
    }

    public String getProspect() {
        return prospect;
    }

    public void setProspect(String prospect) {
        this.prospect = prospect;
    }

    public String getAmbalaj() {
        return ambalaj;
    }

    public void setAmbalaj(String ambalaj) {
        this.ambalaj = ambalaj;
    }

    public String getFnameRezumatCaractProdus() {
        return fnameRezumatCaractProdus;
    }

    public void setFnameRezumatCaractProdus(String fnameRezumatCaractProdus) {
        this.fnameRezumatCaractProdus = fnameRezumatCaractProdus;
    }

    public String getFnameProspect() {
        return fnameProspect;
    }

    public void setFnameProspect(String fnameProspect) {
        this.fnameProspect = fnameProspect;
    }

    public String getFnameAmbalaj() {
        return fnameAmbalaj;
    }

    public void setFnameAmbalaj(String fnameAmbalaj) {
        this.fnameAmbalaj = fnameAmbalaj;
    }

    public String getMedId() {
        return medId;
    }

    public void setMedId(String medId) {
        this.medId = medId;
    }
}
