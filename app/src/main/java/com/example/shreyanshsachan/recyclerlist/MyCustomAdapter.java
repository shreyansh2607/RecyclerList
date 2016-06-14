package com.example.shreyanshsachan.recyclerlist;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.MediaStore;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

import static android.support.v4.app.ActivityCompat.startActivityForResult;

/**
 * Created by Shreyansh Sachan on 08-Jun-16.
 */
public class MyCustomAdapter extends RecyclerView.Adapter<MyCustomAdapter.MyViewHolder> {

    static final int REQUEST_IMAGE_CAPTURE = 1;


    Context context;
    ArrayList<Integer> data = new ArrayList<Integer>(Arrays.asList(0,1,2,3));;
    LayoutInflater inflator;
    SQLiteDatabase sqLiteDatabase;

    public MyCustomAdapter(Context context,SQLiteDatabase sqLiteDatabase) {

        this.context=context;
        inflator=LayoutInflater.from(context);
        this.sqLiteDatabase = sqLiteDatabase;


    }

    @Override
    public MyCustomAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int position) {

        View view = inflator.inflate(R.layout.list_item_row,parent,false );
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder myviewholder, final int position) {



        String[] columns = {"_uid","source","path"};
        Cursor cursor = sqLiteDatabase.query("record", columns, null, null, null, null, null);

        while(cursor.moveToNext()){
            String id = cursor.getString(0);
            String source = cursor.getString(1);
            String path = cursor.getString(2);

            String x = String.valueOf(position);

            if( id.equals(String.valueOf(position+1))){
                myviewholder.textview_heading.setText(source);
                myviewholder.textview.setText(path);

               /* if (x.equals("camera")) {
                    myviewholder.imageview.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Log.v("TAG","camera image clicked");

                        }
                    });
                }*/
            }

            myviewholder.imageview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                        Log.v("TAG","camera image clicked");
                    

                        /*Intent i = new Intent(context,Camera2.class);


                        Camera2 cam2 = new Camera2();

                        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                       // start*/


                }
            });


        }


       // myviewholder.textview.setText(data.get(position).title);
        //myviewholder.imageview.setImageResource(data.get(position).imageId);

    }



    @Override
    public int getItemCount() {
        return data.size();
    }







    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textview;
        ImageView imageview;
        TextView textview_heading;

        public MyViewHolder(View itemView) {
            super(itemView);

            textview= (TextView) itemView.findViewById(R.id.txv_row);
            imageview = (ImageView) itemView.findViewById(R.id.img_row);
            textview_heading = (TextView) itemView.findViewById(R.id.txv_row_name);

        }
    }



    //Camera



}
