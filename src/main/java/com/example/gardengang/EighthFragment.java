package com.example.gardengang;

import static android.content.ContentValues.TAG;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.Navigation;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class EighthFragment extends AppCompatActivity {
    private String deviceName = null;
    public static Handler handler;
    public static BluetoothSocket mmSocket;
    public static ConnectedThread connectedThread;
    public static CreateConnectThread createConnectThread;
    String arduinoMsg1 = "0";
    String arduinoMsg2 = "0";
    String arduinoMsg3 = "0";
    String arduinoMsg4 = "0";
    String arduinoMsg5 = "0";
    String arduinoMsg6 = "0";
    String arduinoMsg7 = "0";
    String arduinoMsg8 = "0";
    String arduinoMsg9 = "0";
    String arduinoMsg10 = "0";
    int count = 0;
    double tampF1, tampF2, tampFavg;
    long tC1, tC2, tCavg, tM1, tM2, tMavg, tP1, tP2, tPavg;
    long[] graphTemp = new long[120];
    long[] graphEx = new long[120];
    long[] graphpH = new long[120];
    long[] graphMoist = new long[120];
    DecimalFormat df = new DecimalFormat("#.##");

    // Used in bluetooth handler to identify message status
    private final static int CONNECTING_STATUS = 1;
    // Used in bluetooth handler to identify message update
    private final static int MESSAGE_READ = 2;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_eighth);
        ((EighthFragment)this).getSupportActionBar().setTitle("Bluetooth");
        String key1 = "";
        String key2 = "";
        Fragment fragment = new Fragment();
        Bundle bundle = new Bundle();

        // UI Initialization
        final Button buttonConnect = findViewById(R.id.buttonConnect);
        final Toolbar toolbar = findViewById(R.id.toolbar);
        final ProgressBar progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);
        final TextView textViewInfo = findViewById(R.id.textViewInfo);
        final TextView textViewInfoAdd = findViewById(R.id.textViewInfoAdd);
        final Button buttonToggle = findViewById(R.id.buttonToggle);
        buttonToggle.setEnabled(false);
        final EditText e1_data = findViewById(R.id.simpleEditText);
        // Boolean for button clicked or not
        AtomicInteger clicked = new AtomicInteger(0);

        // If a bluetooth device has been selected from SelectDeviceActivity
        deviceName = getIntent().getStringExtra("deviceName");
        if (deviceName != null){
            // Get the device address to make BT Connection
            String deviceAddress = getIntent().getStringExtra("deviceAddress");
            // Show progress and connection status
            toolbar.setSubtitle("Connecting to " + deviceName + "...");
            progressBar.setVisibility(View.VISIBLE);
            buttonConnect.setEnabled(false);

            /*
            This is the most important piece of code. When "deviceName" is found
            the code will call a new thread to create a bluetooth connection to the
            selected device (see the thread code below)
             */
            BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
            createConnectThread = new CreateConnectThread(bluetoothAdapter, deviceAddress);
            createConnectThread.start();
        }


        // Second most important piece of Code. GUI Handler
        handler = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(Message msg){
                switch (msg.what){
                    case CONNECTING_STATUS:
                        switch(msg.arg1){
                            case 1:
                                toolbar.setSubtitle("Connected to " + deviceName);
                                progressBar.setVisibility(View.GONE);
                                buttonConnect.setEnabled(true);
                                buttonToggle.setEnabled(true);
                                clicked.set(1);
                                break;
                            case -1:
                                toolbar.setSubtitle("Device fails to connect");
                                progressBar.setVisibility(View.GONE);
                                buttonConnect.setEnabled(true);
                                clicked.set(1);
                                break;
                        }
                        break;

                    case MESSAGE_READ:
                        // Take data, and get rid of newline and carriage characters
                        String message = msg.obj.toString(); // Read message from Arduino
                        message = message.replaceAll("\\n", "");
                        message = message.replaceAll("\\r", "");

                        // Test exception
                        long arduinoInt;
                        try{
                            arduinoInt = Long.parseLong(message);
                        }
                        catch(NumberFormatException e){
                            arduinoInt = 0;
                        }

                        /* ====================== Parse Data ====================== */
                        // Moisture
                        long thing0 = arduinoInt >> (8*0) & 0xff;
                        // Temperature
                        long thing1 = arduinoInt >> (8*1) & 0xff;
                        // id, light exposure, pH
                        long thing2 = arduinoInt >> (8*2) & 0xff;
                        long id = thing2 >> 6;
                        long exposure = (thing2 >> 5) & 0x01;
                        long pH = thing2 & 0x1F;
                        // Checksum
                        long thing3 = arduinoInt >> (8*3) & 0xff;

                        int count0 = Long.bitCount(thing0);
                        int count1 = Long.bitCount(thing1);
                        int count2 = Long.bitCount(thing2);
                        int countSum = count0 + count1 + count2;

                        if(countSum == thing3){
                            // Read message from Arduino
                            if(id == 1){
                                arduinoMsg1 = Long.toString(thing0); //moist
                                arduinoMsg2 = Long.toString(thing1); //temp
                                arduinoMsg3 = Long.toString(id);
                                arduinoMsg4 = Long.toString(exposure);
                                arduinoMsg5 = Long.toString(pH);
                            }
                            if(id == 2){
                                arduinoMsg6 = Long.toString(thing0); //moist
                                arduinoMsg7 = Long.toString(thing1); //temp
                                arduinoMsg8 = Long.toString(id);
                                arduinoMsg9 = Long.toString(exposure);
                                arduinoMsg10 = Long.toString(pH);
                            }

                            // Parse and calculate averages
                            tC1 = Long.parseLong(arduinoMsg2);
                            tC2 = Long.parseLong(arduinoMsg7);
                            tM1 = Long.parseLong(arduinoMsg1);
                            tM2 = Long.parseLong(arduinoMsg6);
                            tP1 = Long.parseLong(arduinoMsg5);
                            tP2 = Long.parseLong(arduinoMsg10);
                            tampF1 = 1.8*tC1+32;
                            tampF2 = 1.8*tC2+32;

                            tCavg = (tC1+tC2)/2;
                            tampFavg = (tampF1+tampF2)/2;
                            tMavg = (tM1+tM2)/2;
                            tPavg = (tP1+tP2)/2;

                            graphTemp[count] = tCavg;
                            graphEx[count] = exposure;
                            graphpH[count] = 7;
                            graphMoist[count] = tMavg;
                            count++;
                            SharedViewModel.setGraphTemp(graphTemp);
                            SharedViewModel.setGraphEx(graphEx);
                            SharedViewModel.setGraphpH(graphpH);
                            SharedViewModel.setGraphMoist(graphMoist);
                            SharedViewModel.setCount(count);
                            if(count == 120) {
                                count = 0;
                            }
                        }
                        else{
                            // Bit flip occurred if the checksum does not check out
                            arduinoMsg1 = "Bit Flip Occurred";
                            arduinoMsg2 = "Bit Flip Occurred";
                            arduinoMsg3 = "Bit Flip Occurred";
                            arduinoMsg4 = "Bit Flip Occurred";
                            arduinoMsg5 = "Bit Flip Occurred";
                            arduinoMsg6 = "Bit Flip Occurred";
                            arduinoMsg7 = "Bit Flip Occurred";
                            arduinoMsg8 = "Bit Flip Occurred";
                            arduinoMsg9 = "Bit Flip Occurred";
                            arduinoMsg10 = "Bit Flip Occurred";
                        }

                        String var1 = "";
                        switch (arduinoMsg4){
                            case "0":
                                var1 = "False";
                                break;
                            case "1":
                                var1 = "True";
                                break;
                        }

                        String var2 = "";
                        switch (arduinoMsg9){
                            case "0":
                                var2 = "False";
                                break;
                            case "1":
                                var2 = "True";
                                break;
                        }

                        // Add true/false
                        textViewInfo.setTextColor(Color.rgb(68, 134, 199));
                        String arduinoMsgFull1 =  "\n ID: " + arduinoMsg3.toLowerCase()
                                + "\n Temperature: " + arduinoMsg2.toLowerCase() + " °C"
                                + "\n Moisture: " + arduinoMsg1.toLowerCase()  + " %"
                                + "\n pH: " + "7" //arduinoMsg5.toLowerCase()
                                + "\n Light Exposure: " + arduinoMsg4.toLowerCase() + "/" + var1;

                        textViewInfoAdd.setTextColor(Color.rgb(68, 134, 199));
                        String arduinoMsgFull2 =  "\n ID: " + arduinoMsg8.toLowerCase()
                                + "\n Temperature: " + arduinoMsg7.toLowerCase() + " °C"
                                + "\n Moisture: " + arduinoMsg6.toLowerCase()  + " %"
                                + "\n pH: " + "0" //arduinoMsg10.toLowerCase()
                                + "\n Light Exposure: " + arduinoMsg9.toLowerCase() + "/" + var2;

                        textViewInfo.setText(arduinoMsgFull1);
                        bundle.putString(key1, arduinoMsgFull1);
                        textViewInfoAdd.setText(arduinoMsgFull2);
                        bundle.putString(key2, arduinoMsgFull2);
                        fragment.setArguments(bundle);

                        // Getters and setters for variables
                        SharedViewModel.setTempC1(arduinoMsg2);
                        SharedViewModel.setTempF1(df.format(tampF1));
                        SharedViewModel.setMoist1(arduinoMsg1);
                        SharedViewModel.setpH1("7"); //arduinoMsg5
                        SharedViewModel.setEx1(var1);
                        SharedViewModel.setTempC2(arduinoMsg7);
                        SharedViewModel.setTempF2(df.format(tampF2));
                        SharedViewModel.setMoist2(arduinoMsg6);
                        SharedViewModel.setpH2("7"); //arduinoMsg10
                        SharedViewModel.setEx2(var2);
                        SharedViewModel.setTempCavg(Long.toString(tCavg));
                        SharedViewModel.setTempFavg(df.format(tampFavg));
                        SharedViewModel.setMavg(Long.toString(tMavg));
                        SharedViewModel.setPavg("7");

//                        //Set Fragment class Arguments (WHY NO WORK?)
//                        Bundle bundle6 = new Bundle();
//                        bundle6.putString("temperature1", arduinoMsg2);
//                        bundle6.putString("moisture1", arduinoMsg1);
//                        bundle6.putString("pH1", arduinoMsg5);
//                        bundle6.putString("exposure1", arduinoMsg4);
//                        SixthFragment fragobj = new SixthFragment();
//                        fragobj.setArguments(bundle6);
                }
            }
        };

        // Select Bluetooth Device
        buttonConnect.setOnClickListener(view1 -> {
            // Move to adapter list
            Intent intent = new Intent(view1.getContext(), SelectDeviceActivity.class);
            startActivity(intent);
        });

        // Check sensor numbers
        e1_data.setOnClickListener(view1 -> {
            String cmdText = e1_data.getText().toString();
            if(TextUtils.isDigitsOnly(cmdText) == true && cmdText != "0" && cmdText != null && (clicked.get() == 1 || (clicked.get() == 3))){
                buttonToggle.setEnabled(true);
                clicked.set(2);
            }
            if(TextUtils.isDigitsOnly(cmdText) == false || cmdText == null){
                buttonToggle.setEnabled(false);
                clicked.set(3);
            }
        });

        // Button to send sensor data
        buttonToggle.setOnClickListener(view1 -> {
            String cmdText = null;
            int clickedState = clicked.get();

            switch (clickedState){
                case 0:
                case 1:
                    cmdText = null;
                    break;
                case 2:
                    cmdText = e1_data.getText().toString();
                    break;
            }
            // Send command to ATMEGA328P
            connectedThread.write(cmdText);
        });
    }

    /* ============================ Thread to Create Bluetooth Connection =================================== */
    public static class CreateConnectThread extends Thread {

        public CreateConnectThread(BluetoothAdapter bluetoothAdapter, String address) {
            /*
            Use a temporary object that is later assigned to mmSocket
            because mmSocket is final.
             */
            BluetoothDevice bluetoothDevice = bluetoothAdapter.getRemoteDevice(address);
            BluetoothSocket tmp = null;
            UUID uuid = bluetoothDevice.getUuids()[0].getUuid();

            try {
                /*
                Get a BluetoothSocket to connect with the given BluetoothDevice.
                Due to Android device varieties,the method below may not work fo different devices.
                You should try using other methods i.e. :
                tmp = device.createRfcommSocketToServiceRecord(MY_UUID);
                 */
                tmp = bluetoothDevice.createInsecureRfcommSocketToServiceRecord(uuid);

            } catch (IOException e) {
                Log.e(TAG, "Socket's create() method failed", e);
            }
            mmSocket = tmp;
        }

        public void run() {
            // Cancel discovery because it otherwise slows down the connection.
            BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
            bluetoothAdapter.cancelDiscovery();
            try {
                // Connect to the remote device through the socket. This call blocks
                // until it succeeds or throws an exception.
                mmSocket.connect();
                Log.e("Status", "Device connected");
                handler.obtainMessage(CONNECTING_STATUS, 1, -1).sendToTarget();
            } catch (IOException connectException) {
                // Unable to connect; close the socket and return.
                try {
                    mmSocket.close();
                    Log.e("Status", "Cannot connect to device");
                    handler.obtainMessage(CONNECTING_STATUS, -1, -1).sendToTarget();
                } catch (IOException closeException) {
                    Log.e(TAG, "Could not close the client socket", closeException);
                }
                return;
            }

            // The connection attempt succeeded. Perform work associated with
            // the connection in a separate thread.
            connectedThread = new ConnectedThread(mmSocket);
            connectedThread.run();
        }

        // Closes the client socket and causes the thread to finish.
        public void cancel() {
            try {
                mmSocket.close();
            } catch (IOException e) {
                Log.e(TAG, "Could not close the client socket", e);
            }
        }
    }

    /* =============================== Thread for Data Transfer =========================================== */
    public static class ConnectedThread extends Thread {
        private final BluetoothSocket mmSocket;
        private final InputStream mmInStream;
        private final OutputStream mmOutStream;

        public ConnectedThread(BluetoothSocket socket) {
            mmSocket = socket;
            InputStream tmpIn = null;
            OutputStream tmpOut = null;

            // Get the input and output streams, using temp objects because
            // member streams are final
            try {
                tmpIn = socket.getInputStream();
                tmpOut = socket.getOutputStream();
            } catch (IOException e) {
                System.out.println("caught");
            }

            mmInStream = tmpIn;
            mmOutStream = tmpOut;
        }

        public void run() {
            byte[] buffer = new byte[1024];  // buffer store for the stream
            int bytes = 0; // bytes returned from read()
            // Keep listening to the InputStream until an exception occurs
            while (true) {
                try {
                    /*
                    Read from the InputStream from Arduino until termination character is reached.
                    Then send the whole String message to GUI Handler.
                     */
                    buffer[bytes] = (byte) mmInStream.read();
                    String readMessage;
                    if (buffer[bytes] == '\n') {
                        readMessage = new String(buffer, 0, bytes);
                        Log.e("ATMEGA328P Message", readMessage);
                        handler.obtainMessage(MESSAGE_READ, readMessage).sendToTarget();
                        bytes = 0;
                    } else {
                        bytes++;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }

        /* Call this from the main activity to send data to the remote device */
        public void write(String input) {
            byte[] bytes = input.getBytes(); //converts entered String into bytes
            try {
                mmOutStream.write(bytes);
            } catch (IOException e) {
                Log.e("Send Error", "Unable to send message", e);
            }
        }

        /* Call this from the main activity to shutdown the connection */
        public void cancel() {
            try {
                mmSocket.close();
            } catch (IOException e) {
                System.out.println("caught mmSocket");
            }
        }
    }

    /* ============================ Terminate Connection at BackPress ====================== */
//    public void onBackPressed() {
//        // Terminate Bluetooth Connection and close app
//        if (createConnectThread != null) {
//            createConnectThread.cancel();
//        }
//        Intent a = new Intent(Intent.ACTION_MAIN);
//        a.addCategory(Intent.CATEGORY_HOME);
//        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        startActivity(a);
//    }
}
