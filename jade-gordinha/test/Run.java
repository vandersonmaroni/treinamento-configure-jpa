import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.OcorrenciaNotaFiscal;

import org.junit.Test;


public class Run {

	@SuppressWarnings("unchecked")
	@Test
	public void teste() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jade-gordinha");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		Query query = entityManager.createQuery("FROM OcorrenciaNotaFiscal");
		query.setMaxResults(20);
		List<OcorrenciaNotaFiscal> listaOcorrenciaNotaFiscal = query.getResultList();
		for (OcorrenciaNotaFiscal ocorrenciaNotaFiscal : listaOcorrenciaNotaFiscal) {
			System.out.println("id: " + ocorrenciaNotaFiscal.getIdOcorrencia() + " | Descricao: " + ocorrenciaNotaFiscal.getDescricao());
		}
	}
}
