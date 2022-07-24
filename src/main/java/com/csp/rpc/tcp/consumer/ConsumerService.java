package com.csp.rpc.tcp.consumer;

import com.csp.rpc.tcp.provider.RemoteCallService;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * @desc: 消费者服务
 * @author: csp52872
 * @date: 2022/6/11
 */
public class ConsumerService {

    public static void main(String[] args) throws Exception {
        Class<RemoteCallService> serviceClass = RemoteCallService.class;
        String simpleName = serviceClass.getName();
        Method method = serviceClass.getMethod("invoke", String.class);
        try (Socket socket = new Socket("127.0.0.1", 1234)) {
            Object[] arguments = {"test"};

            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeUTF(simpleName);
            outputStream.writeUTF(method.getName());
            outputStream.writeObject(method.getParameterTypes());
            outputStream.writeObject(arguments);

            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            Object object = inputStream.readObject();
            System.out.println(object);
        }
    }

}
