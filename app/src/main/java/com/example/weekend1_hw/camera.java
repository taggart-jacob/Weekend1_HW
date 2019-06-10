package com.example.weekend1_hw;

import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.view.View;
import android.content.Intent;
import android.graphics.Bitmap;

public class camera extends AppCompatActivity {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        configureBackBtn();
        Button btnCamera = findViewById(R.id.btnCamera);
        imageView = findViewById(R.id.imageView);

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                //clicking the take picture button starts result activity (taking picture)
                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    //once the capture button has been pressed, the request code, result code, and data captured are passed
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //sets and assigns bitmap variable to look like the data captured by the camera
        Bitmap bitmap = (Bitmap) data.getExtras().get("data");
        //sets the imageView result to be the captured image
        imageView.setImageBitmap(bitmap);
    }

    //configures the back button
    private void configureBackBtn() {
        //sets the back button to the back button view
        Button backBtn = findViewById(R.id.btnBackOnCamera);
        //sets the OnClickListener
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            //whichever button is clicked is passed
            public void onClick(View v) {
                //this closes the app and goes back to the previous instance state
                finish();
            }
        });
    }
}
