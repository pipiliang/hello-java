package io.mockility.manager.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Don't worry be happy
 * Created by liangwei on 11/24/17
 */

public class MockedInterface {
    @JsonProperty(value = "method")
    private RequestMethod method;

    @JsonProperty(value = "url")
    private String url;

    @JsonProperty(value = "response")
    private String response;

    public RequestMethod getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }

    public String getResponse() {
        return response;
    }

    public void setMethod(RequestMethod method) {
        this.method = method;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
