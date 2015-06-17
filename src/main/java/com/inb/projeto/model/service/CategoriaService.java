/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inb.projeto.model.service;

import com.inb.projeto.model.dao.CategoriaDAO;
import com.inb.projeto.model.dao.DAOException;
import com.inb.projeto.model.entity.Categoria;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;

/**
 *
 * @author INB-07
 */
@Service
public class CategoriaService {

    private Categoria categoria;

    @Inject
    private CategoriaDAO categoriaDAO;

    public void salvar(Categoria categoria) throws DAOException, ServiceException {
        if (categoria.getCatId() == null) {
            if (categoria.getCatNome() == null) {
                throw new ServiceException("O valor nome não pode estar vazio");
            } else {
                categoriaDAO.salvar(categoria);
            }
        } else {
            categoriaDAO.atualiza(categoria);
        }

    }

    public List<Categoria> listAll() {
        return categoriaDAO.getAll();
    }

    public void excluir(Categoria categoria) throws DAOException {

        categoriaDAO.deleta(categoria);

    }

    public Categoria findById(int id) {

        return categoriaDAO.findById(id);
    }

}
