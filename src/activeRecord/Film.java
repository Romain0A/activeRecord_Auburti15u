package activeRecord;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Film {
    private String titre;
    private int id;
    private int id_real;


    public Film(String titred,Personne auteur){
        titre = titred;
        id=-1;
        id_real = auteur.getId();
    }

    private Film(String titred,int idd,int id_reald){
        titre = titred;
        id = idd;
        id_real = id_reald;
    }

    public static Film findByID(int idd) throws SQLException {
        DBConnection connection = DBConnection.getInstance();
        Connection connect = connection.getConnection();
        String SQLPrep = "SELECT * FROM Film WHERE id=?;";
        PreparedStatement prep1 = connect.prepareStatement(SQLPrep);
        prep1.setInt(1, idd);
        prep1.execute();
        ResultSet rs = prep1.getResultSet();
        Film resultat = new Film(rs.getString("titre"),rs.getInt("id"),rs.getInt("id_real"));
        return resultat;
    }


}
