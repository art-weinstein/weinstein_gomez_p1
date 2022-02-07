package com.revature.services;

import com.revature.models.Profile;
import com.revature.util.ResourceNotFoundException;

import java.util.List;

public interface ProfileService {
    public Profile addProfile(Profile p);
    public Profile getProfile(int id);
    public List<Profile> getAllProfiles();
    public Profile updateProfile(Profile change);
    public Profile deleteProfile(int id) throws ResourceNotFoundException;
}