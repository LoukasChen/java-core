package com.csp.rpc.tcp.provider;

/**
 * @desc:
 * @author: csp52872
 * @date: 2022/6/11
 */
public class RemoteCallServiceImpl implements RemoteCallService {

    @Override
    public String invoke(String arg) {
        return arg + "success";
    }

}
