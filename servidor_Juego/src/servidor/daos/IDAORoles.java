package servidor.daos;


import java.util.List;

import servidor.persistencia.PoolConexiones.IConexion;
import servidor.valueObjects.VORoles;
import servidor.excepciones.ListarRolesException;

public interface IDAORoles {

	public List<VORoles> listarRoles(IConexion iConn) throws ListarRolesException;
}
