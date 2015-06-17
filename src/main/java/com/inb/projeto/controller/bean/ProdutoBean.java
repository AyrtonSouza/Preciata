package com.inb.projeto.controller.bean;

import com.inb.projeto.model.dao.DAOException;
import com.inb.projeto.model.entity.Categoria;
import com.inb.projeto.model.entity.Imagens;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;

import com.inb.projeto.model.entity.Produto;
import com.inb.projeto.model.entity.Subcategoria;
import com.inb.projeto.model.service.CategoriaService;
import com.inb.projeto.model.service.ImagensService;
import com.inb.projeto.model.service.ProdutoService;
import com.inb.projeto.model.service.SubCategoriaService;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;

@Controller
@RequestScoped
public class ProdutoBean {

    private Produto produto;

    @Inject
    private ProdutoService produtoService;

    @Inject
    private CategoriaService service;

    @Inject
    private SubCategoriaService subCategoriaService;

    @Inject
    private ImagensService imagensService;

    public SubCategoriaService getSubCategoriaService() {
        return subCategoriaService;
    }

    public void setSubCategoriaService(SubCategoriaService subCategoriaService) {
        this.subCategoriaService = subCategoriaService;
    }

    public ImagensService getImagensService() {
        return imagensService;
    }

    public void setImagensService(ImagensService imagensService) {
        this.imagensService = imagensService;
    }

    private List<Categoria> categorias;

    private List<Subcategoria> subcategorias;

    private List<Produto> produtoList;

    private int categoriaid;

    public ProdutoBean() {
        produto = new Produto();

    }

    @PostConstruct
    public void init() {
        produtoList = produtoService.getAll();
        subcategorias = new ArrayList<>();
    }

    public void excluir() {
        try {
            produtoService.excluir(produto);
            produtoList = produtoService.getAll();
            produto = new Produto();

            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Excluido com sucesso", null));

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Erro ao excluir: " + e.getMessage(), null));
            e.printStackTrace();
        }
    }

    public String salvar() {

        try {
            produto.setFkDescId(1);
            produtoService.salvar(produto);
            produto = new Produto();
            produtoList = produtoService.getAll();

            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Salvo com sucesso", null));

            return "/inserirImagem.faces?faces-redirect=true";

        } catch (Exception e) {
            produto = new Produto();
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Erro ao salvar: " + e.getMessage(), null));
            e.printStackTrace();
        }
        return null;
    }

    public void fileUpload(FileUploadEvent event) throws IOException, DAOException {

        String path = FacesContext.getCurrentInstance().getExternalContext()
                .getRealPath("/imagens/" + event.getFile().getFileName());

        try {

            byte[] conteudo = event.getFile().getContents();
            FileOutputStream fos = new FileOutputStream(path);
            fos.write(conteudo);
            fos.close();
            FacesMessage msg = new FacesMessage("Sucesso " + event.getFile().getFileName() + " foi carregado.", event.getFile()
                    .getFileName() + " foi carregado.");
            Imagens imagem = new Imagens();
            imagem.setImaNome(event.getFile().getFileName());
            imagem.setFkProdId(produtoService.getLast());
            imagem.setImaCaminho(path);
            imagensService.salvar(imagem);

        } catch (Exception ex) {
            Logger.getLogger(Imagens.class.getName()).log(Level.SEVERE,
                    "Não Foi possivel Salvar devido a problemas", ex);
            FacesMessage msg = new FacesMessage("Falha" + event.getFile().getFileName() + " não foi carregado.",ex.toString() );

        }
    }

    public ProdutoService getProdutoService() {
        return produtoService;
    }

    public void setProdutoService(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public List<Produto> getProdutoList() {
        return produtoList;
    }

    public void setProdutoList(List<Produto> produtoList) {
        this.produtoList = produtoList;
    }

    public CategoriaService getService() {
        return service;
    }

    public void setService(CategoriaService service) {
        this.service = service;
    }

    public SubCategoriaService getSubcategoriaService() {
        return subCategoriaService;
    }

    public void setSubcategoriaService(SubCategoriaService SubcategoriaService) {
        this.subCategoriaService = SubcategoriaService;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public List<Subcategoria> getSubcategorias() {
        if (subcategorias == null) {
            subcategorias = new ArrayList<>();
        }
        return subcategorias;
    }

    public void setSubcategorias(List<Subcategoria> subcategorias) {
        this.subcategorias = subcategorias;
    }

    public int getCategoriaid() {
        return categoriaid;
    }

    public void setCategoriaid(int categoriaid) {
        this.categoriaid = categoriaid;
    }

    /**
     * Quando o valor do select de categoria muda, este mÃ©todo Ã© chamando e
     * retorna para a visÃ£o uma lista de subcategorias baseado no id recebido
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public void onCategoria() {
        if (categoriaid != 0) {
            subcategorias = subCategoriaService.forCategoria(categoriaid);
            produto.setFkCatId(categoriaid);
        } else {
            subcategorias = new ArrayList();
        }
    }

}
