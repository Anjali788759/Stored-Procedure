package storedprocedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertData {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER PRODUCT ID");
        int product_id = sc.nextInt();
        System.out.println("ENTER PRODUCT NAME");
        String product_name = sc.next();
        System.out.println("ENTER PRODUCT PRICE");
        double product_price = sc.nextDouble();
        System.out.println("ENTER PRODUCT QTY");
        int product_qty = sc.nextInt();
        System.out.println("ENTER PRODUCT CAT");
        String product_category = sc.next();

        Connection con;
        CallableStatement cstmt;

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm10","root","");
            cstmt=con.prepareCall("{ call insertdata(?,?,?,?,?)}");
            cstmt.setInt(1,product_id);
            cstmt.setString(2,product_name);
            cstmt.setDouble(3,product_price);
            cstmt.setInt(4,product_qty);
            cstmt.setString(5,product_category);

            int count=cstmt.executeUpdate();
            System.out.println(count +"data inserted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
