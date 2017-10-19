package com.consesionariavehiculo.ConcesionariaVehiculo.entidades;

import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Bodeguero;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Piso;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-10-17T21:14:12")
@StaticMetamodel(Bodega.class)
public class Bodega_ { 

    public static volatile CollectionAttribute<Bodega, Bodeguero> bodegueroCollection;
    public static volatile SingularAttribute<Bodega, Integer> idbodega;
    public static volatile SingularAttribute<Bodega, String> dirbodega;
    public static volatile SingularAttribute<Bodega, Integer> maxpisos;
    public static volatile CollectionAttribute<Bodega, Piso> pisoCollection;
    public static volatile SingularAttribute<Bodega, Integer> cantpisos;

}