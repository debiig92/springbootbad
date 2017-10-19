/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.consesionariavehiculo.ConcesionariaVehiculo;

import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Bodega;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Detallevehdef;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Espavehiculo;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Estado;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Motorista;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Piso;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Reparacion;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Respaveh;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Saltaller;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Taller;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Usuario;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Vehiculo;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Vehiculo_Espacio;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Vehiculo_Espacio_Bodega;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Vehiculo_Taller;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Vehiculo_Remolque;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Vehiculo_Reparacion;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Vehiculo_Saltaller;
import com.consesionariavehiculo.ConcesionariaVehiculo.entidades.Vehtaller;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.BodegaDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.DetalleVehDefectoDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.EspaciosDetalleDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.EspavehiculoDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.MotoristaDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.PisoDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.ReparacionDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.RespavehDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.SaltallerDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.TallerRepo;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.VehiculoDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.Vehiculo_EspacioDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.Vehiculo_Espacio_BodegaDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.Vehiculo_RemolqueDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.Vehiculo_TallerDAO;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.Vehiculo_ReparacionDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.Vehiculo_SaltallerDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.VehiculosVentaDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.VehiculosViewDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.repositorio.VehtallerDAO;
import com.consesionariavehiculo.ConcesionariaVehiculo.vistas.EspaciosDetalle;
import com.consesionariavehiculo.ConcesionariaVehiculo.vistas.Vehiculos;
import com.consesionariavehiculo.ConcesionariaVehiculo.vistas.Vehiculosventa;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author JC
 */
@Controller
public class BodegaController {

    Usuario usuario;
    Bodega bod;
    @Autowired
    private BodegaDAO bodegadao;
    @Autowired
    private Vehiculo_RemolqueDAO ve_rem;
    @Autowired
    private MotoristaDAO motoristaDao;
    @Autowired
    private TallerRepo tallerDao;
    @Autowired
    private Vehiculo_TallerDAO vehiculo_tallerDAO;
    @Autowired
    private SaltallerDAO saltallerDAO;
    @Autowired
    private Vehiculo_ReparacionDAO vehiculo_reparacionDAO;
    @Autowired
    private Vehiculo_SaltallerDAO vehiculo_saltallerDAO;
    @Autowired
    private VehtallerDAO vehtallerDAO;
    @Autowired
    private PisoDAO pisoDAO;
    @Autowired
    private EspavehiculoDAO espavehiculoDAO;
    @Autowired
    private VehiculosViewDAO vehiculoDAO;
    @Autowired
    private Vehiculo_EspacioDAO vehiculo_espacioDAO;
    @Autowired
    private RespavehDAO respavehDAO;
    @Autowired
    private Vehiculo_Espacio_BodegaDAO vehiculo_espacio_bodegaDAO;
    @Autowired
    private DetalleVehDefectoDAO defectoDAO;
    @Autowired
    private ReparacionDAO reparacionDAO;
     @Autowired
    private EspaciosDetalleDAO espadetDAO;
    @RequestMapping("/IngresarBodega")
    public ModelAndView bodega(HttpSession session) {
        Usuario u = obtenerUsuario(session);
      

        return new ModelAndView("Bodega/RegistroBodega").addObject("usuario", u);
    }

    @RequestMapping(value = "/AddBodega", method = RequestMethod.POST)
    public String GuardarBodega(@ModelAttribute Bodega bodega,HttpSession session) {
         Usuario u = obtenerUsuario(session);
        long acumulador = 0;

        if (bodegadao.count() == 0) {
            bodega.setIdbodega(1);
        } else {
            acumulador = bodegadao.count();
        }
        //convertimo ese valor a entero
        int valor = (int) acumulador;
        bodega.setIdbodega(valor + 1);
        bodegadao.save(bodega);

        return "redirect:/verBodega";
    }

