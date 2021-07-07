package socra.project.elements;

import javax.persistence.*;

@Entity
@Table
public class Task {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    protected Long id;

    @Column(nullable = false)
    private String lieu;

    @Column(nullable = false)
    private String durée;

    @Column(nullable = false)
    private String tarif;

    @Column(nullable = false)
    private String télétravail;

    @Column(nullable = false)
    private String début;

    @Column(nullable = false)
    private String poste;

    @Column(nullable = false)
    private String contexte;

    @Column(nullable = false)
    private String mission;

    public Task(String lieu, String durée, String tarif, String télétravail, String début, String poste, String contexte, String mission) {
        this.lieu = lieu;
        this.durée = durée;
        this.tarif = tarif;
        this.télétravail = télétravail;
        this.début = début;
        this.poste = poste;
        this.contexte = contexte;
        this.mission = mission;
    }

    public Task() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getDurée() {
        return durée;
    }

    public void setDurée(String durée) {
        this.durée = durée;
    }

    public String getTarif() {
        return tarif;
    }

    public void setTarif(String tarif) {
        this.tarif = tarif;
    }

    public String getTélétravail() {
        return télétravail;
    }

    public void setTélétravail(String télétravail) {
        this.télétravail = télétravail;
    }

    public String getDébut() {
        return début;
    }

    public void setDébut(String début) {
        this.début = début;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public String getContexte() {
        return contexte;
    }

    public void setContexte(String contexte) {
        this.contexte = contexte;
    }

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }
}
