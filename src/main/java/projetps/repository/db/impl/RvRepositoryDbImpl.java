package projetps.repository.db.impl;

import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import projetps.entities.Rv;
import projetps.repository.RvRepository;
import projetps.repository.db.RepositoryDbImp;

public class RvRepositoryDbImpl extends RepositoryDbImp<Rv>  implements RvRepository{

    @Override
    public void insert(Rv data) {
        try {
            String query = "INSERT INTO Rv (date, heure, medecinId) VALUES (?, ?, ?)";
            getConnection();
            initPrepareStatement(query);
            ps.setString(1, data.getDate());
            ps.setString(2, data.getHeure());
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
    public List<Rv> selectAll() {
        List<Rv> rvs = new ArrayList<>();
        try {
            String query = "SELECT * FROM Rv";
            getConnection();
            initPrepareStatement(query);
            ResultSet rs = this.executeQuery();
            while (rs.next()) {
               Rv rv = new Rv();
               rv.setId(rs.getInt("id"));
               rs.getString(rs.getString("date"));
               rs.getString(rs.getString("heure"));
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
        return rvs;
    }

    @Override
    public List<Rv> filtreByDate(String date) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'filtreByDate'");
    }

    

   

    
}
