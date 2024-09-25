package projetps.repository.db.impl;

import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;


import projetps.entities.Medecin;
import projetps.entities.Rv;
import projetps.repository.MedecinRepository;
import projetps.repository.db.RepositoryDbImp;

public class MedecinRepositoryDbImpl extends RepositoryDbImp<Medecin>  implements MedecinRepository{

    @Override
    public void insert(Medecin data) {
        try {
            String query = "INSERT INTO Medecin (nom, prenom) VALUES (?, ?)";
            getConnection();
            initPrepareStatement(query);
            ps.setString(1, data.getNom());
            ps.setString(2, data.getPrenom());
            this.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                data.setId(rs.getInt(1));
            }
        } catch (Exception e) {
            System.out.println("ERREUR: " + e.getMessage());

        } finally {
            try {
                this.closeConnexion();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
    @Override
    public Medecin selectByID(int id){
        try {
            String query = "SELECT * FROM Medecin WHERE id = ?";
            getConnection();
            initPrepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = this.executeQuery();
            while (rs.next()) {
                Medecin medecin = new Medecin();
                medecin.setId(rs.getInt("id"));
                medecin.setNom(rs.getString("nom"));
                medecin.setPrenom(rs.getString("prenom"));
                return medecin;
            }
        } catch (Exception e) {
            System.out.println("ERREUR: " + e.getMessage());

        } finally {
            try {
                this.closeConnexion();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Medecin> selectAll() {
        List<Medecin> medecins = new ArrayList<>();
        try {
            String query = "SELECT * FROM Medecin";
            getConnection();
            initPrepareStatement(query);
            ResultSet rs = this.executeQuery();
            while (rs.next()) {
               Medecin medecin = new Medecin();
               medecin.setId(rs.getInt("id"));
               medecin.setNom(rs.getString("nom"));
               medecin.setPrenom(rs.getString("prenom"));
                medecins.add(medecin);
            }
        } catch (Exception e) {
            System.out.println("ERREUR: " + e.getMessage());

        } finally {
            try {
                this.closeConnexion();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return medecins;
    }
   
}
