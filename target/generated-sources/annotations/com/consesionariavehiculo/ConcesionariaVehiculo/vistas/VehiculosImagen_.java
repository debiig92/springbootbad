package com.consesionariavehiculo.ConcesionariaVehiculo.vistas;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-10-17T21:14:12")
@StaticMetamodel(VehiculosImagen.class)
public class VehiculosImagen_ { 

    public static volatile SingularAttribute<VehiculosImagen, Integer> idmarca;
    public static volatile SingularAttribute<VehiculosImagen, String> nommarca;
    public static volatile SingularAttribute<VehiculosImagen, String> nommodel;
    public static volatile SingularAttribute<VehiculosImagen, Integer> idmodelo;
    public static volatile SingularAttribute<VehiculosImagen, BigDecimal> preciosalida;
    public static volatile SingularAttribute<VehiculosImagen, Integer> idvehiculo;
    public static volatile SingularAttribute<VehiculosImagen, byte[]> imagen;
    public static volatile SingularAttribute<VehiculosImagen, Integer> idimagenveh;
    public static volatile SingularAttribute<VehiculosImagen, Integer> anio;
    public static volatile SingularAttribute<VehiculosImagen, Integer> idestado;

}