    //Lista de datos de bodega
    @RequestMapping("/verBodega")
    public ModelAndView ListBodega(HttpSession session) {
         Usuario u = obtenerUsuario(session);
        List<Bodega> list = (List<Bodega>) bodegadao.findAll();
        return new ModelAndView("Bodega/ObtenerDatosBodega", "bodegaList", list).addObject("usuario", u);
    }

    //Edicion de los datos de Bodega   
    @RequestMapping("/editarBodega/{idbodega}")
    public String editarTaller(@PathVariable Integer idbodega, Model model,HttpSession session) {
         Usuario u = obtenerUsuario(session);
         model.addAttribute("usuario",u);
        model.addAttribute("bodega", bodegadao.findOne(idbodega));
        return "Bodega/editarBodega";
    }

    //actualizar datos en la tabla bodega
    @RequestMapping(value = "/editBodega", method = RequestMethod.POST)
    public String editBodega(Bodega bodega,HttpSession session) {
        bodegadao.save(bodega);
        return "redirect:/verBodega";
    }

    public Usuario obtenerUsuario(HttpSession session) {
        usuario = (Usuario) session.getAttribute("usuario");
        return usuario;
    }

    /*PROCESO DE REPARACION*/
    @RequestMapping("/procesoRepacion")
    public ModelAndView procesoReparacion(HttpSession session) {
         Usuario u = obtenerUsuario(session);
        ModelAndView vista = new ModelAndView();
        vista.setViewName("Bodega/verProceso");

        List<Taller> list2 = (List<Taller>) tallerDao.findAll();
        List<Vehiculo_Remolque> list3 = (List<Vehiculo_Remolque>) ve_rem.findAll();
        List<Motorista> list4 = (List<Motorista>) motoristaDao.findAll();
        vista.addObject("lista2", list2);
        vista.addObject("lista3", list3);
        vista.addObject("lista4", list4);
        vista.addObject("usuario", u);
        return vista;
    }

    @RequestMapping(value = "/guardarSalTaller", method = RequestMethod.POST)
    public ModelAndView guardarSalTaller(@Valid Saltaller saltaller, BindingResult result, HttpSession session) {
        Usuario u = obtenerUsuario(session);
        long acumulador = 0;
        if (saltallerDAO.count() == 0) {
            saltaller.setIdsaltaller(1);
        } else {
            acumulador = saltallerDAO.count();
        }
        //convertimo ese valor a entero
        int valor = (int) acumulador;
        saltaller.setIdsaltaller(valor + 1);
        saltallerDAO.save(saltaller);
        String mensaje = "Creacion con Exito!!!";
        ModelAndView vista = new ModelAndView();
        vista.setViewName("Bodega/listarProceso");
        vista.addObject("usuario", u);
        vista.addObject("mensaje", mensaje);
        return listarProceso(session);
    }

    //Listar Proceso de Reparacion
    @RequestMapping("/listarProceso")
    public ModelAndView listarProceso(HttpSession session) {
        Usuario u = obtenerUsuario(session);
        List<Vehiculo_Taller> list = (List<Vehiculo_Taller>) vehiculo_tallerDAO.findAll();
        return new ModelAndView("Bodega/listarProceso", "lista", list).addObject("usuario", u);
    }

