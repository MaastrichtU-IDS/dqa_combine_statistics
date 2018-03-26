package nl.unimaas.ids;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;

import org.eclipse.rdf4j.model.Statement;
import org.eclipse.rdf4j.query.Update;
import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.RepositoryConnection;
import org.eclipse.rdf4j.repository.RepositoryResult;
import org.eclipse.rdf4j.repository.sail.SailRepository;
import org.eclipse.rdf4j.rio.RDFFormat;
import org.eclipse.rdf4j.rio.RDFWriter;
import org.eclipse.rdf4j.rio.Rio;
import org.eclipse.rdf4j.sail.memory.MemoryStore;
import org.yaml.snakeyaml.Yaml;

public class CombineStatistics {
	
	
	public static void main(String[] args) {
		Repository repository = new SailRepository(new MemoryStore());
		repository.initialize();
		
		try(RepositoryConnection conn = repository.getConnection()) {
			// Load the triples
			for(int i=1; i<args.length;i++) {
				conn.add(new File(args[i]), null, RDFFormat.NTRIPLES);
			}
			
			// execute updates
			Yaml yaml = new Yaml();
			@SuppressWarnings("unchecked")
			Map<String, Object> yamlFile = (Map<String, Object>)yaml.load(CombineStatistics.class.getResourceAsStream("/queries.yaml"));
			@SuppressWarnings("unchecked")
			List<String> queries = (List<String>)yamlFile.get("queries");
			for(String sparql : queries) {
				Update update = conn.prepareUpdate(sparql);
				update.execute();
			}
			
			// write repository to file 
			FileOutputStream fos = new FileOutputStream(args[0]);
			RDFWriter rdfWriter = Rio.createWriter(RDFFormat.NTRIPLES, fos);
			try(RepositoryResult<Statement> result = conn.getStatements(null, null, null)) {
				while(result.hasNext()) {
					Statement stmt = result.next();
					rdfWriter.handleStatement(stmt);
				}
				
			}
			rdfWriter.endRDF();
			fos.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			repository.shutDown();
		}
		
		
	}
	
	

}
