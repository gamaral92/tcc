/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util.operacao;

import util.elementos.Imagem;
import util.elementos.ElementoEstruturante;

/**
 *
 * @author Gabriel Amaral
 * @author Jefferson Ribeiro
 */
public class Morfologia {
    
    Imagem imagem;
    ElementoEstruturante ee;

    public Morfologia(Imagem imagem, ElementoEstruturante ee) {
        this.imagem = imagem;
        this.ee = ee;
    }

    public Imagem getImagem() {
        return imagem;
    }

    public ElementoEstruturante getElementoEstruturante() {
        return ee;
    }
    
}
