package com.inb.projeto.model.service;

import com.inb.projeto.model.dao.DAOException;
import com.inb.projeto.model.dao.VendaDAO;
import com.inb.projeto.model.entity.Venda;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;


@Service
public class VendaService {

    private Venda venda;
    
    @Inject
    private VendaDAO vendaDAO;
    
     // Validacao de regra de negocio
    public void salvar(Venda venda) throws DAOException {
            vendaDAO.salvar(venda);
    }

    public void excluir(Venda venda){
    }
    
    
    public List<Venda> getAll() {
        return vendaDAO.getAll();
    }
}
