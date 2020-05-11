package com.metrix.loginpackage;

import CRUDuser.UserDAO;
import java.sql.*;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDatabase {

    Connection con;

    public UserDatabase(Connection con) {
        this.con = con;
    }

    //for register user 
    public boolean saveUser(User user) {
        boolean set = false;
        try {
            //Insert register data to database
            String query = "INSERT INTO METRIX.USER(FNAME,MNAME,LNAME,ADDRESS,EMAIL,PASSWORD,JOINDATE) VALUES(?,?,?,?,?,?,?);";

            PreparedStatement pt = this.con.prepareStatement(query);
            pt.setString(1, user.getFirstName());
            pt.setString(2, user.getMiddleName());
            pt.setString(3, user.getLastName());
            pt.setString(4, user.getAddress());
            pt.setString(5, user.getEmail());
            pt.setString(6, user.getPassword());
            pt.setObject(7, user.getJoinDate());

            pt.executeUpdate();
            set = true;
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return set;
    }

    public boolean saveAdmin(User user) {
        boolean set = false;
        try {
            //Insert register data to database
            String query = "INSERT INTO METRIX.USER(FNAME,MNAME,LNAME,ADDRESS,EMAIL,PASSWORD,JOINDATE,ISADMIN) VALUES(?,?,?,?,?,?,?,1);";

            PreparedStatement pt = this.con.prepareStatement(query);
            pt.setString(1, user.getFirstName());
            pt.setString(2, user.getMiddleName());
            pt.setString(3, user.getLastName());
            pt.setString(4, user.getAddress());
            pt.setString(5, user.getEmail());
            pt.setString(6, user.getPassword());
            pt.setObject(7, user.getJoinDate());

            pt.executeUpdate();
            set = true;
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return set;
    }

    //user login
    public User logUser(String email, String password) {
        User usr = null;
        try {
            String query = "select * from user where email=? and password=? and status=1 and isadmin=0";
            PreparedStatement pst = this.con.prepareStatement(query);
            pst.setString(1, email);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                usr = new User();
                usr.setIduser(rs.getInt("iduser"));
                usr.setFirstName(rs.getString("fname"));
                usr.setMiddleName(rs.getString("mname"));
                usr.setLastName(rs.getString("lname"));
                usr.setAddress(rs.getString("address"));
                usr.setEmail(rs.getString("email"));
                usr.setPassword(rs.getString("password"));
                usr.setJoinDate(rs.getObject("joindate", LocalDate.class));

            }
            rs.close();
            pst.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return usr;
    }

    public User logAdmin(String email, String password) {
        User usr = null;
        try {
            String query = "select * from user where email=? and password=? and status=1 and isadmin=1";
            PreparedStatement pst = this.con.prepareStatement(query);
            pst.setString(1, email);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                usr = new User();
                usr.setIduser(rs.getInt("iduser"));
                usr.setFirstName(rs.getString("fname"));
                usr.setMiddleName(rs.getString("mname"));
                usr.setLastName(rs.getString("lname"));
                usr.setAddress(rs.getString("address"));
                usr.setEmail(rs.getString("email"));
                usr.setPassword(rs.getString("password"));
                usr.setUserRole(rs.getInt("isadmin"));

            }
            rs.close();
            pst.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return usr;
    }

    public boolean updateProfile(User user) {
        boolean test = false;

        try {
            String query = "UPDATE USER SET FNAME=?, mname=?, lname=?, address=?, email=?, password=?, lastupdated=? where iduser=?";
            PreparedStatement pt = this.con.prepareStatement(query);
            pt.setString(1, user.getFirstName());
            pt.setString(2, user.getMiddleName());
            pt.setString(3, user.getLastName());
            pt.setString(4, user.getAddress());
            pt.setString(5, user.getEmail());
            pt.setString(6, user.getPassword());

            pt.setObject(7, LocalDate.now());
            pt.setInt(8, user.getIduser());
            pt.executeUpdate();
            test = true;

            pt.close();

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return test;
    }

    public User getProfile(int id) {
        User user = null;

        try {
            String query = "select * from metrix.user where iduser=? ";

            PreparedStatement pt = this.con.prepareStatement(query);
            pt.setInt(1, id);
            ResultSet rs = pt.executeQuery();

            while (rs.next()) {
                int iduser = rs.getInt("iduser");
                String firstname = rs.getString("fname");
                String middlename = rs.getString("mname");
                String lastname = rs.getString("lname");
                String address = rs.getString("address");
                String email = rs.getString("email");
                String password = rs.getString("password");
                LocalDate joinDate = rs.getObject("joindate", LocalDate.class);
                int userRole = rs.getInt("isadmin");
                int userStatus = rs.getInt("status");
                user = new User(iduser, firstname, middlename, lastname, address, email, password, joinDate, userRole, userStatus);
            }
            rs.close();
            pt.close();
        } catch (Exception ex) {
            ex.printStackTrace();;
        }
        return user;
    }
}
