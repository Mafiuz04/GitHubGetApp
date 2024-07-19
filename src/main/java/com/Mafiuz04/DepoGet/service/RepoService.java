package com.Mafiuz04.DepoGet.service;

import com.Mafiuz04.DepoGet.client.Client;
import lombok.AllArgsConstructor;
import com.Mafiuz04.DepoGet.model.RepoDTO;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RepoService {

    private final Client client;

    public RepoDTO getRepoInfo(String owner, String repo) {
        return client.getRepoInfo(owner, repo);
    }
}
