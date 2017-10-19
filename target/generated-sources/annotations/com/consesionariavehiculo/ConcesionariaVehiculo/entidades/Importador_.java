package com.consesionariavehiculo.ConcesionariaVehiculo.entidades;

import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Contactoimportador;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Importacion;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Rentsalveh;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-10-17T21:14:12")
@StaticMetamodel(Importador.class)
public class Importador_ { 

    public static volatile SingularAttribute<Importador, String> nomimp;
    public static volatile SingularAttribute<Importador, String> corimp;
    public static volatile SingularAttribute<Importador, String> apeimp;
    public static volatile CollectionAttribute<Importador, Rentsalveh> rentsalvehCollection;
    public static volatile CollectionAttribute<Importador, Contactoimportador> contactoimportadorCollection;
    public static volatile SingularAttribute<Importador, String> nomresp;
    public static volatile SingularAttribute<Importador, String> nit;
    public static volatile SingularAttribute<Importador, String> telresp;
    public static volatile SingularAttribute<Importador, String> corresp;
    public static volatile CollectionAttribute<Importador, Importacion> importacionCollection;
    public static volatile SingularAttribute<Importador, String> aperesp;
    public static volatile SingularAttribute<Importador, Character> genimp;
    public static volatile SingularAttribute<Importador, Usuario> usuario;
    public static volatile SingularAttribute<Importador, String> dirimp;

}