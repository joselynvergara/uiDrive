package com.example.uidrive.Interfaces;

import com.example.uidrive.Entidades.DriveDoc;

public interface iComunicaFragmentsMensaje {
    //esta interface se encarga de realizar la comunicacion entre la lista de personas y el detalle
    public void enviarDoc(DriveDoc mensajes); //se transportara un objeto de tipo persona
    //(En la clase Persona se implementa Serializable para poder transportar un objeteo a otro)
}
