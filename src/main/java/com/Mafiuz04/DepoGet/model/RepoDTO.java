package com.Mafiuz04.DepoGet.model;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonProperty;


import java.time.LocalDateTime;

@Data
public class RepoDTO {

    @JsonProperty("full_name")
    private String fullName;
    @JsonProperty("description")
    private String description;
    @JsonProperty("cloneUrl")
    private String cloneUrl;
    @JsonProperty("stargazers_count")
    private Integer stars;
    @JsonProperty("created_at")
    private LocalDateTime createdAt;
}
