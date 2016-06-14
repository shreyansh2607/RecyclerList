package com.example.shreyanshsachan.recyclerlist;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Camera2 extends AppCompatActivity {

    public Camera2(){
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //if (takePictureIntent.resolveActivity(getPackageManager()) != null){
            File photoFile = null;

            try{

                photoFile = createImageFile();
            }
            catch (IOException ex){
                Log.v("TAG", "photo file not created");
            }

            if (photoFile != null){
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(photoFile));
                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
            }
        //}
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    static final int REQUEST_IMAGE_CAPTURE = 1;

    ImageView imageview,imageView2;
    TextView tv;






    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {


        if(requestCode == REQUEST_TAKE_PHOTO && resultCode == RESULT_OK){

            Uri uri = Uri.parse(mCurrentPhotoPath);
            Bitmap myImg = BitmapFactory.decodeFile(uri.getPath());
            //imageview.setImageBitmap(myImg);


            String path = uri.getPath();
            //tv.setText(path);
            //imageView2.setImageURI(uri);


        }
    }


    String mCurrentPhotoPath;
    static final int REQUEST_TAKE_PHOTO = 2;

    public void capture2(View v) {

        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null){
            File photoFile = null;

            try{

                photoFile = createImageFile();
            }
            catch (IOException ex){
                Log.v("TAG", "photo file not created");
            }

            if (photoFile != null){
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(photoFile));
                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
            }
        }


    }

    File image;
    private File createImageFile() throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        mCurrentPhotoPath = "file:" + image.getAbsolutePath();

        Log.v("TAG",mCurrentPhotoPath);
        return image;
    }
}
