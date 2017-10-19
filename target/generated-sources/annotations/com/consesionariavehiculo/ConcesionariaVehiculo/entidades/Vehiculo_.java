package com.consesionariavehiculo.ConcesionariaVehiculo.entidades;

import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Catalogovehiculo;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Clienteveh;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Detallevehdef;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Estado;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Importacion;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Modelo;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Multimediaveh;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Rentsalveh;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Respaveh;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-10-17T21:14:12")
@StaticMetamodel(Vehiculo.class)
public class Vehiculo_ { 

    public static volatile SingularAttribute<Vehiculo, BigDecimal> costoacumulado;
    public static volatile CollectionAttribute<Vehiculo, Detallevehdef> detallevehdefCollection;
    public static volatile CollectionAttribute<Vehiculo, Multimediaveh> multimediavehCollection;
    public static volatile SingularAttribute<Vehiculo, Integer> idvehiculo;
    public static volatile CollectionAttribute<Vehiculo, Rentsalveh> rentsalvehCollection;
    public static volatile SingularAttribute<Vehiculo, BigDecimal> costoinicial;
    public static volatile CollectionAttribute<Vehiculo, Clienteveh> clientevehCollection;
    public static volatile SingularAttribute<Vehiculo, Importacion> idimport;
    public static volatile SingularAttribute<Vehiculo, Estado> idestado;
    public static volatile CollectionAttribute<Vehiculo, Respaveh> respavehCollection;
    public static volatile SingularAttribute<Vehiculo, Modelo> idmodelo;
    public static volatile SingularAttribute<Vehiculo, BigDecimal> preciosalida;
    public static volatile CollectionAttribute<Vehiculo, Catalogovehiculo> catalogovehiculoCollection;
    public static volatile SingularAttribute<Vehiculo, Integer> anio;

}