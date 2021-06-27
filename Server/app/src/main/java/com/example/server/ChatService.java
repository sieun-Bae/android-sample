package com.example.server;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatService extends Service {
    public ChatService() {

    }

    @Override
    public void onCreate() {
        super.onCreate();
        ServerThread thread = new ServerThread();
        thread.start();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    class ServerThread extends Thread {
        public void run() {
            int port = 5001;
            try {
                ServerSocket server = new ServerSocket(port);
                Log.d("ServerThread", "서버가 실행됨.");
                while (true) {
                    Socket socket = server.accept();

                    ObjectInputStream instream = new ObjectInputStream(socket.getInputStream());//일종의 pipe
                    Object input = instream.readObject();
                    Log.d("ServerThread", "input: "+input);

                    ObjectOutputStream outstream = new ObjectOutputStream(socket.getOutputStream());
                    outstream.writeObject(input + "from server.");
                    outstream.flush(); //write를 하면 버퍼에 남아있을수있기에 flush 필수!
                    Log.d("ServerThread", "output 보냄.");
                    socket.close(); //리소스가 한정적이기에 close로 끊어줍니다.
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}