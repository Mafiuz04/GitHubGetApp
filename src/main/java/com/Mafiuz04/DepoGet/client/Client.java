package com.Mafiuz04.DepoGet.client;

import com.Mafiuz04.DepoGet.model.RepoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "getRepo", url = "https://api.github.com")
public interface Client {
@GetMapping("repos/{owner}/{repo}")
    RepoDTO getRepoInfo(@PathVariable String owner, @PathVariable String repo);
}
