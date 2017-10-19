package com.consesionariavehiculo.ConcesionariaVehiculo.vistas;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-10-17T21:14:12")
@StaticMetamodel(VehiculosVideo.class)
public class VehiculosVideo_ { 

    public static volatile SingularAttribute<VehiculosVideo, Integer> idmarca;
    public static volatile SingularAttribute<VehiculosVideo, String> nommarca;
    public static volatile SingularAttribute<VehiculosVideo, String> nommodel;
    public static volatile SingularAttribute<VehiculosVideo, Integer> idmodelo;
    public static volatile SingularAttribute<VehiculosVideo, BigDecimal> preciosalida;
    public static volatile SingularAttribute<VehiculosVideo, Integer> idvehiculo;
    public static volatile SingularAttribute<VehiculosVideo, byte[]> imagen;
    public static volatile SingularAttribute<VehiculosVideo, Integer> idimagenveh;
    public static volatile SingularAttribute<VehiculosVideo, Integer> anio;
    public static volatile SingularAttribute<VehiculosVideo, Integer> idestado;

}