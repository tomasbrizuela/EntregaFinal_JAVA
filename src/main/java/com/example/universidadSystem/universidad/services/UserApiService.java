package com.example.universidadSystem.universidad.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.universidadSystem.universidad.model.Usuario;

@Service
public class UserApiService {

    private final RestTemplate restTemplate;

    public UserApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    String URL = "https://jsonplaceholder.org/users";

    public List<Usuario> getListOfUsers() {
        Usuario[] response = restTemplate.getForObject(URL, Usuario[].class);
        return Arrays.asList(response);
    }

}
