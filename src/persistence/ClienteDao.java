package persistence;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import dto.DtoClienteEndereco;
import entity.Cliente;
import entity.Endereco;

public class ClienteDao extends Dao {

	public void create(Cliente c) throws Exception {
		open();
		con.setAutoCommit(false);
		stmt = con.prepareStatement("insert into cliente values(null,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
		stmt.setString(1, c.getNome());
		stmt.setString(2, c.getEmail());
		stmt.execute();
		rs = stmt.getGeneratedKeys();
		rs.next();
		int key = rs.getInt(1);
		c.setId(key);
		stmt.close();

		stmt = con.prepareStatement("insert into endereco values(null,?,?,?,?,?,?)");
		stmt.setString(1, c.getEndereco().getLogradouro());
		stmt.setString(2, c.getEndereco().getBairro());
		stmt.setString(3, c.getEndereco().getCidade());
		stmt.setString(4, c.getEndereco().getEstado());
		stmt.setString(5, c.getEndereco().getCep());
		stmt.setInt(6, key);
		stmt.execute();
		stmt.close();
		con.setAutoCommit(true);
		close();
	}

	public List<DtoClienteEndereco> findAll() throws Exception {
		open();
		stmt = con.prepareStatement("select * from v$ClienteEndereco");
		List<DtoClienteEndereco> lst = new ArrayList<DtoClienteEndereco>();
		Cliente c = null;
		Endereco e = null;
		DtoClienteEndereco dto = null;
		rs = stmt.executeQuery();
		while (rs.next()) {
			dto = new DtoClienteEndereco();

			c = new Cliente();
			c.setId(rs.getInt("id"));
			c.setNome(rs.getString("nome"));
			c.setEmail(rs.getString("email"));
			dto.setCliente(c);

			e = new Endereco();
			e.setIdEndereco(rs.getInt("idEndereco"));
			e.setLogradouro(rs.getString("logradouro"));
			e.setBairro(rs.getString("bairro"));
			e.setCidade(rs.getString("cidade"));
			e.setEstado(rs.getString("estado"));
			e.setCep(rs.getString("cep"));
			dto.setEndereco(e);

			lst.add(dto);

		}
		stmt.close();
		close();
		return lst;
	}

	public static void main(String[] args) {
		try {

			ClienteDao cDao = new ClienteDao();

//			Cliente c = new Cliente(null, "hugo", "hugo@gmail.com");
//			c.setEndereco(new Endereco());
//			c.getEndereco().setLogradouro("rua do celular");
//			c.getEndereco().setBairro("bairro mobile");
//			c.getEndereco().setCidade("rio de janeiro");
//			c.getEndereco().setEstado("rj");
//			c.getEndereco().setCep("25587412");
//
//			cDao.create(c);
//
//			System.out.println("ok");
			
			cDao.findAll().forEach(System.out::println);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
