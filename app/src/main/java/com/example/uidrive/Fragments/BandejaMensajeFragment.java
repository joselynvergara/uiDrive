package com.example.uidrive.Fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uidrive.Adaptadores.AdapterDrive;
import com.example.uidrive.Entidades.DriveDoc;
import com.example.uidrive.Interfaces.iComunicaFragmentsMensaje;
import com.example.uidrive.R;

import java.util.ArrayList;

public class BandejaMensajeFragment extends Fragment {

    //private OnFragmentInteractionListener mListener;


    AdapterDrive adapterDrive;
    RecyclerView recyclerViewMensajes;
    ArrayList<DriveDoc> listaDrive;

    EditText txtnombre;

    //Crear referencias para poder realizar la comunicacion entre el fragment detalle
    Activity actividad;
    iComunicaFragmentsMensaje interfaceComunicaFragments;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ban_mensaje_,container,false);
 //       txtnombre = view.findViewById(R.id.txtnombre);

        recyclerViewMensajes = view.findViewById(R.id.recyclerView);
        listaDrive= new ArrayList<>();
        cargarLista();
        mostrarData();
        return view;
    }
    public void cargarLista(){
    listaDrive.add(new DriveDoc("Diapositivas de comercio eléctronico",R.drawable.powerpoint,"Lo has subido hoy.",R.drawable.diapositiva));
        listaDrive.add(new DriveDoc("Slytherin",R.drawable.imagenpng,"Lo has abierto hoy.",R.drawable.harrypotter));
        listaDrive.add(new DriveDoc("Sesión sincronica",R.drawable.video,"23/07/2020",R.drawable.youtube));
        listaDrive.add(new DriveDoc("Exposición",R.drawable.powerpoint,"23/07/2020",R.drawable.diap));
        listaDrive.add(new DriveDoc("Diapositivas de proyecto",R.drawable.powerpoint,"23/07/2020",R.drawable.diapositiva));
        listaDrive.add(new DriveDoc("Diapositivas de proyecto",R.drawable.powerpoint,"23/07/2020",R.drawable.diapositiva));



    }
    private void mostrarData(){
        recyclerViewMensajes.setLayoutManager(new LinearLayoutManager(getContext()));
        adapterDrive = new AdapterDrive(getContext(), listaDrive);
        recyclerViewMensajes.setAdapter(adapterDrive);
try {


    adapterDrive.setOnclickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String nombre = listaDrive.get(recyclerViewMensajes.getChildAdapterPosition(view)).getTitulo();
          //  txtnombre.setText(nombre);
            Toast.makeText(getContext(), "Seleccionó: " + listaDrive.get(recyclerViewMensajes.getChildAdapterPosition(view)).getTitulo(), Toast.LENGTH_SHORT).show();
            //enviar mediante la interface el objeto seleccionado al detalle
            //se envia el objeto completo
            //se utiliza la interface como puente para enviar el objeto seleccionado
            interfaceComunicaFragments.equals(listaDrive.get(recyclerViewMensajes.getChildAdapterPosition(view)));
            //luego en el mainactivity se hace la implementacion de la interface para implementar el metodo enviarpersona
        }
    });
}
catch (Exception e)
{

}
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //esto es necesario para establecer la comunicacion entre la lista y el detalle
        //si el contexto que le esta llegando es una instancia de un activity:
        if(context instanceof Activity){
        //voy a decirle a mi actividad que sea igual a dicho contesto. castin correspondiente:
            this.actividad= (Activity) context;
            ////que la interface icomunicafragments sea igual ese contexto de la actividad:
            interfaceComunicaFragments= (iComunicaFragmentsMensaje) this.actividad;
            //esto es necesario para establecer la comunicacion entre la lista y el detalle
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();
        //mListener = null;
    }

    /*
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }*/
}
