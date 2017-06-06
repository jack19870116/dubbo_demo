package com.tiancaibao.pojo.shop;

import java.io.Serializable;

public class ShopsWithBLOBs extends Shops implements Serializable {
    /**
     * 商品描述信息
     */
    private String sinfo;

    private String exchangeDescription;

    private static final long serialVersionUID = 1L;

    public String getSinfo() {
        return sinfo;
    }

    public void setSinfo(String sinfo) {
        this.sinfo = sinfo == null ? null : sinfo.trim();
    }

    public String getExchangeDescription() {
        return exchangeDescription;
    }

    public void setExchangeDescription(String exchangeDescription) {
        this.exchangeDescription = exchangeDescription == null ? null : exchangeDescription.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sinfo=").append(sinfo);
        sb.append(", exchangeDescription=").append(exchangeDescription);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}