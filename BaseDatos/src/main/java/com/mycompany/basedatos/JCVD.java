package com.mycompany.basedatos;

import java.sql.*;

public class JCVD {
    static final String DB_URL = "jdbc:mysql://localhost:3306/jcvd";
    static final String USER = "Radu";
    static final String PASS = "1234";
    static final String QUERY = "SELECT * FROM videojuegos";
    public static void main(String[] args){
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); 
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);){
            
            while(rs.next()){
                System.out.print("ID: " + rs.getInt("Id")+" ");
                System.out.print("Nombre: " + rs.getString("Nombre")+" ");
                System.out.print("Genero: " + rs.getString("Genero")+" ");
                System.out.print("FechaLanzamiento: " + rs.getDate("FechaLanzamiento")+" ");
                System.out.print("Compañia: " + rs.getString("Compañia")+" ");
                System.out.println("Precio: " + rs.getFloat("Precio")+" ");
            }
            //stmt.executeUpdate("INSERT INTO `videojuegos` (`Id`, `Nombre`, `Genero`, `FechaLanzamiento`, `Compañia`, `Precio`) VALUES (NULL, 'Fortnite', 'Battle Royal', '2023-11-20', 'EpicGames', '0')");
            //stmt.executeUpdate("DELETE FROM `videojuegos`   WHERE `Nombre`  = 'Fortnite'");
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