    //Para vista agregar Vehiculo
    @RequestMapping("/AgregarVehiculo/{idsaltaller}")
    public String agregarVehiculo(@PathVariable Integer idsaltaller, Model model,HttpSession session) {
         Usuario u = obtenerUsuario(session);
        List<Vehiculo_Reparacion> list1 = (List<Vehiculo_Reparacion>) vehiculo_reparacionDAO.findAll();
        List<Vehiculo_Saltaller> list3 = (List<Vehiculo_Saltaller>) vehiculo_saltallerDAO.findvsByName(idsaltaller);
        model.addAttribute("lista1", list1);
        model.addAttribute("lista2", vehiculo_tallerDAO.findOne(idsaltaller));
        model.addAttribute("lista3", list3);
        model.addAttribute("lista4", idsaltaller);
        model.addAttribute("usuario", u);
        return "Bodega/Agregar_Vehiculo";
    }
//===========================================MODIFICACION PARA DEFECTOS==========================================================================
    //Para agregar a ProcesoReparacion
    @RequestMapping(value = "/AgregarVehiculoTaller")
    public ModelAndView AgregarVehiculoTaller(@RequestParam("idvehiculo") String idvehiculo,@RequestParam("idsaltaller") Integer idsaltaller,HttpSession session) {
         Usuario u = obtenerUsuario(session);
        long acumulador = 0;
        
        String[] campoTmp = idvehiculo.split("|");
        System.out.println(campoTmp[0]);
        System.out.println(campoTmp[2]);
         Integer idv=Integer.parseInt(campoTmp[0]);
         Integer iddetveh=Integer.parseInt(campoTmp[2]);
        
         Vehtaller vehtaller=new Vehtaller();
         vehtaller.setIdsaltaller(idsaltaller);
         vehtaller.setIdvehiculo(idv);
         
       if (vehtallerDAO.count() == 0) {
            vehtaller.setIdvehtaller(1);
        } 
       else {
            acumulador = vehtallerDAO.count();
       
        //convertimo ese valor a entero
        int valor = (int) acumulador;
        vehtaller.setIdvehtaller(valor + 1);
         }
        //aqui
        int id = VehiculoCambio(vehtaller.getIdvehiculo());
        CambiarDesocupado(id);
        vehtallerDAO.save(vehtaller);
        // Cambiar el defecto reparado=1
        
        defectoDAO.updateReparado(iddetveh);
        
        Detallevehdef d=new Detallevehdef();
        d.setIddetveh(iddetveh);
        
     /*   
         Vehiculo vehi= new Vehiculo();
         vehi.setIdvehiculo(idv);
         respavehDAO.deleteRespavehByIdvehiculo(vehi);*/
        //========================REPARACION================================================
        Reparacion re=new Reparacion();
        re.setIdvehtaller(vehtaller);
        re.setIddetveh(d);
        if (reparacionDAO.count() == 0) {
           re.setIdreparacion(1);
        } 
       else {
            acumulador = reparacionDAO.count();
       
        //convertimo ese valor a entero
        int valor = (int) acumulador;
        re.setIdreparacion(valor + 1);
         }
         reparacionDAO.save(re);
        return listarProceso(session);
    }
    
 //============================================================================================================   
    
    
    
  /*  //Para agregar a ProcesoReparacion
    @RequestMapping(value = "/AgregarVehiculoTaller", method = RequestMethod.POST)
    public ModelAndView AgregarVehiculoTaller(@ModelAttribute Vehtaller vehtaller,HttpSession session) {
         Usuario u = obtenerUsuario(session);
        long acumulador = 0;

        if (vehtallerDAO.count() == 0) {
            vehtaller.setIdvehtaller(1);
        } else {
            acumulador = vehtallerDAO.count();
        }
        //convertimo ese valor a entero
        int valor = (int) acumulador;
        vehtaller.setIdvehtaller(valor + 1);
        //aqui
        int id = VehiculoCambio(vehtaller.getIdvehiculo());
        CambiarDesocupado(id);
        vehtallerDAO.save(vehtaller);
        // Cambiar el defecto reparado=1
        
        
        
        return listarProceso(session);
    }
    */
    
    

    //para vista de Gestion de Bodega
    @RequestMapping("/gestionBodega")
    public ModelAndView gestionBodega(HttpSession session) {
         Usuario u = obtenerUsuario(session);
        List<Bodega> list = (List<Bodega>) bodegadao.findAll();
        return new ModelAndView("BodegaGestion/verGestion", "bodegaList", list).addObject("usuario", u);
    }

