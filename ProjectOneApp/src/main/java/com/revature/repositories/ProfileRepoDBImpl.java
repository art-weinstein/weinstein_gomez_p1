package com.revature.repositories;

import com.revature.models.Profile;
import com.revature.util.ResourceNotFoundException;
import java.util.List;
import static orm.ORM.*;

public class ProfileRepoDBImpl implements ProfileRepo {

    @Override
    public Profile addProfile(Profile p) {
        return addData(p);
    }

    @Override
    public Profile getProfile(int id) {
        return getDataById(id);
    }

    @Override
    public List<Profile> getAllProfiles() {
        return getAllData("profiles");
    }

    @Override
    public Profile updateProfile(Profile change) {
        return updateData(change);
    }

    @Override
    public Profile deleteProfile(int id) throws ResourceNotFoundException {
        return deleteData(id);
    }
//
//    private Profile buildProfile(ResultSet rs) throws SQLException {
//        Profile p = new Profile();
//        p.setId(rs.getInt("p_id"));
//        p.setFirstName(rs.getString("f_name"));
//        p.setLastName(rs.getString("l_name"));
//        p.setMiddleName(rs.getString("m_name"));
//        p.setPhoneNumber(rs.getString("p_num"));
//        return p;
//    }
}