package br.com.caelum.argentum.indicadores;



import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.argentum.modelo.Candlestick;
import br.com.caelum.argentum.modelo.SerieTemporal;


public class MediaMovelSimplesTest {

	@SuppressWarnings("deprecation")
	@Test
	public void sequenciaSimplesDeCandles() throws Exception {
		SerieTemporal serie = 
				GeradorDeSerie.criaSerie(1,2,3,4,3,4,5,4,3);
		
		Indicador mms = new MediaMovelSimples();
		
		Assert.assertEquals(2.0,mms.calcula(2, serie), 0.00001);
		Assert.assertEquals(3.0,mms.calcula(3, serie), 0.00001);
		Assert.assertEquals(10.0/3,mms.calcula(4, serie), 0.00001);
		Assert.assertEquals(11.0/3,mms.calcula(5, serie), 0.00001);
		Assert.assertEquals(4.0,mms.calcula(6, serie), 0.00001);
		Assert.assertEquals(13.0/3,mms.calcula(7, serie), 0.00001);
		Assert.assertEquals(4.0,mms.calcula(8, serie), 0.00001);
		
	}
	
	public double calcula(int posicao, SerieTemporal serie){
		double soma = 0.0;
		for (int i = posicao; i > posicao - 3; i--){
			Candlestick c = serie.getCandle(i);
			soma += c.getFechamento();
		}
		return soma / 3;
		
	}

}
