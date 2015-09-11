/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
public class OperacaoMorfologica {

    /**
     * 
     * @param imagem Imagem PGM
     * @param ee Elemento Estruturante
     * @return Imagem Dilatada
     */
    public static Imagem dilatar(Imagem imagem, ElementoEstruturante ee){
        Dilatacao dilatacao = new Dilatacao(imagem, ee);
        return dilatacao.dilatar();
    }
    
    /**
     * 
     * @param imagem Imagem PGM
     * @param ee Elemento Estruturante
     * @return Imagem Erodida
     */
    public static Imagem erodir(Imagem imagem, ElementoEstruturante ee){
        Erosao erosao = new Erosao(imagem, ee);
        return erosao.erodir();
    }
    
    /**
     * 
     * @param imagem Imagem PGM
     * @param ee Elemento Estruturante
     * @return Imagem Aberta
     */
    public static Imagem abertura(Imagem imagem, ElementoEstruturante ee){
        Erosao erosao = new Erosao(imagem, ee);
        Dilatacao dilatacao = new Dilatacao(erosao.erodir(), ee);
        return dilatacao.dilatar();
    } 
    
    /**
     * 
     * @param imagem Imagem PGM
     * @param ee Elemento Estruturante
     * @return Imagem Fechada
     */
    public static Imagem fechamento(Imagem imagem, ElementoEstruturante ee){
        Dilatacao dilatacao = new Dilatacao(imagem, ee);
        Erosao erosao = new Erosao(dilatacao.dilatar(), ee);
        return erosao.erodir();
    }
    
    /**
     * 
     * @param imagem Imagem PGM
     * @param ee Elemento Estruturante
     * @return Imagem Suavizada
     */
    public static Imagem suavizacao(Imagem imagem, ElementoEstruturante ee){
        return fechamento(abertura(imagem, ee), ee);
    }
    
    /**
     * 
     * @param imagem Imagem PGM
     * @param ee Elemento Estruturante
     * @return Imagem Gradiente
     */
    public static Imagem gradiente(Imagem imagem, ElementoEstruturante ee){
        Dilatacao dilatacao = new Dilatacao(imagem, ee);
        Erosao erosao = new Erosao(imagem, ee);
        return divisao(subtracao(dilatacao.dilatar(), erosao.erodir()));
    }
    
    /**
     * 
     * @param dilatada Imagem dilatada
     * @param erodida Imagem erodida
     * @return Imagem
     */
    public static Imagem subtracao(Imagem dilatada, Imagem erodida){
        int[][] matrizDilatada = dilatada.getImagem();
        int[][] matrizErodida = erodida.getImagem();
        int[][] matrizResultante = new int[matrizDilatada.length][matrizDilatada[0].length];
        for (int i = 0; i < matrizDilatada.length; i++) {
            for (int j = 0; j < matrizDilatada[i].length; j++) {
                matrizResultante[i][j] = matrizDilatada[i][j] - matrizErodida[i][j];
            }
        }
        return new Imagem(matrizResultante);
    }
    
    /**
     * 
     * @param imagem Imagem a ser dividida por 2
     * @return Imagem
     */
    private static Imagem divisao(Imagem imagem){
        int[][] matrizOriginal = imagem.getImagem();
        int[][] matrizResultante = new int[matrizOriginal.length][matrizOriginal[0].length];
        for (int i = 0; i < matrizOriginal.length; i++) {
            for (int j = 0; j < matrizOriginal[i].length; j++) {
                matrizResultante[i][j] = matrizOriginal[i][j] / 2;
            }
        }
        return new Imagem(matrizResultante);
    }
    
}
