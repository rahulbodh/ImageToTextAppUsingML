package com.example.text2imageapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Scanner_activity extends AppCompatActivity {
    private Button capture;
    private ImageView camImage;
    private TextView resultText;
    private Button detectTextBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_scanner);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        camImage = findViewById(R.id.idIVCaptureImage);
        resultText = findViewById(R.id.idTVDetectedText);
        detectTextBtn = findViewById(R.id.idButtonDetect);
        capture = findViewById(R.id.idButtonSnap);
        
        detectTextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetectText();
            }
        });
        
        capture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (CheckCameraPermission()){
                    CaptureImage();
                }else {
                    RequestCameraPermission();
                }
            }
        });
        
    }

    private void CaptureImage() {
    }

    private void RequestCameraPermission() {
        int PERMISSION_CODE = 200;
        ActivityCompat.requestPermissions(this,new String[]{
                Manifest.permission.CAMERA
        },PERMISSION_CODE);
        
    }

    private boolean CheckCameraPermission() {
        int cameraPermission = ContextCompat.checkSelfPermission(getApplicationContext(),CAMERA_SERVICE);
        return cameraPermission == PackageManager.PERMISSION_GRANTED;
    }

    private void DetectText() {
    }
}
