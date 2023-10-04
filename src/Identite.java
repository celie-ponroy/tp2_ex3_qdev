import java.util.Objects;

public class Identite {

    //déclarations des attributs
    private String NIP;
    private String nom;
    private String prenom;

    /**
     * Constructeur
     * @param nip numéro de l'étudiant
     * @param nom nom de l'étudiant
     * @param prenom prénom de l'étudiant
     * @throws InvalidIDexception
     */
    Identite(String nip, String nom, String prenom) throws InvalidIDexception {
        if(nip == null || nom == null || prenom == null){
            throw new InvalidIDexception();
        }
        this.NIP=nip;
        this.nom=nom;
        this.prenom=prenom;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Identite identite = (Identite) o;
        return Objects.equals(NIP, identite.NIP) && Objects.equals(nom, identite.nom) && Objects.equals(prenom, identite.prenom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(NIP, nom, prenom);
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return  nom + " " + prenom;
    }
}
