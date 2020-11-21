package br.com.qualqrum.api.dto;

import java.io.Serializable;

public class PathResponseDTO implements Serializable {

    private String description;
    private String method = "GET";
    private String href;
    private String queryParams[];

    public PathResponseDTO(String description, String href, String[] queryParams) {
        this.description = description;
        this.href = href;
        this.queryParams = queryParams;
    }

    public String getDescription() {
        return description;
    }

    public String getMethod() {
        return method;
    }

    public String getHref() {
        return href;
    }

    public String[] getQueryParams() {
        return queryParams;
    }
}
