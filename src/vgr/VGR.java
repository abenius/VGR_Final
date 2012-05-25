/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vgr;

import java.sql.*;

/**
 *
 * @author AdamAbenius
 */
public class VGR {

    static Connection conn;
    static Statement stmt;
    public static void main(String[] args) throws SQLException {
        dbAnslut();
        ResultSet r = stmt.executeQuery("SELECT * FROM data WHERE modality == 'CR';");
        while (r.next()){
            System.out.println("TJENA");
            System.out.println("ID: " + r.getInt("Patient_ID"));
            System.out.println("Namn: " + r.getString("Patient_Name"));
        }
    }
    
    public static void dbAnslut() throws SQLException{
        //setup
        try {
			Class.forName("org.sqlite.JDBC");
			System.out.print("Ansluter till databas...");
			/*conn = DriverManager.getConnection("jdbc:sqlite:C:/Users/Emil/Desktop/Systemvetenskap - IT, Människa "
                                + "och Organisation/År 2/Informationsteknologi och samhälle\1050/VGR/VGR_Final/vgrdataDB");*/
                        conn = DriverManager.getConnection("jdbc:sqlite:vgrdataDB");
                        System.out.println("  OK /db\n");
			stmt = conn.createStatement();

		} catch (ClassNotFoundException e) {
			System.out.println("Drivrutinen kunde inte laddas.");
		} catch (SQLException e) {
			System.out.println("Databasen kunde inte anslutas till.");
		}
    }
}
