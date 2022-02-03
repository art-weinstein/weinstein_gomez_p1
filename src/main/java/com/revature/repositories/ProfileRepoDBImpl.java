package com.revature.repositories;

import com.revature.models.Profile;
import com.revature.ormtesting.ORMTest;
import com.revature.util.JDBCConnection;
import com.revature.util.ResourceNotFoundException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.revature.ormtesting.ORMTest.*;



public class ProfileRepoDBImpl implements ProfileRepo {

    Connection conn = JDBCConnection.getConnection();


    @Override
    public Profile addProfile(Profile p) {

        return addData(p);

//        String sql = "INSERT INTO profiles VALUES (default,?,?,?,?) RETURNING *";
//
//        try {
//            PreparedStatement ps = conn.prepareStatement(sql);
//
//            //set values for all the placeholders: ?
//            ps.setString(1, p.getFirstName());
//            ps.setString(2, p.getLastName());
//            ps.setString(3,p.getMiddleName());
//            ps.setString(4, p.getPhoneNumber());
//
//            ResultSet rs = ps.executeQuery();
//
//            if(rs.next()) {
//                return buildProfile(rs);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
    }

    @Override
    public Profile getProfile(int id) {
        return getDataById(id);
//        //Make a String for the SQL statement you want executed. Use Placeholders for data values.
//        String sql = "SELECT * FROM profiles WHERE p_id = ?";
//
//        try {
//            //Set up PreparedStatement
//            PreparedStatement ps = conn.prepareStatement(sql);
//            //Set values for any Placeholders
//            ps.setInt(1, id);
//
//            //Execute the query, store the results -> ResultSet
//            ResultSet rs = ps.executeQuery();
//
//            //Extract results our of ResultSet
//            if(rs.next()) {
//                return buildProfile(rs);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
    }



    @Override
    public List<Profile> getAllProfiles() {
       return getAllData("profiles");
//
//        String sql = "SELECT * FROM profiles";
//
//        try {
//            PreparedStatement ps = conn.prepareStatement(sql);
//
//            ResultSet rs = ps.executeQuery();
//
//            //Extract all movies out of the ResultSet
//            List<Profile> profiles = new ArrayList<>();
//            while (rs.next()) {
//                //Add each movie to our list of movies.
//                profiles.add(buildProfile(rs));
//            }
//            return profiles;
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//

    }



    @Override
    public Profile updateProfile(Profile change) {

        return updateData(change);

//        String sql = "UPDATE profiles set f_name=?, l_name=?, m_name=?, p_num=? WHERE p_id = ? RETURNING *";
//
//        try {
//            PreparedStatement ps = conn.prepareStatement(sql);
//
//            ps.setString(1, change.getFirstName());
//            ps.setString(2, change.getLastName());
//            ps.setString(3,change.getMiddleName());
//            ps.setString(4, change.getPhoneNumber());
//            ps.setInt(5, change.getId());
//
//            ResultSet rs = ps.executeQuery();
//
//            if(rs.next()) {
//                return buildProfile(rs);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return null;
    }

    @Override
    public Profile deleteProfile(int id) throws ResourceNotFoundException {

        return deleteData(id);
//        String sql = "DELETE FROM profiles WHERE p_id = ? RETURNING *";
//
//        try {
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setInt(1, id);
//
//            ResultSet rs = ps.executeQuery();
//
//            if(rs.next()) {
//                return buildProfile(rs);
//            } else {
//                throw new ResourceNotFoundException("Resource with id: " + id + " was not found in database.");
//            }
//        } catch (SQLException | ResourceNotFoundException e) {
//            e.printStackTrace();
//        }
//        return null;
    }

    private Profile buildProfile(ResultSet rs) throws SQLException {
        Profile p = new Profile();
        p.setId(rs.getInt("p_id"));
        p.setFirstName(rs.getString("f_name"));
        p.setLastName(rs.getString("l_name"));
        p.setMiddleName(rs.getString("m_name"));
        p.setPhoneNumber(rs.getString("p_num"));
        return p;
    }
    }