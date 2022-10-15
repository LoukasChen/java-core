package com.csp.designPattern.behavior.responsibilityChain;

/**
 * 董事长类：具体处理者
 *
 * @author csp
 * @date 2022/9/4
 */
public class President extends Approver {

    public President(String name) {
        super(name);
    }

    @Override
    protected void processRequest(PurchaseRequest request) {
        if (request.getAmount() < 50000) {
            System.out.println("President process...");
        } else {
            super.successor.processRequest(request);
        }
    }

}
