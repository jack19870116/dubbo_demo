package com.tiancaibao.pojo.pay;

import java.io.Serializable;

public class PayRequestLogsWithBLOBs extends PayRequestLogs implements Serializable {
    /**
     * 请求数据
     */
    private String request;

    /**
     * 响应数据
     */
    private String response;

    private static final long serialVersionUID = 1L;

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request == null ? null : request.trim();
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response == null ? null : response.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", request=").append(request);
        sb.append(", response=").append(response);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}