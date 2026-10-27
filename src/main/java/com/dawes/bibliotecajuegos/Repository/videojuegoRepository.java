package com.dawes.bibliotecajuegos.Repository;

import com.dawes.bibliotecajuegos.DTO.videojuegoDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository
public class videojuegoRepository {
    private static final Logger logger = LoggerFactory.getLogger(videojuegoRepository.class);

    private final DataSource dataSource;

    public videojuegoRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public ArrayList<videojuegoDTO> listarVideojuego(String titulo, Integer anio_lanzamiento, Integer pegi, Integer id_desarrolladora) {

        String sql = "SELECT v.titulo, v.anio_lanzamiento, v.pegi, d.id_desarrolladora " +
                "FROM videojuego v JOIN desarrolladora d ON v.id_desarrolladora = d.nombre" +
                "WHERE v.titulo LIKE ? AND v.anio_lanzamiento = ? AND v.pegi = ? AND d.id_desarrolladora = ?";

        ArrayList<videojuegoDTO> listaVideojuegos = new ArrayList<>();
        Connection connection = null;

        try{
            connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, "%" + titulo + "%");
            ps.setInt(2, anio_lanzamiento);
            ps.setInt(3, pegi);
            ps.setInt(4, id_desarrolladora);

            logger.debug("Query a ejecutar: {}", ps);

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                listaVideojuegos.add(mapearVideojuego(rs));
            }

            connection.close();

        }catch(SQLException e){
            logger.error("Error al listar los videojuegos: " + e.getMessage());
            cerrarConexion(connection);
        }

        return listaVideojuegos;

    }

    private videojuegoDTO mapearVideojuego(ResultSet rs) throws SQLException {
        return new videojuegoDTO(
                rs.getString("titulo"),
                rs.getInt("anio_lanzamiento"),
                rs.getInt("pegi"),
                rs.getInt("id_desarrolladora")
        );
    }

    private void cerrarConexion(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

}
