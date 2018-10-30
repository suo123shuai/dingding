package com.ddcar.entity;

import java.io.Serializable;
import java.util.List;

public class AmountAndFlow implements Serializable {
    private Double totalRevenue;
    private Double totalExpenses;
    private Double income;
    private List<AccountFlow> accountFlow;

    public Double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(Double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public Double getTotalExpenses() {
        return totalExpenses;
    }

    public void setTotalExpenses(Double totalExpenses) {
        this.totalExpenses = totalExpenses;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public List<AccountFlow> getAccountFlow() {
        return accountFlow;
    }

    public void setAccountFlow(List<AccountFlow> accountFlow) {
        this.accountFlow = accountFlow;
    }
}
