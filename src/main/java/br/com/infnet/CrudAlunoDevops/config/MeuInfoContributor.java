package br.com.infnet.CrudAlunoDevops.config;
import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

public class MeuInfoContributor implements InfoContributor{
	@Override
    public void contribute(Builder builder) {
        builder.withDetail("meuDetalhe", "meuValor");
    }
}
