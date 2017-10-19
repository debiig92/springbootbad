package com.consesionariavehiculo.ConcesionariaVehiculo.entidades;

import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Piso;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Respaveh;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-10-17T21:14:12")
@StaticMetamodel(Espavehiculo.class)
public class Espavehiculo_ { 

    public static volatile SingularAttribute<Espavehiculo, Integer> numespa;
    public static volatile SingularAttribute<Espavehiculo, Piso> idpiso;
    public static volatile CollectionAttribute<Espavehiculo, Respaveh> respavehCollection;
    public static volatile SingularAttribute<Espavehiculo, Short> ocupado;
    public static volatile SingularAttribute<Espavehiculo, Integer> idespa;

}