      //Listar Pisos    
    @RequestMapping("/verPisos/{idbodega}")
    public ModelAndView verPisos(@PathVariable Bodega idbodega, Model model, HttpSession session) {
        Usuario u = obtenerUsuario(session);
        List<Piso> list = (List<Piso>) pisoDAO.pisosBodega(idbodega);
        // model.addAttribute("id",idbodega);
        ModelAndView vista = new ModelAndView();
        model.addAttribute("lista", list);
        model.addAttribute("usuario", u);        
        model.addAttribute("id", idbodega);
        vista.setViewName("BodegaGestion/verPisos");
        return vista;
    }
    //Listar Espacios
    @RequestMapping("/verEspacio/{idpiso}")
    public ModelAndView verEspacio(@PathVariable Piso idpiso, Model model,HttpSession session) {
         Usuario u = obtenerUsuario(session);
        List<Espavehiculo> list = (List<Espavehiculo>) espavehiculoDAO.espaPisos(idpiso);
        model.addAttribute("lista", list);

        return new ModelAndView("BodegaGestion/verEspacios").addObject("usuario", u);
    }
    
   
    
    //vista para guardar
    @RequestMapping("/guardarEspacio/{idespa}")
    public ModelAndView guardarEspacio(@PathVariable Espavehiculo idespa, Model model,HttpSession session) {
         Usuario u = obtenerUsuario(session);
       // List<Vehiculo_Espacio> list = (List<Vehiculo_Espacio>) vehiculo_espacioDAO.findAll();
        List<Vehiculos> list = vehiculoDAO.findByidestado(6);
       
        model.addAttribute("lista", list);
        model.addAttribute("lista2", idespa);
        List<Respaveh> list2 = (List<Respaveh>) respavehDAO.findAll();
       model.addAttribute("prueba", list2);
        return new ModelAndView("BodegaGestion/guardarEspacio").addObject("usuario", u);
    }
    //================================GUARDAR VEHICULOS DE TALLER============================================================================
    //vista para guardar
    @RequestMapping("/guardarEspacioTaller/{idespa}")
    public ModelAndView guardarEspacioTaller(@PathVariable Espavehiculo idespa, Model model,HttpSession session) {
         Usuario u = obtenerUsuario(session);
         
         List<Vehiculos> list = vehiculoDAO.findByidestado(2);
                
       // List<Vehiculo_Espacio> list = (List<Vehiculo_Espacio>) vehiculo_espacioDAO.findAll();
        model.addAttribute("lista", list);
        model.addAttribute("lista2", idespa);
        List<Respaveh> list2 = (List<Respaveh>) respavehDAO.findAll();
       model.addAttribute("prueba", list2);
        return new ModelAndView("BodegaGestion/guardarEspacioTaller").addObject("usuario", u);
    }
    
    //guardando el vehiculo en un espacio 
    @RequestMapping(value = "/agregarEspacioTaller")
    public String agregarEspacioTaller(@RequestParam("idvehiculo") int idvehiculo,@RequestParam("costotall") Integer costotall,@RequestParam("idespa") Integer idespa,HttpSession session) {
         Usuario u = obtenerUsuario(session);
        long acumulador = 0;
        Vehiculo ve=new Vehiculo();
        ve.setIdvehiculo(idvehiculo);
        Respaveh respaveh=new Respaveh();
        Espavehiculo e=new Espavehiculo();
        e.setIdespa(idespa);
        respaveh.setIdespa(e);
        respaveh.setIdvehiculo(ve);
        if (respavehDAO.count() == 0) {
            respaveh.setIdrespaveh(1);
        } else {
            acumulador = respavehDAO.count();
       
        //convertimo ese valor a entero
        int valor = (int) acumulador;
        respaveh.setIdrespaveh(valor + 1);
         }
        
        
        //cambiar el estado a ocupado
      //  CambiarOcupado(idespa);
        respavehDAO.save(respaveh);
        vehtallerDAO.updateCostoTaller2(costotall, idvehiculo);
        return "redirect:/gestionBodega";
    }
    
    //===========================================================================================================
    
