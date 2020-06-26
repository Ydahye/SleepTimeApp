package com.ydhproject.sleepapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.camerakit.CameraKitView;


public class CameraFragment extends Fragment {
 private CameraKitView cameraKitView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view = (ViewGroup)inflater.inflate( R.layout.fragment_camera,container,false );

       cameraKitView=view.findViewById( R.id.camera );





        return view;
    }
    @Override
    public void onStart() {
        super.onStart();
        cameraKitView.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        cameraKitView.onResume();
    }

    @Override
    public void onPause() {
        cameraKitView.onPause();
        super.onPause();
    }

    @Override
    public void onStop() {
        cameraKitView.onStop();
        super.onStop();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult( requestCode, permissions, grantResults );
        cameraKitView.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
