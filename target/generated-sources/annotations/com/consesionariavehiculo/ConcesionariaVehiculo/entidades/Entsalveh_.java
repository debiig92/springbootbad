package com.consesionariavehiculo.ConcesionariaVehiculo.entidades;

import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Bodeguero;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Motorista;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Rentsalveh;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Vehiculoremolque;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-10-17T21:14:12")
@StaticMetamodel(Entsalveh.class)
public class Entsalveh_ { 

    public static volatile SingularAttribute<Entsalveh, Motorista> duimotorista;
    public static volatile SingularAttribute<Entsalveh, Integer> identsalveh;
    public static volatile SingularAttribute<Entsalveh, Date> fechaentsal;
    public static volatile SingularAttribute<Entsalveh, Bodeguero> idbodeguero;
    public static volatile SingularAttribute<Entsalveh, Integer> entsalautorizada;
    public static volatile CollectionAttribute<Entsalveh, Rentsalveh> rentsalvehCollection;
    public static volatile SingularAttribute<Entsalveh, Vehiculoremolque> placarem;

}