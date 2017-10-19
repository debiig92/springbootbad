package com.consesionariavehiculo.ConcesionariaVehiculo.entidades;

import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Bodega;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Entsalveh;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-10-17T21:14:12")
@StaticMetamodel(Bodeguero.class)
public class Bodeguero_ { 

    public static volatile CollectionAttribute<Bodeguero, Entsalveh> entsalvehCollection;
    public static volatile SingularAttribute<Bodeguero, Bodega> idbodega;
    public static volatile SingularAttribute<Bodeguero, Integer> idbodeguero;
    public static volatile SingularAttribute<Bodeguero, String> apebodeguero;
    public static volatile SingularAttribute<Bodeguero, String> nombodeguero;
    public static volatile SingularAttribute<Bodeguero, String> telbodeguero;
    public static volatile SingularAttribute<Bodeguero, String> dirbodeguero;

}