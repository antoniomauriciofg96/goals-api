package br.com.fiap.rm335913.goals.response;

import javax.servlet.http.HttpServletResponse;

public class ResponseApiError extends Exception {
    private static final long serialVersionUID = 1L;
    private String errorMessage;
    private Integer responseCode;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public ResponseApiError() {
        super();
    }

    public ResponseApiError setErrorHttp404(String errorMessage) {
        this.errorMessage = errorMessage;
        this.responseCode = HttpServletResponse.SC_NOT_FOUND;
        return this;
    }

    public ResponseApiError setErrorHttp403(String errorMessage) {
        this.errorMessage = errorMessage;
        this.responseCode = HttpServletResponse.SC_FORBIDDEN;
        return this;
    }

    public ResponseApiError setErrorHttp401(String errorMessage) {
        this.errorMessage = errorMessage;
        this.responseCode = HttpServletResponse.SC_UNAUTHORIZED;
        return this;
    }

    public ResponseApiError setErrorHttp500(String errorMessage) {
        this.errorMessage = errorMessage;
        this.responseCode = HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
        return this;
    }

    public ResponseApiError setErrorHttp400(String errorMessage) {
        this.errorMessage = errorMessage;
        this.responseCode = HttpServletResponse.SC_BAD_REQUEST;
        return this;
    }

    public ResponseApiError(String errorMessage, Integer responseCode) {
        this.errorMessage = errorMessage;
        this.responseCode = responseCode;
    }

    @Override
    public String toString() {
        return "ApiReturnExcepetion [errorMessage=" + errorMessage + ", responseCode=" + responseCode
                + "]";
    }
}
