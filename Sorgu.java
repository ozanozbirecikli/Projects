package Internship;

import java.sql.*;

public class Sorgu {

    private static int count;
    private static int totalpopulation;


    public static void viewTable(Connection con, String dbName) throws SQLException {

        Statement stmt = null;
        String query = "SELECT code, name FROM " + dbName + " order BY name";
        String query2 = "SELECT id, cityname, countrycode, district, population FROM " + dbName + " order BY population";


        try {
            stmt = con.createStatement();
            ResultSet rs2 = stmt.executeQuery(query);
            ResultSet rs = stmt.executeQuery(query2);
            while (rs2.next()) {
                int code = rs2.getInt("code");
                String countryname = rs2.getString("name");
                count = 0;
                totalpopulation = 0;
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String cityname = rs.getString("cityname, (district)");
                    int countrycode = rs.getInt("countrycode");
//                    String district = rs.getString("district");
                    int population = rs.getInt("population");
                    System.out.println(id + "\t" + cityname + "\t" + countrycode + "\t" + population);

                    count(countrycode, code, population);

                }

                if (verification() == true) {
                    System.out.println(countryname + "\t" + code + "\t" + count + "\t" + totalpopulation);
                }

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }


    }

    public static void count(int countrycode, int code, int population) {
        if (countrycode == code) {
            count++;
        }
        population++;
    }

    public static boolean verification() {
        if (count >= 15 && totalpopulation >= 3000000) {
            return true;
        }
        return false;
    }


}




