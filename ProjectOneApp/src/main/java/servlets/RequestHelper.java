package servlets;


import com.revature.controllers.ProfileController;
import com.revature.repositories.ProfileRepo;
import com.revature.repositories.ProfileRepoDBImpl;
import com.revature.services.ProfileService;
import com.revature.services.ProfileServiceImpl;
import com.revature.util.ResourceNotFoundException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;

//This Class is acting as a Delegator - to tell our code where it should be processed next.
public class RequestHelper {

    static ProfileRepo pr = new ProfileRepoDBImpl();
    static ProfileService ps = new ProfileServiceImpl(pr);
    static ProfileController pc = new ProfileController(ps);

    public static void getProcess(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {

        String uri = request.getRequestURI();
        System.out.println(uri);

        String[] uriTokens = uri.split("/");
        System.out.println(Arrays.toString(uriTokens));

        switch (uriTokens.length) {
            case 0:
            case 1:
            case 2: {
                response.sendError(404);
                break;
            }
            case 3: {
                if(("profiles").equals(uriTokens[2])) pc.getProfiles(request, response);
                else response.sendError(400, "Collection does not exist");
                break;
            }
            case 4: {
                //Call our get<Insert Entity Here> by Id service method.
                request.setAttribute("id", uriTokens[3]);
                if(("profiles").equals(uriTokens[2])) pc.getProfileById(request, response);
                break;
            }
            default: {
                response.sendError(400);
                break;
            }
        }

    }

    public static void postProcess(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {


        String uri = request.getRequestURI();
        System.out.println(uri);

        String[] uriTokens = uri.split("/");
        System.out.println(Arrays.toString(uriTokens));

        switch (uriTokens.length) {
            case 0:
            case 1:
            case 2: {
                response.sendError(404);
                break;
            }
            case 3: {
                //Call our getAll<Insert Entity Here> methods.
                if (("profiles").equals(uriTokens[2])) pc.addProfile(request, response);
                else response.sendError(400, "Collection does not exist");
                break;
            }
            default: {
                response.sendError(400);
                break;
            }

        }

    }

    public static void putProcess(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String uri = request.getRequestURI();
        System.out.println(uri);

        String[] uriTokens = uri.split("/");
        System.out.println(Arrays.toString(uriTokens));

        switch (uriTokens.length) {

            case 0:
            case 1:
            case 2: {
                response.sendError(404);
                break;
            }

            case 4: {
                int id = 0;
                String input = uriTokens[3];

                if(input.matches("[0-9]+")) {
                    id = Integer.parseInt(input);
                } else {
                    response.sendError(400, "ID is not a number");
                    return;
                }

                request.setAttribute("id", id);
                if (("profiles").equals(uriTokens[2])) pc.updateProfile(request, response);
                else response.sendError(400, "Collection does not exist");
                break;
            }
            default: {
                response.sendError(400);
                break;
            }

        }

    }

    public static void deleteProcess(HttpServletRequest request, HttpServletResponse response) throws IOException, ResourceNotFoundException {

        String uri = request.getRequestURI();
        System.out.println(uri);

        String[] uriTokens = uri.split("/");
        System.out.println(Arrays.toString(uriTokens));

        switch (uriTokens.length) {
            case 0:
            case 1:
            case 2: {
                response.sendError(404);
                break;
            }
            case 4: {
                int id = 0;
                String input = uriTokens[3];

                if(input.matches("[0-9]+")) {
                    id = Integer.parseInt(input);
                } else {
                    response.sendError(400, "ID is not a number");
                    return;
                }

                request.setAttribute("id", id);
                if (("profiles").equals(uriTokens[2])) pc.deleteProfile(request, response);
                else response.sendError(400, "Collection does not exist");
                break;
            }
            default: {
                response.sendError(400);
                break;
            }

        }
    }
}