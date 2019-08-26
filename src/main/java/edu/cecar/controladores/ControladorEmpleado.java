package edu.cecar.controladores;


import edu.cecar.componentes.baseDeDatos.ConectarMySQL;
import edu.cecar.modelos.Empleado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



/**
 * Clase: $(name)
 * 
 * @version: 0.1
 *  
 * @since: $(date)
 * 
 * Fecha de Modificación:
 * 
 * @author: Eduard Gárcia Pérez
 * 
 * Copyrigth: CECAR
 */


/**
 *
 * clase que controla las operaciones CRUD de los empleados
 */
public class ControladorEmpleado {
    
    private ConectarMySQL conectarMySQL;
    
    public ControladorEmpleado(){
        
        conectarMySQL = new ConectarMySQL("127.0.0.1", "Manpower", "root", "");
    }
    
    public void guardar(Empleado empleado) throws SQLException{
        
        PreparedStatement preparedStatement = conectarMySQL.getConnection().prepareStatement("Insert into empleados value (?,?,?,?)");
        
        preparedStatement.setString(1, empleado.getCodigo());
        preparedStatement.setString(2, empleado.getNombres());
        preparedStatement.setString(3, empleado.getApellidos());
        preparedStatement.setString(4, empleado.getFechaNacimiento());
        preparedStatement.execute();
        
    }
    
    public Empleado consultar(String codigo) throws SQLException{
        
        Empleado empleado = null;
        
        PreparedStatement preparedStatement = conectarMySQL.getConnection().prepareStatement("Select Cedula, nombres, apellidos, fechaNacimiento from empleados where Cedula = ?");
        
        preparedStatement.setString(1, codigo);
        
        ResultSet resultado = preparedStatement.executeQuery();
        
        if (resultado.next()){
            
            empleado = new Empleado(codigo,resultado.getString(2), resultado.getString(3), resultado.getString(4));
                
                
            
        }
        
        return empleado;

    }
    
    
    public void actuaizar(Empleado empleado)throws SQLException{
        
        
        
        PreparedStatement preparedStatement = conectarMySQL.getConnection().prepareStatement("Update empleado set  nombres = ?, apellidos = ?, fechaNacimiento = ? where Cedula = ? ");
    
        preparedStatement.setString(1, empleado.getCodigo());
        preparedStatement.setString(2, empleado.getNombres());
        preparedStatement.setString(3, empleado.getApellidos());
        preparedStatement.setString(4, empleado.getFechaNacimiento());
        preparedStatement.execute();
    
    }
    
    public void eliminar(){
        
        
    }
    

}
