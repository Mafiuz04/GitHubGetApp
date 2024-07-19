package com.Mafiuz04.DepoGet.service;

import com.Mafiuz04.DepoGet.controller.RepoController;
import com.Mafiuz04.DepoGet.model.RepoDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class RepoServiceTest {
    @Mock
    private RepoService repoService;

    @InjectMocks
    private RepoController repoController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(repoController).build();
    }

    @Test
    void getRepository_shouldReturnRepository() throws Exception {
        String owner = "testOwner";
        String repo = "testRepo";
        RepoDTO repoDTO = new RepoDTO();
        repoDTO.setFullName(owner + "/" + repo);

        when(repoService.getRepoInfo(anyString(), anyString())).thenReturn(repoDTO);

        MvcResult result = mockMvc.perform(get("/repos/{owner}/{repo}", owner, repo)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String content = result.getResponse().getContentAsString();
        System.out.println("Response content: " + content);  // Debugging

        verify(repoService).getRepoInfo(owner, repo);

        assertTrue(content.contains(owner + "/" + repo), "Response should contain repository name");
    }

    @Test
    void getRepository_shouldHandleNullResponse() throws Exception {
        String owner = "testOwner";
        String repo = "testRepo";
        when(repoService.getRepoInfo(anyString(), anyString())).thenReturn(null);

        MvcResult result = mockMvc.perform(get("/repos/{owner}/{repo}", owner, repo)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String content = result.getResponse().getContentAsString();
        System.out.println("Response content: " + content);  // Debugging

        verify(repoService).getRepoInfo(owner, repo);

        assertTrue(content.isEmpty() || content.equals("null"), "Response should be empty or 'null' for null repository");
    }
}
