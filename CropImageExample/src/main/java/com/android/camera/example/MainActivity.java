package com.android.camera.example;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.android.camera.CropImageIntentBuilder;

import java.io.File;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private final static int REQUEST_PICTURE = 1;
    private final static int REQUEST_CROP_PICTURE = 2;

    @Bind(R.id.imageView)
    ImageView imageView;
    @Bind(R.id.button)
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @OnClick(R.id.button)
    public void onClickButton() {
        startActivityForResult(MediaStoreUtils.getPickImageIntent(), REQUEST_PICTURE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        final File croppedImageFile = new File(getFilesDir(), "test.jpg");
        if ((requestCode == REQUEST_PICTURE) && (resultCode == RESULT_OK)) {
            final Uri croppedImage = Uri.fromFile(croppedImageFile);
            final CropImageIntentBuilder cropImage = new CropImageIntentBuilder(
                    imageView.getMeasuredWidth(), imageView.getMeasuredHeight(), croppedImage)
                    .setOutlineColor(ContextCompat.getColor(this, R.color.accent))
                    .setSourceImage(data.getData());
            startActivityForResult(cropImage.getIntent(this), REQUEST_CROP_PICTURE);
        } else if ((requestCode == REQUEST_CROP_PICTURE) && (resultCode == RESULT_OK)) {
            imageView.setImageBitmap(BitmapFactory.decodeFile(croppedImageFile.getAbsolutePath()));
            imageView.setVisibility(View.VISIBLE);
            button.setVisibility(View.GONE);
        }
    }
}