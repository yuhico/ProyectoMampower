
package edu.cecar.test;

import edu.cecar.controladores.ControladorEmpleado;
import edu.cecar.modelos.Empleado;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author 1102887352
 */
public class TestControladorEmpleado {
    
    /*
    
    public TestControladorEmpleado() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}/*
    
    */
    
    @Test
    public void testConexciónBaseDatos(){
        
        try{
            
            ControladorEmpleado controladorEmpleado = new ControladorEmpleado();
            
            System.out.println("Conexión exitosa");
            
        }catch (Exception ex ){
            
            fail("Error de conexión");
            Logger.getLogger(TestControladorEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    
    }
    
    @Test
    public void testGuardar(){
    
    Empleado empleado = new Empleado("9253","Eduard", "García", "1999-05-13");
    
    try {
    ControladorEmpleado controladorEmpleado = new ControladorEmpleado();

            controladorEmpleado.guardar(empleado);
            
            Empleado empleadoBaseDeDatos = controladorEmpleado.consultar(empleado.getCodigo());
            
            assertEquals("El codigo esperado no coincide con el insertado",empleado.getCodigo(),empleadoBaseDeDatos.getCodigo());
            assertEquals("El nombre esperado no coincide con el insertado",empleado.getNombres(),empleadoBaseDeDatos.getNombres());
            assertEquals("El codigo esperado no coincide con el insertado",empleado.getApellidos(),empleadoBaseDeDatos.getApellidos());
            assertEquals("El codigo esperado no coincide con el insertado",empleado.getFechaNacimiento(),empleadoBaseDeDatos.getFechaNacimiento());
            
        } catch (SQLException ex) {
            Logger.getLogger(TestControladorEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}
     public void testActualizar(){
        
        Empleado empleado = new Empleado("9253","Eduard", "perez", "1999-05-13");
    
    try {
    ControladorEmpleado controladorEmpleado = new ControladorEmpleado();

            controladorEmpleado.actuaizar(empleado);
            
            Empleado empleadoBaseDeDatos = controladorEmpleado.consultar(empleado.getCodigo());
            
            assertEquals("El codigo esperado no coincide con el insertado",empleado.getCodigo(),empleadoBaseDeDatos.getCodigo());
            assertEquals("El nombre esperado no coincide con el insertado",empleado.getNombres(),empleadoBaseDeDatos.getNombres());
            assertEquals("El codigo esperado no coincide con el insertado",empleado.getApellidos(),empleadoBaseDeDatos.getApellidos());
            assertEquals("El codigo esperado no coincide con el insertado",empleado.getFechaNacimiento(),empleadoBaseDeDatos.getFechaNacimiento());
            
        } catch (SQLException ex) {
            Logger.getLogger(TestControladorEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
   
    
}
