package io.grpc.examples.messaging;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.TimeUnit;

public class MessagingClient {
    private final ManagedChannel channel;
    private final MessagingGrpc.MessagingBlockingStub blockingStub;
    private final MessagingGrpc.MessagingStub asyncStub;

    public MessagingClient(String host, int port) {
        channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
        blockingStub = MessagingGrpc.newBlockingStub(channel);
        asyncStub = MessagingGrpc.newStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public void sendMessage(String text) {
        MessageRequest request = MessageRequest.newBuilder()
                .setMessageId("10")
                .setSenderId("bechir")
                .setText(text)
                .build();

        MessageResponse response = blockingStub.sendMessage(request);

        System.out.println("Message received from server: " + response);
    }

    public void sendReceiveMessage() {
        StreamObserver<MessageResponse> responseObserver = new StreamObserver<MessageResponse>() {
            @Override
            public void onNext(MessageResponse response) {
                System.out.println("Received reply: " + response.getStatus());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("Error: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("Message stream completed");
            }
        };

        StreamObserver<MessageRequest> requestObserver = asyncStub.sendReceiveMessage(responseObserver);

        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    MessageRequest request = MessageRequest.newBuilder()
                            .setMessageId(Integer.toString(i))
                            .setSenderId("BEN TEKFA")
                            .setText("Message " + i)
                            .build();
                    requestObserver.onNext(request);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
            }

            requestObserver.onCompleted();
        }).start();
    }

    public static void main(String[] args) throws InterruptedException {
        MessagingClient client = new MessagingClient("localhost", 5001); // Change the port to match the server
        client.sendMessage("Hi, I've sent you a message");
        client.sendReceiveMessage();
        client.shutdown();
    }
}