    //guardando el vehiculo en un espacio 
    @RequestMapping(value = "/agregarEspacio/{idespa}", method = RequestMethod.POST)
    public String agregarEspacio(@ModelAttribute Respaveh respaveh,@PathVariable int idespa,HttpSession session) {
         Usuario u = obtenerUsuario(session);
        long acumulador = 0;

        if (respavehDAO.count() == 0) {
            respaveh.setIdrespaveh(1);
        } else {
            acumulador = respavehDAO.count();
        }
        //convertimo ese valor a entero
        int valor = (int) acumulador;
        respaveh.setIdrespaveh(valor + 1);
        //cambiar el estado a ocupado
      //  CambiarOcupado(idespa);
        respavehDAO.save(respaveh);
        
        return "redirect:/gestionBodega";
    }
    
    
    
    
    
    
    
    //metodo para cambiar estado a ocupado
    public void CambiarOcupado(int id){
        espavehiculoDAO.updateOcupado(id);
    }
    //metodo para cambiar estado a desocupado
    public void CambiarDesocupado(int id){
        espavehiculoDAO.updateDesocupado(id);
    }
    //metodo para ver que vehiculo cambiar
    public int VehiculoCambio(int id){        
        int idespa = (int)vehiculo_espacio_bodegaDAO.verIdEspa(id);
       return idespa;
    }
    //PARA LISTAR LOS ESPACIOS CON SUS PISOS Y BODEGAS
    //para ver las listas las bodegas 
    @RequestMapping("/listarEspaciosBodega")
    public ModelAndView listarEspaciosBodega(HttpSession session) {
         Usuario u = obtenerUsuario(session);
        List<Bodega> list = (List<Bodega>) bodegadao.findAll();
        return new ModelAndView("BodegaEspacios/listarGestion", "bodegaList", list).addObject("usuario", u);
    }

    //Listar Pisos    
    @RequestMapping("/listarPisos/{idbodega}")
    public ModelAndView listarPisos(@PathVariable Bodega idbodega, Model model,HttpSession session) {
        Usuario u = obtenerUsuario(session);
        List<Piso> list = (List<Piso>) pisoDAO.pisosBodega(idbodega);
        return new ModelAndView("BodegaEspacios/listarPisos", "lista", list).addObject("usuario", u);
    }

    //Listar Espacios
    @RequestMapping("/listarEspacio/{idpiso}")
    public ModelAndView listarEspacio(@PathVariable int idpiso, Model model,HttpSession session) {
       Usuario u = obtenerUsuario(session);
        //List<Vehiculo_Espacio_Bodega> list = (List<Vehiculo_Espacio_Bodega>) vehiculo_espacio_bodegaDAO.verEspacioPiso(idpiso);
        List<EspaciosDetalle> list=(List<EspaciosDetalle>) espadetDAO.findByidpiso(idpiso);
        model.addAttribute("lista", list);

        return new ModelAndView("BodegaEspacios/listarEspacios").addObject("usuario", u);
    }
    
    
    //==========================PISOS==================================
     //para ver la vista de Agegar nuevo piso
    @RequestMapping("/IngresarPiso/{idbodega}")
    public ModelAndView IngresarPiso(HttpSession session, @PathVariable Bodega idbodega) {
        Usuario u = obtenerUsuario(session);        
        return new ModelAndView("BodegaEspacios/IngresarPiso").addObject("usuario", u).addObject("id",idbodega);
    }

    @RequestMapping(value = "/addPiso/{idbodega}", method = RequestMethod.POST)
    public String guardarPiso(@ModelAttribute Piso piso, HttpSession session,@PathVariable int idbodega) {
        Usuario u = obtenerUsuario(session);       
        long acumulador = 0;

        if (pisoDAO.count() == 0) {
            piso.setIdpiso(1);
        } else {
            acumulador = pisoDAO.count();
        }
        //convertimo ese valor a entero
        int valor = (int) acumulador;
        piso.setIdpiso(valor + 1);
        pisoDAO.save(piso);       
        return "redirect:/listarPisos/{idbodega}";
    }
}
