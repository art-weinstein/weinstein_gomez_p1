package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.models.Profile;
import com.revature.services.ProfileService;
import com.revature.util.ResourceNotFoundException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfileController {

    ProfileService ps;
    Gson gson = new Gson();

    public ProfileController(ProfileService ps) {
        this.ps = ps;
    }

    public void getProfileById(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {

        String input = request.getAttribute("id").toString();
        int id = 0;
        if(input.matches("[0-9]+")) {
            id = Integer.parseInt(input);
        } else {
            response.sendError(400, "ID is not a number");
            return;
        }

        Profile p = ps.getProfile(id);

        response.getWriter().append((p != null) ? gson.toJson(p): "{}");
    }

    public void getProfiles(HttpServletRequest request, HttpServletResponse response) throws IOException {

        List<Profile> profileList = new ArrayList<>();
        profileList = ps.getAllProfiles();

        response.getWriter().append(gson.toJson(profileList));
    }



    public void addProfile(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {

        //Extract data/information from the request
        BufferedReader reader = request.getReader();
        Profile p = gson.fromJson(reader, Profile.class);

        //Call some service(s) to process the data/information
        p = ps.addProfile(p);

        //Generate a response from that processed data.
        if(p != null) {
            response.setStatus(201);
            response.getWriter().append(gson.toJson(p));
        } else {
            response.getWriter().append("{}");
        }


    }

    public void updateProfile(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Profile p = gson.fromJson(request.getReader(), Profile.class);
        p.setId((int) request.getAttribute("id"));

        p = ps.updateProfile(p);

        response.getWriter().append((p != null) ? gson.toJson(p) : "{}");
    }

    public void deleteProfile(HttpServletRequest request, HttpServletResponse response) throws ResourceNotFoundException, IOException {

        int id = (int) request.getAttribute("id");

        Profile p = ps.deleteProfile(id);

        response.setStatus(204);
    }
}