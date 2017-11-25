package com.example.alecsandra.library;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.text.TextBlock;
import com.google.android.gms.vision.text.TextRecognizer;

public class ocrFromImage extends AppCompatActivity {

    ImageView imgView;
    Button btnProcess;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ocr_from_image);

        imgView = (ImageView)findViewById(R.id.image_view_ocr_try);
        //display Toast message to see if it gets here - TODO - remove
        Toast.makeText(getApplicationContext(),
                "I took img id!",
                Toast.LENGTH_SHORT
        ).show();

        btnProcess = (Button)findViewById(R.id.button_process_ocr_try);
        txtResult = (TextView)findViewById(R.id.textview_result_ocr_try);

        final Bitmap bitmap = BitmapFactory.decodeResource(
                getApplicationContext().getResources(),
                R.drawable.ocr_try
        );

        imgView.setImageBitmap(bitmap);

        btnProcess.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //display Toast message to see if it gets here - TODO - remove
                Toast.makeText(getApplicationContext(),
                        "I try to read ocr!",
                        Toast.LENGTH_SHORT
                ).show();

                TextRecognizer textRecognizer = new TextRecognizer.Builder(getApplicationContext()).build();
//                if (recognizer.isOperational()){
//                    scan.setText("Could not set up the detector!");
//                    return;
//                }
//                TextRecognizer textRecognizer = new TextRecognizer.Builder(getApplicationContext()).build();
//
//                //TODO - remove
//                Toast.makeText(getApplicationContext(),
//                        "I pass new TextRecognizer.Builder!",
//                        Toast.LENGTH_SHORT
//                ).show();
//
//                if (!textRecognizer.isOperational()) {
//                    Log.e("ERROR", "Detector dependencies are not yep available");
//                    //TODO - remove
//                    Toast.makeText(getApplicationContext(),
//                            "textRecognizer not operational:(!",
//                            Toast.LENGTH_SHORT
//                    ).show();
//                } else {
//                    Frame frame = new Frame.Builder().setBitmap(bitmap).build();
//                    SparseArray<TextBlock> items = textRecognizer.detect(frame);
//                    //verify the size item - TODO - remove
//                    if (items.size() >0 ) {
//                        Toast.makeText(getApplicationContext(),
//                                "I got items!",
//                                Toast.LENGTH_SHORT
//                        ).show();
//
//                    } else {
//                        Toast.makeText(getApplicationContext(),
//                                "I don't have items!",
//                                Toast.LENGTH_SHORT
//                        ).show();
//
//                    }
//
//                    StringBuilder stringBuilder = new StringBuilder();
//                    for (int i = 0; i < items.size(); ++i) {
//                        TextBlock item = items.valueAt(i);
//                        stringBuilder.append(item.getValue());
//                        stringBuilder.append("\n");
//                    }
//                    txtResult.setText(stringBuilder.toString());
//                }
            }
        });
    }
}
