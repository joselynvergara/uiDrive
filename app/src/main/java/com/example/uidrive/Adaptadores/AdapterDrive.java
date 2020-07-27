package com.example.uidrive.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uidrive.Entidades.DriveDoc;
import com.example.uidrive.R;

import java.util.ArrayList;

public class AdapterDrive extends RecyclerView.Adapter<AdapterDrive.ViewHolder> implements View.OnClickListener {

    LayoutInflater inflater;
    ArrayList<DriveDoc> model;

    private View.OnClickListener listener;

    public AdapterDrive(Context context, ArrayList<DriveDoc> model){
        this.inflater = LayoutInflater.from(context);
        this.model = model;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.lista_mensajes, parent, false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    public void setOnclickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String titulo = model.get(position).getTitulo();
        String fecha = model.get(position).getFecha();
        int formato= model.get(position).getFormato();
        int documento = model.get(position).getDocumento();
        holder.titulo.setText(titulo);
        holder.imagen.setImageResource(documento);
        holder.fecha.setText(fecha);
        holder.formato.setImageResource(formato);
    }


    @Override
    public int getItemCount() {
        return model.size();
    }

    @Override
    public void onClick(View view) {
        if(listener!=null){
            listener.onClick(view);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView titulo,fecha;
        ImageView imagen, formato;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            titulo=itemView.findViewById(R.id.titulo);
            fecha=itemView.findViewById(R.id.fecha);
            imagen = itemView.findViewById(R.id.documento);
            formato = itemView.findViewById(R.id.formato);
        }

    }

}
