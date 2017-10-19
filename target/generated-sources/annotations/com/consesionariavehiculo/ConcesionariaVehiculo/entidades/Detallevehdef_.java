package com.consesionariavehiculo.ConcesionariaVehiculo.entidades;

import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Reparacion;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Vehiculo;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-10-17T21:14:12")
@StaticMetamodel(Detallevehdef.class)
public class Detallevehdef_ { 

    public static volatile CollectionAttribute<Detallevehdef, Reparacion> reparacionCollection;
    public static volatile SingularAttribute<Detallevehdef, Integer> iddetveh;
    public static volatile SingularAttribute<Detallevehdef, Integer> reparado;
    public static volatile SingularAttribute<Detallevehdef, Vehiculo> idvehiculo;
    public static volatile SingularAttribute<Detallevehdef, String> detalledef;

}