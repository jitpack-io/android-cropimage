package com.android.camera.example;

import android.content.Intent;

final class MediaStoreUtils {

    private MediaStoreUtils() {
    }

    public static Intent getPickImageIntent() {
        final Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        return Intent.createChooser(intent, "Select picture");
    }
}
