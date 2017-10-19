package com.consesionariavehiculo.ConcesionariaVehiculo.entidades;

import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Autorizacion;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Persona;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-10-17T21:14:12")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> passusuario;
    public static volatile SingularAttribute<Usuario, Integer> idrol;
    public static volatile CollectionAttribute<Usuario, Persona> personaCollection;
    public static volatile CollectionAttribute<Usuario, Autorizacion> autorizacionCollection;
    public static volatile SingularAttribute<Usuario, String> nomusuario;
    public static volatile SingularAttribute<Usuario, Integer> idusuario;
    public static volatile SingularAttribute<Usuario, Integer> activo;

}