package com.consesionariavehiculo.ConcesionariaVehiculo.entidades;

import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Bodega;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Espavehiculo;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-10-17T21:14:12")
@StaticMetamodel(Piso.class)
public class Piso_ { 

    public static volatile CollectionAttribute<Piso, Espavehiculo> espavehiculoCollection;
    public static volatile SingularAttribute<Piso, Integer> idpiso;
    public static volatile SingularAttribute<Piso, Integer> numpiso;
    public static volatile SingularAttribute<Piso, Bodega> idbodega;
    public static volatile SingularAttribute<Piso, Integer> maxespa;
    public static volatile SingularAttribute<Piso, Integer> cantespa;

}