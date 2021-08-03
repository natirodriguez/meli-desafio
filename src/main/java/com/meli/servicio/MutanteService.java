package com.meli.servicio;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.meli.excepciones.DNAExcepcion;

import static java.lang.Math.min;
import static java.lang.Math.max;

@Service
public class MutanteService {
	//region Variables
	char[] LETRAS_POSIBLES = {'A', 'T', 'C', 'G'};
	int CANTIDAD_MINIMA_SECUENCIA = 4; 
	int consecutivos; 
	//endregion

	//region Metodos privados
    private ArrayList<String> ObtenerDiagonalesValidas(String[] matrizDNA) {
    	ArrayList<String> listaStringDiagonal = new ArrayList<String>();
    	for (int i = 1 - matrizDNA.length; i < matrizDNA.length; i++) {
    		String valorDiagonalActual = "";
    		for (int x = -min(0, i), y = max(0, i); x < matrizDNA.length && y < matrizDNA.length; x++, y++) {
    			char charPosicionActual = matrizDNA[y].charAt(x); 
    			valorDiagonalActual += charPosicionActual; 
    		}
    		listaStringDiagonal.add(valorDiagonalActual);
    	}
    	return listaStringDiagonal;
    }

    private boolean TieneConsecutivo(char elementoActual, char primeraPosicion) {
    	if(consecutivos < 3)
        {
        	if(primeraPosicion == elementoActual) {
        		consecutivos += 1; // Aumento la cantidad de n�meros consecutivos
        	}
        	else 
        	{
        		consecutivos = 0; // Reseteo la cantidad de n�meros consecutivos
        	} 
        }
        else {
        	return true;
        }
    	return false; 
    }
    
    private void ValidarCaracterCorrecto(char elemento) {
    	if (new String(LETRAS_POSIBLES).indexOf(elemento) == -1)
    		throw new DNAExcepcion("El caracter " + elemento + " es invalido"); 
    }
    
    private void ValidarTamanioMatrizInvalido(String[] matrizDNA) {
    	if (matrizDNA.length < CANTIDAD_MINIMA_SECUENCIA)
    		throw new DNAExcepcion("La tabla debe de ser mínimo de " + CANTIDAD_MINIMA_SECUENCIA + " X " + CANTIDAD_MINIMA_SECUENCIA); 
    	
    }
    //endregion
    
    public boolean LectorDeFilas(String[] matrizDNA) {
    	for(int f = 0; f < matrizDNA.length; f++) {
            char primerElemento = matrizDNA[f].charAt(0); 
            ValidarCaracterCorrecto(primerElemento);
            consecutivos = 0; 

            for(int c = 1 ; c < matrizDNA.length; c++) {
                char elemento = matrizDNA[f].charAt(c);
                ValidarCaracterCorrecto(elemento);

                if (TieneConsecutivo(elemento,primerElemento))
                	return true; 
    		}
        }
    	return false; 
    }
    
    public boolean LectorDeColumnas(String[] matrizDNA) {
    	for(int c = 0; c < matrizDNA.length; c++) {
            char primerElemento = matrizDNA[0].charAt(c);            
            consecutivos = 0; 
            ValidarCaracterCorrecto(primerElemento);

    		for(int f = 1 ; f < matrizDNA.length; f++) {
                char elemento = matrizDNA[f].charAt(c);
                ValidarCaracterCorrecto(elemento);

                if (TieneConsecutivo(elemento,primerElemento))
                	return true; 
    		}
        }
    	return false; 
    }
        
    public boolean LectorDeDiagonales(String[] matrizDNA)
    {
    	ArrayList<String> listaConDiagonales = ObtenerDiagonalesValidas(matrizDNA); 
    	
    	for(String diagonal: listaConDiagonales) {
    		if (diagonal.length() > CANTIDAD_MINIMA_SECUENCIA -1)
    		{
    			char primerElemento = diagonal.charAt(0);
                consecutivos = 0; 
                char[] charArray = diagonal.toCharArray();  
                ValidarCaracterCorrecto(primerElemento);

                for(int i=1;i<charArray.length;i++){  
                    char elemento = charArray[i];
                    ValidarCaracterCorrecto(elemento);

                    if (TieneConsecutivo(elemento,primerElemento))
                    	return true; 
        		}
    		}
    	}
    	return false; 
    }
    
    public boolean EsMutante(String[] matrizDNA){
    	ValidarTamanioMatrizInvalido(matrizDNA);
    	
    	if (this.LectorDeFilas(matrizDNA))
    		return true; 
    	else if (this.LectorDeColumnas(matrizDNA))
    		return true; 
    	else if (this.LectorDeDiagonales(matrizDNA))
    		return true; 
    	
    	return false; 
    }
}
