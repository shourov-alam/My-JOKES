package com.shourov.myjokes;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {


Context context;

    private String[] data;

    public Adapter(Context context,String [] data){
    this.context=context;
        this.data=data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row,parent,false);




        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {



        final String myData = data[position];

        holder.tx.setText(myData);

        holder.bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT,myData);
                intent.setType("text/plain");
                intent=Intent.createChooser(intent,"Share By");


                holder.itemView.getContext().startActivity(intent);

            }
        });

        holder.bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    ClipboardManager manager = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB) {
                        ClipData data = ClipData.newPlainText("data", myData);
                        manager.setPrimaryClip(data);
                        Toast.makeText(context,"Jokes Copied",Toast.LENGTH_SHORT).show();
                    } else {
                        manager.setText(myData);
                        Toast.makeText(context,"Jokes Copied",Toast.LENGTH_SHORT).show();
                    }
                }
                catch (Exception e) {                  }


            }
        });





    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
         TextView tx;
         ImageView bt;
         ImageView bt2;

        public MyViewHolder(@NonNull View itemView) {

            super(itemView);
            tx=itemView.findViewById(R.id.txt);
            bt=itemView.findViewById(R.id.btn2);
            bt2=itemView.findViewById(R.id.btn1);



        }
    }

}
