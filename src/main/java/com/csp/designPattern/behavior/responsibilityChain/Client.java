package com.csp.designPattern.behavior.responsibilityChain;

/**
 * @author csp
 * @date 2022/9/4
 */
public class Client {

    public static void main(String[] args) {
        Approver director = new Director("主任");
        Approver president = new President("老板");
        director.setSuccessor(president);

        PurchaseRequest request = PurchaseRequest.PurchaseRequestBuilder.create().amount(10000).build();
        director.processRequest(request);
    }
}
