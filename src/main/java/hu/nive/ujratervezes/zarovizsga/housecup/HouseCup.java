package hu.nive.ujratervezes.zarovizsga.housecup;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HouseCup {

    private DataSource dataSource;

    public HouseCup(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public int getPointsOfHouse(String houdse) {
        int result;
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement("SELECT SUM(points_earned) FROM house_points WHERE house_name = ?;")
        ) {
            ps.setString(1, houdse);
            result = getPoints(ps);

        } catch (SQLException sqlException) {
            throw new IllegalStateException("Connection failed", sqlException);
        }
        return result;
    }

    private int getPoints(PreparedStatement ps) {
        int result = 0;
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                result = rs.getInt("SUM(points_earned)");
            }
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Cannot query", sqlException);
        }
        return result;
    }
}
