package it.epicode.lucal.App;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import it.epicode.lucal.App.config.Beans;
import it.epicode.lucal.App.entities.Ruolo;
import it.epicode.lucal.App.entities.enums.TipoRuolo;
import it.epicode.lucal.App.services.RuoloService;

@SpringBootApplication
public class AppApplication implements CommandLineRunner{
	
	ApplicationContext ctx = new AnnotationConfigApplicationContext(Beans.class);

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
		
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		//popolaDb();

		
		((AnnotationConfigApplicationContext)ctx).close();
	}
	
	@Autowired
	private RuoloService rs;
	
	public void popolaDb() {
//		Ruolo r1 = (Ruolo)ctx.getBean("ruolo", TipoRuolo.ROLE_ADMIN);
//		Ruolo r2 = (Ruolo)ctx.getBean("ruolo", TipoRuolo.ROLE_USER);
//		
//		rs.save(r1);
//		rs.save(r2);
//		
	}

}
