/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inb.projeto.model.service;

import com.inb.projeto.model.dao.DAOException;
import com.inb.projeto.model.dao.SubCategoriaDao;
import com.inb.projeto.model.entity.Subcategoria;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;

/**
 *
 * @author INB-07
 */
@Service
public class SubCategoriaService {
    
    private Subcategoria subcategoria;
    
    @Inject
    private SubCategoriaDao subCategoriaDao;

    public SubCategoriaService() {
    }
    
    
    
    
    public void salvar(Subcategoria subCategoria ) throws DAOException, ServiceException{
    if(subCategoria.getSubId() == 0){
        if(subCategoria.getSubNome()== null){
        throw new ServiceException("O valor nome não pode estar vazio");
        }else{
         subCategoriaDao.salvar(subCategoria);
        }
    }else{
    subCategoriaDao.atualiza(subCategoria);
    }
 
 }
 
 public List<Subcategoria> listAll(){
      return subCategoriaDao.getAll();
 }
 
 public List<Subcategoria> forCategoria(int id){
      return subCategoriaDao.findByCategoria(id);
 }

 

public void excluir (Subcategoria Subcategoria) throws DAOException{

   subCategoriaDao.deleta(Subcategoria);

}
    
    
    
}
