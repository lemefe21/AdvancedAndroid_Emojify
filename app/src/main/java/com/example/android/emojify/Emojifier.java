package com.example.android.emojify;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.widget.Toast;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;

public class Emojifier {

    public static void detectFaces(Context context, Bitmap bitmap) {

        // Create the face detector, disable tracking and enable classifications
        FaceDetector detector = new FaceDetector.Builder(context)
                .setTrackingEnabled(false)
                .setClassificationType(FaceDetector.ALL_CLASSIFICATIONS)
                .build();
        
        //Build the frame
        Frame frame = new Frame.Builder().setBitmap(bitmap).build();
        
        //Detect faces
        SparseArray<Face> faces = detector.detect(frame);

        //Show the number of faces
        Toast.makeText(context, "detectFaces: " + faces.size(), Toast.LENGTH_SHORT);

        if(faces.size() == 0) {
            Toast.makeText(context, R.string.no_faces_message, Toast.LENGTH_SHORT).show();
        }

        detector.release();

    }


}
