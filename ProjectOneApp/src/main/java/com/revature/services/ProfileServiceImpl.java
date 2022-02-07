package com.revature.services;

import com.revature.models.Profile;
import com.revature.repositories.ProfileRepo;
import com.revature.util.ResourceNotFoundException;

import java.util.List;


public class ProfileServiceImpl implements ProfileService {

    private ProfileRepo pr;

    //This is a process called Dependency Injection
    public ProfileServiceImpl(ProfileRepo pr) {
        //Constructor Injection -> When the dependency need for the Class is fulfilled in a Constructor.
        this.pr = pr;
    }

    @Override
    public Profile addProfile(Profile p) {
        return pr.addProfile(p);
    }

    @Override
    public Profile getProfile(int id) {
        return pr.getProfile(id);
    }

    @Override
    public List<Profile> getAllProfiles() {
        return pr.getAllProfiles();
    }

    @Override
    public Profile updateProfile(Profile change) {
        return pr.updateProfile(change);
    }

    @Override
    public Profile deleteProfile(int id) throws ResourceNotFoundException {
        return pr.deleteProfile(id);
    }



}