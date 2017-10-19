package com.consesionariavehiculo.ConcesionariaVehiculo.entidades;

import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Clienteveh;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-10-17T21:14:12")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile SingularAttribute<Cliente, String> apecliente;
    public static volatile SingularAttribute<Cliente, String> nomcliente;
    public static volatile CollectionAttribute<Cliente, Clienteveh> clientevehCollection;
    public static volatile SingularAttribute<Cliente, String> dircliente;
    public static volatile SingularAttribute<Cliente, String> telcliente;
    public static volatile SingularAttribute<Cliente, String> duicliente;

}