package com.ibanheiz.util;

import javax.enterprise.event.Observes;

public class BuscaCidadeObserver {

	public void mlkObservador(@Observes @AntiPilantraOlhudu String logDeObservacao) {
		System.out.println(logDeObservacao);
	}
	
	public void mlkObservadorPilantra(@Observes @PilantraOlhudu String logDeObservacao) {
		System.out.println("MLK PILANTRA:" + logDeObservacao);
	}
}
