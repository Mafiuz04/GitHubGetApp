package com.Mafiuz04.DepoGet.controller;

import lombok.RequiredArgsConstructor;
import com.Mafiuz04.DepoGet.model.RepoDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.Mafiuz04.DepoGet.service.RepoService;

@RestController
@RequiredArgsConstructor
public class RepoController {
    private final RepoService repoService;

    @GetMapping("/repos/{owner}/{repo}")
    public RepoDTO getRepoInfo(@PathVariable String owner, @PathVariable String repo){
        return repoService.getRepoInfo(owner,repo);
    }
}
