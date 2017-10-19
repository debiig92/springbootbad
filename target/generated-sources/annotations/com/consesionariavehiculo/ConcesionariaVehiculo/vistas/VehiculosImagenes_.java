package com.consesionariavehiculo.ConcesionariaVehiculo.vistas;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-10-17T21:14:12")
@StaticMetamodel(VehiculosImagenes.class)
public class VehiculosImagenes_ { 

    public static volatile SingularAttribute<VehiculosImagenes, Integer> idmarca;
    public static volatile SingularAttribute<VehiculosImagenes, String> nommarca;
    public static volatile SingularAttribute<VehiculosImagenes, Integer> idmodelo;
    public static volatile SingularAttribute<VehiculosImagenes, String> nommodel;
    public static volatile SingularAttribute<VehiculosImagenes, BigDecimal> preciosalida;
    public static volatile SingularAttribute<VehiculosImagenes, Integer> idvehiculo;
    public static volatile SingularAttribute<VehiculosImagenes, byte[]> imagen;
    public static volatile SingularAttribute<VehiculosImagenes, Integer> idimagenveh;
    public static volatile SingularAttribute<VehiculosImagenes, Integer> anio;
    public static volatile SingularAttribute<VehiculosImagenes, Integer> idestado;

}