package com.csp.designPattern.behavior.responsibilityChain;

/**
 * 主任类：具体处理者
 *
 * @author csp
 * @date 2022/9/4
 */
public class Director extends Approver {

    public Director(String name) {
        super(name);
    }

    @Override
    protected void processRequest(PurchaseRequest request) {
        if (request.getAmount() < 10000) {
            System.out.println("Director process...");
        } else {
            super.successor.processRequest(request);
        }
    }
}
