package com.consesionariavehiculo.ConcesionariaVehiculo.entidades;

import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Entsalveh;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Importador;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Vehiculo;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-10-17T21:14:12")
@StaticMetamodel(Rentsalveh.class)
public class Rentsalveh_ { 

    public static volatile SingularAttribute<Rentsalveh, String> motivo;
    public static volatile SingularAttribute<Rentsalveh, Entsalveh> identsalveh;
    public static volatile SingularAttribute<Rentsalveh, Importador> nit;
    public static volatile SingularAttribute<Rentsalveh, Vehiculo> idvehiculo;
    public static volatile SingularAttribute<Rentsalveh, BigDecimal> costoentradabodega;
    public static volatile SingularAttribute<Rentsalveh, Integer> idrentsalveh;

}