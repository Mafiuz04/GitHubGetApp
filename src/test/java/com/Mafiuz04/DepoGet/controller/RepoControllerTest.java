package com.Mafiuz04.DepoGet.controller;

import com.Mafiuz04.DepoGet.client.Client;
import com.Mafiuz04.DepoGet.model.RepoDTO;
import com.Mafiuz04.DepoGet.service.RepoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

public class RepoControllerTest {
    @Mock
    private Client client;

    @InjectMocks
    private RepoService repoService;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    void testGetRepository() {
        String owner = "testOwner";
        String repo = "testRepo";
        RepoDTO repoDTO = new RepoDTO();
        repoDTO.setFullName("testOwner/testRepo");
        repoDTO.setDescription("Test repository");
        repoDTO.setCloneUrl("https://github.com/testOwner/testRepo.git");
        repoDTO.setStars(100);
        repoDTO.setCreatedAt(LocalDateTime.of(2020,12,20,12,12,12));

        when(client.getRepoInfo(owner, repo)).thenReturn(repoDTO);

        RepoDTO result = repoService.getRepoInfo(owner, repo);

        assertEquals("testOwner/testRepo", result.getFullName());
        assertEquals("Test repository", result.getDescription());
        assertEquals("https://github.com/testOwner/testRepo.git", result.getCloneUrl());
        assertEquals(100, result.getStars());
        assertEquals(LocalDateTime.of(2020,12,20,12,12,12), result.getCreatedAt());
    };
}
