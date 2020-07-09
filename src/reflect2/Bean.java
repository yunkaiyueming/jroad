package reflect2;

import java.math.BigDecimal;

public class Bean {
    private Boolean usefull;
    private BigDecimal rate;
    private String name;

    public Boolean getUsefull() {
        return usefull;
    }

    public void setUsefull(Boolean usefull) {
        this.usefull = usefull;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Bean{" +
                "usefull=" + usefull +
                ", rate=" + rate +
                ", name='" + name + "}";
    }
}
