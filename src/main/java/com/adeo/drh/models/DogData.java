package com.adeo.drh.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
    {
        id: "hK9AnH4q_Ah",
                url: "https://i.thedogapi.co.uk/hK9AnH4q_Ah.jpg",
            time: "2017-07-22T03:52:02.668554",
            format: "jpeg",
            verified: "1",
            checked: "1"
    }
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DogData {
    private String id;
    private String url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
