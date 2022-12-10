package federation;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;


public interface joueurDAO {
	
	public String url="jdbc:mysql://localhost:3306/td_java";
	public String nomUtilisateur="root";
	public String mots_de_passe="";
	
	public static final String ajout="INSERT INTO joueurs"+"(nom,prenom,numero_licence)VALUES"+"(?,?,?);";
	public static final String findOne="select id,nom,prenom,numero_licence from joueurs where id=? ";
	public static final String delete="delete from joueurs where id=?;";
	public static final String selectAll = "select * from joueurs";
	public static final String edit ="update user set nom=?,prenom=?,numero_licence=? where id= ?;";
	
	
	public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, nomUtilisateur,mots_de_passe);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }
	
	public static void  insertion(Joueur joueur)throws SQLException{
		System.out.println(ajout);
		 try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(ajout)) {
	            preparedStatement.setString(1, joueur.getNom());
	            preparedStatement.setString(2, joueur.getPrenom());
	            preparedStatement.setString(3, joueur.getNumero_licence());
	            System.out.println(preparedStatement);
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            printSQLException(e);
	        }
		
	}
	public static Joueur selectionner(int id) {
		Joueur joueur= null;
		try (Connection connection = getConnection();
	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(findOne);) {
	            preparedStatement.setInt(1, id);
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            ResultSet rs = preparedStatement.executeQuery();

	            // Step 4: Process the ResultSet object.
	            while (rs.next()) {
	                String nom = rs.getString("nom");
	                String prenom = rs.getString("prenom");
	                String numero_licence = rs.getString("numero_licence");
	                joueur = new Joueur(id, nom, prenom, numero_licence);
	            }
	        } catch (SQLException e) {
	            printSQLException(e);
	        }
	        return joueur;
		
		
	}
	public static List < Joueur > getAll() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List < Joueur > joueurs = new ArrayList < > ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(selectAll);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String numero_licence = rs.getString("numero_licence");
                joueurs.add(new Joueur(id,nom, prenom, numero_licence));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return joueurs;
    }
	public static boolean delete(int id) throws SQLException {
        boolean ligneSupprime;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(delete);) {
            statement.setInt(1, id);
            ligneSupprime = statement.executeUpdate() > 0;
        }
        return ligneSupprime;
    }

    public static boolean edit(Joueur joueur) throws SQLException {
        boolean ligneAjour;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(edit);) {
            statement.setString(1, joueur.getNom());
            statement.setString(2, joueur.getPrenom());
            statement.setString(3, joueur.getNumero_licence());
            statement.setInt(4, joueur.getId());

            ligneAjour = statement.executeUpdate() > 0;
        }
        return ligneAjour;
    }

	public static void printSQLException(SQLException e) {
		// TODO Auto-generated method stub
		
	}

}
