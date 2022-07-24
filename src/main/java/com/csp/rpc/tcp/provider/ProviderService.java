package com.csp.rpc.tcp.provider;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * @desc: 生产者服务
 * @author: csp52872
 * @date: 2022/6/11
 */
public class ProviderService {

    private static final Map<String, Object> services = new HashMap<>();

    static {
        services.putIfAbsent(RemoteCallService.class.getName(), new RemoteCallServiceImpl());
    }

    public static void main(String[] args) throws Exception {
        try (ServerSocket server = new ServerSocket(1234)) {
            while (true) {
                Socket socket = server.accept();
                ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                String interfaceName = inputStream.readUTF();
                String methodName = inputStream.readUTF();
                Class<?>[] parameterTypes = (Class<?>[]) inputStream.readObject();
                Object[] arguments = (Object[]) inputStream.readObject();
                Class<?> serviceInterfaceName = Class.forName(interfaceName);
                Object service = services.get(interfaceName);
                Method method = serviceInterfaceName.getMethod(methodName, parameterTypes);
                Object result = method.invoke(service, arguments);
                ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                outputStream.writeObject(result);
            }
        }
    }
}
