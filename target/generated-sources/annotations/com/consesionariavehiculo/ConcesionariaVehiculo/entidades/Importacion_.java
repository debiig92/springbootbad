package com.consesionariavehiculo.ConcesionariaVehiculo.entidades;

import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Importador;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-10-17T21:14:12")
@StaticMetamodel(Importacion.class)
public class Importacion_ { 

    public static volatile SingularAttribute<Importacion, Integer> cantveh;
    public static volatile SingularAttribute<Importacion, Importador> nit;
    public static volatile SingularAttribute<Importacion, Integer> idimport;
    public static volatile SingularAttribute<Importacion, Date> fecimport;

}