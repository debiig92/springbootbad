package com.consesionariavehiculo.ConcesionariaVehiculo.entidades;

import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Cliente;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Usuario;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Vehiculo;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-10-17T21:14:12")
@StaticMetamodel(Clienteveh.class)
public class Clienteveh_ { 

    public static volatile SingularAttribute<Clienteveh, Integer> entregado;
    public static volatile SingularAttribute<Clienteveh, Vehiculo> idvehiculo;
    public static volatile SingularAttribute<Clienteveh, Integer> idclienteveh;
    public static volatile SingularAttribute<Clienteveh, Date> fechacompra;
    public static volatile SingularAttribute<Clienteveh, Cliente> duicliente;
    public static volatile SingularAttribute<Clienteveh, Usuario> idusuario;

}