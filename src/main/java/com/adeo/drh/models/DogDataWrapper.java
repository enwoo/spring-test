package com.adeo.drh.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class DogDataWrapper {
    private int count;
    private String error;
    @JsonProperty("api_version")
    private String apiVersion;
    private List<DogData> data=new ArrayList<>();
}
