package com.csp.concurrency.thread.practice;

import java.util.LinkedList;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @desc:
 * @author: csp52872
 * @date: 2021/10/31
 */
public class MessageQueueTest {

    public static void main(String[] args) {
        MessageQueue messageQueue = new MessageQueue(5);
        for (int i = 0; i < 20; i++) {
            int j = i;
            new Thread(() -> {
                messageQueue.put(new Message(UUID.randomUUID().toString(), "put message" + j));
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            ).start();
        }

        new Thread(() -> {
            while (true) {
                System.out.println("consume:" + messageQueue.take());
            }
        }).start();
    }

    private static class Message {

        private String messageId;

        private String messageContent;

        public Message(String messageId, String messageContent) {
            this.messageId = messageId;
            this.messageContent = messageContent;
        }

        @Override
        public String toString() {
            return "Message{" +
                    "messageId='" + messageId + '\'' +
                    ", messageContent='" + messageContent + '\'' +
                    '}';
        }
    }

    private static class MessageQueue {

        private final LinkedList<Message> messages = new LinkedList<>();

        private int capacity;

        public MessageQueue(int capacity) {
            this.capacity = capacity;
        }

        public synchronized Message take() {
            while (messages.size() == 0) {
                try {
                    System.out.println("没有待消费的消息");
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return messages.removeFirst();
        }

        public synchronized void put(Message message) {
            while (messages.size() > this.capacity) {
                try {
                    System.out.println("当前队列已满");
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            messages.addLast(message);
            this.notifyAll();
            System.out.println("put message:" + message);
        }
    }
}
