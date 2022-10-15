package com.csp.designPattern.behavior.responsibilityChain;

/**
 * 采购单：请求类
 * @author csp
 * @date 2022/9/4
 */
public class PurchaseRequest {
    /**
     * 采购金额
     */
    private double amount;
    /**
     * 采购单编号
     */
    private int number;
    /**
     * 采购目的
     */
    private String purpose;

    public PurchaseRequest(double amount, int number, String purpose) {
        this.amount = amount;
        this.number = number;
        this.purpose = purpose;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }


    public static final class PurchaseRequestBuilder {
        private double amount;
        private int number;
        private String purpose;

        private PurchaseRequestBuilder() {
        }

        public static PurchaseRequestBuilder create() {
            return new PurchaseRequestBuilder();
        }

        public PurchaseRequestBuilder amount(double amount) {
            this.amount = amount;
            return this;
        }

        public PurchaseRequestBuilder number(int number) {
            this.number = number;
            return this;
        }

        public PurchaseRequestBuilder purpose(String purpose) {
            this.purpose = purpose;
            return this;
        }

        public PurchaseRequest build() {
            return new PurchaseRequest(amount, number, purpose);
        }
    }


}
