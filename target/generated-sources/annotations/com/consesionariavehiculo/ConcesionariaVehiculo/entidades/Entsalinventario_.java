package com.consesionariavehiculo.ConcesionariaVehiculo.entidades;

import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Catalogovehiculo;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-10-17T21:14:12")
@StaticMetamodel(Entsalinventario.class)
public class Entsalinventario_ { 

    public static volatile SingularAttribute<Entsalinventario, Integer> identsalinve;
    public static volatile SingularAttribute<Entsalinventario, Integer> idusuariosol;
    public static volatile SingularAttribute<Entsalinventario, Date> fechaingreso;
    public static volatile SingularAttribute<Entsalinventario, Date> fechasalida;
    public static volatile CollectionAttribute<Entsalinventario, Catalogovehiculo> catalogovehiculoCollection;
    public static volatile SingularAttribute<Entsalinventario, Integer> idusuarioacep;

}