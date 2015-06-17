package com.inb.projeto.model.service;

import com.inb.projeto.model.dao.DAOException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.inb.projeto.model.dao.ProdutoDAO;
import com.inb.projeto.model.entity.Produto;

@Service
public class ProdutoService {

    private Produto produto;
    
    @Inject
    private ProdutoDAO produtoDAO;
    
     // Validacao de regra de negocio
    public void salvar(Produto produto) throws DAOException, ServiceException {
        if(produto.getProdNome() == null || produto.getProdNome().trim().isEmpty() ||
           produto.getProdDescricao() == null || produto.getProdDescricao().trim().isEmpty()){
            throw new ServiceException("Todos os campos são obrigatorios");
        }else if(produto.getProdPreco() < 1 || produto.getProdQuantidade() < 1 ){
            throw new ServiceException("O produto não pode ter quantidade ou valor igual a 0");
        }else{
            produtoDAO.salvar(produto);
                
            }
        }
        
    

    public void excluir(Produto produto){}
    
    
    public List<Produto> getAll() {
        return produtoDAO.getAll();
    }
    
    public Integer getLast(){
    
    return produtoDAO.getLastProduto();
    }
}
