package io.grpc.examples.messaging;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import io.grpc.examples.messaging.MessagingGrpc;
import io.grpc.examples.messaging.MessageRequest;
import io.grpc.examples.messaging.MessageResponse;

import java.io.IOException;

public class MessagingServer {
    private final int port;
    private final Server server;

    public MessagingServer(int port) {
        this.port = port;
        this.server = ServerBuilder.forPort(port).addService(new MessagingImpl()).build();
    }

    public void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    public void start() throws IOException {
        server.start();
        System.out.println("Server is listening on port " + port);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.err.println("*** shutting down gRPC server since JVM is shutting down");
            MessagingServer.this.stop();
            System.err.println("*** server shut down");
        }));
    }

    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

     private class MessagingImpl extends MessagingGrpc.MessagingImplBase {
        @Override
        public void sendMessage(MessageRequest request, StreamObserver<MessageResponse> responseObserver) {
            MessageResponse response = MessageResponse.newBuilder()
                    .setResponseId("1")
                    .setStatus("Welcome from server. I've received your message in a sync call.")
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        @Override
        public StreamObserver<MessageRequest> sendReceiveMessage(StreamObserver<MessageResponse> responseObserver) {
            return new StreamObserver<MessageRequest>() {int r=0;String number ;
                @Override
                public void onNext(MessageRequest request) {r++;number=Integer.toString(r );
                    System.out.println("Received message from client: " + request.getText());
                    MessageResponse response = MessageResponse.newBuilder()
                            .setResponseId(number)
                            .setStatus("Message number received by the server: " + number)
                            .build();
                    responseObserver.onNext(response);
                }

                @Override
                public void onError(Throwable t) {
                    System.err.println("Error from client: " + t.getMessage());
                }

                @Override
                public void onCompleted() {
                    System.out.println("Stream completed from client");
                    responseObserver.onCompleted();
                }
            };
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        MessagingServer server = new MessagingServer(5001); // Change the port to match the client
        server.start();
        server.blockUntilShutdown();
    }
}
