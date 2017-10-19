package com.consesionariavehiculo.ConcesionariaVehiculo.entidades;

import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Menu;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Rol;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-10-17T21:14:12")
@StaticMetamodel(Privilegio.class)
public class Privilegio_ { 

    public static volatile SingularAttribute<Privilegio, Rol> idrol;
    public static volatile SingularAttribute<Privilegio, Integer> idprivilegio;
    public static volatile SingularAttribute<Privilegio, Menu> idelemento;
    public static volatile SingularAttribute<Privilegio, Short> activo;

}