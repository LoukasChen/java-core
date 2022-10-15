package com.csp.designPattern.behavior.responsibilityChain;

/**
 * 审批者类
 *
 * @author csp
 * @date 2022/9/4
 */
public abstract class Approver {

    protected Approver successor;

    protected String name;

    public Approver(String name) {
        this.name = name;
    }

    /**
     * 设置后继者
     *
     * @param successor
     */
    public void setSuccessor(Approver successor) {
        this.successor = successor;
    }

    protected abstract void processRequest(PurchaseRequest request);

}
