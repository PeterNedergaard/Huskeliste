package DBAccess;

import com.example.huskelistetomcat.Emne;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Liste {

    public static void tilfoejEmne(Emne emne) {
        String sql = "INSERT INTO emner(emne) VALUES(?)";

        try (Connection con = ConnectionConfiguration.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {
            ps.setString(1, emne.getNavn());

            try {
                ps.executeUpdate();
            } catch (SQLIntegrityConstraintViolationException e){
                System.out.println("You tried to add an 'emne' which is already in the database");
                return;
            }

            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            emne.setId(id);

            System.out.println("Emnet blev tilfoejet");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
