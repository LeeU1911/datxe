package vn.datxe.datxe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


import org.json.JSONObject;

import java.net.URISyntaxException;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;


public class Booking extends AppCompatActivity {
    private Socket socket;
    {
        try {
            socket = IO.socket("https://datxe.herokuapp.com");
        } catch (URISyntaxException e) {}
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {

            @Override
            public void call(Object... args) {
                socket.emit("foo", "hi");
            }

        }).on("event", new Emitter.Listener() {

            @Override
            public void call(Object... args) {}

        }).on(Socket.EVENT_DISCONNECT, new Emitter.Listener() {

            @Override
            public void call(Object... args) {}

        });
        socket.connect();
    }

    public void selectSeat(View view){
        int buttonId = view.getId();

    }

    public void connect2Server(){

    }



    @Override
    public void onDestroy() {
        super.onDestroy();

        socket.disconnect();
    }
}
